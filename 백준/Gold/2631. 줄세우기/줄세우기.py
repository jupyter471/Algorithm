"""
부분증가수열 : 원소가 n개인 배열의 일부원소를 골라내서 만든 부분 수열 중, 각 원소가 이전 원소보다 크다는 조건을 만족

이 문제는 순서를 바꿔서 정렬한다는 접근보다 자리에 안맞는 애들을 끼워 넣는 방식으로 접근했어야했다
또한 애들순서보다는 몇 명의 애들을 옮겨야하는지가 중요했음! like 짝꿍 정할 때 빈 자리에 애들 들어가는 느낌으로...
dp -> 작은 문제들의 해답으로 큰 문제를 풀겠다
가장 긴 부분증가수열의 길이를 구하면 됨 -> 그 제외 애들은 옮겨야됨
"""

children = []
n = int(input())
for _ in range(n):
    children.append(int(input())-1)

dp = [1] * n
for i in range(n):
    for j in range(i):
        if children[j] < children[i]:
            dp[i] = max(dp[i], dp[j] + 1)
print(n - max(dp))