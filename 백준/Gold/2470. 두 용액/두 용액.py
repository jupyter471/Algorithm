#산성 용액의 특성값은 1부터 1,000,000,000
#알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
#0에 가장 가까운 용액 만들기
import sys
n = int(input())
acid = list(map(int,sys.stdin.readline().split()))
acid = sorted(acid)
#두용액을 더했을 때 그게 0에 가까워야함
#절댓값이 0에 가까워야함
answer = [None,None]
start = 0
end = n -1
min = float('inf')
while start < end:
    sum = acid[start] + acid[end]
    
    if abs(sum) < min:
        min = abs(sum)
        answer[0] = acid[start]
        answer[1] = acid[end]

        if sum == 0:
            break  #끝
    
    if sum < 0:
        #합이 더 커져야함
        start += 1
    else:
        end -= 1
print(answer[0],answer[1])
