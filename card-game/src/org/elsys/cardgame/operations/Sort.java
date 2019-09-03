package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class Sort extends OperationImpl {

    public Sort(GameImpl game) {
        super("sort", game);
    }

    @Override
    public void execute() {
        game.getDeck().sort();
    }
}
