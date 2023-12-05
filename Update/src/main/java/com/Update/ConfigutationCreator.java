package com.Update;

import org.update4j.Configuration;
import org.update4j.FileMetadata;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigutationCreator {
    public static String userDir = System.getProperty("user.dir");
    public static String bootstrapTargetDir = userDir + "\\Bootstrap\\target\\";
    public static String jfxTargetDir = userDir + "\\JFX\\target\\";
    public static String updateTargetDir = userDir + "\\Update\\target\\";
    public static void createConfig()
    {
        Configuration config = Configuration.builder()
                .baseUri("https://github.com/Skurczybyk/Base")
                .basePath(userDir)
                .files(FileMetadata.streamDirectory("").filter(e->e.getSource().toString().endsWith(".jar")))
                .build();
        try(Writer out = Files.newBufferedWriter(Paths.get("config.xml")))
        {
            config.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
