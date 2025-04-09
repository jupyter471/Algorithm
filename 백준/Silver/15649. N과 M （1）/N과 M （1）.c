#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 8
//M: 뽑는 개수 N: N까지의 자연수
int m, n;
int result[8];
int checklist[9]; //중복제외를 위한 리스트 뽑으면 1로 변경
//[*,1,2,3,4,5,6,7,8]
//순열 (a, a+i,,,,,)

void find(int a) 
{
	if (a == m)  //순열 하나 생성 완료 
	{
		for (int i = 0; i < m; i++) //순열출력
		{
			printf("%d ", result[i]);
		}
		printf("\n");
	}
	else   //수열에 하나씩 추가하기
	{
		for (int i = 1; i <= n; i++)
		{
			if (checklist[i] == 0)
			{
				result[a] = i; //숫자입력
				checklist[i] = 1; 
				find(a + 1);  //다음 자리 숫자입력을 위한 재귀, 이 재귀가 끝나면 순열 하나가 만들어짐
				checklist[i] = 0; //다시 0으로 만들어야함
			}
		}
	}
}

int main()
{
	scanf("%d %d", &n, &m);
	find(0);
}