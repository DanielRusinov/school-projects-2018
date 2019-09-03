package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameImpl implements Game {

    private DeckImpl deck;
    private HandImpl hand;
    private Map<String, Operation> operations = new HashMap<>();

    public GameImpl(DeckImpl deck) {
        this.deck = deck;
    }

    public GameImpl() {}

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public Hand getDealtHand() {
        return deck.getHandInst();
    }

    @Override
    public void setDealtHand(Hand hand) {
        this.hand = (HandImpl) hand;
    }

    @Override
    public void process(String command) {
        Operation operation = operations.get(command);
        if (operation != null) {
            operation.execute();
        } else throw new CardException("ERROR: Unknown operation");

    }

    @Override
    public void addOperation(Operation operation) {
        operations.put(operation.getName(), operation);
    }
}
