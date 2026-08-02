class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        c=nums1+nums2
        c.sort()
        a=len(c)//2
        return (c[a] + c[a-1]) / 2 if len(c) % 2 == 0 else c[a]
        