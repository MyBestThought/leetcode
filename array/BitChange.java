/**
十进制数的反码		leecode 1009
每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。

二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。

给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
示例 1：

输入：5
输出：2
解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
*/
class Solution {
	
    public int bitwiseComplement1(int N) {
		//先将该数转为字符串
        String s = Integer.toBinaryString(N);
		StringBuilder sb = new StringBuilder();
		//互换0和1
        for(int i=0; i < s.length(); i++){
			if(s.charAt(i) == '0'){
				sb.append("1");
			}else{
				sb.append("0");
			}
		}
		//转为十进制
        return Integer.parseInt(sb.toString(),2);
    }
	//6是110 那么他的反码是他与111异或得到的001。所以找到比N大的每位都为1的数，与N进行异或
	public int bitwiseComplement2(int N) {
        int num = 1;
        while(num < N){
            num = (num << 1) + 1;
        }
        return N ^ num;
    }
}