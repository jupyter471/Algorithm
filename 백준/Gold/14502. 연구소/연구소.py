"""
벽은 무조건 3개
안전 영역 최대 크기
0:빈 칸, 1: 벽, 2: 바이러스
브루트포스로 벽 세우고 -> bfs로 안전 영역 크기 구하기
N : 세로 M : 가로
"""
import copy
import sys
from itertools import combinations
from collections import deque
def spread(area,wall,virus,n,m):
    #bfs로 탐색
    dq = deque()
    # print(wall)
    temp = copy.deepcopy(area)
    visited = [[False] * m for _ in range(n)]
    #상하좌우
    move = [(-1,0),(1,0),(0,-1),(0,1)]
    for element in wall:
        temp[element[0]][element[1]] = 1
    spread_area = 0
    for v in virus:
        dq.append(v)
        while dq:
            curr = dq.popleft()
            visited[curr[0]][curr[1]] = True
            for i in range(4):
                nxt = [curr[0] + move[i][0], curr[1] + move[i][1]]
                if (0<= nxt[0] < n) and (0<= nxt[1] < m):
                    if visited[nxt[0]][nxt[1]] == False and temp[nxt[0]][nxt[1]] == 0:  #퍼질 수 있음
                        temp[nxt[0]][nxt[1]] = 2
                        spread_area += 1
                        dq.append(nxt)
    # if wall[0][0] == 0 and wall[0][1] == 1:
    #     print(temp)
    #     print(spread_area)
    return spread_area





N,M = map(int, input().split())
area = []
safe_size = 0
for _ in range(N):
    area.append(list(map(int, sys.stdin.readline().split())))

empty = []  #빈공간 좌표 저장
virus = []
for i in range(N):
    for j in range(M):
        if area[i][j] == 0:
            empty.append([i,j])
        elif area[i][j] == 2:
            virus.append([i,j])
wall_count = N * M - len(virus) - len(empty) + 3
for case in combinations(empty,3):
    #바이러스 퍼짐
    result = N * M - len(virus) - spread(area,case,virus,N,M) - wall_count
    safe_size = max(safe_size,result)


#안전 영역 = 전체 크기 - 바이러스 영역 - 벽 개수
print(safe_size)