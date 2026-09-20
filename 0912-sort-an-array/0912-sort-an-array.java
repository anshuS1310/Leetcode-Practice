class Solution {
    static void merge(int [] a,int l,int m ,int r){
        int n1=m-l+1,n2=r-m;
        int l1[]=new int[n1];
        int l2[]=new int[n2];
        for(int i=0;i<n1;i++){
            l1[i]=a[l+i];
        }
        for(int i=0;i<n2;i++){
            l2[i]=a[m+1+i];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(l1[i]<=l2[j]){
                a[k++]=l1[i++];
            }else{
                a[k++]=l2[j++];
            }
        }
        while(i<n1){
            a[k++]=l1[i++];
        }
        while(j<n2){
            a[k++]=l2[j++];
        }
    }
    static void mergest(int [] a, int l ,int r){
        if(l<r){
            int m=l+(r-l)/2;
            mergest(a,l,m);
            mergest(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    public int[] sortArray(int[] nums) {
        mergest(nums,0,nums.length-1);
        return nums;
    }
}