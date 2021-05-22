package tictactoe;

import java.util.*;

/**
 * @author Omar Elsabaawy
 * The easiest way to implement a TictacToe game ever with 2 players play
 */

public class Tictactoe {

    static Scanner s=new Scanner(System.in);
    static String[] board= new String[9];;
    static String turn;

    public static void main(String[] args) {
        PlayTheGame();
    }
    // The game starts by calling this method as it has all the methods in we start by player 1 with X
    // and player 2 with O
    public static void PlayTheGame(){
        turn = "X";
        String winner = null;
            System.out.println("Welcome to 2 Player Tic Tac Toe.");
            System.out.println("--------------------------------");
            System.out.println("the first player plays with \'X\'");
            System.out.println("the second player plays with \'O\'");
        FillTheBoard();
        PrintTheBoard();
            System.out.println("Enter number to replace by");
        do {
                int Inputnum;
                try {
                        Inputnum = s.nextInt();
                        if (!(Inputnum > 0 && Inputnum <= 9)) {
                                System.out.println("Invalid input; re-enter the number please:");
                                continue;
                        }
                } catch (InputMismatchException e) {
                        System.out.println("Invalid input; re-enter the number please:");
                        continue;
                }
                if (board[Inputnum-1].equals(String.valueOf(Inputnum))) {
                        board[Inputnum-1] = turn;
                        if (turn.equals("X")) {
                                turn = "O";
                        } else {
                                turn = "X";
                        }
                        PrintTheBoard();
                        winner = checkWinner();
                } else {
                        System.out.println("this number is already taken please re-enter the number");
                        continue;
                }
        }while (winner == null);
        
        if (winner.equalsIgnoreCase("draw")) {
                System.out.println("Draw game!!!");
        } else {
                System.out.println("Congratulations!!! player " + winner );
        }
    }
    // This method to check if the player scored 3 Xs or Os in every situation
    public static String checkWinner() {
        for (int i = 0; i < board.length-1; i++) {        
                String line = null;           
                switch (i) {     
                case 0: line = board[0] + board[1] + board[2];      
                    break;

                case 1: line = board[3] + board[4] + board[5]; 
                    break;

                case 2: line = board[6] + board[7] + board[8];
                    break;

                case 3: line = board[0] + board[3] + board[6];
                    break;

                case 4: line = board[1] + board[4] + board[7];   
                    break;

                case 5: line = board[2] + board[5] + board[8];
                    break;

                case 6: line = board[0] + board[4] + board[8];
                    break;

                case 7: line = board[2] + board[4] + board[6];
                        break;
                }
                if (line.equals("XXX")) {
                        return "X";
                } 
                else if (line.equals("OOO")) {
                        return "O";
                    }
                 }

                for (int i = 0; i <board.length; i++) {
                        if (Arrays.asList(board).contains(String.valueOf(i+1))) {
                                break;
                        }
                        else if (i == 8) 
                            return "draw";
                }

            System.out.println(turn + "'s turn; enter a number to place " + turn + " in:");
            return null;
    }
    // Method to print the board
    public static void PrintTheBoard() {
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("\\---|---|---/");
    }
    // Method that insert X or O in a slot
    public static void FillTheBoard() { 
            for (int i = 0; i < board.length; i++) {
                    board[i] = String.valueOf(i+1);
            }
        }
    
}

