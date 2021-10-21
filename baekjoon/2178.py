from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        if not graph[x][y]:
            continue
        for i in range(4):
            nx = x+dir1[i]
            ny = y+dir2[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    return graph[N-1][M-1]


N, M = map(int, input().split())
graph = []

for i in range(N):
    graph.append(list(map(int, input())))


dir1 = [-1, 1, 0, 0]
dir2 = [0, 0, -1, 1]


print(bfs(0, 0))
