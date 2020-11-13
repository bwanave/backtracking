package org.example.queen;

import org.example.common.Chessboard;

public class NQueensProblem {
    private final Chessboard chessboard;

    public NQueensProblem(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void placeQueens() {
        boolean result = placeQueenInColumn(0);
        if (result) {
            System.out.println("All queens placed successfully !");
            System.out.println(chessboard);
        }
        else
            System.out.println("Unable to place the queens. No possible solution available");
    }

    private boolean placeQueenInColumn(int col) {
        // BASE CASE
        if (col >= chessboard.getSize())
            return true;

        for (int row = 0; row < chessboard.getSize(); row++) {
            Chessboard.Position pos = new Chessboard.Position(row, col);
            boolean isSafe = isSafePos(pos);
            if (isSafe) {
                // Place queen
                chessboard.set(pos, 1);

                // place next queen (in next column)
                // RECURSIVE CASE
                boolean isSuccess = placeQueenInColumn(col + 1);
                if (isSuccess)
                    return true;
                else {
                    // BACKTRACKING
                    // Remove currently placed queen as this path doesn't leading to correct solution
                    chessboard.set(pos, 0);
                }
            }
        }
        return false;
    }

    private boolean isSafePos(Chessboard.Position pos) {
        int row = pos.getX();
        int col = pos.getY();

        int i, j;
        // Safe row left
        for (i = 0; i <= col; i++)
            if (chessboard.get(new Chessboard.Position(row, i)) == 1)
                return false;

        // Left upper diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (chessboard.get(new Chessboard.Position(i, j)) == 1)
                return false;

        // Left lower diagonal
        for (i = row, j = col; i < chessboard.getSize() && j >= 0; i++, j--)
            if (chessboard.get(new Chessboard.Position(i, j)) == 1)
                return false;
        return true;
    }
}
