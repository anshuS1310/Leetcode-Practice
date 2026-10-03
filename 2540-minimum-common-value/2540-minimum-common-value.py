class Solution:
    def getCommon(self, nums1: list[int], nums2: list[int]) -> int:
        nums1=set(nums1)
        nums2=set(nums2)
        res=list(nums1 & nums2)
        res.sort()
        if len(res)>0:
            return res[0]
        return -1
        