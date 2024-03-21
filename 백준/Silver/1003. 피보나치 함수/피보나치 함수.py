def bottom_up(n,zero_one):
    if n >=2:
        for i in range(2,n+1):
            zero_one[0][i] = zero_one[0][i-2] + zero_one[0][i-1]
            zero_one[1][i] = zero_one[1][i-2] + zero_one[1][i-1]
    return zero_one
def init(x):
    if x == 0:
        zero_one = [[1],[0]]
    else:
        zero_one = [[0] * (x+1) for _ in range(2)]
        zero_one[0][0] = 1
        zero_one[0][1] = 0
        zero_one[1][0] = 0
        zero_one[1][1] = 1
    bottom_up(x,zero_one)
    return zero_one
n = int(input())
for _ in range(n):
    x = int(input())
    res = init(x)
    print(res[0][x], res[1][x])