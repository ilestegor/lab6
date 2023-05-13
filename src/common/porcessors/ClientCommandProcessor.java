package common.porcessors;

import common.manager.CommandManager;
import common.network.Request;
import common.utility.Printer;
import common.exception.CommandIsNotExecutedException;
import common.exception.RecursionException;
import common.exception.WrongArgumentException;

import java.util.Arrays;

public class ClientCommandProcessor {
    private final Printer printer = new Printer();


    public Request commandRequest(String[] inputData) {
        String command = inputData[0];
        String[] args = Arrays.copyOfRange(inputData, 1, inputData.length);
        CommandManager.getClientCommandMap().get(command).setName(command);
        CommandManager.getClientCommandMap().get(command).setArgs(args);
        try {
            return CommandManager.getClientCommandMap().get(command).execute(new Printer());
        } catch (WrongArgumentException ex) {
            printer.printError(ex.getMessage());
        } catch (RecursionException ex){
            printer.printError(ex.getMessage());
        }
        throw new CommandIsNotExecutedException();
    }

    public boolean commandChecker(String[] inputData) {
        if (CommandManager.executeClient(inputData)) {
            return true;
        } else {
            printer.printNextLine("Такой команды нет! Введите команду help для просмотра списка всех доступных команд");
            return false;
        }
    }
}
