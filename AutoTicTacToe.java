import java.util.*;

public class AutoTicTacToe {
    static char[] board = new char[9];
    static char currentPlayer;

    public static void main(String[] args) {
        Arrays.fill(board, ' '); // initialize empty board
        Random rand = new Random();
        currentPlayer = rand.nextBoolean() ? 'X' : 'O';

        System.out.println("TIC TAC TOE AUTO GAME STARTS!");
        printBoard();

        while (true) {
            // Get available moves
            List<Integer> emptyPositions = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    emptyPositions.add(i);
                }
            }

            // Random move
            int move = emptyPositions.get(rand.nextInt(emptyPositions.size()));
            board[move] = currentPlayer;

            System.out.println(currentPlayer + " played at position " + (move + 1));
            printBoard();

            // Check for win or draw
            if (checkWinner(currentPlayer)) {
                System.out.println("🎉 " + currentPlayer + " wins!");
                break;
            } else if (isFull()) {
                System.out.println("😐 It's a draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            // Delay for readability
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }

    // Print the board
    public static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    // Check if the board is full
    public static boolean isFull() {
        for (char c : board)
            if (c == ' ')
                return false;
        return true;
    }

    // Check for winner
    public static boolean checkWinner(char player) {
        int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };
        for (int[] pos : winPositions) {
            if (board[pos[0]] == player && board[pos[1]] == player && board[pos[2]] == player)
                return true;
        }
        return false;
    }
}
