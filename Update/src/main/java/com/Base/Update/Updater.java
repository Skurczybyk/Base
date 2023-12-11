package com.Base.Update;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.FileMetadata;
import org.update4j.UpdateOptions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Updater {
    public static void updatePrint()
    {
        String userDir = System.getProperty("user.dir");
        System.out.println("To jest updater");
        Configuration config = Configuration.builder()
                .baseUri("https://github.com/Skurczybyk/Base/tree/master")
                .basePath(userDir)
                .files(FileMetadata.streamDirectory("").filter(f -> f.getSource().getFileName().toString().endsWith(".jar")))
                .build();
        System.out.println(config.toString());
        try ( Writer out = Files.newBufferedWriter(Paths.get("config.xml"))){

            config.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void makeUpdate() throws IOException {
        URL configURL = new URL("https://raw.githubusercontent.com/Skurczybyk/Base/master/config.xml");
        Reader in = new InputStreamReader(configURL.openStream(), StandardCharsets.UTF_8);
        Configuration config = null;
        config = Configuration.read(in);
        Path zip = Paths.get("up.zip");
        config.update(UpdateOptions.archive(zip));
        Archive.read(zip).install();
    }
}
