import java.util.*;
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int df=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i])<df){
                df=Math.abs(arr[i+1]-arr[i]);
            }
        }
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i])==df){
                List<Integer> tres=new ArrayList<>();
                tres.add(arr[i]);
                tres.add(arr[i+1]);
                res.add(tres);
            }
        }
        return res;
    }
}