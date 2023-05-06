package stuff.parse;

import stuff.interfaces.BaseWriter;
import common.manager.ServerCollectionManager;
import stuff.model.MusicBand;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import stuff.utility.Printer;

import java.io.*;

/**
 * Parser for writing collection to file in Yaml
 *
 * @author ilestegor
 */
public class YamlWriter implements BaseWriter {
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
        if (!new File(path).exists()){
            printer.printNextLine("Файла, который задан в переменной окружения не существует. Коллекция не сохранена в файл!");
            return;
        }
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path))) {
            yaml.dump(new CloneParser().parseToClone(serverCollectionManager.getMusicBandLinkedList().toArray(new MusicBand[0])), writer);
            writer.flush();
            printer.printNextLine("Коллекция успешно сохранена");
        } catch (IOException e) {
            printer.printNextLine("Отсутсвуют права на файл! Коллекция не сохранена в файл");
        }
    }
}
