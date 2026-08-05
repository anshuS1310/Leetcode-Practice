class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length(),n2=num2.length();
        if(n1==0||n2==0){
            return "0";
        }
        int nn1=1,nn2=1;
        if(num1.charAt(0)=='-'){
            nn1=-1;
        }
        if(num2.charAt(0)=='-'){
            nn2=-1;
        }
        int ng=nn1*nn2;
        int[] r=new int[n1+n2];
        int i1=0,i2=0;
        for(int i =n1-1;i>=0;i--){
            if(num1.charAt(i)=='-'){
                continue;
            }
            int c=0;
            int n1r=num1.charAt(i)-'0';
            i2=0;
            for(int j=n2-1;j>=0;j--){
                if(num2.charAt(j)=='-'){
                    continue;
                }
                int n2r=num2.charAt(j)-'0';
                int s=n1r*n2r+r[i1+i2]+c;
                c=s/10;
                r[i1+i2]=s%10;
                i2++;
            }
            if(c>0){
                r[i1+i2]+=c;
            }
            i1++;
        }
        int i=r.length-1;
        while(i>=0 && r[i]==0){
            i--;
        }
        if(i==-1){
            return "0";
        }
        String s="";
        while(i>=0){
            s+=Integer.toString(r[i--]);
        }
        if(ng==-1){
            s="-"+s;
        }
        return s;
    }
}