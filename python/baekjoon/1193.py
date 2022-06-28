i = 1
N = int(input())

while N > i:
    N -= i
    i += 1

if i % 2 == 1:
    print(str(i+1-N)+'/'+str(N))
else:
    print(str(N)+'/'+str(i+1-N))
