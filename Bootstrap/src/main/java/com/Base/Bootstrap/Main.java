package com.Base.Bootstrap;

import com.Base.Update.Updater;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Updater.updatePrint();
/*        try {
            Updater.makeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}