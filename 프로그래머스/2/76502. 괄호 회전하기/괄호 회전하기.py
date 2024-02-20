from collections import deque
def solution(s):
    answer = 0
    # print(right_b(s))
    new = s
    for x in range(len(s)):
        #회전
        first = new[0]
        new = new[1:]
        new += first
        if right_b(new):
            # print(new)
            answer += 1
    return answer

def right_b(string):
    dict = {"]":"[",")":"(","}":"{"}
    q = []
    for s in string:
        if s not in dict:
            q.append(s)
        else:
            if not q:
                return False
            else:
                if q[-1] == dict[s]:
                    q.pop()
    if not q:
        return True
    else:
        return False
#왼쪽으로 밀기