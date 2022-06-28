import collections


def printing(X, status):
    result = '['
    if status:
        for i in range(len(X) - 1, -1, -1):
            result += str(X[i])
            if i != 0:
                result += ','
    else:
        for i, val in enumerate(X):
            result += str(val)
            if i != len(X) - 1:
                result += ','

    result += ']'
    return result


def solution(queue, X):
    status = False
    for val in queue:
        if val == 'R':
            status = not status
        else:
            try:
                if status:
                    X.pop()
                else:
                    X.popleft()
            except:
                return 'error'
    return printing(X, status)


T = int(input())

for i in range(T):
    queue = collections.deque([])

    p = list(input())
    n = int(input())
    x = input()
    X = []
    if x != '[]':
        X = collections.deque(list(map(int, x[1:-1].split(','))))

    print(solution(p, X))
