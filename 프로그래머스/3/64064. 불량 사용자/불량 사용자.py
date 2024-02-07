from itertools import product
def solution(user_id, banned_id):
    answer = 0
    #각 경우의 수 넣고 조합 구하기
    case = []
    #사용 여부 체크
    for idx_ban,ban in enumerate(banned_id):
        case.append([])
        for idx_user,user in enumerate(user_id):
            if len(user) == len(ban) and comp(user,ban):
                #True면 배열에 추가
                case[-1].append(user)
    # print(case)
    # #조합 구하기
    result = []
    # print(pro)
    for p in product(*case):
        s = set(p)
        if len(s) == len(p) and s not in result:
            result.append(s)
            answer += 1
    print(result)
    return answer

# * 로 가리기
# user_id 응모자 아이디 목록
# banned_id 불량 사용자 아이디 목록 크기 1이상 user_id 이하
# 제대 아이디 목록의 경우의 수

#비교 유저 아이디와 ban이 주어졌을 때 해당 유저 아이디가 ban이 될 수 있는지
def comp(user,ban):
    for idx,u in enumerate(user):
        if ban[idx] != "*":
            if ban[idx] != u:
            #다름
                return False
    return True

#완탐으로라도 풀었어야함



"""
from itertools import product
def solution(user_id, banned_id):
    answer = 0
    #각 경우의 수 넣고 조합 구하기
    case = []
    for _ in range(len(banned_id)):
        case.append([])
    # for i in range(len(user_id)):
    
    for idx_ban,ban in enumerate(banned_id):
        for idx_user,user in enumerate(user_id):
            if len(user) == len(ban):
                if comp(user,ban):
                    #True면 배열에 추가
                    case[idx_ban].append(user)
    # print(case)
    # #조합 구하기
    result = []
    pro = list(product(*case))
    for p in pro:
        p = sorted(p)
        s = set(p)
        if len(s) == len(p) and p not in result:
            result.append(p)
            answer += 1
    return answer

# * 로 가리기
# user_id 응모자 아이디 목록
# banned_id 불량 사용자 아이디 목록 크기 1이상 user_id 이하
# 제대 아이디 목록의 경우의 수

#비교 유저 아이디와 ban이 주어졌을 때 해당 유저 아이디가 ban이 될 수 있는지
def comp(user,ban):
    for idx,u in enumerate(user):
        if ban[idx] != "*":
            if ban[idx] != u:
            #다름
                return False
    return True

#완탐으로라도 풀었어야함
"""
