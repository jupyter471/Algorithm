import sys
n = int(input())
maps = [[None] * n for _ in range(n)]
homes = []
for i in range(n):
    line = sys.stdin.readline().strip()
    for idx,l in enumerate(line):
        maps[i][idx] = int(l)
move = [(-1,0),(1,0),(0,-1),(0,1)]
def main():
    for i in range(n):
        for j in range(n):
            if maps[i][j] == 1:
                h = dfs(i,j,1)
                homes.append(h)
    print(len(homes))
    for i in sorted(homes):
        print(i)

def dfs(i,j,cnt):
    maps[i][j] = 0
    for m in move:
        new_r = m[0] + i
        new_c = m[1] + j
        if 0<=new_r<n and 0<=new_c<n and maps[new_r][new_c]:
            #가능
            maps[new_r][new_c] = 0
            cnt = dfs(new_r,new_c,cnt+1)
    return cnt

main()