package common.command;

import common.manager.ServerCollectionManager;
import common.network.Request;
import common.network.RequestFactory;
import common.network.Response;
import common.network.ResponseFactory;
import common.utility.Printer;
import server.model.MusicBand;
import common.exception.WrongArgumentException;

import java.util.*;

/**
 * Class contains implementation of print_filed_ascending_number_of_participants
 *
 * @author ilestegor
 */
public class PrintFieldAscNumberOfParticipantsCommand extends Command {

    public PrintFieldAscNumberOfParticipantsCommand(ServerCollectionManager serverCollectionManager) {
        super("print_ascending_number_of_participants", "Команда выводит колиечство участников всех групп в порядке возрастания", serverCollectionManager);
    }

    public PrintFieldAscNumberOfParticipantsCommand() {
    }

    @Override
    public Request execute(Printer printer) {
        if (checkArgument(getArgs())) {
            return new RequestFactory().createRequest(getName(), getArgs());
        }
        throw new WrongArgumentException("У команды print_ascending_number_of_participants нет аргументов! Попробуйте еще раз");

    }

    @Override
    public Response execute(Request request) {
        if (getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
            return new ResponseFactory().createResponse("Коллекция пуста");
        } else {
            LinkedHashMap<String, Integer> bandNameAndParticipantsCount = new LinkedHashMap<>();
            for (MusicBand musicBand : getMusicBandCollectionManager().getMusicBandLinkedList()) {
                bandNameAndParticipantsCount.put(musicBand.getName(), musicBand.getNumberOfParticipants());
            }
            List<Map.Entry<String, Integer>> newList = new ArrayList<Map.Entry<String, Integer>>(bandNameAndParticipantsCount.entrySet());
            Collections.sort(newList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
            ArrayList<String> bandsForResponse = new ArrayList<>();
            for (Map.Entry<String, Integer> l : newList) {
                bandsForResponse.add(l.getKey() + "  ->  " + l.getValue());
            }
            return new ResponseFactory().createResponse("Название группы -> Количество участников:\n" + String.join("\n", bandsForResponse));
        }

    }

    @Override
    public boolean checkArgument(String[] inputArgs) {
        return inputArgs.length == 0;
    }
}
