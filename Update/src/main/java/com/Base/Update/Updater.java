package com.Base.Update;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.FileMetadata;
import org.update4j.UpdateOptions;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Updater {
    private static String userDir = System.getProperty("user.dir");
    private static String pathDir = userDir + "\\.m2\\repository\\com\\Base";
    public static void updatePrint()
    {

        System.out.println("To jest updater");
        Configuration config = Configuration.builder()
                .baseUri("https://raw.githubusercontent.com/Skurczybyk/Base/master")
                .basePath(userDir)
                .file(FileMetadata.readFrom("Update/target/Update-0.0.1-SNAPSHOT-jar-with-dependencies.jar").uri("https://raw.githubusercontent.com/Skurczybyk/Base/master/Update/target/Update-0.0.1-SNAPSHOT-jar-with-dependencies.jar").path(userDir + "Update\\Update\\0.0.1-SNAPSHOT\\Update-0.0.1-SNAPSHOT-jar-with-dependencies.jar").ignoreBootConflict(true))
                .file(FileMetadata.readFrom("TheApp/target/TheApp-0.0.1-SNAPSHOT-jar-with-dependencies.jar").uri("https://raw.githubusercontent.com/Skurczybyk/Base/master/TheApp/target/TheApp-0.0.1-SNAPSHOT-jar-with-dependencies.jar").path(userDir + "App\\TheApp\\0.0.1-SNAPSHOT\\TheApp-0.0.1-SNAPSHOT-jar-with-dependencies.jar").ignoreBootConflict(true))
                .build();
        System.out.println(config.toString());
        try ( Writer out = Files.newBufferedWriter(Paths.get("config.xml"))){

            config.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void makeUpdate() throws IOException {
        System.out.println(pathDir);
        URL configURL = new URL("https://raw.githubusercontent.com/Skurczybyk/Base/master/config.xml");
        Reader in = new InputStreamReader(configURL.openStream(), StandardCharsets.UTF_8);
        Configuration config = null;
        config = Configuration.read(in);
        System.out.println(config.toString());
        Path zip = Paths.get("up.zip");
        config.update(UpdateOptions.archive(zip));
        Archive.read(zip).install();
    }
    public static void testDownload() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/Skurczybyk/Base/master/Update/target/Update-0.0.1-SNAPSHOT.jar");
        ReadableByteChannel chanell = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream("Updater.jar");
        stream.getChannel().transferFrom(chanell,0, Long.MAX_VALUE);
    }
}
