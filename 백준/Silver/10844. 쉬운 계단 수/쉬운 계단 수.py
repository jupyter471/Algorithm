N = int(input())
#다음 자리 수는 이전 자리 수보다 1작거나 1크다

dp = []  #dp[자리수][숫자] = 해당 자리수에 해당 숫자가 올 수 있는 경우의 수
dp = [[0] * 10 for _ in range(N+1)]
dp[1] = [0,1,1,1,1,1,1,1,1,1]

for i in range(2,N+1):
    for j in range(10):
        #점화식: dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
        #단 j가 0이거나 9일 때는 분기해야함
        if j == 0:
            dp[i][j] = dp[i-1][j+1]
        elif j == 9:
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

print(sum(dp[N]) % 1000000000)