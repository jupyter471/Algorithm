"""
방향 X
1번에서 N정점
주어진 두 정점 거쳐야함
"""
from collections import defaultdict
import heapq

N,E = map(int, input().split())

adj_list = defaultdict(list)

for _ in range(E):
    s,d,c = map(int, input().split())
    adj_list[s].append((d,c))
    adj_list[d].append((s,c))

must_pass = list(map(int, input().split()))


# 1 -> n까지 must_pass 두 경로를 거쳐야
#1 -> a, a ->b, b->n
#순서는 모름
#1 -> a, 1-> b까지 구하고 a->n, b->n 구하고 작은 값

#bellman
# def bellman(src):
#     dist = [float('inf')] * (N+1)
#     dist[src] = 0
#
#     for _ in range(N):
#         #N번 순회하면서
#         #각 노드가 나머지 노드에 도달할 수 있는 최소 거리
#         #1번 노드에서 나머지 노드까지의 거리 구하기
#         #노드 돌면서 갱신
#         for i in range(1,N+1):
#             for e in adj_list[i]:
#                 if dist[e[0]] > dist[i] + e[1]:
#                     dist[e[0]] = dist[i] + e[1]
#
#     return dist

#dijkstra
def dijkstra(src):
    dist = [float('inf')] * (N + 1)
    dist[src] = 0

    heap = []
    heapq.heappush(heap,(0,src))
    while heap:
        c,src = heapq.heappop(heap)
        for ele in adj_list[src]:
            if dist[ele[0]] > dist[src] + ele[1]:
                dist[ele[0]] = dist[src] + ele[1]
                heapq.heappush(heap, (dist[src] + ele[1],ele[0]))

    return dist

start = dijkstra(1)
atoN = dijkstra(must_pass[0])
btoN = dijkstra(must_pass[1])

#1-> a -> b -> n
#1-> b -> a -> n
a_path = start[must_pass[0]] + atoN[must_pass[1]] + btoN[N]
b_path = start[must_pass[1]] + btoN[must_pass[0]] + atoN[N]
result = min(a_path, b_path)
print(result if result < float('inf') else -1)
