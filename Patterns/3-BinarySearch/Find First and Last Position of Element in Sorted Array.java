//Find First and Last Position of Element in Sorted Array
//link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer=new int[2];
        answer[0]=first(nums,target);
        answer[1]=last(nums,target);
        return answer;
    }

    private static int first(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int answer=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                answer=mid;
                high=mid-1;
            }else if(nums[mid] > target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return answer;
    }

    private static int last(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int answer=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                answer=mid;
                low=mid+1;
            }else if(nums[mid] > target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return answer;
    }
}