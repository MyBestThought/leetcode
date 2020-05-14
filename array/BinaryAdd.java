/**
leetcode 67：二进制求和


给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

*/
//模拟借位的思想
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int i = a.length()-1, j = b.length()-1;
        while(i >= 0 || j >= 0){
            if(i >= 0){
                c += a.charAt(i--) - '0';
            }
            if(j >= 0){
                c += b.charAt(j--) - '0';
            }
            sb.append(c % 2);
            c >>= 1;
        }
        String res = sb.reverse().toString();
        return c > 0 ? 1+res : res;
    }
}