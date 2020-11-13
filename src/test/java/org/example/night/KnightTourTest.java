package org.example.night;

import org.example.common.Chessboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnightTourTest {

    @Test
    void startTour() {
        Chessboard chessboard = new Chessboard(8, -1);
        KnightTour knightTour = new KnightTour(chessboard);
        knightTour.startTour();
        String expected = "0\t59\t38\t33\t30\t17\t8\t63\n" +
                "37\t34\t31\t60\t9\t62\t29\t16\n" +
                "58\t1\t36\t39\t32\t27\t18\t7\n" +
                "35\t48\t41\t26\t61\t10\t15\t28\n" +
                "42\t57\t2\t49\t40\t23\t6\t19\n" +
                "47\t50\t45\t54\t25\t20\t11\t14\n" +
                "56\t43\t52\t3\t22\t13\t24\t5\n" +
                "51\t46\t55\t44\t53\t4\t21\t12";
        Assertions.assertEquals(expected, chessboard.toString());
    }
}