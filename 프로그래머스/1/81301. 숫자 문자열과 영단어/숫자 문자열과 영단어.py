def solution(s):
    index = 0
    answer = ""
    num = {"zero" : "0", "one" : "1", "two" : "2", "three" : "3", "four" : "4", "five" : "5", "six" : "6", "seven" : "7", "eight" : "8", "nine" : "9"}
    while index < len(s):
        if s[index].isdigit():
            answer += s[index]
            index += 1
        else:
            #영어인경우
            temp = ""
            while index < len(s) and s[index].isalpha():
                temp += s[index]
                index += 1
                if temp in num:
                    temp = num[temp]
                    break
            answer += temp
    #숫자 or 영어 -> 숫자로
    return int(answer)