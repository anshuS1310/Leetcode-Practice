class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer,Integer> m= new HashMap<>();
        for(int i:nums){
            m.put(i,m.getOrDefault(i,0)+1);
        }
        Map<Integer,Integer> m1= new HashMap<>();
        for(int i:m.values()){
            m1.put(i,m1.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            if(m1.get(m.get(i))==1){
                return i;
            }
        }
        return -1;
        
    }
}