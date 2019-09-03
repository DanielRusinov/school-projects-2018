package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.CardImpl;
import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class DrawBottomCard extends OperationImpl {

    public DrawBottomCard(GameImpl game) {
        super("draw_bottom_card", game);
    }

    @Override
    public void execute() {
        CardImpl card = (CardImpl) game.getDeck().drawBottomCard();
        CardImpl.print(card);
    }
}
