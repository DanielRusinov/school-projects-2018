package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.CardImpl;
import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class BottomCard extends OperationImpl {

    public BottomCard(GameImpl game) {
        super("bottom_card", game);
    }

    @Override
    public void execute() {
        CardImpl card = (CardImpl) game.getDeck().bottomCard();
       	CardImpl.print(card);
    }
}
