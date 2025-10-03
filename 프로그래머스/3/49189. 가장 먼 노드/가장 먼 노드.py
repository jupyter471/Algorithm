from collections import deque

def solution(n, edge):
    adj = [[] for i in range(n+1)]
    visited = [0 for i in range(n+1)]
    
    for v1,v2 in edge:
        adj[v1].append(v2)
        adj[v2].append(v1)
    
    q = deque([1])
    visited[1] = 1
    
    while q:
        nx = q.popleft()
        for data in adj[nx]:
            if visited[data] == 0:
                visited[data] = visited[nx] + 1
                q.append(data)
    
    m_data = max(visited)
    
    answer = 0
    for k in visited:
        if k == m_data:
            answer+=1
    return answer