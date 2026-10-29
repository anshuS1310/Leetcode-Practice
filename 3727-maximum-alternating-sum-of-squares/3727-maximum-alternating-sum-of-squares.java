class Solution {
    public long maxAlternatingSum(int[] nums) {
      int n=nums.length;
      for(int i=0;i<nums.length;i++){
        if(nums[i]<0){
            nums[i]*=(-1);
        }
      }
      Arrays.sort(nums);
      int i=0,j=n-1;
      long s=0;
      while(i<j){
        s+=((nums[j]*nums[j])-(nums[i]*nums[i]));
        i++;
        j--;
      }
      if(n%2==1){
        s+=nums[j]*nums[j];
      }
      return s;  
    }
}