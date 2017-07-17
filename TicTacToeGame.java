//Hi Dave, some comments - parts of this was created as a shell. I filled in the code for methods etc. 
//The Play method starting at line 171 needs to be split into more methods
//However, I can't seem to be able to do it without loosing the value of 'col' and 'row' inputs by the user
//Also having trouble placing the playAgain piece method
//And having trouble placing a counter for the total number of games, number of Player 1 wins, Player 2 wins, draws and best wins (nubers in a row)
//Also need to code for a computer player - would you happen to know of any good examples on the internet?
//you help is very much appreciated!!!


/** COMP 1006/1406
  * Summer 2017
  *
  * Assignment 1
  */

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class TicTacToeGame{
  public static char turn = 'X';
  public static int row, col;
  public static Scanner scan = new Scanner (System.in);


  /** symbol for X */
  public static final Character ex = 'X';

  /** symbol for O */
  public static final Character oh = 'O';

  /** symbol for empty grid element */
  public static final Character empty = ' ';

  /** board is the grid that the game is played on;
    * each element must be one of ex, oh or empty*/
  public static Character[][] board;

  /** rows is the number of rows (N) in the game board */
  public static int rows;

  /** columns is the number of columns (M) in the game board */
  public static int columns;

  /** win_condition is the value of K, the winning condition of the game */
  public static int win_condition;

  /** specifies if the game is 1p (human-human) or 2p (human-computer) */
  public static boolean human_human_game;


  /** Checks for a win based on the last symbol played in the game
   *
   * It is assumed that the position specified by the last_row_played
   * and last_column_played is valid and that the symbol in the board
   * at that position is not empty. (It must be <em>ex</em> or <em>oh</em>)
   *
   * @param last_row_played is the row of the last symbol played
   * @param last_column_played is the column of the last symbol played
   * @return the length of the winning row/column/diagonal of symbols
   * if the last move is a winning move, or -1 if the last move is not
   * a winning move.
   */
  public static int win(int last_row_played, int last_column_played){
    // add your code and change the return value
    return -2;
  }

  /** main method to run the game
    *
    * @param args optional command line arguments to
    * specify if the game is 1p (human-computer) or
    * 2p (human-human). Expect the string "2p" if any
    * command line argument is given.
    */
  public static void main(String[] args){

    /*------------------------------------------
     * handle command line arguments if any
     * to determine if the game is human-human
     * or human-computer
     *------------------------------------------*/
    if( args.length > 0){
      /* there are commend line arguments present */
      // add your code here
      if (args[0].equals("2p"))
      {
        System.out.println("Human Human Game!");
        human_human_game = true;
      }
      else
      {
      /* there are no command line argument present */
      // add your code here
        System.out.println("Human Computer Game!");
        human_human_game = false;
      }
    }

    /*------------------------------------
     * read N-M-K data from init file
     * N = rows
     * M = columns
     * K = win_condition
     *------------------------------------*/

    /*-------------------------------------
     *-------------------------------------
     * BEGIN : Do NOT change the code here
     *-------------------------------------*/
    BufferedReader file_input;
    FileReader     file;
    String         file_name = "init";
    String         line;

    try{
      file = new FileReader(file_name);
      file_input = new BufferedReader(file);

      line = file_input.readLine();
      rows = Integer.parseInt(line);

      line = file_input.readLine();
      columns = Integer.parseInt(line);

      line = file_input.readLine();
      win_condition = Integer.parseInt(line);

      /* always close your files you are done with them! */
      file_input.close();

    }catch(Exception e){
      /* somethine went wrong! */
      System.err.println("Failure to read data from init file properly");
      System.err.println(e);
      System.err.println("Program ending");
      return;
    }


    /*-------------------------------------
     * END : Do NOT change the code here
     *-------------------------------------
     *-------------------------------------*/


    /* create and initialize the game board */


    /* allocate memory for the board array */
    board = new Character[rows][columns];
    //KW code: scanner = new Scanner (System.in);

    // add code to initialize all elements to empty
    //EmptyBoard();


    /* code to drive the game */

    // add your code here
    for (int i=0; i<rows; i++){
      for (int j=0; j<columns; j++){
        board[i][j] = '_' ;
      }
    }

    PrintBoard();
    Play();

  }





  public static void Play()
  {
    System.out.println("Welcome to tic-tac-toe++! Please enter a row and a column: ");
    Integer ticker = 0;
    boolean playing = true;
    while (playing)
    {
      String line = scan.nextLine();
      String row1 = line.split(" ")[1];
      String col1 = line.split(" ")[3];

      Integer row = Integer.valueOf(row1);
      Integer col = Integer.valueOf(col1);

      if (row<0 || row > rows || col<0 || col > columns)
      {
        System.out.println("Entry must be between row 0 to " + rows + " and column 0 to " + columns + ". Try again: ");
      }

      else if (board[row][col] == '_')
      {
        board[row][col] = turn;
        ticker++;
        System.out.println(" ");
        System.out.println(turn + " was placed at row " + row + " and column "+ col);


        int matchV = 0;
        int matchH = 0;
        //check for horizontal win
        for (int j = 0; j < columns; j++)
        {
          if (board[row][j] == turn)
            matchH++;
        }

        //check for vertical win
        for (int i = 0; i < rows; i++)
        {
          if (board[i][col] == turn)
            matchV++;
        }

        PrintBoard();

        if (matchH == win_condition || matchV == win_condition)
        {
          System.out.print("Game Over! " + turn + " wins!");
          //EmptyBoard();

//fix this
        playAgain();

        }
        else
        {
          if (turn == 'X')
            turn = 'O';
          else
            turn = 'X';
          if (ticker == rows*columns)
          {
            System.out.println("GameOver! Tie Game!");

//fix this
          playAgain();

          }
          System.out.println(" ");
          System.out.println("Please enter a row and column: ");
        }
      }
      else
      {
        System.out.println("Box already filled. Please enter a row and column: ");
      }
    }
  }

  public static void EmptyBoard(){
    for (int i=0; i<rows; i++){
      for (int j=0; j<columns; j++){
        board[i][j]='_';
      }
      //System.out.println();
    }
  }

  public static void PrintBoard(){
    for (int i=0; i<rows; i++){
      System.out.println();
      for (int j=0; j<columns; j++){
        if (j == 0)
          System.out.print("| ");
        System.out.print(board[i][j] + " | ");
      }
    }
    System.out.println();
  }

 
 

  public static void printScore(){

  }



  public static void playAgain()
  {
    System.out.println("Play again (Y/N)? ");
    char c = scan.next().charAt(0);
    if (c == 'Y')
    {
      EmptyBoard();
      Play();
    }

  }

}
