str = input().lower()
solution = {}
for s in str:
    v = solution.get(s)
    if v == None:
        solution[s] = 1
    else:
        solution[s] = v + 1
z = [i for i, k in solution.items() if max(solution.values()) == k]
print(z[0].upper() if len(z) == 1 else '?')