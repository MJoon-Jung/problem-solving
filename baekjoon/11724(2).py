from collections import deque


def bfs(n):
    queue = deque()
    queue.append(n)
    visited[n] = True
    while queue:
        n = queue.popleft()
        for val in graph[n]:
            if visited[val]:
                continue
            visited[val] = True
            queue.append(val)


N, M = map(int, input().split())

graph = [[]for _ in range(N+1)]
visited = [False for _ in range(N+1)]

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

count = 0

for i in range(1, N+1):
    if not visited[i]:
        bfs(i)
        count += 1
print(count)
