n,c = map(int, input().split())
house = []

for _ in range(n):
    house.append(int(input()))

house = sorted(house)

#구해야하는 것 인접한 공유기의 최대 거리 -> 공유기를 C개만큼 사용하는

start = 1   #공유기 간의 거리 중 최소
end = house[n-1] - house[0] #공유기 사이의 거리 중 최대
#최적의 거리를 구해야됨
while start <= end:
    mid = (start + end) // 2
    #공유기 설치
    cnt = 1
    current = house[0]  #첫번째집부터 시작
    for i in range(1,n):
        if house[i] >= current + mid:  #공유기간 거리가 mid이상이어야됨 -> 우린 가장 인접한 공유기의 최적 거리를 알고싶으니깐
            cnt += 1
            current = house[i]

    if cnt >= c:
        #공유기가 부족함-> 간격을 늘려야됨
        start = mid + 1
    else:
        end = mid -1

print(end)