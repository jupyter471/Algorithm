n,c = map(int, input().split())

num = []

for i in range(n):
    num.append(int(input()))

num = sorted(num)

start = 1
end = num[n-1] - num[0]


while start <= end:
    mid = (start + end) // 2
    cnt = 1
    last = num[0]
    for i in range(1,n):
        if last + mid <= num[i]:
            cnt+=1
            last = num[i]

    if cnt < c:
        end = mid - 1
    else:
        start = mid + 1

print(end)