from itertools import combinations_with_replacement

n,m = map(int, input().split())

for x in list(combinations_with_replacement([i for i in range(1,n+1)],m)):
    ele = []
    for i in range(m):
        ele.append(str(x[i]))
    print(" ".join(ele))