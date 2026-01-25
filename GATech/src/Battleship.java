import java.util.Scanner;
public class Battleship {
    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!\n");
        Scanner input = new Scanner(System.in);

        char [][] p1_locationBoard = new char[5][5];
        char [][] p2_locationBoard = new char[5][5];
        char [][] p1_targetBoard = new char[5][5];
        char [][] p2_targetBoard = new char[5][5];
        
        // intialize boards
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        getShipLocations(p1_locationBoard);
        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        getShipLocations(p2_locationBoard);
        initializeBoard(p1_targetBoard);
        initializeBoard(p2_targetBoard);

        // targeting
        int row, col, p1_score = 0, p2_score = 0, counter = 1;
        do{
            if (counter % 2 != 0) {
                System.out.println("Player 1, enter hit row/column:");
                try {
                    row = input.nextInt();
                    col = input.nextInt();
                    if(row > 5 | col > 5) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                    }
                    else if(p1_targetBoard[row][col] != '-') {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                        continue;
                    }
                    else{
                        if(p2_locationBoard[row][col] != '@') {
                            System.out.println("PLAYER 1 MISSED!");
                            p1_targetBoard[row][col] = 'O';
                        }                            
                        else {
                            System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
                            p1_targetBoard[row][col] = 'X';
                            p1_score++;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
            } else {
                System.out.println("Player 2, enter hit row/column:");
                try {
                    row = input.nextInt();
                    col = input.nextInt();
                    if(row > 5 | col > 5) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                    }
                    else if(p2_targetBoard[row][col] != '-') {
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                        continue;
                    }
                    else{
                        if(p1_locationBoard[row][col] != '@') {
                            System.out.println("PLAYER 2 MISSED!");
                            p2_targetBoard[row][col] = 'O';
                        }                            
                        else {
                            System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
                            p2_targetBoard[row][col] = 'X';
                            p2_score++;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
            }
            counter++;
        } while(p1_score < 5 & p2_score < 5); 

        if(p1_score == 5)
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
        else
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");

        System.out.println("\nFinal boards:");
    }

    public static void initializeBoard(char[][] board) {
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                board[i][j] = '-';
    }

    public static void getShipLocations(char[][] playerBoard) {
        Scanner input = new Scanner(System.in);

        initializeBoard(playerBoard);
        
        int row, col, shipsNum = 1;
        while (shipsNum <= 5) {
            System.out.println("Enter ship " + shipsNum + " location:");
            try {
                row = input.nextInt();
                col = input.nextInt();
                if(row > 5 | col > 5) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
                else if(playerBoard[row][col] == '@') {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    continue;
                }
                playerBoard[row][col] = '@';
                shipsNum++;
            } catch (Exception e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
            }        
        }
    }
}