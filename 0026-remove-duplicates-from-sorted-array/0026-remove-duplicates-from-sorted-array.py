class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l=len(nums)
        i1=1
        for i in range(l-1):
            if nums[i+1]!=nums[i]:
                nums[i1]=nums[i+1]
                i1+=1
        return i1