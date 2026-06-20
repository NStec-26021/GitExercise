package numer0n.factory.service;

import numer0n.service.CommandHandler;
import numer0n.service.impl.GameCommandHandlerImpl;

public interface GameCommandHandlerFactory {
    public static CommandHandler create() {
        return new GameCommandHandlerImpl();
    }
}
