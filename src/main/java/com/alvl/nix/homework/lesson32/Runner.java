package com.alvl.nix.homework.lesson32;

public class Runner {
    public static void main(String[] args) {
        StoreStrings storeStrings = new StoreStrings();
        MultThread multThread = new MultThread(storeStrings);
        new Thread(multThread,"multthread").start();
    }
}
