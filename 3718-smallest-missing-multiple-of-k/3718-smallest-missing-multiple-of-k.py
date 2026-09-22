class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        a=set(nums)
        s=0
        while(True):
            s+=k
            if s in a:
                continue
            else:
                break
        return s