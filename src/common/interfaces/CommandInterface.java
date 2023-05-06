package common.interfaces;

import common.network.Request;
import stuff.utility.Printer;

/**
 * Contains methods for stuff.command execution and argument checking
 *
 * @author ilestegor
 */
public interface CommandInterface {
    /**
     * Executes stuff.command
     *
     * @return
     */
    Request execute(Printer printer);

    /**
     * Validate arguments
     *
     * @param inputArgs
     * @return
     */

    boolean checkArgument(Printer printer, String[] inputArgs);
}
