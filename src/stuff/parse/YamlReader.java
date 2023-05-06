package stuff.parse;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import stuff.interfaces.BaseReader;
import stuff.model.MusicBand;
import stuff.utility.Printer;

import java.io.*;

/**
 * Parser that reads Yaml from file, adding converted object to collection
 *
 * @author ilestegor
 */
public class YamlReader implements BaseReader {
    MusicBand[] musicBands;
    private final Printer printer;

    public YamlReader(Printer printer) {
        this.printer = printer;
    }

    @Override
    public MusicBand[] read(String path) throws FileNotFoundException, ClassCastException {
        YAMLMapper yamlMapper = new YAMLMapper(new YAMLFactory());
        yamlMapper.registerModule(new JavaTimeModule());
        try {
            InputStreamReader input = new InputStreamReader(new FileInputStream(path));
            musicBands = yamlMapper.readValue(input, MusicBand[].class);
        } catch (FileNotFoundException ex){
            printer.printNextLine("Файл не найден или отсутсвуют права на файл!");
        } catch (IOException ex) {
            printer.printNextLine("Файл пустой или поля у объектов невалидны. Проверьте файл и валидность данных!");
        } catch (ClassCastException ex) {
            printer.printNextLine("Тип введенного поля не соответсвует требуемому типу! Попробуйте еще раз");
        }
        return musicBands;
    }

    public MusicBand[] getMusicBands() {
        return musicBands;
    }
}
