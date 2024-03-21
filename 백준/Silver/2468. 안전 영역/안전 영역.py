#map 탐색하면서 특정 값 이상인 영역의 개수
#dfs로 탐색하면서 개수 세기

import sys
from copy import deepcopy
sys.setrecursionlimit(100000)
n = 0
maps = []
move = [(0,-1),(0,1),(-1,0),(1,0)]

def get_input():
    global n,maps
    n = int(input())
    for _ in range(n):
        line = list(map(int,sys.stdin.readline().split()))
        maps.append(line)
    # return max_num,min_num

def get_count(t,level):
    #안전지역 개수 구하기
    #dfs
    count = 0
    global n
    def dfs(v):
        t[v[0]][v[1]] = level
        for m in move:
            nxt_r = v[0] + m[0]
            nxt_c = v[1] + m[1]
            if 0<=nxt_r<n and 0<=nxt_c<n and t[nxt_r][nxt_c] > level:
                dfs([nxt_r,nxt_c])
    for i in range(n):
        for j in range(n):
            if t[i][j] > level:
                count += 1
                dfs([i,j])

    # print("level count",level,count)
    return count




def main():
    #최대 안전 지역 개수 구하기
    get_input()
    max_count = 0 #안전지역 개수 저장할 배열  
    # print(max_num,min_num)
    for i in range(0,max(map(max,maps))+1):
        t = deepcopy(maps)
        max_count = max(max_count,get_count(t,i))

    print(max_count)

main()


"""
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
"""