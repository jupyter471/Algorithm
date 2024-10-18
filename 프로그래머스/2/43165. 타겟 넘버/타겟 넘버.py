size = 0
def solution(numbers, target):
    #dfs 경로는 더하거나 빼거나
    curr = 0
    answer = 0
    global size
    size = len(numbers)

    answer = dfs(numbers,0,0,target)
    #더하기 경로 -> 만약 남은 수를 모두 빼도 target보다 크다면 백트랙킹
    #빼기 경로 -> 만약 남은 수를 모두 더해도 target보다 작다면 백트랙킹
    return answer

def dfs(numbers,curr,index,target):
    if index == size:
        if curr == target:
            return 1
        else: 
            return 0
#백트랭킹
    if curr + sum(numbers[index:]) < target:
        return 0
    if curr - sum(numbers[index:]) > target:
        return 0
    add =  dfs(numbers,curr+numbers[index],index+1,target)
    sub = dfs(numbers,curr-numbers[index],index+1,target)
    return add + sub
    