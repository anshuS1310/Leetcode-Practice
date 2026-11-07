class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int []> f=new PriorityQueue<>((a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        for(int i=0;i<servers.length;i++){
            f.offer(new int[]{servers[i],i});
        }
        PriorityQueue<long []> bs=new PriorityQueue<>((a,b) ->{
            if(a[0]!=b[0]){
                return Long.compare(a[0],b[0]);
            }
            if(a[1]!=b[1]){
                return Long.compare(a[1],b[1]);
            }
            return Long.compare(a[2],b[2]);
        });
        int ans[]=new int[tasks.length];
        for(int i=0;i<tasks.length;i++){
            while(!bs.isEmpty() && bs.peek()[0]<=i){
                long c[]=bs.poll();
                f.offer(new int[]{(int)c[1],(int)c[2]});
            }
            if(!f.isEmpty()){
                int c[]=f.poll();
                ans[i]=c[1];
                bs.offer(new long[]{i+(long)tasks[i],(long)c[0],(long)c[1]});
            }else{
                long c[]=bs.poll();
                ans[i]=(int)c[2];
                bs.offer(new long[]{c[0]+(long)tasks[i],c[1],c[2]});
            }
        }
        return ans;
    }
}