class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> f=new PriorityQueue<>();
        PriorityQueue<long[]> b=new PriorityQueue<>((a,bs) -> Long.compare(a[0],bs[0]));
        for(int i=0;i<k;i++){
            f.offer(i);
        }
        int c[]=new int[k];
        for(int i=0;i<arrival.length;i++){
            while(!b.isEmpty() && b.peek()[0]<=arrival[i]){
                int id=(int)b.poll()[1];
                f.offer(i+Math.floorMod(id-i,k));
            }
            if(f.isEmpty()){
                continue;
            }
            int id=f.poll()%k;
            c[id]++;
            b.offer(new long[]{(long) arrival[i]+load[i],id});
        }
        int mx=0;
        for(int i:c){
            mx=Math.max(mx,i);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            if(c[i]==mx){
                res.add(i);
            }
        }
        return res;
    }
}  
