/**
	leetcode 1010
	在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
	返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
	示例 1：
	输入：[30,20,150,100,40]
	输出：3
	解释：这三对的总持续时间可被 60 整数：
	(time[0] = 30, time[2] = 150): 总持续时间 180
	(time[1] = 20, time[3] = 100): 总持续时间 120
	(time[1] = 20, time[4] = 40): 总持续时间 60。
*
*/
//用一个数组记录每个时间对应的模60结果的总和，如果两个数的模相加为60，则这两个数相加是60的倍数
class Solution {
    public int numPairsDivisibleBy60one(int[] time) {
        int[] record = new int[60];
        int count = 0;
        for(int t : time){
			//求时间的余数
            t %= 60;
            if(t != 0){
				//如果不为0，找到相加为0的余数
                count += record[60-t];
            }else{
				//如果为0，加其他为0的数
                count += record[t];
            }
            record[t] ++;
        }
        return count;
    }
	//思路相同
	public int numPairsDivisibleByTwo(int[] time) {
        int[] bucket = new int[60];
        int cnt = 0;
        for (int t : time) {
            int mod = t % 60;
            int remain = mod == 0 ? 0 : 60 - mod;
            cnt += bucket[remain];
            bucket[mod]++;
        }
        return cnt;
    }
}