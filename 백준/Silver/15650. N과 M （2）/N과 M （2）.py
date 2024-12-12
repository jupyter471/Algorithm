from itertools import combinations

N,M = map(int, input().split())

for x in combinations([i for i in range(1,N+1)],M):
    x = list(map(str,x))
    print(" ".join(list(x)))