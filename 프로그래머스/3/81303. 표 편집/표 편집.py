size = 0
def solution(n, k, cmd):
    global size
    size = n
    answer = ""
    #n : 행개수 k:처음위치
    dict = {}
    deleted = []
    dict[0] = [None,1,True]
    for i in range(1,n-1):
        dict[i] = [i-1,i+1,True]
    dict[n-1] = [n-2,None,True]
    # print(dict)
    #["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
    for c in cmd:
        if c.startswith('D'):
            _,m = c.split(" ")
            k = down(dict,k,int(m))
        elif c.startswith('U'):
            _,m = c.split(" ")
            k = up(dict,k,int(m))
        elif c =='C':
            dict[k][2] = False
            deleted.append(k)
            k = delete(dict,k)
        elif c == 'Z':
            idx = deleted.pop()
            dict[idx][2] = True
            recover(dict,idx)
    #삭제된 인덱스 확인
    for d in dict:
        if dict[d][2] == True:
            answer += "O"
        else:
            answer += "X"
    return answer
def down(dict,k,m):
    for _ in range(m):
        k = dict[k][1]
    return k

def up(dict,k,m):
    for _ in range(m):
        k = dict[k][0]
    return k
def delete(dict,k):
    prev = dict[k][0]
    nxt = dict[k][1]
    if prev != None:
        dict[prev][1] = nxt
    if nxt != None:
        dict[nxt][0] = prev
        k = nxt
    else:
        k = prev
    return k
def recover(dict,idx):
    #복구
    if dict[idx][0] != None:
        prev = dict[idx][0]
        dict[prev][1] = idx
    if dict[idx][1] != None:
        nxt= dict[idx][1]
        dict[nxt][0] = idx
    
#연결리스트?
#U X 위 D X 아래 C 현재 선택된 행 삭제, 바로 아래 행 선택, Z삭제 복구 원래대로 복구? 처음 인덱스? 
#명령 후 표와 처음 표 비교 삭제 -> O 삭제x->x 문자열