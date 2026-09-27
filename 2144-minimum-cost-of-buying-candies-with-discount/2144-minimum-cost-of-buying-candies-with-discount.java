import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int s=0;
        for(int i:cost){
            s+=i;
        }
        for (int i = cost.length - 3; i >= 0; i -= 3) {
            s -= cost[i];
        }
        return s;
    }
}