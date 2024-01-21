def solution(numbers, hand):
    answer = ''
    left_nums = {'1':(0,0),'4':(1,0),'7':(2,0)}
    right_nums = {'3':(0,2),'6':(1,2),'9':(2,2)}
    both = {'2':(0,1),'5':(1,1),'8':(2,1),'0':(3,1)}
    #위치 : (행,열)
    left_pos = (3,0)
    right_pos = (3,2)
    for i in numbers:
        i = str(i)
        if i in left_nums:
            left_pos = left_nums[i]
            answer += 'L'
        elif i in right_nums:
            right_pos = right_nums[i]
            answer += 'R'
        else:
            #거리 구해야함
            row = both[i][0]
            col = both[i][1]
            dis_left = abs(row-left_pos[0]) + abs(col-left_pos[1])
            dis_right = abs(row-right_pos[0]) + abs(col-right_pos[1])
            if dis_left < dis_right:
                #왼손 누르기
                answer += 'L'
                left_pos = both[i]
            elif dis_left > dis_right:
                answer += 'R'
                right_pos = both[i]
            elif dis_left == dis_right:
                if hand == "right":
                    answer += 'R'
                    right_pos = both[i]
                else:
                    answer += 'L'
                    left_pos = both[i]
    return answer

#왼손 엄지 -> *
#오른손 엄지 -> #
#상하좌우로만 이동 

#1,4,7 -> 왼손
#3,6,9 -> 오른손
#2,5,8,0 -> 더 가까운 엄지 -> 손잡이

#numbers : 누를번호
#hand : 손잡이
#result = L 또는 R로 이루어진 배열

#[0,0,0]
#[0,0,0]
#[0,0,0]
#[L,0,R]