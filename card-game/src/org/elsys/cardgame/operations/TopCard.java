package org.elsys.cardgame.operations;

import org.elsys.cardgame.factory.CardImpl;
import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class TopCard extends OperationImpl {

    public TopCard(GameImpl game) {
        super("top_card", game);
    }

    @Override
    public void execute() {
        CardImpl card = (CardImpl) game.getDeck().topCard();
        CardImpl.print(card);
    }
}
