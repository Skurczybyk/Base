package com.Base;

import com.Update.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       try {
            Updater.checkFrUpdates();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //com.Update.Main.main(args);
        //com.JFX.Main.main(args);
    }
}