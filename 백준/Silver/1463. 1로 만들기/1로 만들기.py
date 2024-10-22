n = int(input())
dp = [-1] * (n+1)

dp[1] = 0
#top- down 주의 할 점 n가 2와 3의 공배수를 경우 두 개 모두 비교해봐야함
def top_down(x):
    if dp[x] != -1:
        return dp[x]
    if x % 2 == 0 and x % 3 == 0:
        dp[x] = min(top_down(x//3) + 1, top_down(x//2) + 1)
    elif x % 3 == 0:
        dp[x] = min(top_down(x//3) + 1, top_down(x-1) + 1)
    elif x % 2 == 0:
        dp[x] = min(top_down(x//2) + 1, top_down(x-1) + 1)
    else:
        dp[x] = top_down(x-1) + 1
    return dp[x]

print(top_down(n))