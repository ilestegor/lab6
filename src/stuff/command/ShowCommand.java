//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import stuff.model.MusicBand;
//import stuff.utility.Printer;
//
///**
// * Class contains implementation of show stuff.command
// * Outputs all elements in collection
// *
// * @author ilestegor
// */
//public class ShowCommand extends Command {
//    public ShowCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда выводит все элементы коллекции", serverCollectionManager);
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        if (checkArgument(new Printer(), getArgs())) {
//            if (getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
//                printer.printNextLine("Коллекция пуста!");
//            } else {
//                for (MusicBand musicBand : getMusicBandCollectionManager().getMusicBandLinkedList()) {
//                    System.out.println(musicBand);
//                }
//            }
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            return true;
//        } else {
//            printer.printNextLine("Команда show не имеет аргументов, попробуйте ввести команду без аргументов!");
//            return false;
//        }
//    }
//}
