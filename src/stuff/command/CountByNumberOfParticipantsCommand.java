//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import stuff.model.MusicBand;
//import stuff.utility.Printer;
//
///**
// * Class contains implementation of count_by_number_of_participants stuff.command
// * Counts by number of participants and outputs amount of elements with the same number of participants
// *
// * @author ilestegor
// */
//public class CountByNumberOfParticipantsCommand extends Command {
//
//
//    public CountByNumberOfParticipantsCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда выводит количество элементов, значение поля numberOfParticipants которых равно заданному", serverCollectionManager);
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        int count = 0;
//        if (checkArgument(new Printer(), getArgs())) {
//            int userCountInput = Integer.parseInt(getArgs().toString());
//            if (getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
//                printer.printNextLine("Коллекция пуста!");
//            } else {
//                for (MusicBand musicBand : getMusicBandCollectionManager().getMusicBandLinkedList()) {
//                    if (musicBand.getNumberOfParticipants() == userCountInput) {
//                        count++;
//                    }
//                }
//                if (count == 0) {
//                    printer.printNextLine("Музыкальных групп с таким количеством участников не найдено!");
//                } else
//                    printer.printNextLine("Количество музыкальных групп с указанным количеством участников: " + count);
//            }
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            System.out.println("У команды count_by_number_of_participants должен быть аргумент!");
//            return false;
//        } else {
//            try {
//                int count = Integer.parseInt(getArgs().toString());
//                if (count < 0) {
//                    printer.printNextLine("Аргумент должен быть > 0!");
//                    return false;
//                } else {
//                    return true;
//                }
//            } catch (NumberFormatException ex) {
//                printer.printNextLine("Команда count_by_number_of_participants имеет аргумент типа  (int)!");
//                return false;
//            }
//        }
//    }
//
//}
