rep = {10:"A",11:"B",12:"C",13:"D",14:"E",15:"F"}
def solution(n, t, m, p):  
    answer = ''
    ans = "00"
    #진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    for i in range(0,m*t):
        ans += get(i, n)
    #튜브의 순서에 필요한 숫자 구하기
    # print(ans)
    count = 1
    index = p
    while count <= t:
        # print(ans[index])
        answer += ans[index]
        index += m
        count += 1
        
    # print(answer)
    return answer

def get(num,n):
    ans = ""
    while num > 0:
        num,q = divmod(num,n)
        if q >= 10:
            ans += rep[q]
        else:
            ans += str(q)
    # print(num,ans[::-1])
    return ans[::-1]