T = int(input())

def multiply(long,short):
    max_result = 0
    for i in range(len(long)-len(short)+1):
        result = 0
        for j in range(len(short)):
            result += long[i+j] * short[j]
        max_result = max(max_result, result)

    return max_result

for i in range(T):
    N,M = map(int, input().split())
    input_array = []
    for _ in range(2):
        input_array.append(list(map(int, input().split())))

    if N > M: #첫번째 배열이 더 길다
        print(f"#{i+1} {multiply(input_array[0],input_array[1])}")

    else:
        print(f"#{i+1} {multiply(input_array[1],input_array[0])}")

