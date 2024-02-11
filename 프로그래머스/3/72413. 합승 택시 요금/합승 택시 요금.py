import heapq
def solution(n, s, a, b, fares):
    #방향없음
    
    #그래프 생성
    graph = [[] for _ in range(n+1)]
    for u,v,c in fares:
        graph[u].append((v,c))
        graph[v].append((u,c))
    #모든 거리 구해두기
    dist = dj(s,graph,n)
    #a,b 따로 이동할 때 거리
    cost = dj(s,graph,n)[a] + dj(s,graph,n)[b]
    #최소거리 구하기
    for v in range(1,n+1):
        if s != v:
            cost = min(cost, dist[v] + dj(v,graph,n)[a] + dj(v,graph,n)[b])
    return cost
    # print(a_d,b_d,a_to_b)
    # print(min(a_d+b_d,a_d + a_to_b))
    #다익스트라
    # return answer

def dj(v,graph,n):
    heap = []
    dist = [float('inf')] * (n+1)
    visited = [False] * (n+1)
    dist[v] = 0
    heapq.heappush(heap,(v,0))
    while heap:
        v,c = heapq.heappop(heap)
        # print(graph[v])
        for x in graph[v]:
            nxt, nc = x
            if c + nc < dist[nxt]:
                visited[nxt] = True
                dist[nxt] = nc + c
                heapq.heappush(heap,(nxt,nc+c))
    return dist

def get_dist(v,a,b,graph,n):
    #v : a랑 b까지 거리 측정할 노드
    v_d = dj(v,graph,n)
    return v_d[a] + v_d[b]
#n : 개수
#s : 출발지점
# 최저 예상 택시요금 (합승 안해도 됨)
#fares [지점1,지점2,가격]

