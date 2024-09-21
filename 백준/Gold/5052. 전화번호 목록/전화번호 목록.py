def main():
    test_case = int(input())
    for _ in range(test_case):
        n = int(input())
        if check(n):
            print("YES")
        else:
            print("NO")

def check(n):
    phone_book = [input() for _ in range(n)]
    phone_book = sorted(phone_book)
    for phone_number1, phone_number2 in zip(phone_book, phone_book[1:]):
        if phone_number2.startswith(phone_number1):
            return False
    return True

main()