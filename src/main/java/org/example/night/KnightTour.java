package org.example.night;

import org.example.common.Chessboard;

public class KnightTour
{
    // All possible moves for Knight
    private static final int[][] possibleMoves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private final Chessboard chessboard;

    public KnightTour(Chessboard chessboard)
    {
        this.chessboard = chessboard;
    }

    public void startTour()
    {
        // Start from the first position/cell on chessboard. i.e. pos [0, 0]
        Chessboard.Position startPos = new Chessboard.Position(0, 0);
        int moveIndex = 0;
        chessboard.set(startPos, moveIndex);

        // Perform next move
        boolean result = performMove(startPos, moveIndex + 1);
        if (result)
        {
            System.out.println("Knight's tour completed.");
            System.out.println(chessboard);
        }
        else
            System.out.println("Unable to complete Knight's tour. No possible solution available");
    }

    private boolean performMove(Chessboard.Position currentPos, int moveIndex)
    {
        // BASE CASE
        if (moveIndex >= chessboard.getSize() * chessboard.getSize())
            return true;

        for (int[] move : possibleMoves)
        {
            Chessboard.Position nextPos = new Chessboard.Position(currentPos.getX() + move[0], currentPos.getY() + move[1]);
            boolean isSafe = isSafePos(nextPos);
            if (isSafe)
            {
                // perform move
                chessboard.set(nextPos, moveIndex);

                // perform next move.
                // RECURSIVE CASE
                boolean isMoveSuccess = performMove(nextPos, moveIndex + 1);
                if (isMoveSuccess)
                    return true;
                else
                {
                    // BACKTRACKING
                    // Rollback current move as this path doesn't leading to correct solution
                    chessboard.set(nextPos, -1);
                }
            }
        }
        return false;
    }

    private boolean isSafePos(Chessboard.Position pos)
    {
        return pos.getX() >= 0 && pos.getX() < chessboard.getSize()
                && pos.getY() >= 0 && pos.getY() < chessboard.getSize()
                && chessboard.get(new Chessboard.Position(pos.getX(), pos.getY())) == -1;
    }
}
