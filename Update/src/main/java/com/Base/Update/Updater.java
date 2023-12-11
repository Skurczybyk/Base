package com.Base.Update;

import org.update4j.Configuration;
import org.update4j.FileMetadata;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
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
}
