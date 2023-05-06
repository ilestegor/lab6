//package stuff.command;
//
//import common.command.Command;
//import common.manager.ServerCollectionManager;
//import stuff.parse.YamlWriter;
//import stuff.utility.Printer;
//
///**
// * Class contains implementation of save stuff.command
// * Saves collection to file
// *
// * @author ilestegor
// */
//public class SaveCommand extends Command {
//    public SaveCommand(ServerCollectionManager serverCollectionManager) {
//        super("Команда сохраняет коллекцию в файл", serverCollectionManager);
//    }
//
//    @Override
//    public void execute(Printer printer) {
//        if (checkArgument(new Printer(), getArgs())) {
//            YamlWriter yamlWriter = new YamlWriter(new Printer(), getMusicBandCollectionManager());
//            yamlWriter.write(System.getenv("YamlFile"));
//        }
//    }
//
//    @Override
//    public boolean checkArgument(Printer printer, Object inputArgs) {
//        if (inputArgs == null) {
//            return true;
//        } else {
//            printer.printNextLine("У команды save нет аргументов! Попробуйте еще раз");
//            return false;
//        }
//    }
//}
