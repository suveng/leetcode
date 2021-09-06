/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package sort.bubble;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(new int[] {10, 2, 1, 2, 3, 4, 5})));
    }
}