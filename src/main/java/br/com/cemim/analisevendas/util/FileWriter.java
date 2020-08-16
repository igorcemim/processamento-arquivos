package br.com.cemim.analisevendas.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Component
public class FileWriter {

    public void write(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

}
