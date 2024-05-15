package com.Base.Bootstrap;

import com.Base.App.Starter;
import com.Base.Update.Updater;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! Main 2");
        //Updater.updatePrint();
        try {
            Updater.makeUpdate();
        } catch (IOException e) {
            System.out.println("Aplikacja aktualna");
        }
        Starter starter = new Starter();
                starter.start();
/*        try {
            Updater.testDownload();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}