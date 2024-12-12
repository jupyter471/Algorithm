N,M = map(int, input().split())
know = list(map(int, input().split()))
knowNum = know[0]
knowSet = set(know[1:])

#참여할 파티 선택 기준 -> 진실을 아는 사람이 아무도 없어야함 && 사람수가 적은 순으로

group = []
heap = []

for _ in range(M):
    people = list(map(int, input().split()))
    group.append(set(people[1:]))

for _ in range(M):
    for ele in group:
        if knowSet & ele:
            knowSet.update(ele)


cnt = 0
for ele in group:
    if ele.isdisjoint(knowSet):
        cnt += 1

print(cnt)

#1차 실패
#거짓말을 할 수 있는 그룹 기준이 아니라 진실만을 말해야하는 그룹의 수를 세야함
#거짓말을 이미 들은 사람이 진실을 알고 있는 사람과 한 조면 안됨
#조에 한 명이라도 진실을 알고 있으면 진실을 말해야함

#2차 실패
"""
    for ele in group:
        if knowList & ele:
            knowList.update(ele)
    이렇게만 한 상태라면 그룹 입력 순서에 따라 달라짐 -> 순서에 상관없어야함
    knowList와 비교하는 횟수가 그룹수만큼 반복되어야함
    반례) A는 이미 진실을 알고있음
    1번 그룹에서 B가 안전하다고 판단하여 넘어감 3번 그룹에 A,B가 있음 -> B는 거짓말을 들으면 안되게 됨
    -> 다른 그룹들을 순회하며 B가 있었던 그룹에 대한 처리를 해야함
"""