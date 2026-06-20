package numer0n.service.impl;

import static numer0n.constant.GameConfig.*;
import numer0n.exception.KeyNotFoundException;
import numer0n.service.CommandHandler;

public class NumeronCommandHandlerImpl implements CommandHandler {

    public NumeronCommandHandlerImpl() {}

    @Override
    public String handle(String value) throws KeyNotFoundException {
        if (value.length() == NUMBER_DIGITS) {
            return NUMERON_COMMANDS.get("a");
        } else {
            if (!NUMERON_COMMANDS.containsKey(value)) {
                throw new KeyNotFoundException();
            }

            return NUMERON_COMMANDS.get(value);
        }
    }

}
