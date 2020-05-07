/**
leetcode  最小差
给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差

示例：

输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
输出： 3，即数值对(11, 8)


*/
 /*
	对两个数组进行排序
	双指针
	
	int diff = a[i] - b[j]
	如果 diff < 0 ，表示 a[i] 小于 b[j] ，a 尽可能接近 b，那么 i++
	如果 diff > 0 ，表示 a[i] 大于 b[j] ，b 尽可能接近 a，那么 j++

	特殊情况：
	a = {1,2,3,4,5}
	b = {6,7,8,9,10}
	如果 a 数组最大值比 b 数组最小值还小，那么 a 数组 i 会一直右移，直到到达边界 break
	*/
class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);Arrays.sort(b);
        int min = Integer.MAX_VALUE;
        int i=0, j=0;
        while(i < a.length && j < b.length){
            long val  = a[i] - b[j];
            min = (int)Math.min(min, Math.abs(val));
            if(val < 0){
                i++;
            }else{
                j++;
            }
        }
        return min;
    }
}