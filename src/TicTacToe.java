/**
 * Write a program that plays tic-tac-toe. The tic-tac-toe game is played on a 3 × 3 grid and is played by two players, who take turns.
 * The first player marks moves with a circle, the second with a cross. The player who has formed a horizontal, vertical, or diagonal sequence of three marks wins.
 * Your program should draw the game board, ask the user for the coordinates of the next mark, change the players after every successful move, and pronounce the winner.
 */
public class TicTacToe {

    private String[][] board; //null?
    private boolean full;


    public TicTacToe(){
        board = new String[][]{{"Open", "Open", "Open"}, {"Open", "Open", "Open"}, {"Open", "Open", "Open"}}; //?
        //just for fun we'll do each inner array is a column.
        //top to bottom
        full = false;
    }

    public void player1Plays(int x, int y){
        board[x-1][y-1] = "O";//?
    }
    public void player2Plays(int x, int y){
        board[x-1][y-1] = "X";
    }

    /**
     * This method checks if there is a horizontal, vertical, or diagonal sequence of three marks, i.e. if someone has won.
     * It will return an int representing who won
     * @return 1 if player 1 has won, 2 if player 2 has won, and 0 if no one has won
     */
    public int checkWin(){
        if(checkMark("O")){
            return 1;
        }
        if(checkMark("X")){
            return 2;
        }else{
            return 0;
        }
    }

    /**
     * Standard getter for the board
     * @return a primitive String 2-D array which is the board
     */
    public String[][] getBoard() {
        return board;
    }


    private boolean checkMark(String mark){
        for(int i =0; i<= board.length-1; i++){
            if(checkDown(board, mark, i, 0)) {
                return true;
            }
        }
        for(int i =0; i<= board[0].length-1; i++){
            if(checkRight(board, mark, 0, i)) {
                return true;
            }
        }
        //i just realized all my calls are redundant for the board passing in
        if(checkNegativeDiagonal(board, mark, 0, 0)){
            return true;
        }
        if(checkPositiveDiagonal(board, mark, board.length-1, 0)){
            return true;
        }
        return false;
    }
    private boolean checkRight(String[][] board, String root, int x, int y){
        int winningLength = 3;
        int xPos = x;
        int yPos = y;
        boolean found = false;

        for(int i = 1; i<=winningLength-1; i++){
            if(translateRight(board,xPos, yPos).equals(root)){
                xPos++;
            }else{
                found = false;
                break;
            }
            found = true;
        }
        return found;
    }    //this one???
    private boolean checkDown(String[][] board, String root, int x, int y){
        int winningLength = 3;
        int xPos = x;
        int yPos = y;
        boolean found = false;

        for(int i = 1; i<=winningLength-1; i++){
            if(translateDown(board,xPos, yPos).equals(root)){
                yPos++;
            }else{
                found = false;
                break;
            }
            found = true;
        }
        return found;
    }
    private boolean checkNegativeDiagonal(String[][] board, String root, int x, int y){
        int winningLength = 3;
        int xPos = x;
        int yPos = y;
        boolean found = false;

        for(int i = 1; i<=winningLength-1; i++){
            if(translateNegativeDiagonal(board,xPos, yPos).equals(root)){
                xPos++;
                yPos++;
            }else{
                found = false;
                break;
            }
            found = true;
        }
        return found;
    }
    private boolean checkPositiveDiagonal(String[][] board, String root, int x, int y){
        int winningLength = 3;
        int xPos = x;
        int yPos = y;
        boolean found = false;

        for(int i = 1; i<=winningLength-1; i++){
            if(translatePositiveDiagonal(board,xPos, yPos).equals(root)){
                xPos++;
                yPos++;
            }else{
                found = false;
                break;
            }
            found = true;
        }
        return found;
    }
    private String translateRight(String[][] board, int x, int y){
        //the x and y are going to be indexed values
        return board[x+1][y];
    }
    private String translateDown(String[][] board, int x, int y){
        //the x and y are going to be indexed values
        return board[x][y+1];
    }
    private String translateNegativeDiagonal(String[][] board, int x, int y){
        //the x and y are going to be indexed values
        return board[x+1][y+1];
    }
    private String translatePositiveDiagonal(String[][] board, int x, int y){
        //the x and y are going to be indexed values
        return board[x-1][y+1];
    }
}
