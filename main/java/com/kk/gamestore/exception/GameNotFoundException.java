package com.kk.gamestore.exception;

public class GameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -694354952032299587L;
	private String gameId;

	public GameNotFoundException(String gameId) {
		this.gameId = gameId;
	}

	public String getGameId() {
		return gameId;
	}
}
