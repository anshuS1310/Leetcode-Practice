class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        for i in range(len(nums1)-m):
            nums1.pop()
        for i in range(len(nums2)-n):
            nums2.pop()
        for i in nums2:
            nums1.append(i)
        nums1.sort()
        
            
        