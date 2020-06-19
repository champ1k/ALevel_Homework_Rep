package com.alvl.nix.homework.lesson19.assignment;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        CSVFileTable csvFileTable = new CSVFileTable("C:\\Users\\Егор\\IdeaProjects\\corehomework\\src\\main\\java\\com\\alvl\\nix\\homework\\lesson19\\filetable.csv");
        System.out.println(csvFileTable.getElement(1, 1));
        System.out.println(csvFileTable.getElement(1, "gender"));
    }
}
