package org.elsys.cardgame.factory;

import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.operations.*;

import static org.elsys.cardgame.api.Rank.*;
import static org.elsys.cardgame.api.Rank.ACE;
import static org.elsys.cardgame.api.Rank.TEN;

public class GameFactory {

	private static void beforeWork(GameImpl game){
		game.addOperation(new Size(game));
		game.addOperation(new DrawTopCard(game));
		game.addOperation(new DrawBottomCard(game));
		game.addOperation(new TopCard(game));
		game.addOperation(new BottomCard(game));
		game.addOperation(new Shuffle(game));
		game.addOperation(new Sort(game));
		game.addOperation(new Deal(game));
	}
	
	public static Game createWarGame(List<Card> cards) {
		DeckImpl deck = new DeckImpl(cards, Rank.values(), 52, 26);
		if(deck.size() < 52) throw new CardException("ERROR: Not enough cards for War");
		GameImpl game = new GameImpl(deck);
		beforeWork(game);
		return game;
	}

	public static Game createSantaseGame(List<Card> cards) {
		Rank[] ranks =  {NINE, JACK, QUEEN, KING, TEN, ACE};
		DeckImpl deck = new DeckImpl(cards, ranks, 24, 6);
		if(deck.size() < 24) throw new CardException("ERROR: Not enough cards for Santase");
		GameImpl game = new GameImpl(deck);
		beforeWork(game);
		return game;
	}

	public static Game createBeloteGame(List<Card> cards) {
		Rank[] ranks =  {SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
		DeckImpl deck = new DeckImpl(cards, ranks, 32, 8);
		if(deck.size() < 32) throw new CardException("ERROR: Not enough cards for Belote");
		GameImpl game = new GameImpl(deck);
		beforeWork(game);
		return game;
	}
}
