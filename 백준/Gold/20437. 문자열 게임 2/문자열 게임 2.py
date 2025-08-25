T = int(input())

for i in range(T):
    string = input()
    K = int(input())

    pos = [[] for _ in range(26)]

    for idx, c in enumerate(string):
        pos[ord(c) - ord('a')].append(idx)
    
    second = -1
    first = float('inf')

    for arr in pos:
        if len(arr) < K: continue

        for i in range(len(arr) - K + 1):
            #문자열 길이
            length = arr[i + K - 1] - arr[i] + 1
            first = min(first, length)
            second = max(second, length)
    
    if first == float('inf'):
        print(-1)
        # print("\n")
        continue
    else:
        print(first, second)
        # print("\n")

