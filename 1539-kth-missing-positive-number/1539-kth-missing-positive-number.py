class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        for i in range(len(arr)):
            if(arr[i]>(k+i)):
                return (k+i)
        return (k+len(arr))
        