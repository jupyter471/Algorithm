from collections import defaultdict
def solution(gems):
    answer = [1, len(gems)]
    
    kind = len(set(gems))
    count = defaultdict(int)
    start = end = 0
    count[gems[0]] = 1
    
    while start < len(gems) and end < len(gems):
        if len(count) < kind:
            #추가해야함
            end += 1
            if end == len(gems):
                break
            count[gems[end]] += 1
            
        elif len(count) == kind:
            #최적의 답 찾기 배열 줄이기
            if answer[1] - answer[0] > end - start:
                answer = [start+1,end+1]
            #start 옮기기
            else:
                count[gems[start]] -= 1
                if count[gems[start]] == 0:
                    del(count[gems[start]])
                start += 1
    return answer