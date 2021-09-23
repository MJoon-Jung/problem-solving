N, M = map(int, input().split(' '))
a = set([input() for i in range(N)])
b = set([input() for i in range(M)])
c = a & b
print(len(c))
[print(v) for v in sorted(c)]