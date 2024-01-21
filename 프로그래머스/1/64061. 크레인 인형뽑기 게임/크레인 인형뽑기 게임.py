def solution(board, moves):
    answer = 0
    #0 -> 없는 인형
    dolls = []
    for i in moves:
        #board[i-1][j]
        for j in range(len(board)):
            if board[j][i-1] != 0:
                #print(board[j][i-1])
                answer = check(dolls,board[j][i-1],answer)
                board[j][i-1] = 0
                break
        
    return answer
def check(dolls,new,answer):
    #print(new)
    #print(dolls)
    if (dolls and dolls[-1] == new):
        #print(dolls[-1])
        answer += 2
        dolls.pop()
    else:
        dolls.append(new)
    return answer
    
#board : 격자상태 같은 인형 -> 같은 숫자
#moves : 크레인 작동 위치
#answer : 터트려져 사라진 인형 개수

# 1 2 3 4 5
#[0,0,0,0,0]
#[0,0,1,0,3]
#[0,2,5,0,1]
#[4,2,4,4,2]
#[3,5,1,3,1]

#moves에서 하나씩 탐색 제일 위에꺼 위치 -> 배열에 넣기
#바로 아래꺼 비교