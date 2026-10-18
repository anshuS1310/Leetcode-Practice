class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> r= new HashMap<>();
        for(int c:nums){
            r.put(c,r.getOrDefault(c,0)+1);
        }
        for(var e:r.entrySet()){
            if(e.getValue()==1){
                return e.getKey();
            }
        }
        return -1;
    }
}