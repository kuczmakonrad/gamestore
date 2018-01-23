	package com.kk.gamestore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kk.gamestore.domain.Game;
import com.kk.gamestore.exception.GameNotFoundException;
import com.kk.gamestore.service.GameService;

@RequestMapping("/games")
@Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@RequestMapping
	public String Welcome(Model model) {
		model.addAttribute("games", gameService.getAllGames());
		return "games";
	}

	@RequestMapping("/all")
	public String allGames(Model model) {
		model.addAttribute("games", gameService.getAllGames());
		return "games";
	}
	
	@RequestMapping("/{platform}")
	public String getGamesByPlatform(Model model, @PathVariable("platform") String gamePlatform) {
		model.addAttribute("games", gameService.getGamesByPlatform(gamePlatform));
		return "games";
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getGamesByFilter(@MatrixVariable(pathVar="ByCriteria")
	Map<String,List<String>> filterParams, Model model){
		model.addAttribute("games", gameService.getGamesByFilter(filterParams));
		return "games";
	}
	
	@RequestMapping("/game")
	public String getGamesById(@RequestParam("id") String gameId, Model model){
		Game game = gameService.getGameById(gameId);
		model.addAttribute("game", game); 
		return "game";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewGameForm(Model model) {
	Game newGame = new Game();
	model.addAttribute("newGame", newGame);
	return "addGame";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewGameForm(@ModelAttribute("newGame") @Valid Game gameToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addGame";
			}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
		throw new RuntimeException("Próba wi¹zania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile gameImage = gameToBeAdded.getGameImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (gameImage!=null && !gameImage.isEmpty()) {
		try {
		gameImage.transferTo(new File(rootDirectory+"resources\\images\\"+gameToBeAdded.getGameId() + ".png"));
		} catch (Exception e) {
		throw new RuntimeException("Blad podczas zapisu okladki gry.", e);
		}
		}
	gameService.addGame(gameToBeAdded);
	return "redirect:/games";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	
	binder.setAllowedFields("gameId", "gameName", "gamePrice", "gameDescription","gamePlatform", "gameCategory", "gamesInStock", "gameImage", "condition");
	}	
	
	
	@ExceptionHandler(GameNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, GameNotFoundException exception) {
	ModelAndView mav = new ModelAndView();
	mav.addObject("invalidGameId", exception.getGameId());
	mav.addObject("exception", exception);
	mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
	mav.setViewName("gameNotFound");
	return mav;
	}


	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
	return "invalidPromoCode";
	}
}
