package com.alvl.nix.homework.lesson12.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Players {
    private static final Logger log = LoggerFactory.getLogger(Players.class);
    String coordinates;
    char coordinateX;
    char coordinateY;
    public byte moveCounter = 1;

    public byte getMoveCounter() {
        return moveCounter;
    }

    public void update(char gridGame[][]) {
        move();
        setCoordinates(gridGame);
    }

    public void move() {
        if (moveCounter % 2 == 0) {
            log.info("\tMove №" + moveCounter + ". Second player, Your turn! Enter move: ");
            System.out.println("\tMove №" + moveCounter + ". Second player, Your turn! Enter move: ");
        } else {
            log.info("\tMove №" + moveCounter + ". First player, Your turn! Enter move: ");
            System.out.println("\tMove №" + moveCounter + ". First player, Your turn! Enter move: ");
        }
    }

    public char[][] setCoordinates(char[][] gridOfGame) {
        Scanner scannerOfPlayerMove = new Scanner(System.in);
        coordinates = scannerOfPlayerMove.next();
        if (coordinates.length() != 2) {
            log.warn("This move is not available! Enter correct move!");
            System.out.println("This move is not available! Enter correct move! ");
            return gridOfGame;
        }
        coordinateX = coordinates.charAt(0);
        coordinateY = coordinates.charAt(1);
        int x = 0, y = 0;
        for (int i = 0, j = 49; j < 58; i++, j++) {
            if (coordinateX != j) {
                continue;
            } else {
                x = i;
                break;
            }
        }
        for (int i = 0, j = 49; j < 58; i++, j++) {
            if (coordinateY != j) {
                continue;
            } else {
                y = i;
                break;
            }
        }

        if (x >= gridOfGame.length && y >= gridOfGame.length) {
            log.warn("Choose another point! \t");
            System.out.println("Choose another point! \t");
            return gridOfGame;
        }
        if (gridOfGame[x][y] == '-') {
            if ((moveCounter % 2 == 0) && (gridOfGame[x][y] != 'X') && (gridOfGame[x][y] != '0')) {
                gridOfGame[x][y] = 'X';
                log.info("Player Second move" + gridOfGame[x][y] + " ");
                moveCounter++;
            } else {
                gridOfGame[x][y] = '0';
                log.info("Player First move" + gridOfGame[x][y] + " ");
                moveCounter++;
            }
        } else {
            log.warn("Choose another point! \t");
            System.out.println("Choose another point! \t");
        }
        return gridOfGame;
    }

}