package com.kk.gamestore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.kk.gamestore.domain.Game;
import com.kk.gamestore.service.GameService;
import com.kk.gamestore.exception.GameNotFoundException;

public class GameIdValidator implements ConstraintValidator<GameId, String> {

	@Autowired
	private GameService gameService;

	@Override
	public void initialize(GameId constraintAnnotation) {
		// Celowo pozostawione puste; w tym miejscu nale¿y zainicjowaæ adnotacjê
		// ograniczaj¹c¹
		// do sensownych domyœlnych wartoœci.
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Game game;
		try {

			game = gameService.getGameById(value);
		} catch (GameNotFoundException e) {
			return true;
		}
		if (game != null) {
			return false;
		}
		return true;
	}
}