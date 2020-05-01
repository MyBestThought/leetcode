/**
*	查找两个数组中的中位数
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i < nums1.length; i++){
            list.add(nums1[i]);
        }
        for(int i=0; i < nums2.length; i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        double result = 0;
        if(list.size()%2 != 0){
            result = list.get(list.size()/2);
        }else{
            result = (double)(list.get(list.size()/2) + list.get(list.size()/2-1))/2;
        }
        return result;
    }
}