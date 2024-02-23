from collections import deque
def solution(queue1, queue2):
    answer = 0
    s1 = sum(queue1)
    s2 = sum(queue2)
    q1 = deque(queue1)
    q2 = deque(queue2)
    movemax = (len(queue1) + len(queue2)) * 2
    #못만드는 경우
    if (s1 + s2) % 2 == 1:
        return -1
    
    #아무리 옮겨도 못 만드는 경우
    
    while s1 != s2:
        if answer >= movemax:
            return -1
        while q1 and s1 > s2:
            num = q1.popleft()
            q2.append(num)
            s1 -= num
            s2 += num
            answer += 1
        while q2 and s1 < s2:
            num = q2.popleft()
            q1.append(num)
            s1 += num
            s2 -= num
            answer += 1
    return answer

#큐 원소 추출하고 넣어서 합 같도록
#pop &insert ->1회