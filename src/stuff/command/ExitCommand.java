package stuff.command;

import client.network.ClientConnection;
import common.command.Command;
import common.manager.ServerCollectionManager;
import common.manager.UserManager;
import common.network.Request;
import common.network.RequestFactory;
import common.network.Response;
import common.network.ResponseFactory;
import server.network.ServerConnection;
import stuff.utility.Printer;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Class contains implementation of exit stuff.command
 * Terminates the application
 *
 * @author ilestegor
 */
public class ExitCommand extends Command {


    public ExitCommand(ServerCollectionManager serverCollectionManager) {
        super("exit", "Команда завершает программу без сохранения результата в файл", serverCollectionManager);
    }

    public ExitCommand(){};
    @Override
    public Request execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())){
            UserManager.setIsInWork(false);
            return new RequestFactory().createRequest(getName(), getArgs());
        } return new RequestFactory().createRequest("", new String[]{});
    }

    @Override
    public Response execute(Request request) {
//            команда сохранения коллекции

            return new ResponseFactory().createResponse("Завершение работы!");
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
