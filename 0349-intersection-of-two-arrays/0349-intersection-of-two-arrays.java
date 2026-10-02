import java.util.*;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);Arrays.sort(nums2);
        int a=nums1.length,b=nums2.length,i=0,j=0;
        ArrayList<Integer> res=new ArrayList<>();
        while(i<a && j<b){
            if(i>0 && nums1[i-1]==nums1[i]){
                i++;
                continue;
            }
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                res.add(nums1[i++]);
                j++;
            }
        }
        
        int [] ans= new int[res.size()];
        for(int k=0;k<res.size();k++){
            ans[k]=res.get(k);
        }
        return ans;

    }
}