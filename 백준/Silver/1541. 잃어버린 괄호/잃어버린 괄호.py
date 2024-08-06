formula = input()
split_form = formula.split("-")
num_list = []
for x in split_form:
    sum = 0
    p_split = x.split("+")
    for i in p_split:
        sum += int(i)
    num_list.append(sum)
result = num_list[0]
for i in num_list[1:]:
    result -= i
print(result) 
