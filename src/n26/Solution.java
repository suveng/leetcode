package n26;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/20
 * @version 1.0.0
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = 0;

        res = solution.removeDuplicates(new int[]{1, 1, 2});
        System.out.println(res);

        res = solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(res);

        res = solution.removeDuplicates(new int[]{1, 2, 2});
        System.out.println(res);
    }


    /**
     * 26. 删除数组中的重复项
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/

    public int removeDuplicates(int[] nums) {
        //采用双指针
        int i , j=0;
        for(i=1;i<nums.length;i++){
            if (nums[j]!=nums[i]){
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
    }

    /**
     * 说明: 重复复制了,浪费CPU,但是可以解决无序的数组
     *
     * @author  suwenguang
     * @date    2019/6/20
     * @return  int <- 返回类型
     */
    @Deprecated
    public int removeDuplicatesV1(int[] nums) {
        int res = nums.length;
        int i = 1;
        while (i < res) {
            boolean bool = false;
            //和前面的比
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] == nums[i]) {
                    System.arraycopy(nums, i, nums, i - 1, res - i);
                    res--;
                    bool = true;
                    break;
                }
            }

            if (!bool) {
                i++;
            }
        }
        return res;
    }
}
