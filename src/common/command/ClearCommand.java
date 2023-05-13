package common.command;

import common.manager.ServerCollectionManager;
import common.network.Request;
import common.network.RequestFactory;
import common.network.Response;
import common.network.ResponseFactory;
import common.utility.Printer;
import common.exception.WrongArgumentException;


/**
 * Class contains implementation of clear stuff.command
 * Clears collection
 *
 * @author ilestegor
 */
public class ClearCommand extends Command {

    public ClearCommand(ServerCollectionManager serverCollectionManager) {
        super("clear", "Команда очищает коллекцию", serverCollectionManager);

    }

    public ClearCommand() {
    }

    @Override
    public Request execute(Printer printer) {
        if (checkArgument(getArgs()))
            return new RequestFactory().createRequest(getName(), getArgs());
        throw new WrongArgumentException("У команды " + getName() + " не должно быть аргументов!");
    }

    @Override
    public Response execute(Request request) {
        if (!getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
            getMusicBandCollectionManager().clearCollection();
            return new ResponseFactory().createResponse("Коллекция очищена!");
        }
        return new ResponseFactory().createResponse("Коллекция пустая");
    }

    @Override
    public boolean checkArgument(String[] inputArgs) {
        return inputArgs.length == 0;
    }

}
