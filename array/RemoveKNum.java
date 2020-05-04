/**
*	移除K位数字，使得最终的值最小
*	leetcode：402
*
*	给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
*	注意:
*	num 的长度小于 10002 且 ≥ k。
*	num 不会包含任何前导零。
*
*	示例 1 :
*	输入: num = "1432219", k = 3
*	输出: "1219"
*	解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
*
*	示例 2 :
*	输入: num = "10200", k = 1
*	输出: "200"
*	解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
*
*	示例 3 :
*	输入: num = "10", k = 2
*	输出: "0"
*	解释: 从原数字移除所有的数字，剩余为空就是0。

*/
class Solution {
	//从左到右，找第一个比后面大的字符，然后删除，清零，共进行k次扫描
    public String removeKdigits(String num, int k) {
		//如果num长度等于k，直接返回0
        if(num.length() == k){
            return "0";
        }
        StringBuilder s = new StringBuilder(num);
		//循环k次
        for(int i=0; i < k; i++){
			//用来标记第一个比后面大的字符
            int index = 0;
			//找到下标
            for(int j=1; j < s.length() && s.charAt(j) >= s.charAt(j-1); j++){
                index = j;
            }
			//删除
            s.delete(index,index+1);
            //删除前面的0
			while(s.length() > 1 && s.charAt(0) == '0'){
                s.delete(0, 1);
            }

        }
        return s.toString();
    }
}