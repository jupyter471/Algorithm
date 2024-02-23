import sys
from collections import deque
n,m,v = map(int,input().split())
mat = [[False for _ in range(n+1)] for _ in range(n+1)] #이차원 배열로 연결되어있으면 true로 변경

for _ in range(m):
    i,j = map(int, sys.stdin.readline().split())
    mat[i][j] = True
    mat[j][i] = True #양방향

visited1 = [False] * (n+1)  # bfs 방문여부 저장
visited2 = [False] * (n+1)  #dfs 방문여부 저장

def bfs(v):   #queue
    q = deque([v])
    visited1[v] = True
    while q:
        x = q.popleft()
        print(x, end=" ")
        for y in range(1,n+1):
            if mat[x][y] == True and visited1[y] == False:
                q.append(y)
                visited1[y] = True
def dfs(v):    #stack
    visited2[v] = True
    print(v, end=" ")
    for y in range(1,n+1):
        if not visited2[y] and mat[v][y] == True:
            dfs(y)
dfs(v)
print()
bfs(v)