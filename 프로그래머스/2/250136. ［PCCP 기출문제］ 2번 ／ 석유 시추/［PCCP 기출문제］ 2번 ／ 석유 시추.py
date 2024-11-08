#덩어리분류하고 크기 기록해두기 2부터
from collections import defaultdict,deque
def solution(land):
    sichu = defaultdict(int)
    row = len(land)
    col = len(land[0])
    
    answer = 0
    mark = 2
    def dfs(v):
        size = 1
        movement = [(-1,0),(1,0),(0,-1),(0,1)]
        dq = deque()
        dq.append(v)
        while dq:
            v = dq.popleft()
            land[v[0]][v[1]] = mark
            for i in range(4):
                nxt_r = v[0] + movement[i][0]
                nxt_c = v[1] + movement[i][1]
                if 0<= nxt_r < row and 0<=nxt_c < col:
                    if land[nxt_r][nxt_c] == 1:
                        #탐색
                        size += 1
                        dq.append([nxt_r,nxt_c])
                        land[nxt_r][nxt_c] = mark
        sichu[mark] = size
        return mark
    for i in range(col):
        cnt = 0
        area = set()
        for j in range(row):
            if land[j][i] == 1:
                area.add(dfs([j,i]))
                mark += 1
            elif land[j][i] > 1:
                #기존에 카운트한 영역 -> 한번만 더해야됨
                area.add(land[j][i])
        for a in area:
            cnt += sichu[a]
        answer = max(cnt,answer)
    
    return answer