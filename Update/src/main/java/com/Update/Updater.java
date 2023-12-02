package com.Update;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.UpdateOptions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;

public class Updater {
    public static void checkFrUpdates() throws IOException {
        URL url = new URL("https://github.com/Skurczybyk/Base");
        Configuration config = null;
        try(InputStreamReader in = new InputStreamReader(url.openStream()))
        {
            config = Configuration.read(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Konfiguracja pobrana. Pobieram pliki");
        config.update(UpdateOptions.archive(Path.of("newUpdate.zip")));
        System.out.println("Pliki pobrane. Rozpoczynam aktualizacje");
        Archive.read("newUpdate.zip").install();
        System.out.println("Aktualizacja zakończona");
    }
}
