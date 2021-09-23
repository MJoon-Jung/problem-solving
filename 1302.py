solution = {}
N = int(input())
for i in range(N):
    t = input()
    value = solution.get(t)
    if value == None:
        solution[t] = 1
    else:
        solution[t] = value + 1

list = [k for k, v in solution.items() if max(solution.values()) == v]
list.sort()
print(list[0])