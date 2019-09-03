package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckImpl implements Deck {

    private List<Card> deck = new ArrayList<Card>();
    private int deckSize;
    private HandImpl handInst;
    private Rank[] ranks;
    private Suit[] suits;


    public DeckImpl(Rank[] ranks, int deckSize, int handSize) {
        handInst = new HandImpl(handSize);
        suits = Suit.values();
        this.ranks = ranks;
        this.deckSize = deckSize;

        for (int i = 0; i <= this.ranks.length - 1; i++){
            for(int j = 0; j <= 3 ; j++){
                deck.add(new CardImpl(suits[j], ranks[i]));
            }
        }
    }

    public DeckImpl(List<Card> cards, Rank[] ranks, int deckSize, int handSize) {
        this.deck = cards;

        handInst = new HandImpl(handSize);
        suits = Suit.values();
        this.ranks = ranks;
        this.deckSize = deckSize;

    }
    
    private void sizeCheck(int size) {
    	if(size() < size) throw new CardException("ERROR: Not enough cards in deck");
    }

    @Override
    public List<Card> getCards() {
        return deck;
    }

    public void setDeckSize(int size) {
        this.deckSize = size;
    }

    @Override
    public int size() {
        return deck.size();
    }

    @Override
    public int handSize() {
        return handInst.size();
    }

    @Override
    public Card drawTopCard() {
    	sizeCheck(1);
        return deck.remove(0);
    }

    @Override
    public Card topCard() {
    	sizeCheck(1);
        return deck.get(0);
    }

    @Override
    public Card drawBottomCard() {
    	sizeCheck(1);
        return deck.remove(size() -1);
    }

    @Override
    public Card bottomCard() {
    	sizeCheck(1);
        return deck.get(size() -1);
    }

    @Override
    public Hand deal() {
    	sizeCheck(handSize());
        Card card;

        for (int i = 0; i < handSize(); i++){
            card = deck.remove(0);
            handInst.hand.add(card);
        }

        return handInst;
    }

    public HandImpl getHandInst() {
        return handInst;
    }

    @Override
    public void sort() {
        deck.sort((c1, c2) -> {
            if(Arrays.asList(ranks).indexOf(c2.getRank()) > Arrays.asList(ranks).indexOf(c1.getRank())){
                return -1;
            } else if(Arrays.asList(ranks).indexOf(c2.getRank()) < Arrays.asList(ranks).indexOf(c1.getRank())){
                return 1;
            } else return c1.getSuit().compareTo(c2.getSuit());
        });
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }
}
