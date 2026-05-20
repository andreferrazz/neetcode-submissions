class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = []
        i = 0
        j = 0

        while i < len(nums1) or j < len(nums2):
            if i >= len(nums1):
                nums.append(nums2[j])
                j += 1
            elif j >= len(nums2) or nums1[i] < nums2[j]:
                nums.append(nums1[i])
                i += 1
            elif nums2[j] < nums1[i]:
                nums.append(nums2[j])
                j += 1
            else:
                nums.append(nums1[i])
                i += 1
        
        mid = len(nums) // 2

        if len(nums) % 2 == 0:
            return (nums[mid] + nums[mid - 1]) / 2
        else:
            return nums[mid]
        