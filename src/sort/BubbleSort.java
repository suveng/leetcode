/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package sort;

/**
 * @author suwenguang
 * @since 2021-09-06 12:57
 */
public class BubbleSort {

    // 每一次和相邻的元素比较, 大的就往后移动, 一次遍历后, 大的元素就在最后了;
    public int[] sort(int[] source) {
        if (source == null) {
            return null;
        }

        int[] sort;
        sort = source;

        // 需要比较 n - 1 次, n是3, 就要比较两次
        for (int i = 0; i < sort.length - 1; i++) {
            // 调换也只需要 调换未排序好的元素的长度 - 1
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j + 1];
                    sort[j + 1] = sort[j];
                    sort[j] = temp;
                }
            }
        }
        return sort;
    }
}