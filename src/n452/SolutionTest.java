/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package n452;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void findMinArrowShots() {
        Solution solution = new Solution();
        int[][] points = new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution.findMinArrowShots(points));

        points = new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrowShots(points));
    }
}