package 整数反转_7;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/2
 * description:
 **/

class Solution {
    public int reverse(int x) {
        //处理输入
        long res = 0;
        int max = 0x7fffffff;
        int min = 0x80000000;

        //翻转逻辑
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        //判断溢出
        if (res < min || res > max) {
            return 0;
        }
        return (int) res;
    }
}

