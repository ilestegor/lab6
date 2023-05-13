package server.parse;

import common.manager.ServerCollectionManager;
import common.utility.Printer;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import server.model.MusicBand;
import common.interfaces.BaseWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Parser for writing collection to file in Yaml
 *
 * @author ilestegor
 */
public class YamlWriter implements BaseWriter, Runnable {
    private final Printer printer;
    private final ServerCollectionManager serverCollectionManager;

    public YamlWriter(Printer printer, ServerCollectionManager serverCollectionManager) {
        this.printer = printer;
        this.serverCollectionManager = serverCollectionManager;
    }

    @Override
    public void write(String path) {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);
        if (path == null || !new File(path).exists()) {
            printer.printError("Файла, который задан в переменной окружения не существует. Коллекция не сохранена в файл!");
            return;
        }
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path))) {
            yaml.dump(new CloneParser().parseToClone(serverCollectionManager.getMusicBandLinkedList().toArray(new MusicBand[0])), writer);
            writer.flush();
            printer.printNextLine("Коллекция успешно сохранена");
        } catch (IOException e) {
            printer.printError("Отсутсвуют права на файл! Коллекция не сохранена в файл");
        }
    }

    @Override
    public void run() {
        write(System.getenv("YamlFle"));
    }
}
