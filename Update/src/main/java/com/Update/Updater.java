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
        URL url = new URL("https://raw.githubusercontent.com/Skurczybyk/Base/master/config.xml?token=GHSAT0AAAAAACKTOJT25WPBNZLQ6NKBNG72ZLPPY2Q");
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
        String link = "https://github.com/Skurczybyk/Base/blob/master/config.xml?raw=true";
        String fileName = "configuration.xml";
        URL url = new URL(link);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        Map<String,List<String>> header = http.getHeaderFields();
        while(isRedirected(header))
        {
            link = header.get("Location").get(0);
            url = new URL(link);
            http = (HttpURLConnection) url.openConnection();
            header = http.getHeaderFields();
        }
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
    private static boolean isRedirected(Map<String, List<String>> header)
    {
        for (String h:header.get( null ))
        {
        if (h.contains( " 301 ")
        ||  h.contains(" 302 "))
        {
            return true;
        }}
        return false;
    }
}
