package com.kk.gamestore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kk.gamestore.domain.Game;

public interface GameService {
	List<Game> getAllGames();
	Game getGameById(String gameId);
	List<Game> getGamesByPlatform(String gamePlatform);
	Set<Game> getGamesByFilter(Map<String, List<String>> filterParams);
	void addGame(Game game);

}
