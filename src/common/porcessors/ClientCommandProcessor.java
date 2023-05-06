package common.porcessors;

import common.manager.CommandManager;
import common.network.Request;
import common.network.RequestFactory;
import stuff.utility.Printer;

import java.util.Arrays;

public class ClientCommandProcessor {
    private final Printer printer = new Printer();


    public Request commandRequest(String[] inputData){
        String command = inputData[0];
        String[] args = Arrays.copyOfRange(inputData, 1, inputData.length);
        if (CommandManager.executeClient(inputData)){
            CommandManager.getClientCommandMap().get(command).setName(command);
            CommandManager.getClientCommandMap().get(command).setArgs(args);
           return CommandManager.getClientCommandMap().get(command).execute(new Printer());
        }
        return new RequestFactory().createRequest("", new String[]{});
    }

    public boolean commandChecker(String[] inputData){
        if (CommandManager.executeClient(inputData)){
           return true;
        } else {
            printer.printNextLine("Такой команды нет!");
            return false;
        }
    }
}
