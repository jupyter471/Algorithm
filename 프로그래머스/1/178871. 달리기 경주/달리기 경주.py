def solution(players, callings):
    #index 찾는 게 오래 걸림 -> dict에 저장
    dic = {}
    answer = []
    for i in range(len(players)):
        dic[players[i]] = i
    for name in callings:
        idx = dic[name] #등수
        dic[name] -= 1
        dic[players[idx-1]] += 1
        players[idx], players[idx-1] = players[idx-1],players[idx]
    return players