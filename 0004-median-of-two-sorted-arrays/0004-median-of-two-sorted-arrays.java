class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length,n=nums2.length;
        int l=0,r=m;
        while(l<=r){
            int md1=l+(r-l)/2;
            int md2=(m+n+1)/2-md1;
            int l1=(md1==0 ? Integer.MIN_VALUE : nums1[md1-1]),r1=(md1==m ? Integer.MAX_VALUE : nums1[md1]),l2=(md2==0 ? Integer.MIN_VALUE : nums2[md2-1]),r2=(md2==n ? Integer.MAX_VALUE : nums2[md2]);
            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1>r2){
                r=md1-1;
            }else{
                l=md1+1;
            }
        }
        return 0.0;
    }
}