package n9;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/6/12
 * @version 1.0.0
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;

        res = solution.isPalindrome(121);
        System.out.println(res);
        System.out.println("---");

        res = solution.isPalindrome(-121);
        System.out.println(res);
        System.out.println("---");

        res = solution.isPalindrome(10);
        System.out.println(res);
        System.out.println("---");

    }

    /**
     * https://leetcode-cn.com/problems/palindrome-number/submissions/
     *
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     *
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     *
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        System.out.println(s);
        int length = s.length();

        int mid = (length + 1) / 2;
        for (int i = 0; i < mid; i++) {
            if (!(s.charAt(i) ==s.charAt(length-i-1))){
                return false;
            }
        }
        return true;
    }


}
