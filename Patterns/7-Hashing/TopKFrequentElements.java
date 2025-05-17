//Top k Frequent Elements
//link:https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(new int[]{entry.getValue(),entry.getKey()});
        }
        Collections.sort(list,(a,b)-> b[0]-a[0]);

        for(int i=0; i<k;i++){
            answer[i]=list.get(i)[1];
        }
        return answer;
    }
    
}