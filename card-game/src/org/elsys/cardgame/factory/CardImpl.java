package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class CardImpl implements Card {

    private Suit suit;
    private Rank rank;

    @Override
    public boolean equals(Object two) {
        if (two instanceof Card) {
            Card card = (Card) two;
            String suit1 = this.getSuit().getSymbol();
            String suit2 = card.getSuit().getSymbol();
            String rank1 = this.getRank().getSymbol();
            String rank2 = card.getRank().getSymbol();
            if ( suit1.equals(suit2) && rank1.equals(rank2)) return true;
        }
        return false;
    }

    public CardImpl(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void print(CardImpl card) {
        System.out.print(card.getSuit().toString() + card.getRank().toString() + " "); 
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }
}
