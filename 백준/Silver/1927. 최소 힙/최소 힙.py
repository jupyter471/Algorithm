"""
입력값이 0이면 출력
그 외는 힙에 넣기
"""
import sys
import heapq

N = int(input())

heap = []

for _ in range(N):
    case = int(sys.stdin.readline())
    if case == 0:
        try:
            print(heapq.heappop(heap))
        except:
            print(0)
    else:
        heapq.heappush(heap,case)