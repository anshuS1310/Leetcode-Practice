class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        a = nums.copy()
        b = []
        res = -1
        for i in range(0, len(nums)):
            b.append(nums[i])
            if (max(b) - min(a)) <= k:
                return i
            a.pop(0) 
        return res