//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import stuff.utility.Printer;
//
//
///**
// * Class contains implementation of clear stuff.command
// * Clears collection
// *
// * @author ilestegor
// */
//public class ClearCommand extends Command {
//
//    public ClearCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда очищает коллекцию", serverCollectionManager);
//
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        if (checkArgument(new Printer(), getArgs())) {
//            if (getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
//                printer.printNextLine("Коллекция уже пустая");
//            } else {
//                getMusicBandCollectionManager().clearCollection();
//                printer.printNextLine("Коллекция очищена!");
//            }
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            return true;
//        } else {
//            printer.printNextLine("У команды clear нет аргументов!");
//            return false;
//        }
//    }
//
//}
