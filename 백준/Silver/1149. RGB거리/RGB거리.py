N = int(input())
rgb = []
for _ in range(N):
    rgb.append(list(map(int,input().split())))

dp = [[0]*3 for _ in range(N)]
dp[0] = rgb[0]

for i in range(1,N):
    #i번째 집 색칠
    #i번째 : 빨간색 -> min(i-1번째 집이 초록 + i 빨강 비용, i-1번째 집이 파랑 + i 빨강 비용)
    dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + rgb[i][0]
    dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + rgb[i][1]
    dp[i][2] = min(dp[i-1][0],dp[i-1][1]) + rgb[i][2]
print(min(dp[-1]))