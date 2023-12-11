package com.Update;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.UpdateOptions;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Updater {
    public static void checkFrUpdates() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/Skurczybyk/Base/master/config.xml");
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
    public static void downloadTest() throws Throwable {
        String link = "https://github.com/Skurczybyk/Base/blob/master/config.xml";
        String fileName = "configuration.xml";
        URL url = new URL(link);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        InputStream in = http.getInputStream();
        byte[] buffer = new byte[4096];
        int n = -1;
        OutputStream out = new FileOutputStream(new File(fileName));
        while((n = in.read(buffer)) != -1)
        {
            out.write(buffer,0,n);
        }
        out.close();
    }

}
