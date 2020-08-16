package br.com.cemim.analisevendas.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileReader {

    public String readFrom(String path) throws IOException {
        var bytes = Files.readAllBytes(Path.of(path));
        return new String(bytes);
    }

}
