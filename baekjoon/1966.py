import collections as c
from itertools import islice


def getCount(queue, M, val):
    count = 0
    for idx, value in enumerate(queue):
        if val == value:
            count += 1
            if idx == M:
                break
    return count


def dequeSlice(queue, start, end):
    return c.deque(islice(queue, start, end))


def solution(queue, M):
    count = 0
    val = queue[M]
    goalNum = queue.count(val)
    print(queue)
    while True:
        max_val = max(queue)
        if max_val == val:
            break
        idx = queue.index(max_val)
        queue = dequeSlice(queue, idx, len(queue)) + dequeSlice(queue, 0, idx)
        queue.popleft()
        if idx > M:
            M = len(queue) - idx + M
        else:
            M = M - idx - 1
        count += 1
    if goalNum == 1:
        return count + 1

    return count + getCount(queue, M, val)


result = []
K = int(input())

for _ in range(K):
    N, M = map(int, input().split())
    queue = c.deque(map(int, input().split()))
    result.append(solution(queue, M))
    queue.clear()
[print(val) for val in result]
