package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.Operation;

public abstract class OperationImpl implements Operation {

    protected String name;
    protected GameImpl game;

    public OperationImpl(String name, GameImpl game) {
        this.name = name;
        this.game = game;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract void execute();
}
