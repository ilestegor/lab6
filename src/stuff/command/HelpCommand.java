package stuff.command;

import common.command.Command;
import common.manager.ServerCollectionManager;
import common.manager.CommandManager;
import common.network.Request;
import common.network.RequestFactory;
import common.network.Response;
import common.network.ResponseFactory;
import stuff.utility.Printer;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class contains implementation of help stuff.command\
 * Outputs list of available commands
 *
 * @author ilestegor
 */
public class HelpCommand extends Command {
    public HelpCommand(ServerCollectionManager serverCollectionManager) {
        super("help", "Команда выводит список достпуных комманд и их описание", serverCollectionManager);
    }
    public HelpCommand(){};

    @Override
    public Request execute(Printer printer) {
        return new RequestFactory().createRequest(getName(), getArgs());
    }

    @Override
    public Response execute(Request request) {
        if (checkArgument(new Printer(), request.getRequestBody().getArgs())) {
            int count = 1;
            ArrayList<String> helpCommandList = new ArrayList<>();
            for (Map.Entry<String, Command> command : CommandManager.getServerCommandMap().entrySet()) {
                helpCommandList.add(count + ". " + command.getKey() + " - " + command.getValue().getDescription());
                count++;
            }
            return new ResponseFactory().createResponse(String.join("\n", helpCommandList));
        } return new ResponseFactory().createResponse("У команды help нет аргументов, попробуйте еще раз!");
    }

    @Override
    public boolean checkArgument(Printer printer, String[] inputArgs) {
        if (inputArgs.length == 0) {
            return true;
        } else {
            return false;
        }
    }
}
