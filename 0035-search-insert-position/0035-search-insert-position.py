class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        a=0
        for i in range(len(nums)):
            if target>nums[i]:
                a=i+1
        return a