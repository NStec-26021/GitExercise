package numer0n.service.impl;

import static numer0n.constant.GameConfig.*;
import static numer0n.constant.MessageConfig.*;
import numer0n.factory.service.GameCommandHandlerFactory;
import numer0n.factory.service.NumeronManagerFactory;
import numer0n.factory.util.InputCommandFactory;
import numer0n.service.CommandHandler;
import numer0n.service.GameManager;
import numer0n.service.NumeronManager;
import numer0n.util.InputCommand;

public class GameManagerImpl implements GameManager {
    private InputCommand inputCommand;

    private CommandHandler gameCommandHandler;

    private NumeronManager numeronManager;

    public GameManagerImpl() {
        this.inputCommand = InputCommandFactory.create();
        this.gameCommandHandler = GameCommandHandlerFactory.create();
        this.numeronManager = NumeronManagerFactory.create();
    }

    @Override
    public void start() {
        this.run();
    }

    private void run() {
        System.out.println(GAME_TITLE);

        while (true) {
            this.inputCommand.input(INPUT_GAME_COMMAND_MESSAGE);

            String input = this.inputCommand.getText();

            try {
                if (this.executeCommand(this.gameCommandHandler.handle(input))) {
                    System.out.println(GAME_EXIT_MESSAGE);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean executeCommand(String command) {
        switch (command) {
            case CONTINUE:
                this.numeronManager.start();
                return false;

            case EXIT:
                return true;

            default:
                return true;
        }
    }
}
