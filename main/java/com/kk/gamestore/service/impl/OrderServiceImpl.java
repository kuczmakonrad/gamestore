package com.kk.gamestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.gamestore.domain.Game;
import com.kk.gamestore.domain.repository.GameRepository;
import com.kk.gamestore.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	public void processOrder(String gameId, int count) {
		Game gameById = gameRepository.getGameById(gameId);
		if (gameById.getGamesInStock() < count) {
			throw new IllegalArgumentException(
					"Zbyt ma³o kopii gry na magazynie. Pozosta³o: " + gameById.getGamesInStock());
		}

		gameById.setGamesInStock(gameById.getGamesInStock() - count);
	}
}