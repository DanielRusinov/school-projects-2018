package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.factory.CardImpl;
import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.factory.OperationImpl;

public class Deal extends OperationImpl {

    public Deal(GameImpl game) {
        super("deal", game);
    }

    @Override
    public void execute() {

        for(Card card : game.getDeck().deal().getCards()) {
            CardImpl temp = (CardImpl)card;
            CardImpl.print(temp);
        }
    }
}
