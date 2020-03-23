package com.alvl.nix.homework.lesson18;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SubStrings {
    public static void main(String[] args) throws IOException {
        findSubString("lol");
    }

    public static void findSubString(String s) {
        Path source = Paths.get("C:\\Users\\Егор\\IdeaProjects\\corehomework\\src\\main\\java\\com\\alvl\\nix\\homework\\lesson18\\substrings.txt");//C:\Users\Егор\IdeaProjects\corehomework\src\main\java\com\alvl\nix\homework\lesson18
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(source)) {
            while (scanner.hasNext()) {
                String scanned = scanner.nextLine();
                if (scanned.contains(s))
                    lines.add(scanned);
            }
        } catch (IOException ignored) {
            throw new RuntimeException(ignored);
        }
        lines.forEach(System.out::println);
    }

}
