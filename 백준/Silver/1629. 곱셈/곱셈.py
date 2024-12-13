#자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
import sys
sys.setrecursionlimit(10**7)

a,b,c = map(int, sys.stdin.readline().split())

"""
재귀로 계속 b를 쪼개야됨 -> 1이 될 때까지 => a^8 = ((a^2)^2)^2 ->  8번에서 3번으로 줄게됨
1. 1일 때
2. 짝수일때
3. 홀수일때
"""

def power(a,b,c):
    #최소한으로 쪼개진 경우
    if b == 1:
        return a % c
    #더 쪼개야하는 경우
    temp = power(a,b//2,c)
    if b % 2 == 0:
        #짝수일 때 temp * temp
        return (temp * temp) % c
    else:
        #ex) b가 3일 때 temp : a
        return (temp * temp * a) % c

print(power(a,b,c))


#시간초과 이유 -> 제곱뿐만아니라 나머지 연산도 분할해야함
#=> 모듈러 법칙
"""
A^B % C = A^(B/2) * A^(B/2) % C
"""