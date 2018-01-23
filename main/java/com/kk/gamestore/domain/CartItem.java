package com.kk.gamestore.domain;

import java.math.BigDecimal;

public class CartItem {

	private Game game;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(Game game) {
		super();
		this.game = game;
		this.quantity = 1;
		this.totalPrice = game.getGamePrice();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
		this.updateTotalPrice();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = this.game.getGamePrice().multiply(new BigDecimal(this.quantity));
	}
	
	@Override
	public int hashCode() {
		final int prime = 311;
		int result = 1;
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		return true;
	}
}
