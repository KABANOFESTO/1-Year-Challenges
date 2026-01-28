package arrays;

public class GameBoard {

    private final char[][] board;
    private final int size;

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void placeMove(int row, int col, char player) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (board[row][col] != '-') {
            throw new IllegalStateException("Cell already occupied");
        }
        board[row][col] = player;
    }

    public void displayBoard() {
        for (char[] rows : board) {
            for (char cell : rows) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GameBoard game = new GameBoard(3);

        game.placeMove(0, 0, 'X');
        game.placeMove(1, 1, 'O');
        game.placeMove(2, 2, 'X');

        game.displayBoard();
    }
}
