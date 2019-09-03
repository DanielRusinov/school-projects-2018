package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Hand;

import java.util.ArrayList;
import java.util.List;

public class HandImpl implements Hand {

    protected List<Card> hand = new ArrayList<Card>();
    private int size;


    public HandImpl(int size) {
        this.size = size;
    }

    @Override
    public List<Card> getCards() {
        return hand;
    }

    @Override
    public int size() {
        return size;
    }
}
