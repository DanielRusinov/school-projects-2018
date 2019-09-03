package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class Shuffle extends OperationImpl {

    public Shuffle(GameImpl game) {
        super("shuffle", game);
    }

    @Override
    public void execute() {
        game.getDeck().shuffle();
    }
}