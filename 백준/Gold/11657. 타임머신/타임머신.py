"""
N : 노드
M : 간선 개수
a,b,c : 시작,도착,비용
1번 도시에서 나머지 도시로 가는 가장 빠른 시간
무한 루프 -> -1 출력
"""
import sys
from collections import defaultdict

n,m = map(int,sys.stdin.readline().split())
edge = []
for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    edge.append([a-1,b-1,c])

cost = [float('inf')] * n #1번노드에서 각 노드까지의 거리

#매 반복마다 거리 계산 (bellmanford)
cost[0] = 0
flag = False
for i in range(n):
    for v in edge:
        #v = [neighbor, cost]
        if cost[v[0]] != float('inf') and cost[v[0]] + v[2] < cost[v[1]]:
            cost[v[1]] = cost[v[0]] + v[2]
            if i == n-1:
                flag = True

if flag == True:
    print(-1)
    exit(0)

for x in cost[1:]:
    if x == float('inf'):
        print(-1)
    else:
        print(x)