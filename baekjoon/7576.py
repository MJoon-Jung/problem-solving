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
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
            elif graph[nx][ny] > 1:
                queue.append((nx, ny))
                if graph[x][y] < graph[nx][ny]:
                    graph[nx][ny] = graph[x][y]


N, M = map(int, input().split())

graph = []

for _ in range(M):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(M):
    for j in range(N):
        if graph[i][j] <= 0:
            continue
        bfs(i, j)

max_val = -1
for i in range(M):
    for j in range(N):
        current_val = graph[i][j]
        if current_val == 0:
            print(-1)
            exit()
        max_val = max(current_val, max_val)

print(max_val)
