package com.alvl.nix.homework.lesson12.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TicTacToe3x3 implements TicTacToe {
    private static final Logger log = LoggerFactory.getLogger(TicTacToe3x3.class);
    private char[][] gameGrid = new char[][]{
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };
    private boolean gameFinished = false;
    private byte moveOfPlayers = 1;

    @Override
    public int reset(Players playersGame) {
        log.info("Reset the game?");
        System.out.println("Restart Game? 1 - Yes : 2 - No");
        Scanner scannerOfReset = new Scanner(System.in);
        int choice = scannerOfReset.nextInt();
        if (choice == 1) {
            gameGrid = new char[][]{
                    {'-', '-', '-'},
                    {'-', '-', '-'},
                    {'-', '-', '-'}
            };
            moveOfPlayers = 1;
            gameFinished = false;
            log.info("Game reset!");
            playersGame.moveCounter = 1;
            startGame(playersGame);
        } else if (choice == 2) {
            log.info("Game Over!");
            System.out.println("Game Over!");
            return 0;
        } else return 0;

        return 0;
    }

    @Override
    public void startGame(Players playersGame) {
        log.info("Game start!");
        System.out.println("Game start");
        while (gameFinished == false) {
            playersGame.update(gameGrid);
            moveOfPlayers = playersGame.getMoveCounter();
            gameWinCheck();
            gameFinished();
        }
        ifGameFinished(playersGame);
    }

    public void gameWinCheck() {
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length; j++) {
                if (moveOfPlayers > 5) {
                    if ((gameGrid[0][0] == gameGrid[0][1]) && (gameGrid[0][1] == gameGrid[0][2]) && (gameGrid[0][0] != '-')) {
                        gameFinished = true;
                    }
                    if ((gameGrid[1][0] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[1][2]) && (gameGrid[1][1] != '-')) {
                        gameFinished = true;
                    }
                    if ((gameGrid[2][0] == gameGrid[2][1]) && (gameGrid[2][1] == gameGrid[2][2]) && (gameGrid[2][2] != '-')) {
                        gameFinished = true;
                    }

                    if ((gameGrid[0][0] == gameGrid[1][0]) && (gameGrid[1][0] == gameGrid[2][0]) && (gameGrid[0][0] != '-')) {
                        gameFinished = true;
                    }
                    if ((gameGrid[0][1] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[2][1]) && (gameGrid[1][1] != '-')) {
                        gameFinished = true;
                    }
                    if ((gameGrid[0][2] == gameGrid[1][2]) && (gameGrid[1][2] == gameGrid[2][2]) && (gameGrid[2][2] != '-')) {
                        gameFinished = true;
                    }

                    if ((gameGrid[0][0] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[2][2]) && (gameGrid[2][2] != '-')) {
                        gameFinished = true;
                    }
                    if ((gameGrid[0][2] == gameGrid[1][1]) && (gameGrid[1][1] == gameGrid[2][0]) && (gameGrid[2][0] != '-')) {
                        gameFinished = true;
                    }
                }
                System.out.print(gameGrid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void gameFinished() {
        if (moveOfPlayers > 9) {
            gameFinished = true;
        }
    }

    public void ifGameFinished(Players playersGame) {
        if (gameFinished == true) {
            if (moveOfPlayers < 10) {
                if (moveOfPlayers % 2 == 0) {
                    log.info("First player win!");
                    System.out.println("First player win!");
                } else {
                    log.info("Second player win!");
                    System.out.println("Second player win!");
                }
            } else {
                log.info("Tie!");
                System.out.println("Tie!");
            }
            reset(playersGame);
        }
    }

}

