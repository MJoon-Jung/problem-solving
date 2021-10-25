from collections import deque

dx = [1, 1, 1, 0, 0, -1, -1, -1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        for i in range(len(dx)):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if visited[nx][ny] == True or graph[nx][ny] == 0:
                continue
            visited[nx][ny] = True
            queue.append((nx, ny))


result = []
while True:
    N, M = map(int, input().split())
    if N == 0 and M == 0:
        break
    graph = []
    visited = []
    for i in range(M):
        graph.append(list(map(int, input().split())))
        visited.append([False for _ in range(N)])
    count = 0
    for i in range(M):
        for j in range(N):
            if not visited[i][j] and graph[i][j] == 1:
                bfs(i, j)
                count += 1
    result.append(count)

[print(val) for val in result]
