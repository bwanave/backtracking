package org.example.queen;

import org.example.common.Chessboard;

public class Main
{
    public static void main(String[] args)
    {
        Chessboard chessboard = new Chessboard(4, 0);
        NQueensProblem nQueensProblem = new NQueensProblem(chessboard);
        nQueensProblem.placeQueens();
    }
}
