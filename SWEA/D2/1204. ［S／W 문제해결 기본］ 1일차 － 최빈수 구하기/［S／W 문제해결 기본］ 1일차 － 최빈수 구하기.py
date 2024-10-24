from collections import Counter
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
	n = int(input())
	number = list(map(int, input().split()))
	num = Counter(sorted(number))
	num = sorted(num.items(), key = lambda x: (-x[1],-x[0]))   #value에 대해 내림차순 후 key 값에 대해 내림차순
	print(f'#{test_case} {num[0][0]}')
    
	
    # ///////////////////////////////////////////////////////////////////////////////////
