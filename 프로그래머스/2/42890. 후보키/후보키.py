from itertools import combinations

def solution(relation):
    col = len(relation[0])
    row = len(relation)
    
    #가능한 조합
    all_possible = []
    for i in range(1,col+1):
        all_possible.extend(combinations(range(col),i))
    
    unique = []
    for comb in all_possible:
        temp = []
        for re in relation:
            tmp = []
            for c in comb:
                tmp.append(re[c])
            temp.append(tmp)
        # print(temp)
        #유일성 체크
        temp = set(list(map(tuple,temp)))
        if len(temp) == row:
            flag = True
            # print(temp)
            #최소성 체크
            # print(unique)
            for uni in unique:
                if set(uni).issubset(comb):
                    flag = False
                    break
            if flag:
                unique.append(comb)
    
    return len(unique)