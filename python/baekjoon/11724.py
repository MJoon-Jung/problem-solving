from collections import deque


def bfs(n, index):
    queue = deque()
    queue.append(n)
    visited[n] = index
    while queue:
        n = queue.popleft()
        for val in graph[n]:
            if visited[val] > 0:
                continue
            visited[val] = index
            queue.append(val)
    pass


N, M = map(int, input().split())

graph = [[]for _ in range(N+1)]
visited = [-1 for _ in range(N+1)]

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, N+1):
    if visited[i] == -1:
        bfs(i, i)

result = set([])
for i in range(1, len(visited)):
    if visited[i] != -1:
        result.add(visited[i])
print(len(result))
