package com.Update;

public class Main {
    public static void main(String[] args) {
        String userTest = ConfigutationCreator.userDir;
        String targetTest = ConfigutationCreator.bootstrapTargetDir;
        String jfxTarget = ConfigutationCreator.jfxTargetDir;
        String updateTarget = ConfigutationCreator.updateTargetDir;
        System.out.println(userTest);
        System.out.println(targetTest);
        System.out.println(jfxTarget);
        System.out.println(updateTarget);
        ConfigutationCreator.createConfig();
    }
}