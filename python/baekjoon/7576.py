from sys import stdin
from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if graph[nx][ny] == 0 or graph[x][y] + 1 < graph[nx][ny]:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))


# N, M = map(int, input().split())
N, M = map(int, stdin.readline().split())

graph = []

for _ in range(M):
    graph.append(list(map(int, stdin.readline().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(M):
    for j in range(N):
        if graph[i][j] == 1:
            bfs(i, j)
max_val = -1
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            print(-1)
            exit()
        max_val = max(max_val, graph[i][j])

print(max_val-1)
