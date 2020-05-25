package com.alvl.nix.homework.lesson32;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MultThread implements Runnable {
    private final StoreStrings storeStrings;

    MultThread(StoreStrings storeStrings) {
        this.storeStrings = storeStrings;
    }

    private File file = new File("output.txt");

    @Override
    public void run() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            synchronized (storeStrings) {
                String quit = "quit";
                while (!storeStrings.getInput().equals(quit)) {
                    if (storeStrings.isChanged()) {
                        bw.write(storeStrings.getInput());
                        Thread.sleep(1000);
                    }

                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

