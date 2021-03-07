package perso.salim.lettersfreqwar.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component("FileUtils")
public class FileUtils {

    public List<String> getDictionnary(String path) throws IOException {

        return readListFromPathWithScanner(path);

    }

    public List<String> readListFromPathWithScanner(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

           return reader.lines().collect(Collectors.toList());

        }
    }

    public String getPathFromCode(String languageCode) {

        String baseFileURI = "C:/Users/sghba/IdeaProjects/Repo JAVA/letters-freq/letters-freq-war/src/main/resources/Dictionaries/";

        switch (languageCode){
            case "fr":
                return baseFileURI + "fr_FR.txt";
            case "es":
                return baseFileURI + "es_ES.txt";
            case "en":
            default:
                return baseFileURI + "en_EN.txt";
        }
    }
}
