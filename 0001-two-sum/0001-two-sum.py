class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res=[]
        l=len(nums)
        for i in range(l):
            for j in range(i+1,l):
                sum=nums[i]+nums[j]
                if sum==target:
                    res.append(i)
                    res.append(j)
                    break
        return res