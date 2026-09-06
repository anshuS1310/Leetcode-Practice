import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int b=0,u=n-1,p=-1;
        while(b<=u){
            int m=(b+u)/2;
            if(arr[m]<x){
                p=m;
                b=m+1;
            }else{
                u=m-1;
            }
        }
        int l=p,r=p+1;
        List<Integer> res= new ArrayList<>();
        while(r<n && arr[r]==x && res.size()<k){
            res.add(arr[r]);
            r++;
        }
        
        while(l>=0 && r<n && res.size()<k){
            int da=Math.abs(arr[l]-x);
            int db=Math.abs(arr[r]-x);
            if(da>db){
                res.add(arr[r]);
                r++;
            }else{
                res.add(arr[l]);
                l--;
            }
        }
        while(l>=0 && res.size()<k){
            res.add(arr[l]);
            l--;
        }  
        while(r<n && res.size()<k){
            res.add(arr[r]);
            r++;
        }
        Collections.sort(res);
        return res;
    }
}