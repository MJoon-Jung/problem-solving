import heapq


def heapsort(iterable):
    h = []
    result = []

    [heapq.heappush(h, value) for value in iterable]
    print(heapq)
    [result.append(heapq.heappop(h)) for _ in range(len(h))]

    return result


n = int(input())
arr = []

[arr.append(int(input())) for _ in range(n)]

res = heapsort(arr)
[print(x) for x in res]
