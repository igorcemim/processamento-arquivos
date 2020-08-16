package br.com.cemim.analisevendas.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileWriter {

    public void write(Path path, String content) throws IOException {
        Files.createFile(path);
        Files.writeString(path, content);
    }

}
