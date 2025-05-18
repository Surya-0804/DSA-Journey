//Group annagrams
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//link https://leetcode.com/problems/group-anagrams/description/
//Time Complexity: O(n * k log k)
//Space Complexity: O(n * k)


class GroupAnnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();

        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String sortedWord=new String(chars);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(str);
        }
        return new ArrayList<>(map.values());
    }
}