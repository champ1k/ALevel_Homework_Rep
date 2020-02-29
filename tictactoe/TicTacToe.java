import java.util.logging.*;

import java.io.IOException;
import java.util.logging.FileHandler;

public class TicTacToe {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(TicTacToe.class.getName());
        FileHandler fh = new FileHandler("C:/Users/Егор/firstmodule/tictactoelog.log");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        boolean gameFinished = false;
        char[][] gameGrid = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        System.out.println("How to enter moves:");
        logger.info("Info about moves!");
        String[][] settingsGrid = new String[][]{
                {"a1", "a2", "a3"},
                {"b1", "b2", "b3"},
                {"c1", "c2", "c3"}
        };
        for (String[] strings : settingsGrid) {
            for (int j = 0; j < settingsGrid.length; j++) {
                System.out.print(strings[j] + "\t");
                logger.info(strings[j]+ "\t");
            }
            System.out.println();
        }
        Player playerGame = new Player();
        byte moveOfPlayers = 1;
        logger.info("Game start!");
        System.out.println("Game start");
        while (gameFinished == false) {
            playerGame.update(gameGrid);
            moveOfPlayers = playerGame.getMoveCounter();
            if (moveOfPlayers > 9) {
                gameFinished = true;
            }

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

        if (gameFinished == true) {
            if (moveOfPlayers < 9) {
                if (moveOfPlayers % 2 == 0) {
                    logger.info("First player win!");
                    System.out.println("First player win!");
                } else {
                    logger.info("Second player win!");
                    System.out.println("Second player win!");
                }
            } else {
                logger.info("Tie!");
                System.out.println("Tie!");
            }
            logger.info("Game Over!");
            System.out.println("Game Over!");
        }

    }
}

