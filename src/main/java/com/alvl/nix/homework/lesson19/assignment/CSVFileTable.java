package com.alvl.nix.homework.lesson19.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.*;

public class CSVFileTable {

    private final String CSV_DELIMITER = ",";

    private String[] headers;

    private List<String[]> table;

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public List<String[]> getTable() {
        return table;
    }

    private String[] getRow(int row) {
        return table.get(row);
    }

    public CSVFileTable(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            headers = Objects.requireNonNull(br.lines()
                    .findFirst()
                    .orElse(null))
                    .split(CSV_DELIMITER);

            table = br.lines()
                    .map(s -> s.split(CSV_DELIMITER))
                    .filter(this::isSize)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getElement(int row, int col) {
        checkCSVSize(row, col);
        return getLineElement(row, col);
    }

    public String getElement(int row, String text) {
        int index = checkCSVSize(row, text);
        return getLineElement(row, index);
    }

    private void checkCSVSize(int row, int col) {
        if ((row < 0 || row >= table.size()) && (col < 0 || col >= headers.length)) {
            throw new IllegalArgumentException();
        }
    }

    private int checkCSVSize(int row, String text) {
        int index = 0;
        if (row < 0 || row >= table.size()) {
            throw new IllegalArgumentException();
        }
        while ((!headers[index++].contains(text))) {
            if (index >= headers.length) {
                throw new IllegalArgumentException();
            }
        }
        index--;
        return index;
    }

    private String getLineElement(int row, int index) {
        String[] line = getRow(row);
        return line[index];
    }

    private boolean isSize(String[] s) {
        return s.length == headers.length;
    }
}
