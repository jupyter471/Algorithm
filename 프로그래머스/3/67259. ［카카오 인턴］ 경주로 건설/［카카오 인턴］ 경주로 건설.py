from collections import deque
#테케 11,13,16,17,18,19,25 실패...시발시발시발

def solution(board):
    # build(board,[0,0,True])
    # build(board,[0,0,False])
    return min(build(board,[0,0,0,0]),build(board,[0,0,3,0]))
def build(board,start):
    n = len(board)
    visited = [[False] * n for _ in range(n)]
    cost_board = [[float('inf')] * n for _ in range(n)]
    cost_board[0][0] = 0
    #상하 
    ud = ([1,0],[-1,0])
    lr = ([0,-1],[0,1])
    d = ([1,0],[-1,0],[0,-1],[0,1]) #
    #dfs
    w = deque([start])
    visited[0][0] = True
    #True : 가로 False : 세로
    while w:
        # print(w)
        # print(cost_board)
        r,c,f,cost = w.popleft()
        #가로 탐색
        for i in range(4):
            nr = r + d[i][0]
            nc = c + d[i][1]
            if (0<=nr<n and 0<=nc<n) and board[nr][nc] == 0:
                new = cost + 100
                if i != f: 
                    new = new + 500
                if cost_board[nr][nc] >= new:
                    cost_board[nr][nc] = new
                    w.append((nr,nc,i,new))
        # for x in lr:
        #     nr = r + x[0]
        #     nc = c + x[1]
        #     if (0<=nr<n and 0<=nc<n) and board[nr][nc] == 0:
        #         cost = cost_board[r][c] + 100
        #         if not f: #이전코스가 세로였음
        #             cost += 500
        #         if cost_board[nr][nc] >= cost:
        #             cost_board[nr][nc] = cost
        #             w.append((nr,nc,True))
        # for x in ud:
        #     nr = r + x[0]
        #     nc = c + x[1]
        #     if 0<=nr<n and 0<=nc<n and board[nr][nc] == 0:
        #         cost = cost_board[r][c] + 100
        #         if f: #이전코스가 세로였음
        #             if not (nr == 1 and nc == 0):
        #                 cost += 500
        #         #이미 방문했던 경우
        #         if cost_board[nr][nc] >= cost:
        #                 cost_board[nr][nc] = cost
        #                 w.append((nr,nc,False))
    print(cost_board) 
    return cost_board[n-1][n-1]
       
        
# 0 : 빔 1: 벽(건설x)
# (0,0) ~ (N-1,N-1)
#직선 : 100원 코너 : 500원 
#경주로 : 두 빈칸 연결 -> 직선 하나
#경주로 최소 비용 (코너 최소화)
#다 구하고 최소값?

