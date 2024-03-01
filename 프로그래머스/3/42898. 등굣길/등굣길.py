def solution(m, n, puddles):
    maps = [[0] * m for _ in range(n)]
    puddle = [[False] * m for _ in range(n)]
    for i,j in puddles:
        puddle[j-1][i-1] = True
    # print(puddle)
    answer = 0 #개수 %  1,000,000,007
    for i in range(m):
        if puddle[0][i]:
            break  #더이상 못 감
        maps[0][i] = 1
        
    for i in range(n):
        if puddle[i][0]:
            break
        maps[i][0] = 1
    # print(maps)
    for i in range(1,n):
        for j in range(1,m):
            if not puddle[i][j]:
                maps[i][j] = maps[i-1][j] + maps[i][j-1]
    # print(maps)
    return maps[-1][-1] % 1000000007

"""
0 1 1 1 
1 2 3 4 
1 3 6 10
"""
#(3-2)
# (2,3) - (1,1) -> (1,2) 
