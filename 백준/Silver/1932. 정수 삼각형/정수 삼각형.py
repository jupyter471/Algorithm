"""
정수 삼각형
맨 위층부터 아래로 내려오면서 선택한 수의 합이 최대가 되는 경로
DP?
맨 끝 제외 양쪽에서 내려옴
dp[층][i] = dp[층-1][i-1] + dp[층-1][i]
"""

size = int(input())
triangle = []
for _ in range(size):
    triangle.append(list(map(int, input().split())))

dp = [[0] * size for _ in range(size)]

dp[0][0] = triangle[0][0]

for i in range(1,size):
    for j in range(0,i+1):
        if j == 0:
            dp[i][j] = dp[i-1][j] + triangle[i][j]
        if j == i:
            dp[i][j] = dp[i-1][j-1] + triangle[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]

print(max(dp[-1]))
# print(dp)