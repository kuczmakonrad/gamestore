package com.kk.gamestore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kk.gamestore.domain.Game;

public interface GameRepository {
	
	List <Game> getAllGames();
	Game getGameById(String GameId);
	List <Game> getGamesByPlatform(String gamePlatform);
	Set <Game> getGamesByFilter(Map<String, List<String>> filterParams);
	void addGame(Game game);
	
}
