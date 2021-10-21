max_len = 1000001
M, N = map(int, input().split())

a = [i for i in range(max_len)]
a[1] = 0
for i in range(2, len(a)):
    if a[i] != 0:
        for j in range(i + i, max_len, i):
            a[j] = 0

for i in range(M, N + 1):
    if a[i] != 0:
        print(a[i])
