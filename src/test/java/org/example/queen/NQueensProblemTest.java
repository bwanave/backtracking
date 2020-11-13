package org.example.queen;

import org.example.common.Chessboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NQueensProblemTest {

    @Test
    void placeQueens() {
        Chessboard chessboard = new Chessboard(4, 0);
        NQueensProblem nQueensProblem = new NQueensProblem(chessboard);
        nQueensProblem.placeQueens();
        String expected = "0\t0\t1\t0\n" +
                "1\t0\t0\t0\n" +
                "0\t0\t0\t1\n" +
                "0\t1\t0\t0";
        Assertions.assertEquals(expected, chessboard.toString());
    }

    @Test
    void placeQueensFail() {
        Chessboard chessboard = new Chessboard(4, 0);
        NQueensProblem nQueensProblem = new NQueensProblem(chessboard);
        nQueensProblem.placeQueens();
        String expected = "0\t0\t1\t01\n" +
                "1\t0\t0\t0\n" +
                "0\t0\t0\t1\n" +
                "0\t1\t0\t0";
        Assertions.assertNotEquals(expected, chessboard.toString());
    }
}