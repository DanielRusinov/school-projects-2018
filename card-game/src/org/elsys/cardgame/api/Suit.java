package org.elsys.cardgame.api;

public enum Suit {

	CLUBS("C"),
	DIAMONDS("D"),
	HEARTS("H"),
	SPADES("S");

	private String symbol;

	public static Suit convert(String name) {
		for (Suit suit : Suit.values()) {
			if (name.equals(suit.symbol)) {
				return suit;
			}
		}
		return null;
	}

	Suit(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}
