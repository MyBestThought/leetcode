/**
leetcode：347	前K个高频元素

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
*/

class Solution {
	//通过Map统计元素出现的次数
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
       
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }    
        });
        int[] ret = new int[k];
        int index = 0;
        for(Map.Entry<Integer,Integer> m:list){ 
            if(index == k){
                break;
            }else{
                ret[index++] = m.getKey();
            }
            
        }
        return ret;
    }
}