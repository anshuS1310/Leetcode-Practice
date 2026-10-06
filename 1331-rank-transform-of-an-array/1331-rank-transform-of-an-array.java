import java.util.Arrays;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> m=new HashMap<>();
        int temp[]=arr.clone();
        Arrays.sort(temp);
        int rank = 1;
        for (int val : temp) {
            if (!m.containsKey(val)) {
                m.put(val, rank);
                rank++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=m.get(arr[i]);
        }
        return arr;
    }
}