package darily;

import org.junit.Test;

/**
 * @Classname day0409maximumCount
 * @Author Spridra
 * @Version 1.0.0
 * @Time 2024-04-09 15:52
 */

public class day0409maximumCount {
    @Test
    public void test() {
        int[] nums = {-2,-1,-1,1,2,3};
        Solution solution = new Solution();
        int i = solution.maximumCount(nums);
        int j = solution.maximumCountByBinarySearch(nums);
        System.out.println(i);
        System.out.println(j);
    }
}
class Solution {
    //暴力遍历
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for (int x : nums) {
            if (x < 0) {
                neg++;
            } else if (x > 0) {
                pos++;
            }
        }
        return Math.max(neg, pos);
    }
    //二分查找第一个大于的数
    public int maximumCountByBinarySearch(int[] nums) {
        int neg = lowerBound(nums, 0);
        // 第一个 > 0 的位置，等价于第一个 >= 1 的位置
        int pos = nums.length - lowerBound(nums, 1);
        //因为是非递减所以可能有连续的0
        return Math.max(neg, pos);
    }

    // 返回 nums 中第一个 >= target 的数的下标
    // 如果不存在这样的数，返回 nums.length
    // 详见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int target) {
        // 二分范围：开区间 (left, right)
        int left = -1;
        int right = nums.length;
        // 开区间不为空
        while (left + 1 < right) {
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // 二分范围缩小至 (left, mid)
                right = mid;
            } else {
                // 二分范围缩小至 (mid, right)
                left = mid;
            }
        }
        // 此时 left 等于 right - 1
        // 因为 nums[right - 1] < target 且 nums[right] >= target，所以答案是 right
        return right;
    }
}
//给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
// 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
// 注意：0 既不是正整数也不是负整数。
//
// 示例 1：
//
//
//输入：nums = [-2,-1,-1,1,2,3]
//输出：3
//解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
//
//
// 示例 2：
//
//
//输入：nums = [-3,-2,-1,0,0,1,2]
//输出：3
//解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
//
//
// 示例 3：
//
//
//输入：nums = [5,20,66,1314]
//输出：4
//解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2000
// -2000 <= nums[i] <= 2000
// nums 按 非递减顺序 排列。
//
//
//
//
// 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？
//
// Related Topics 数组 二分查找 计数 👍 23 👎 0