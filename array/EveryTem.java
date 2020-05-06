/**
leetcode 739：每日温度

根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

找出数组中大于当前元素的第一个元素，到当前元素的距离
递减栈，当前元素与栈中元素比较，小则入栈，大则出栈并将二者之间的下标差值为出栈元素的结果值，并继续比较下一个栈顶元素
如果栈为空，直接入栈(表示前面元素都找到了比自己大的值)
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < T.length; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }
        return result;
    }
}