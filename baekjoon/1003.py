dpz = [0]*41
dpo = [0]*41
dpz[0] = 1
dpz[1] = 0
dpo[0] = 0
dpo[1] = 1

T = int(input())

for i in range(2, 41):
    dpz[i] = dpz[i-1] + dpz[i-2]
    dpo[i] = dpo[i-1] + dpo[i-2]

for i in range(T):
    N = int(input())
    print('%d %d' % (dpz[N], dpo[N]))
