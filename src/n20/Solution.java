package n20;

import java.util.Stack;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/18
 * @version 1.0.0
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res;

        res = solution.isValid("()");
        System.out.println(res);

        res = solution.isValid("()[]{}");
        System.out.println(res);

        res = solution.isValid("(]");
        System.out.println(res);

        res = solution.isValid("(])]");
        System.out.println(res);

        res = solution.isValid("{[]}");
        System.out.println(res);

        res = solution.isValid("[");
        System.out.println(res);

    }

    /**
     * 20. 有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/
    public boolean isValid(String s) {
        //使用栈
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.size() > 0) {
                if (stack.peek() == '(') {
                    if (s.charAt(i) == ')') {
                        stack.pop();
                        continue;
                    }
                }
                if (stack.peek() == '[') {
                    if (s.charAt(i) == ']') {
                        stack.pop();
                        continue;
                    }
                }
                if (stack.peek() == '{') {
                    if (s.charAt(i) == '}') {
                        stack.pop();
                        continue;
                    }
                }
                return false;
            }
            return false;
        }
        return stack.size() <= 0;
    }
}
