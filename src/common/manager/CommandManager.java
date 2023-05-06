package common.manager;

import common.command.Command;
import common.network.Request;
import stuff.command.*;
import stuff.utility.Printer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Contains methods for storing, getting stuff.command instances
 *
 * @author ilestegor
 */
public class CommandManager {
    private static HashMap<String, Command> clientCommandMap;
    private static HashMap<String, Command> serverCommandMap;
    private final ServerCollectionManager serverCollectionManager;
    private static final Printer printer = new Printer();


    public CommandManager(ServerCollectionManager serverCollectionManager) {
        this.serverCollectionManager = serverCollectionManager;
        initServerCommands();
        initClientCommands();
    }

    private void initServerCommands() {
        serverCommandMap = new HashMap<>();
        serverCommandMap.put("help", new HelpCommand(serverCollectionManager));
        serverCommandMap.put("info", new InfoCommand(serverCollectionManager));
        serverCommandMap.put("exit", new ExitCommand(serverCollectionManager));
//        serverCommandMap.put("show", new ShowCommand(serverCollectionManager));
//        serverCommandMap.put("remove_by_id", new RemoveByIdCommand(serverCollectionManager));
//        serverCommandMap.put("clear", new ClearCommand(serverCollectionManager));
//        serverCommandMap.put("add", new AddCommand(serverCollectionManager));
//        serverCommandMap.put("count_by_number_of_participants", new CountByNumberOfParticipantsCommand(serverCollectionManager));
//        serverCommandMap.put("filter_starts_with_name", new FilterStartsWithNameCommand(serverCollectionManager));
//        serverCommandMap.put("update", new UpdateIdCommand(serverCollectionManager));
//        serverCommandMap.put("print_ascending_number_of_participants", new PrintFieldAscNumberOfParticipantsCommand(serverCollectionManager));
//        serverCommandMap.put("save", new SaveCommand(serverCollectionManager));
//        serverCommandMap.put("sort", new SortCommand(serverCollectionManager));
//        serverCommandMap.put("insert_at", new InsertAtIndexCommand(serverCollectionManager));
//        serverCommandMap.put("remove_lower", new RemoveLowerCommand(serverCollectionManager));
//        serverCommandMap.put("execute_script", new ExecuteScriptCommand(serverCollectionManager));
    }

    private void initClientCommands(){
        clientCommandMap = new HashMap<>();
        clientCommandMap.put("info", new InfoCommand());
        clientCommandMap.put("help", new HelpCommand());
        clientCommandMap.put("exit", new ExitCommand());
    }

    /**
     * Return all commands that stored in HashMap
     *
     * @return HashMap object with Command objects
     */
    public static HashMap<String, Command> getClientCommandMap() {
        return clientCommandMap;
    }

    public static HashMap<String, Command> getServerCommandMap() {
        return serverCommandMap;
    }

    public static boolean executeClient(String[] inputData){
        if (inputData.length == 0){
            return false;
        } else {
            String command = inputData[0];
            return clientCommandMap.containsKey(command);
        }
    }

    public static boolean executeServer(Request request){
        return serverCommandMap.containsKey(request.getCommandDTO().getCommandName());
    }
}
