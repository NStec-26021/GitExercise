package numer0n.factory.service;

import numer0n.service.CommandHandler;
import numer0n.service.impl.NumeronCommandHandlerImpl;

public interface NumeronCommandHandlerFactory {
    public static CommandHandler create() {
        return new NumeronCommandHandlerImpl();
    }
}
