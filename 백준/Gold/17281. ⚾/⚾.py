import sys
from itertools import permutations

MAX_OUT = 3
"""
각 선수의 타석 결과 case
[[4, 0, 0, 0, 0, 0, 0, 0, 0], [4, 0, 0, 0, 0, 0, 0, 0, 0]]
"""
def game(case,n, result):
    curr_inning = 0
    rotation = case[:3] + [0] + case[3:]
    # print(rotation)
    point = 0
    curr_player = 0   #현재 플레이해야하는 선수에 해당하는 rotaion 내에서의 인덱스 -> rotation[curr_player] 에 해당하는 번호의 선수가 플레이함
    while curr_inning < n:
        #각 이닝 시작
        out_count = 0
        b1 = b2 = b3 = 0  #각 베이스에 와있는 선수
        #플레이 시작
        while out_count < 3:   #이전 이닝에서 끝난 이후부터 다시 시작해야됨
            if result[curr_inning][rotation[curr_player]] == 0:
                #out
                out_count += 1
            elif result[curr_inning][rotation[curr_player]] == 1:
                point += b3  # b3에 진루했던 선수가 있다면 득점
                b1,b2,b3 = 1,b1,b2   #진루
            elif result[curr_inning][rotation[curr_player]] == 2:
                point += b2 + b3
                b1,b2,b3 = 0,1,b1
            elif result[curr_inning][rotation[curr_player]] == 3:
                point += b1+b2+b3
                b1,b2,b3 = 0,0,1  #모두 다 홈인하고 3루에만 선수 있음
            else:
                #홈런
                point += (b1+b2+b3+1)
                b1,b2,b3 = 0,0,0  #모든 베이스는 비게된다
            curr_player += 1
            if curr_player == 9:
                curr_player = 0
        curr_inning += 1
    return point
    #case에 나온 순서대로 결과가 나오고 inning(n)만큼 종료되면 바로 return
    #현재 베이스 상태를 어떻게 표현하지 걍 하드코딩 해야됨



N = int(input())
result = [] #각 선수가 각 이닝에서 얻는 결과 1번 선수 ~ 9번 선수
player = [i for i in range(1,9)]  #result에 바로 하기 위해 인덱스 -1
# print(player)
for _ in range(N):
    result.append(list(map(int,sys.stdin.readline().split())))

#모든 경우의 수 단 여기에 1번선수는 빠져 있음
cases = list(permutations(player))
score = 0
for case in cases:
    score = max(score, game(list(case),N,result))
print(score)