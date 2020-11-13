package org.example.common;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Chessboard {
    private final int[][] chessboard;

    public Chessboard(int size, int initializeBy) {
        chessboard = new int[size][size];

        if (initializeBy != 0) {
            for (int[] row : chessboard) {
                Arrays.fill(row, initializeBy);
            }
        }
    }

    public int get(Position pos) {
        return chessboard[pos.getX()][pos.getY()];
    }

    public void set(Position pos, int value) {
        chessboard[pos.getX()][pos.getY()] = value;
    }

    public int getSize() {
        return chessboard.length;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int[] row : chessboard) {
            String string = Arrays.stream(row)
                    .boxed()
                    .map(Object::toString)
                    .collect(Collectors.joining("\t"));
            stringJoiner.add(string);
        }
        return stringJoiner.toString();
    }

    /**
     * A Position, which represents single cell on chessboard.
     */
    public static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", j=" + y +
                    '}';
        }
    }
}
