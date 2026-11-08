class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        int [] f=new int[10];
        for(int i:digits){
            f[i]++;
        }
        int t=0;
        for(int i=1;i<10;i++){
            if(f[i]==0){
                continue;
            }
            f[i]--;
            for(int j=0;j<10;j++){
                if(f[j]==0){
                continue;
                }
                f[j]--;
                for(int k=0;k<=8;k+=2){
                    if(f[k]==0){
                        continue;
                    }
                    f[k]--;
                    t++;
                    f[k]++;
                }
                f[j]++;
            }
            f[i]++;
        }
        return t;
    }
}