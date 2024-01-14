def solution(msg):
    answer = []
    dic = {}
    index = 1
    for i in range(ord('A'),ord('Z')+1):
        dic[chr(i)] = index
        index += 1
    size = len(msg)
    p = 0 # W위치
    msg_len = len(msg)
    while(p < msg_len):
        find_len = 1 #사전에서 찾을 문자열의 길이
        while(find_len <= msg_len):
            if msg[p:p + find_len] in dic:
                #print(msg[p:p+find_len])
                find_len += 1
            else:
                find_len = (1 if find_len == 1 else find_len - 1)
                #print("find",find_len)
                break
        answer.append(dic[msg[p:p +find_len]])
        dic[msg[p:p + find_len+1]] = index
        index += 1
        p += find_len
    print(answer)
    return answer