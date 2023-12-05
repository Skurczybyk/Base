package com.Update;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.UpdateOptions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Updater {
    public static void checkFrUpdates() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/Skurczybyk/Base/master/config.xml?token=GHSAT0AAAAAACKTOJT2R5TGGX6ZOMK7HBA2ZLPPCNA");
        Configuration config = null;
        System.out.println("Pobieram konfiguracje");
        try(Reader in = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))
        {
            config = Configuration.read(in);
            System.out.println("Konfiguracja pobrana. Pobieram pliki");
            config.update(UpdateOptions.archive(Path.of("newUpdate.zip")));
            System.out.println("Pliki pobrane. Rozpoczynam aktualizacje");
            Archive.read("newUpdate.zip").install();
            System.out.println("Aktualizacja zakończona");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
