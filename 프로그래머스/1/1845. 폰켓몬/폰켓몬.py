def solution(nums):
    answer = 0
    dup_remove = set(nums)
    if (len(dup_remove) < len(nums) // 2): return len(dup_remove)
    return len(nums) //2
