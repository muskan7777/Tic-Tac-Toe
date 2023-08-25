
//import java.util.function.DoubleToIntFunction;
//mport java.util.Random;
import java.util.Scanner;

//TICTACTOE GAME

//1stclass to creat the dashboard and perform the functionality
class TicTacToe {
    static char[][] board; // 2d array

    public TicTacToe() {
        board = new char[3][31 ];
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // display the board on screen
    static void dispBoard() {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" |");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("---------");
         }
    }

    // to perform the functionality add the x and 0
    static void placeMark(int row, int col, char mark) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            board[row][col] = mark;
        } else {
            System.out.println("invalid position");
        }
    }

    // check win win conditions on colms
    static boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;

    }

    // check win win condition on rows
    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    // check win win condition on diagonals
    static boolean checkDiagWin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        } else {
            return false;
        }
    }

}

// player class
//abstract class Player {
    //String name;
    //char mark;

   // abstract void makeMove();

    //boolean isValidMove(int row, int col) {
        //if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
           // if (TicTacToe.board[row][col] != ' ') {
               // return true;
            //}
       // }
       // return false;

    //}
//}

// 2nd class create for human player
class HumanPlayer //extends Player
 {
    String name;
    char mark;

    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("enter the rows and col");
            row = scan.nextInt();
            col = scan.nextInt();
        } while (!isValidMove(row, col));
        TicTacToe.placeMark(row, col, mark);

    }

    // for valid or invalid move or space is empty or on dashboard
     boolean isValidMove(int row, int col) { //reusable code
    if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
     if (TicTacToe.board[row][col] != ' ') {
     return true;
     }
    }
    return false;

  }
}

//class AIPlayer extends Player {
    //String name;
    //char mark;

    //AIPlayer(String name, char mark) {
        //this.name = name;
        //this.mark = mark;
    //}

    //void makeMove() {
        //Scanner scan = new Scanner(System.in);
        //int row;
        //int col;
        //do {
            //Random r = new Random();
            //row = r.nextInt(3);
            //col = r.nextInt(3);
        //} while (!isValidMove(row, col));
        //TicTacToe.placeMark(row, col, mark);

    //}

    // for valid or invalid move or space is empty or on dashboard
    // boolean isValidMove(int row, int col) {
    // if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
    // if (TicTacToe.board[row][col] != ' ') {
    // return true;
    // }
    // }
    // return false;

    // }
//}

public class LaunchGame {
    public static void main(String args[]) {
        TicTacToe t = new TicTacToe();
        // this for while checking the functionality of displayboard
        // t.dispBoard();
        // t.placeMark(0, 0, 'x');
        // t.placeMark(1, 1, 'x');
        // t.placeMark(2, 2, 'x');
        // t.placeMark(0, 2, 'x');
        // t.placeMark(2, 0, 'x');

        // t.dispBoard();
        //System.out.println(t.checkColWin());
        // System.out.println(t.checkRowWin());
        // System.out.println(t.checkDiagWin());

        HumanPlayer p1 = new HumanPlayer("Nobita", 'x');
        HumanPlayer p2 = new HumanPlayer("Sizuka", 'o');
        //AIPlayer p2 = new AIPlayer("AI", 'o');

        HumanPlayer cp;// curren player(cp) its helps to deciding the chance of player
        cp = p1;

        while (true) {
            System.out.println(cp.name + " turn");
            cp.makeMove();
            TicTacToe.dispBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
                System.out.println(cp.name + " has Won");
                break;
            } else {
                if (cp == p1) {
                    cp = p2;
                } else {
                    cp = p1;
                }
            }
        }

    }

}
