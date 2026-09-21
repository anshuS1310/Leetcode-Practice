class Solution {
    private void mg(String [] arr,int l,int r,int m){
        int n1=m-l+1,n2=r-m;
        String [] L=new String[n1];
        String [] R=new String[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=arr[m+1+i];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i].length()<=R[j].length()){
                arr[k++]=L[i++];
            }else{
                arr[k++]=R[j++];
            }
        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=R[j++];
        }
    }
    private void mst(String [] arr,int l,int r){
        if(l<r){
            int md=l+(r-l)/2;
            mst(arr,l,md);
            mst(arr,md+1,r);
            mg(arr,l,r,md);
        }
    }
    public String arrangeWords(String text) {
        String[] arr=text.toLowerCase().split("\\s+");
        mst(arr,0,arr.length-1);
        String res=String.join(" ",arr);
        return Character.toUpperCase(res.charAt(0))+res.substring(1);
    }
}