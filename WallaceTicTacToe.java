import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WallaceTicTacToe {

    static ArrayList<Integer> userInput1 = new ArrayList<Integer>();
    static ArrayList<Integer> userInput2 = new ArrayList<Integer>();

    /*EDIT 1*/
    static ArrayList<Integer> filledPositions = new ArrayList<>();


    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Player1 enter the place that you would like your X to go (1-9):");
            int userInput1 = scan.nextInt();
            System.out.println("Player2 enter the place that you would like your O to go (1-9):");
            int userInput2 = scan.nextInt();
            System.out.println(userInput1);
            System.out.println(userInput2);

            if (userInput1 < 1 || userInput1 > 9) {
                System.out.println("Player 1 that is not on the board, chose another place!");
                userInput1 = scan.nextInt();
            }
            if (userInput2 < 1 || userInput2 > 9) {
                System.out.println("Player 2 that is not on the board, chose another place!");
                userInput2 = scan.nextInt();
            }
            if (userInput1 == userInput2) {
                System.out.println("Player 1 chose that spot, chose another position!");
                userInput2 = scan.nextInt();
            }


            /*EDIT 2*/
            for(int i: filledPositions){
                if(userInput1 == i){
                    System.out.println("error message");
                    userInput1 = scan.nextInt();
                }
                if(userInput2 == i){
                    System.out.println("error message");
                    userInput2 = scan.nextInt();
                }
            }
            filledPositions.add(userInput1);
            filledPositions.add(userInput2);


            placement(gameBoard, userInput1, "player1");
            placement(gameBoard, userInput2, "player2");

            printGameBoard(gameBoard);
            String result = winner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

        }

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placement(char[][] gameBoard, int userInput1, String user) {
        char symbol = ' ';
        if (user.equals("player1")) {
            symbol = 'X';
        } else {
            symbol = 'O';
            userInput2.add(userInput1);
        }
        switch (userInput1) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String winner() {

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List centerCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List topLeftDiagonal = Arrays.asList(1, 5, 9);
        List bottomLeftDiagonal = Arrays.asList(3, 5, 7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(centerCol);
        winningConditions.add(leftCol);
        winningConditions.add(rightCol);
        winningConditions.add(topLeftDiagonal);
        winningConditions.add(bottomLeftDiagonal);

        for (List l : winningConditions) {
            if (userInput1.containsAll(l)) {
                return "Player 1 won!";
            } else if (userInput2.containsAll(l)) {
                return "Player 2 won!";
            } else if (userInput1.size() + userInput2.size() >= 9) {
                return "It is a tie!";
            }

        }

        return "";


    }
}