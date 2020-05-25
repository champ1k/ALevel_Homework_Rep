package com.alvl.nix.homework.lesson32;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StoreStrings implements Runnable {
    private String input = "";
    private Scanner scanner = new Scanner(System.in);
    private boolean changed;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public void run() {
        setInput(scanner.nextLine());
        setChanged(true);
    }
}
