from collections import deque


def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=" ")
    graph[v].sort()
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        x = queue.popleft()
        print(x, end=' ')
        for i in graph[x]:
            graph[i].sort()
            if not visited[i]:
                queue.append(i)
                visited[i] = True


N, M, V = map(int, input().split())

graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
visited2 = [False for i in range(N+1)]

for i in range(M):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

dfs(graph, V, visited)
print()
bfs(graph, V, visited2)
