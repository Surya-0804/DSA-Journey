//Intersection of two Arrays
//Problem: Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique, and the result can be returned in any order
//link: https://leetcode.com/problems/intersection-of-two-arrays/description/
//Time Complexity: O(n + m)
//Space Complexity: O(n + m)

class IntersectionOfTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int num: nums1){
            set.add(num);
        }
        Set<Integer> common=new HashSet<>();
        for(int num: nums2){
            if(set.contains(num)){
                common.add(num);
            }
        }
        int[] answer=new int[common.size()];
        int i=0;
        for(int num : common){
            answer[i++]=num;
        }
        return answer;
    }
}