import java.util.*;

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[idx++] = entry.getKey();
                if (idx == 2) break; 
            }
        }

        return res;
    }
}