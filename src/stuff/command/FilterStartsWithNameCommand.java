//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import stuff.model.MusicBand;
//import stuff.utility.Printer;
//
///**
// * Class contains implementation of filter_starts_with_name stuff.command
// * Outputs elements which name's start with same substring
// *
// * @author ilestegor
// */
//public class FilterStartsWithNameCommand extends Command {
//
//    public FilterStartsWithNameCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда выводит элементы, названия групп которых начинаются с заданной подстроки", serverCollectionManager);
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        int count = 0;
//        if (checkArgument(new Printer(), getArgs())) {
//            if (getMusicBandCollectionManager().getMusicBandLinkedList().isEmpty()) {
//                printer.printNextLine("Коллекция пуста!");
//            } else {
//                for (MusicBand musicBand : getMusicBandCollectionManager().getMusicBandLinkedList()) {
//                    if (musicBand.getName().startsWith(getArgs().toString())) {
//                        count++;
//                        System.out.println(musicBand);
//                    }
//                }
//                printer.printNextLine("Количество групп, подходящих под условие " + count);
//                if (count == 0) {
//                    printer.printNextLine("Групп с такой подстрокой не нашлось!");
//                }
//            }
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            printer.printNextLine("У команды filter_starts_with_name должен быть аргумент (подстрока, с которой начинается название музыкальной группы) \n" +
//                    "IMPORTANT: Регистр подстроки важен! Если название начинается с большой буквы, а Вы ввели маленькую, или наоборот, то музыкальная группы найдена не будет");
//            return false;
//        } else {
//            return true;
//        }
//    }
//}
