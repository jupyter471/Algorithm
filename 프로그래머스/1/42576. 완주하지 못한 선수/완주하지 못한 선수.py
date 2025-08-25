from collections import defaultdict
def solution(participant, completion):
    answer = ''
    dict = defaultdict(int)
    for p in participant:
        dict[p] += 1
    for c in completion:
        dict[c] -= 1
        if dict[c] == 0:
            dict.pop(c)
    
    for k in dict.keys():
        answer = k
    return answer