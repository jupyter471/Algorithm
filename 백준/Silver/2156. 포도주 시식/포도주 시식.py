wine = [0]
N = int(input())
for _ in range(N):
    wine.append(int(input()))

dp = [0] * (N+1)
dp[1] = wine[1]

"""
첫번째를 마시거나 안마시거나
"""
if N>1:
    dp[2] = wine[2] + wine[1]
    for i in range(3,N+1):
        dp[i] = max(dp[i-1],dp[i-2]+wine[i],wine[i-1] + wine[i] + dp[i-3])

# print(dp)
print(dp[-1])