import java.util.Scanner;


public class Player {
    String coordinates;
    char coordinateX, coordinateY;
    byte moveCounter = 1;


    public byte getMoveCounter() {
        return moveCounter;
    }

    public char[][] update(char gridOfGame[][]) {

        if (moveCounter % 2 == 0) {

            System.out.println("\tMove №" + moveCounter + ". Second player, Your turn! Enter move: ");
        } else {
            System.out.println("\tMove №" + moveCounter + ". First player, Your turn! Enter move: ");
        }
        Scanner scannerOfPlayerMove = new Scanner(System.in);


        coordinates = scannerOfPlayerMove.next();

        if (coordinates.length() != 2) {
            System.out.println("This move is not available! Enter correct move! ");
            return gridOfGame;
        }

        coordinateX = coordinates.charAt(0);
        coordinateY = coordinates.charAt(1);

        int x = 0, y = 0;
        switch (coordinateX) {
            case 'a':
                x = 0;
                break;
            case 'b':
                x = 1;
                break;
            case 'c':
                x = 2;
                break;
            default:
                System.out.println("This move is not available! Enter correct move!\n");
                return gridOfGame;
        }
        switch (coordinateY) {
            case '1':
                y = 0;
                break;
            case '2':
                y = 1;
                break;
            case '3':
                y = 2;
                break;
            default:
                System.out.printf("This move is not available! Enter correct move!\n");
                return gridOfGame;
        }


        if (gridOfGame[x][y] == '-') {
            if ((moveCounter % 2 == 0) && (gridOfGame[x][y] != 'X') && (gridOfGame[x][y] != '0')) {
                gridOfGame[x][y] = 'X';
                moveCounter++;
            } else {
                gridOfGame[x][y] = '0';
                moveCounter++;
            }
        } else {
            System.out.println("Choose another point! \t");
        }
        return gridOfGame;
    }
}
