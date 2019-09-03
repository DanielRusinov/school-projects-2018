package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class Size extends OperationImpl {

    public Size(GameImpl game) {
        super("size", game);
    }

    @Override
    public void execute() {
        System.out.println(game.getDeck().size());
    }
}
