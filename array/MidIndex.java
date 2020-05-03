方法：前缀和
算法：

S 是数组的和，当索引 i 是中心索引时，位于 i 左边数组元素的和 leftsum 满足 S - nums[i] - leftsum。
我们只需要判断当前索引 i 是否满足 leftsum==S-nums[i]-leftsum 并动态计算 leftsum 的值。

作者：LeetCode
/**
*	leetcode 724		查找数组的中心索引
*	方法：利用前缀和。首先进行一次遍历，得到数组的总和。当索引i是中心索引的时候，位于i左边元素的和left满足s-nums[i]-leftsum=rightSum.
*		  所以只需要判断当前索引i是否满足rightSum == s-nums[i]-leftsum	
*	输入: 
*	nums = [1, 7, 3, 6, 5, 6]
*	输出: 3
*	解释: 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。同时, 3 也是第一个符合要求的中心索引。	
*/
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = 0;
        for(int i=0; i < nums.length; i++){
            right += nums[i];
        }
        for(int i=0; i < nums.length; i++){
            left += i > 0 ? nums[i-1] : 0;
            right -= nums[i];
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}