import java.util.*;
class Solution {
    private int ct(int n){
        int c=0;
        while(n>0){
            c+=n&1;
            n>>=1;
        }
        return c;
    }
    public int[] sortByBits(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        Arrays.sort(arr, (a, b) -> {
            int c1 = ct(a);
            int c2 = ct(b);
            return c1 - c2; 
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}