import sys
from collections import deque
import copy


def bfs(x, y, k, graph, visited):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if graph[nx][ny] > k and not visited[nx][ny]:
                    queue.append((nx, ny))
                    visited[nx][ny] = True


input = sys.stdin.readline
N = int(input())
graph = []
visited = [[False for _ in range(N)] for _ in range(N)]

max_val = 0
for i in range(N):
    graph.append(list(map(int, input().split())))
    graph_max_val = max(graph[i])
    max_val = max(max_val, graph_max_val)

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
result = []
for k in range(max_val):
    count = 0
    graph_copy = copy.deepcopy(graph)
    visited_copy = copy.deepcopy(visited)
    for i in range(N):
        for j in range(N):
            if graph_copy[i][j] > k and not visited_copy[i][j]:
                bfs(i, j, k, graph_copy, visited_copy)
                count += 1
    result.append(count)
print(max(result))
