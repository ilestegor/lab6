//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import common.manager.UserManager;
//import stuff.utility.Printer;
//
///**
// * Class contains implementation of add stuff.command
// * Adds new element to collection
// *
// * @author ilestegor
// */
//public class AddCommand extends Command {
//    public AddCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда добавляет новый пользоватлеьский элемент в коллекцию", serverCollectionManager);
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        if (checkArgument(new Printer(), getArgs())) {
//            if (getMusicBandCollectionManager().getMusicBandLinkedList().add(UserManager.requestDataForUserMusicBand())){
//                printer.printNextLine("Объект успешно добавлен в коллекцию!");
//            } else printer.printNextLine("Объект не добавлен в коллекцию! Попробуйте еще раз");
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            return true;
//        } else {
//            printer.printNextLine("У команды add нет аргументов!");
//            return false;
//        }
//    }
//}
