import sys
n = int(input())
work = []
for _ in range(n):
    work.append(list(map(int, sys.stdin.readline().split())))

start = []
score = 0
#[소요시간, 점수]
for w in work:
    if w[0] == 1:
        if w[2] == 1:
            score += w[1]
            continue
        start.append([w[2]-1, w[1]])

    else:
        #[0]
        if start:
            now = start.pop()
            if now[0] == 1:
                score += now[1]
            else:
                start.append([now[0]-1,now[1]])
print(score)