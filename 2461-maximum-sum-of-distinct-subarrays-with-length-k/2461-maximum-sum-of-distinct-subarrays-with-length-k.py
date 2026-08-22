class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        ans = 0
        seen = set()  # Fast O(1) duplicate tracking
        l = 0  # Left pointer for sliding window
        cur_sum = 0  # Running sum tracking

        for i in range(len(nums)):
            while nums[i] in seen:
                seen.remove(nums[l])
                cur_sum -= nums[l]
                l += 1
            seen.add(nums[i])
            cur_sum += nums[i]
            if len(seen) == k:
                if cur_sum > ans:
                    ans = cur_sum
                seen.remove(nums[l])
                cur_sum -= nums[l]
                l += 1

        return ans

