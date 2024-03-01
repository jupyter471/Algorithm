#집 n개 공유기 C개 인접한 공유기 거리 최대한 크게 
#가장 인접한 공유기 거리를 최대한 크게 하게 설치
#최대 거리 
import sys
n,c = map(int,input().split())
homes = []
for _ in range(n):
    homes.append(int(input()))
homes = sorted(homes)
ans = []
#이진탐색 : 특정 수를 찾고싶다 -> 인접한 최대 거리를 찾고 싶다! 

#이진탐색
start = 0
end = 1000000000
if c == 2:
    print(homes[-1] - homes[0])
    exit()

#해당 거리로 공유기 설치 가능한지 체크
def check(dist,c):
    src = homes[0]
    for h in homes[1:]:
        if src + dist <= h:
            #dist이상일 때 설치 가능
            src = h
            c -= 1
        if c == 1: #처음에는 무조건 설치
            ans.append(dist)
            return True
    return False

while start <= end:
    mid = (start + end) //2

    if check(mid,c):
        #설치 가능 -> 거리 더 넓혀서 다시 체크
        start = mid + 1
    else:
        end = mid - 1

print(max(ans))



"""
1 3 7 9 12
"""