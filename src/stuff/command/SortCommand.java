//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import stuff.utility.Printer;
//import stuff.utility.SortByName;
//
///**
// * Class contains implementation of sort stuff.command
// * Sorts collection by id
// *
// * @author ilestegor
// */
//public class SortCommand extends Command {
//    public SortCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда сортирует коллекцию по названию музыкальной группы", serverCollectionManager);
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        if (checkArgument(new Printer(), getArgs())) {
//            if (getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
//                printer.printNextLine("Коллекция пуста! Сортировать нечего");
//            } else {
//                getMusicBandCollectionManager().getMusicBandLinkedList().sort(new SortByName());
//                printer.printNextLine("Коллекция успешно отсортирована!");
//            }
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            return true;
//        } else {
//            printer.printNextLine("У команды sort не должно быть аргументов!");
//            return false;
//        }
//    }
//
//}
