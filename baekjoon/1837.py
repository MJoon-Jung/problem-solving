max_len = 1000001

a = [i for i in range(max_len)]
a[1] = 0
for i in range(2, len(a)):
    if a[i] != 0:
        for j in range(i + i, max_len, i):
            a[j] = 0

good = False
r = -1
P, K = map(int, input().split())
for idx, p in enumerate(a):
    if idx == len(a) - 1:
        if p == 0:
            good = True
            break
    if p == 0:
        continue
    if P % p == 0:
        q = P // p
        if p < K or q < K:
            if p < q:
                r = p
            else:
                r = q
            break
        good = True
if good:
    print('GOOD')
else:
    print('BAD %d' % (r))