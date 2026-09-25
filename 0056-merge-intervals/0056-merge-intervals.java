class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res= new ArrayList<>();
        int curr[] = intervals[0];
        res.add(curr);
        for(int i=1;i<intervals.length;i++){
            int c[] = intervals[i];
            if(c[0]<=curr[1]){
                curr[1]=Math.max(c[1],curr[1]);
            }
            else{
                curr=c;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}