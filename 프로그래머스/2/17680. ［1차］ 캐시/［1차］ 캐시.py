from collections import deque

def solution(cacheSize, cities):
    answer = 0
    qu = deque(maxlen = cacheSize)  #도시랑 시간 저장
    for city in cities:
        city = city.lower()
        #참조된 시간 순으로 deque에 저장됨
        if city not in qu:
            qu.append(city)
            answer += 5
        else:
            #이미 있는 경우 qu에서 삭제하고 맨 뒤에 저장
            qu.remove(city)
            qu.append(city)
            answer += 1
    return answer


#캐시 크기에 따른 실행시간 측정 프로그램
#도시 이름 검색하면 도시와 관련된 맛집 게시물 보여줌
#LRU : 가장 오랫동안 참조되지 않은 페이지 교체