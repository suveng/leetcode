/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package n946;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author suwenguang
 * @since 2021-09-05 15:40
 */
public class Solution {

    // 栈的出栈序列是否正确
    // 重新按照 入栈序列 入栈, 每入栈一个元素即可以出栈, 如果出栈元素和栈顶元素相等, 即把元素出栈, 看最后栈里面是否还有元素, 如果还有元素证明该出栈序列是错误的
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(popped.length);
        for (int i : popped) {
            queue.add(i);
        }

        // 模拟入栈序列
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && !queue.isEmpty() && stack.peek().equals(queue.peek())) {
                queue.poll();
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//
// 示例 2：
//
//
//输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
//
//
//
//
// 提示：
//
//
// 1 <= pushed.length <= 1000
// 0 <= pushed[i] <= 1000
// pushed 的所有元素 互不相同
// popped.length == pushed.length
// popped 是 pushed 的一个排列
//
// Related Topics 栈 数组 模拟
// 👍 195 👎 0


