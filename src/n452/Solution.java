/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package n452;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author suwenguang
 * @since 2021-09-05 16:39
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        // 如果数组为空, 则立刻返回
        if (points == null) {
            return 0;
        }

        // 排序
        List<int[]> sort = Arrays.asList(points);
        sort.sort(Comparator.comparingInt(o -> o[0]));

        // 贪心策略
        // 遍历数组
        // 初始的射箭区间为第一个结点的右界, 如果下一个结点的左界在射箭区间内, 则比较射箭区间的右界, 更新射箭区间的右界为小的右界, 继续遍历,
        // 如果不在射箭区间内, 则射箭数+1, 更新射箭区间为新节点的右界

        int arrowCount = 1;
        int arrowRight = sort.get(0)[1];
        for (int[] point : sort) {
            if (point[0] <= arrowRight) {
                // 区间内
                if (point[1] < arrowRight){
                    arrowRight = point[1];
                }
            } else {
                // 区间外
                arrowCount++;
                arrowRight=point[1];
            }
        }
        System.out.println(arrowCount);
        return arrowCount;
    }
}