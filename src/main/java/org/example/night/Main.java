package org.example.night;

import org.example.common.Chessboard;

public class Main
{
    public static void main(String[] args)
    {
        Chessboard chessboard = new Chessboard(8, -1);
        KnightTour knightTour = new KnightTour(chessboard);
        knightTour.startTour();
    }
}
