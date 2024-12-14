from itertools import permutations
N, M = map(int, input().split())

nums = list(map(int, input().split()))

nums = sorted(nums)

for x in permutations(nums,M):
    x = list(map(str, x))
    print(" ".join(x))