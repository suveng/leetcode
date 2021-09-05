/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package n946;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void validateStackSequences() {
        Solution solution = new Solution();
        int[] pushed = new int[] {1, 2, 3, 4, 5};
        int[] popped = new int[] {4,3,5,1,2};
        System.out.println(
            solution.validateStackSequences(pushed, popped));
    }
}