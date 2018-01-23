package com.kk.gamestore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import com.kk.gamestore.domain.Cart;
import com.kk.gamestore.domain.CartItem;
import com.kk.gamestore.domain.Game;
import com.kk.gamestore.exception.GameNotFoundException;
import com.kk.gamestore.service.CartService;
import com.kk.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "rest/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		return  cartService.create(cart);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
		return cartService.read(cartId);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cartId") String cartId,	@RequestBody Cart cart) {
		cartService.update(cartId, cart);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartService.delete(cartId);
	}
	
	@RequestMapping(value = "/add/{gameId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable String gameId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if(cart== null) {
			cart = cartService.create(new Cart(sessionId));
		}
		
		Game game = gameService.getGameById(gameId);
		if(game == null) {
			throw new IllegalArgumentException(new GameNotFoundException(gameId));
		}
		
		cart.addCartItem(new CartItem(game));
		cartService.update(sessionId, cart);
	}
	
	@RequestMapping(value = "/remove/{gameId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String gameId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if(cart== null) {
			cart = cartService.create(new Cart(sessionId));
		}
		
		Game game = gameService.getGameById(gameId);
		if(game == null) {
			throw new IllegalArgumentException(new GameNotFoundException(gameId));
		}
		
		cart.removeCartItem(new CartItem(game));
		
		cartService.update(sessionId, cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason="Niepoprawne ¿¹danie, sprawdŸ przesy³ane dane.")
	public void handleClientErrors(Exception ex) { }

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Wewnêtrzny b³¹d serwera")
	public void handleServerErrors(Exception ex) {	}
}
