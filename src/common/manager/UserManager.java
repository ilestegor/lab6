package common.manager;

import common.command.Command;
import stuff.exception.RecursionException;
import stuff.model.MusicBand;
import stuff.model.MusicBandBuilder;
import stuff.utility.Printer;
import stuff.utility.RecursionLimiter;

import java.util.*;

/**
 * Contains tools for getting data from user
 *
 * @author ilestegor
 */
public class UserManager {
    private static final HashMap<String, Command> commandMap;
    private static final Scanner scanner;
    private static boolean isInWork;
    private static final Printer printer = new Printer();
    private static final int COMMAND_NAME_POSITION = 0;
    private static final int COMMAND_ARGUMENT_POSITION = 1;

    static {
        Printer printer = new Printer();
        commandMap = CommandManager.getClientCommandMap();
        scanner = new Scanner(System.in);
        isInWork = true;
        printer.printNextLine("Приложение запущено!");
        printer.printNextLine("Чтобы ознакомиться c командами, введите команду help");
    }

    /**
     * Requests commands for script from file
     *
     * @param list
     */
    public static void requestCommandForScript(List<String> list) {
        try {
            for (String command : list) {
                command = command.replaceAll("\\s+", " ").trim().strip();
                printer.printNextLine("\nСейчас выполняется команда " + command);
                RecursionLimiter.emerge();
                requestPlainCommand(command);
            }
        } catch (RecursionException ex) {
            printer.printError("\nСкрипт вызывает сам себя! Выход из скрипта");
        }
    }

    /**
     * Gets data from user via Command Line and executes commands
     *
     * @param line
     */
    public static String[] requestPlainCommand(String line) {
        String[] commandAndArgument = line.split(" ");
        String command = commandAndArgument[COMMAND_NAME_POSITION];
        String argument;
        if (commandAndArgument.length == 1) {
            return new String[]{command.toLowerCase()};
        } else if (commandAndArgument.length == 2) {
            argument = commandAndArgument[COMMAND_ARGUMENT_POSITION];
            return new String[]{command.toLowerCase(), argument};
        } else {
            return new String[]{};
        }
    }

    /**
     * Requests stuff.command from user with ask to enter stuff.command
     */
    public static String[] requestCommand() {
        try {
            printer.printThisLine("\nВведите команду: ");
            String line = scanner.nextLine().strip().replaceAll("\\s+", " ");
            return requestPlainCommand(line);
        } catch (NoSuchElementException ex) {
            printer.printNextLine("Завершение программы!");
            setIsInWork(false);
        }
        return new String[]{};
    }

    /**
     * Requests data from user for adding new MusicBand object to collection. Used with add stuff.command
     *
     * @return MusicBand object
     */
    public static MusicBand requestDataForUserMusicBand() {
        MusicBandBuilder musicBandBuilder = new MusicBandBuilder();
        return musicBandBuilder.buildId().buildName().buildCoordinates().buildCreationDate().buildNumberOfParticipants().buildAlbumsCount().buildEstablishmentDate().buildMusicGenre().buildLabel().build();
    }

    /**
     * Flag for indicating that program is running
     *
     * @return true if program is working, false otherwise
     */
    public static boolean isIsInWork() {
        return isInWork;
    }

    /**
     * Method for setting work of program
     *
     * @param isInWork
     */
    public static void setIsInWork(boolean isInWork) {
        UserManager.isInWork = isInWork;
    }
}
