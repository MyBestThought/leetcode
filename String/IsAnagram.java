/**
leetcode 242：字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
*/
class Solution {
	//方法一：初始化一个26长度的数组，遍历字符串，最后判断是否所有位置都为0即可
    public boolean isAnagram1(String s, String t) {
        int[] result = new int[26];
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            int val = ch - 'a';
            result[val] ++;
        }
        for(int i=0; i < t.length(); i++){
            char ch = t.charAt(i);
            int val = ch -'a';
            result[val] --;
        }
        for(int i : result){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
	//调用库函数
	public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] as=s.toCharArray();
        char[] ts=t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(ts);
        return Arrays.equals(as,ts);
    }
}