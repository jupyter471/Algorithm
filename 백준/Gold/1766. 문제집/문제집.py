import heapq
from collections import defaultdict
n,m = map(int, input().split())
graph = defaultdict(list)
indegree = [0] * (n+1)
pq = []
result = []
for _ in range(m):
    a, b = map(int, input().split())   #a 먼저->b
    graph[a].append(b)
    indegree[b] += 1

for i in range(1, n+1):
    if indegree[i] == 0:
        #차수 0인 노드
        heapq.heappush(pq, i)
while pq:
    nxt = heapq.heappop(pq)
    result.append(nxt)
    for x in graph[nxt]:
        indegree[x] -= 1
        if indegree[x] == 0:
            heapq.heappush(pq, x)

print(*result, sep=" ")