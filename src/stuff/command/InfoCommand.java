package stuff.command;

import common.command.Command;
import common.manager.CommandManager;
import common.manager.ServerCollectionManager;
import common.network.Request;
import common.network.RequestFactory;
import common.network.Response;
import stuff.utility.Printer;

/**
 * Class contains implementation of info stuff.command
 * Outputs basic information about collection (type, date of init, number of elements)
 *
 * @author ilestegor
 */
public class InfoCommand extends Command {

    public InfoCommand(ServerCollectionManager serverCollectionManager) {
        super("info", "Команда выводит основную информацию о коллекции: тип, дата инициализации, количество элементов", serverCollectionManager);
    }
    public InfoCommand(){}

    @Override
    public Request execute(Printer printer) {
        return new RequestFactory().createRequest(getName(), getArgs());
    }

    @Override
    public Response execute(Request request) {
        if (checkArgument(new Printer(), request.getRequestBody().getArgs())) {
            return new Response("Тип коллекции: " + getMusicBandCollectionManager().getMusicBandLinkedList().getClass().getSimpleName() + "\n" +
                    "Дата инициализации: " + getMusicBandCollectionManager().getLocalDate().toString().substring(0, 10) + "\n" +
                    "Количсетво элементов: " + getMusicBandCollectionManager().getMusicBandLinkedList().size());
        } return new Response("Команда info не имеет аргументов, попробуйте ввести команду без аргументов!");
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
