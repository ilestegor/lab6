package common.porcessors;

import common.manager.CommandManager;
import common.network.Request;
import common.network.Response;

public class ServerCommandProcessor {
    public Response processCommand(Request request){
        if (CommandManager.executeServer(request)){
            return CommandManager.getServerCommandMap().get(request.getCommandDTO().getCommandName()).execute(request);
        } return new Response("Такой команды нет или у данной команды не должно быть аргументов!");
    }
}
