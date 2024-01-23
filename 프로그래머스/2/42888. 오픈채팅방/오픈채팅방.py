#1시반
def solution(record):
    answer = []
    in_out = []
    print_lis = {'Enter':"님이 들어왔습니다.",'Leave':"님이 나갔습니다."}
    dict = {}  #id : 닉네임
    for i in range(len(record)):
        temp = record[i].split(" ")
        if temp[0] == "Enter" or temp[0] == "Change":
            dict[temp[1]] = temp[2]
        in_out.append([temp[1],temp[0]])
    # print(in_out)
    for i in in_out:
        #아이디 enter
        if i[1] == 'Change':
            continue
        answer.append(dict[i[0]]+print_lis[i[1]])
    return answer

#닉네임 변경 -> 기존에 출력된 닉네임도 변경
# 나가고 이름 바꿔서 들어오면 출력된 닉넴 변경

#record: 닉네임 변경 기록
#최종 출력 : return
#Enter, Leave, Change