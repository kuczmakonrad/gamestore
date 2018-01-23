package com.kk.gamestore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kk.gamestore.domain.Game;
import com.kk.gamestore.domain.repository.GameRepository;
import com.kk.gamestore.exception.GameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryGameRepository implements GameRepository {

	private List<Game> listOfGames = new ArrayList<Game>();

	public InMemoryGameRepository() {
		
		//PS3
		Game resistance3 = new Game("G1", "Resistance 3", "PS3", new BigDecimal(25));
		resistance3.setGameDescription("Gra w której próbujemy zapobiec niebezpieczeñstwu zagra¿aj¹cemu œwiatu.");
		resistance3.setGameCategory("Strzelanka FPP");
		resistance3.setGamesInStock(10);
		
		Game batmanac = new Game("G2", "Batman Arkham City", "PS3", new BigDecimal(39));
		batmanac.setGameDescription("Gra w której wcielasz siê w batmana. Ratujemy miasto Arkham.");
		batmanac.setGameCategory("Fantasy");
		batmanac.setGamesInStock(7);
		
		Game battlefield3 = new Game("G3", "Battlefield 3", "PS3", new BigDecimal(49));
		battlefield3.setGameDescription("Gra w której wcielasz siê w role agenta, który broni kraju.");
		battlefield3.setGameCategory("Strzelanka");
		battlefield3.setGamesInStock(7);
	
		Game legohp = new Game("G4", "Lego Harry Potter years 1-4", "PS3", new BigDecimal(59));
		legohp.setGameDescription("Gra Lego Harry Potter dla dzieci w przedziale wiekowym 1-4.");
		legohp.setGameCategory("Dla dzieci");
		legohp.setGamesInStock(10);
		
		Game mirrorsedge = new Game("G5", "Mirrors Edge", "PS3", new BigDecimal(29));
		mirrorsedge.setGameDescription("Gra akcji, w której wcielamy siê w g³ówn¹ bohaterkê Faith, która lubi parkour.");
		mirrorsedge.setGameCategory("Akcja");
		mirrorsedge.setGamesInStock(25);
		
		Game mafia2 = new Game("G6", "Mafia II", "PS3", new BigDecimal(50));
		mafia2.setGameDescription("Gra gangsterska osadzona w XX wieku. Obroñ swoj¹ rodzinê i zostañ królem pó³swiatka.");
		mafia2.setGameCategory("Gangsterska");
		mafia2.setGamesInStock(9);
		//PS4
		Game wiedzmin3 = new Game("G7", "WiedŸmin 3","PS4", new BigDecimal(120));
		wiedzmin3.setGameDescription("Gra na podstawie ksi¹¿ki.Jest to polska produkcja.");
		wiedzmin3.setGameCategory("RPG");
		wiedzmin3.setGamesInStock(13);
		
		Game nhl15 = new Game("G8", "NHL 15","PS4", new BigDecimal(60));
		nhl15.setGameDescription("Gra sportowa, w której gramy w hokeja.");
		nhl15.setGameCategory("Sportowa");
		nhl15.setGamesInStock(6);
		
		Game mortalcombatx = new Game("G9", "Mortal Combat X", "PS4", new BigDecimal(100));
		mortalcombatx.setGameDescription("Kultowa gra multiplayer, w której bijemy siê z innymi graczami.");
		mortalcombatx.setGameCategory("Bijatyka");
		mortalcombatx.setGamesInStock(17);
		
		Game dyinglight = new Game("G10", "Dying Light", "PS4", new BigDecimal(90));
		dyinglight.setGameDescription("Polska produkcja, w której musimy odnaleŸæ siê w œwiecie Zombie.");
		dyinglight.setGameCategory("Postapokaliptyczna");
		dyinglight.setGamesInStock(4);
		
		Game littlebigplanet3 = new Game("G11", "Little Big Planet 3", "PS4", new BigDecimal(70));
		littlebigplanet3.setGameDescription("Trzecia seria gry zrêcznoœciowej dla ludzi w ka¿dym wieku.");
		littlebigplanet3.setGameCategory("Zrêcznoœciowa");
		littlebigplanet3.setGamesInStock(6);
		
		Game fallout4 = new Game("G12", "Fallout 4", "PS4", new BigDecimal(100));
		fallout4.setGameDescription("Kolejna z serii gry fantastycznej akcji z broni¹, g³ównie w kosmosie.");
		fallout4.setGameCategory("Rpg / akcja");
		fallout4.setGamesInStock(20);
		//XBOXONE
		Game fifa17 = new Game("G13" ,"Fifa 17", "XBOXONE",new BigDecimal(60));
		fifa17.setGameDescription("Gra sportowa dziedzina pi³ka no¿na z roku 2017.");
		fifa17.setGameCategory("Sportowa");
		fifa17.setGamesInStock(10);
		
		Game quantumbreak = new Game("G14" ,"Quantum Break", "XBOXONE",new BigDecimal(70));
		quantumbreak.setGameDescription("Quantum Break to gra zainspirowana wspó³czesnymi teoriami naukowymi o czasoprzestrzeni.");
		quantumbreak.setGameCategory("Fantastyczna");
		quantumbreak.setGamesInStock(25);
		
		Game forzahorizon2  = new Game("G15" ,"Forza Horizon 2", "XBOXONE",new BigDecimal(90));
		forzahorizon2.setGameDescription("Najnowsza wersja gry Forza, która jest symulatorem samochodowym.");
		forzahorizon2.setGameCategory("Samochodowa");
		forzahorizon2.setGamesInStock(15);
		
		Game snipere4 = new Game("G16" ,"Sniper Elite 4 Italia", "XBOXONE",new BigDecimal(140));
		snipere4.setGameDescription("Symulator snajperski, w czwartej czêœci akcja dzieje siê we W³oszech.");
		snipere4.setGameCategory("Akcja");
		snipere4.setGamesInStock(10);
		
		Game mafia3 = new Game("G17", "Mafia III","XBOXONE", new BigDecimal(110));
		mafia3.setGameDescription("Gra gangsterska osadzona w XX wieku.");
		mafia3.setGameCategory("Strzelanka, gangsterska");
		mafia3.setGamesInStock(12);
		
		Game watchdogs = new Game("G18" ,"Watch Dogs", "XBOXONE",new BigDecimal(80));
		watchdogs.setGameDescription("Gra, w której wcielasz siê w hakera w Chicago.");
		watchdogs.setGameCategory("Akcja");
		watchdogs.setGamesInStock(22);
		//XBOX 360
		Game crysis3 = new Game("G19" ,"Crysis 3", "XBOX360",new BigDecimal(70));
		crysis3.setGameDescription("Akcja gry osadzona zosta³a w roku 2047, czyli 24 lata po wydarzeniach ukazanych w Crysis 2.");
		crysis3.setGameCategory("Fantastyczna/Akcja");
		crysis3.setGamesInStock(8);
		
		Game tombrider = new Game("G20" ,"Tomb Rider", "XBOX360",new BigDecimal(80));
		tombrider.setGameDescription("Gra przygodowa, w której wcielamy siê w bohaterkê.");
		tombrider.setGameCategory("Przygodowa");
		tombrider.setGamesInStock(13);
		
		Game gothic4 = new Game("G21" ,"Gothic 4: Arcania", "XBOX360",new BigDecimal(60));
		gothic4.setGameDescription("Gra RPG, w której rozwijamy swoj¹ postaæ. Osadzona w krainie fantasy.");
		gothic4.setGameCategory("RPG");
		gothic4.setGamesInStock(12);
		
		Game minecraft = new Game("G22" ,"Minecraft", "XBOX360",new BigDecimal(50));
		minecraft.setGameDescription("Gra dla dzieci, w której tworzymy w³asny œwiat z klocków.");
		minecraft.setGameCategory("Dla dzieci");
		minecraft.setGamesInStock(8);
		
		Game payday2 = new Game("G23" ,"Payday 2", "XBOX360",new BigDecimal(80));
		payday2.setGameDescription("Gra akcji, w której musimy okradaæ banki.");
		payday2.setGameCategory("Gangsterska");
		payday2.setGamesInStock(15);
		
		Game gta5 = new Game("G24" ,"Grand Theft Auto V", "XBOX360",new BigDecimal(120));
		gta5.setGameDescription("Gra opiera siê na trójce bohaterów, którym nieobce s¹ zatargi z prawem.");
		gta5.setGameCategory("Akcja/Gangsterska");
		gta5.setGamesInStock(24);
		
		//PS3
		listOfGames.add(resistance3);
		listOfGames.add(mirrorsedge);
		listOfGames.add(legohp);
		listOfGames.add(mafia2);
		listOfGames.add(battlefield3);
		listOfGames.add(batmanac);
		//PS4
		listOfGames.add(wiedzmin3);
		listOfGames.add(nhl15);
		listOfGames.add(mortalcombatx);
		listOfGames.add(dyinglight);
		listOfGames.add(littlebigplanet3);
		listOfGames.add(fallout4);
		//XBOXONE
		listOfGames.add(watchdogs);
		listOfGames.add(mafia3);
		listOfGames.add(snipere4);
		listOfGames.add(forzahorizon2);
		listOfGames.add(quantumbreak);
		listOfGames.add(fifa17);
		//XOX 360
		listOfGames.add(gta5);
		listOfGames.add(payday2);
		listOfGames.add(minecraft);
		listOfGames.add(gothic4);
		listOfGames.add(tombrider);
		listOfGames.add(crysis3);
	}

	@Override
	public List<Game> getAllGames() {
		return listOfGames;
	}

	//Metoda zwraca wskazana gre po ID lub wyswietla blad jezeli takowej nie ma
	@Override
	public Game getGameById(String gameId) {
		Game gameById = null;
		for(Game game : listOfGames) {
		if(game!=null && game.getGameId()!=null && game.getGameId().equals(gameId)){
		gameById = game;
		break;
		}
		}
		if(gameById == null){
		throw new GameNotFoundException(gameId);
		}
		return gameById;
		}


	@Override
	public List<Game> getGamesByPlatform(String gamePlatform) {
		List<Game> gamesByPlatform = new ArrayList<Game>();
		for(Game game: listOfGames) {
			if(gamePlatform.equalsIgnoreCase(game.getGamePlatform())) {
				gamesByPlatform.add(game);
			}
		}	
		return gamesByPlatform;	
	}




	@Override
	public Set<Game> getGamesByFilter(Map<String, List<String>> filterParams) {
		Set<Game> gamesByName = new HashSet<Game>();
		Set<Game> gamesByPlatform = new HashSet<Game>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("name")) {
			for(String gameName: filterParams.get("name")) {
				for(Game game: listOfGames) {
				if(gameName.equalsIgnoreCase(game.getGameName())) {
					gamesByName.add(game);
				}
			}
		}
	}
	if(criterias.contains("platform")) {
		for (String platform: filterParams.get("platform")) {
			gamesByPlatform.addAll(this.getGamesByPlatform(platform));
		}
	}
	gamesByPlatform.retainAll(gamesByName);
	return gamesByPlatform;
	}
	
	@Override
	public void addGame(Game game) {
		listOfGames.add(game);
		}

}
