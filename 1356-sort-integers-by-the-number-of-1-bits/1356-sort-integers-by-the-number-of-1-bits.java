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
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> ck=new ArrayList<>();
        for(int i=0;i<32;i++){
            ck.add(new ArrayList<>());
        }
        for(int i:arr){
            ck.get(ct(i)).add(i);
        }
        for(int i:arr){
            Collections.sort(ck.get(ct(i)));
        }
        int [] res=new int[arr.length];
        int id=0;
        for(int i=0;i<32;i++){
            List<Integer> t=ck.get(i);
            for(int j:t){
                res[id++]=j;
            }
        }
        return res;
    }
}