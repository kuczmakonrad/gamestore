package com.kk.gamestore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.gamestore.domain.Game;
import com.kk.gamestore.domain.repository.GameRepository;
import com.kk.gamestore.service.GameService;

@Service
public class GameServiceImpl  implements GameService{

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public List<Game> getAllGames() {
		return gameRepository.getAllGames();
	}

	@Override
	public Game getGameById(String gameId) {
		return gameRepository.getGameById(gameId);
	}

	@Override
	public List<Game> getGamesByPlatform(String gamePlatform) {
		return gameRepository.getGamesByPlatform(gamePlatform);
	}

	@Override
	public Set<Game> getGamesByFilter(Map<String, List<String>> filterParams) {
		return gameRepository.getGamesByFilter(filterParams);
	}
	
	@Override
	public void addGame(Game game){
		gameRepository.addGame(game);
		}
}


