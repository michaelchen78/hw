import java.sql.SQLOutput;
import java.util.Scanner;

public class TicTacToeTester {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        boolean finished = false;
        Scanner in = new Scanner(System.in);
        int turn = 1;
        int won = 0;

        while(!finished){
            drawBoard(game);
            System.out.printf("It is Player %d's turn.", turn);
            System.out.printf("\nPlease input the x coordinate: ");
            int x = in.nextInt();
            System.out.printf("Please input the y coordinate: ");
            int y = in.nextInt();

            if(turn==1) {
                game.player1Plays(x, y);
            }else{
                game.player2Plays(x, y);
            }


            won = game.checkWin();
            if(won!=0){
                finished=true;
            }

            if(turn ==1){
                turn =2;
            }else{
                turn =1;
            }
        }

        drawBoard(game);

        System.out.println("The winner is: " + won + "!");



    }

    private static void drawBoard(TicTacToe game){
        System.out.println();
        System.out.println();

        //why did this fail?
        //
        for(int i = 0; i<= game.getBoard()[/*i*/0].length -1; i++) { //this is redundant since not each? ?????
            for (int j = 0; j <= game.getBoard().length - 1; j++) {
                String s = "%4s | ";
                if (j == game.getBoard().length - 1) {
                    s = "%4s";
                }
                System.out.printf(s, game.getBoard()[j][i]);
            }
            if (!(i == game.getBoard().length - 1)) {
                System.out.println("\n__________________");
            }
        }

        System.out.println();
        System.out.println();
    }



}
