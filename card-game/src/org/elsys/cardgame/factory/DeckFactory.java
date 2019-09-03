package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Rank;

import static org.elsys.cardgame.api.Rank.*;

public class DeckFactory {



	public static Deck defaultWarDeck() {
		DeckImpl deck = new DeckImpl(Rank.values(), 52, 26);

		return deck;
	}

	public static Deck defaultSantaseDeck() {
		Rank[] ranks =  {NINE, JACK, QUEEN, KING, TEN, ACE};
		DeckImpl deck = new DeckImpl( ranks, 24, 6);

		return deck;
	}

	public static Deck defaultBeloteDeck() {
		Rank[] ranks =  {SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
		DeckImpl deck = new DeckImpl( ranks, 32, 8);

		return deck;
	}
}
