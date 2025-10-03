package recursions;

public class SodukuSolver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sol.solveSudoku(board);
    }

    static class Solution {
        public void solveSudoku(char[][] board) {
            solveSudoku(board, 0, 0);
        }

        public char[][] solveSudoku(char[][] board, int x, int y) {
            if (y == board[0].length) {
                y = 0;
                x++;
            }
            if (x == board.length) {
                return board;
            }
            if (board[x][y] == '.') {
                boolean[] options = new boolean[10];
                for (char[] chars : board) {
                    if (chars[y] != '.') {
                        options[chars[y] - 48] = true;
                    }
                }
                for (int i = 0; i < board[0].length; i++) {
                    if (board[x][i] != '.') {
                        options[board[x][i] - 48] = true;
                    }
                }
                for (int i = 1; i < options.length; i++) {
                    if (!options[i]) {
                        board[x][y] = (char) (i + 48);
                        if (solveSudoku(board, x, y + 1) == null) {
                            board[x][y] = '.';
                        } else {
                            return board;
                        }
                    }
                }
                return null;
            } else {
                return solveSudoku(board, x, ++y);
            }
        }
    }
}
