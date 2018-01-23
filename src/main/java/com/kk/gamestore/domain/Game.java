package com.kk.gamestore.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import com.kk.gamestore.validator.GameId;


@XmlRootElement
public class Game {
	
	@Pattern(regexp="G[0-9]+", message="{Pattern.Game.gameId.validation}")
	@GameId
	private String gameId;
	@Size(min=2, max=50, message="{Size.Game.gameName.validation}")
	private String gameName;
	@NotNull (message="{NotNull.Game.gamePlatform.validation}")
	private String gamePlatform;
	@Min(value=0, message="{Min.Game.gamePrice.validation}")
	@Digits(integer=8, fraction=2, message="{Digits.Game.gamePrice.validation}")
	@NotNull (message= "{NotNull.Game.gamePrice.validation}")
	private BigDecimal gamePrice;
	@NotNull (message="{NotNull.Game.gameDescription.validation}")
	@Size (min=1, max=500, message="{Size.Game.gameDescription.validation}")
	private String gameDescription;
	@NotNull (message="{NotNull.Game.gameCategory.validation}")
	@Size(min=1, max=30, message="{Size.Game.gameCategory.validation}")	
	private String gameCategory;
    @Min(value=1, message="{Min.Game.gamesInStock.validation}")	
	private long gamesInStock;
	
	private long gamesInOrder;
	
	@JsonIgnore
	private MultipartFile gameImage;
	


		
	private boolean discontinued;
	@NotNull (message="{NotNull.Game.condition.validation}")
	private String condition;
	
								//Konstruktor
	public Game() {
		super();
	}

	public Game(String gameId, String gameName, String gamePlatform, BigDecimal gamePrice) {
		this.gameId = gameId;
		this.gameName = gameName;
		this.gamePlatform = gamePlatform;
		this.gamePrice = gamePrice;
	}

	
								//Gettery i settery ka¿dego ze zmiennych
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	
	public String getGamePlatform() {
		return gamePlatform;
	}

	public void setGamePlatform(String gamePlatform) {
		this.gamePlatform = gamePlatform;
	}
	
	
	public BigDecimal getGamePrice() {
		return gamePrice;
	}
	public void setGamePrice(BigDecimal gamePrice) {
		this.gamePrice = gamePrice;
	}
	
	
	public String getGameDescription() {
		return gameDescription;
	}
	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}
	
	
	public String getGameCategory() {
		return gameCategory;
	}
	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}
	
	
	public long getGamesInStock() {
		return gamesInStock;
	}
	public void setGamesInStock(long gamesInStock) {
		this.gamesInStock = gamesInStock;
	}
	
	
	public long getGamesInOrder() {
		return gamesInOrder;
	}
	public void setGamesInOrder(long gamesInOrder) {
		this.gamesInOrder = gamesInOrder;
	}
	
	
	public boolean isDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@XmlTransient
	public MultipartFile getGameImage() {
		
		return gameImage;
	}

	public void setGameImage(MultipartFile gameImage) {
		this.gameImage = gameImage;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (gameId == null) {
			if (other.gameId != null)
				return false;
		} else if (!gameId.equals(other.gameId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + ", gamePlatform=" + gamePlatform + ", gamePrice="
				+ gamePrice + "]";
	}
}	
