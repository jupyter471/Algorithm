import heapq
def solution(scoville, K):
    answer = 0
    #힙에서 가장 작은 게 k이상일 때 까지
    #계속 돌리면서 수정해주기
    
    heapq.heapify(scoville)
    min_s = heapq.heappop(scoville)
    while (min_s < K):
        answer += 1
        if not scoville:
            return -1
        second_s = heapq.heappop(scoville)
        new_s = min_s + second_s * 2
        heapq.heappush(scoville,new_s)
        min_s = heapq.heappop(scoville)
    return answer