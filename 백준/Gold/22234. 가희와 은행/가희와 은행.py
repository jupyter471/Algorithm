import sys
from collections import deque
N,T,W = map(int, input().split())
waiting = deque()
for _ in range(N):
    waiting.append(list(map(int,sys.stdin.readline().split())))  #대기 큐 고객 -> id,소요시간
# print(waiting)
after = []
M = int(input()) #1초
for _ in range(M):
    after.append(list(map(int, sys.stdin.readline().split())))  #id,소요시간,오픈 후 흐른 시간
after.sort(key=lambda x: x[2]) #입장한 시간순으로 정렬
after = deque(after)
sec = 0 #흐르는 시간

while sec < W:
    now_id, now_t = waiting.popleft()   #id, 소요시간
    if now_t <= T:
        #소요시간이 기준시간보다 작은 경우
        for _ in range(now_t):
            print(now_id)
            sec += 1
            if sec == W:
                exit(0)
        while after and after[0][2] <= sec:
            m = after.popleft()
            waiting.append([m[0], m[1]])
    else:
        for _ in range(T):
            print(now_id)
            sec += 1
            if sec == W:
                exit(0)
        # 대기열 갱신
        while after and after[0][2] <= sec:
            m = after.popleft()
            waiting.append([m[0], m[1]])
        waiting.append([now_id, now_t - T])