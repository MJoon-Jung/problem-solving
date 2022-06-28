from collections import deque


def bfs(x):
    queue = deque()
    queue.append(x)
    visited[x] = True
    count = 0
    while queue:
        x = queue.popleft()
        for val in graph[x]:
            if visited[val]:
                continue
            queue.append(val)
            visited[val] = True
            count += 1
    return count


N = int(input())
T = int(input())

graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)

for _ in range(T):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(bfs(1))
