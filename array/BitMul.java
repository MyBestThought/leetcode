import java.util.*;
/**

现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。

输入例子1:
36

输出例子1:
49

输入例子2:
100

对于小于10的数n，输出1n。
对于大于10的数，需要分解为若干个个位数之积，数字的个数尽可能少。这个数字可以分解为以9，8，...，2的因子之积。然后从小到大输出即可。
*/

public class Solution {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    public int solution (int n) {
        // write code here
        if(n <= 9){
            return 10 + n;
        }
        int result=0, base = 1;
        for(int i=9; i > 1; i--){
            while(n%i == 0){
                result += i*base;
                base *= 10;
                n /= i;
            }
        }
        if(n > 1){
            return -1;
        }
        return result;
    }
}