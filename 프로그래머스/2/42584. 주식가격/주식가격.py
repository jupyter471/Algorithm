def solution(prices):
    answer = []
    n = len(prices)
    for i in range(n-1):
        sec = 0
        for j in range(i,n-1):
            if prices[i] <= prices[j]:
                sec += 1
            else:
                break;
        answer.append(sec)
    answer.append(0)
    return answer

#가격이 떨어지지 않는 기간 구하기
#총 시간, 가격이 동일하거나 오른경우 -> 남은 총시간
#가격이 떨어지면 1