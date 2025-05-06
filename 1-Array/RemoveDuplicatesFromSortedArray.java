// ✅ Problem: Remove Duplicates from Sorted Array
// 🔗 Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// ------------------------------------------------------------------------------------
// 🧠 Brute Force Approach
// ✅ Time Complexity: O(n log n)
// ✅ Space Complexity: O(n)
import java.util.LinkedHashSet;
import java.util.Set;

class SolutionBruteForce {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        // LinkedHashSet maintains the insertion order
        // HashSet does not maintain the insertion order
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }
        return index;
    }
}

// ------------------------------------------------------------------------------------
// ⚡ Optimized Approach: Two Pointers
// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1)

class SolutionOptimized {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
