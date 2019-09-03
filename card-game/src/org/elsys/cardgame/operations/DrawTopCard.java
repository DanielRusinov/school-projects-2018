package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.CardImpl;
import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class DrawTopCard extends OperationImpl {

    public DrawTopCard(GameImpl game) {
        super("draw_top_card", game);
    }

    @Override
    public void execute() {
        CardImpl card = (CardImpl) game.getDeck().drawTopCard();
        CardImpl.print(card);
    }
}
