good = False
r = -1
P, K = map(int, input().split())
for p in range(2, K+1):
    if P % p == 0:
        q = P // p
        if p < K or q < K:
            if p < q:
                r = p
            else:
                r = q
            break
        good = True
        break
    else:
        if p == K:
            good = True
if good:
    print('GOOD')
else:
    print('BAD %d' % (r))
