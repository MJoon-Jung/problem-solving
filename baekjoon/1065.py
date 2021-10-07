def isArithmetic(n):
    tmp = list(map(int, str(n)))
    abs = 0
    for i in range(len(tmp) - 1):
        if i == 0:
            abs = tmp[i] - tmp[i+1]
            continue
        k = tmp[i] - tmp[i+1]
        if abs != k:
            return False
    return True

'''
result = [0]
[result.append(i) for i in range(1, 100)]
'''
result = [val for val in range(100)]

for i in range(100, 1001):
    val = result[-1]
    if isArithmetic(i):
        result.append(val + 1)
    else:
        result.append(result[-1])

N = int(input())

print(result[N])
