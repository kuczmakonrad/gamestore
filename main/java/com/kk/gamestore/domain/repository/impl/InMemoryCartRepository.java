package com.kk.gamestore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kk.gamestore.domain.Cart;
import com.kk.gamestore.domain.repository.CartRepository;

@Repository
public class InMemoryCartRepository implements CartRepository{
	
	private Map<String, Cart> listOfCarts;
	

	public InMemoryCartRepository() {
		listOfCarts = new HashMap<String,Cart>();
		
	}
	
	
	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Nie mo�na utworzy� koszyka. Koszyk o wskazanym  id (%) ju� istnieje.",cart.getCartId()));
		}

		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}
	
	
	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Nie mo�na zaktualizowa� koszyka. Koszyk o wskazanym id (%) nie istnieje.",cartId));
		}

		listOfCarts.put(cartId, cart);
	}

	
	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Nie mo�na usun�� koszyka. Koszyk o wskazanym id (%) nie istnieje.",cartId));
		}

		listOfCarts.remove(cartId);
	}

}
