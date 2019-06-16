package n14;

/**
 * description:
 * @author suwenguang
 * @date 19-6-16
 * @version 1.0.0
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = "";

        res=solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(res);

        res=solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        System.out.println(res);

    }


    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String res = strs[0];


        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < res.length() && j < strs[i].length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res=res.substring(0,j);
            if (res.equals("")){
                return res;
            }
        }
        return res;
    }
}
