from collections import deque

limit = 100001


def bfs():
    queue = deque()
    queue.append(N)

    while queue:
        n = queue.popleft()
        if n == K:
            break
        for i in (n+1, n-1, n*2):
            if i < 0 or i >= limit:
                continue
            if graph[i] == 0:
                graph[i] = graph[n] + 1
                queue.append(i)


N, K = map(int, input().split())

graph = [0]*limit

bfs()

print(graph[K])
