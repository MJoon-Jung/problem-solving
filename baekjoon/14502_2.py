from collections import deque
import copy

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def bfs(wall, x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if wall[nx][ny] == 0:
                    wall[nx][ny] = 2
                    queue.append((nx, ny))


max_safety_counts = 0

length = N * M
for i in range(0, length - 2):
    for j in range(i + 1, length - 1):
        for k in range(j + 1, length):
            kx, ky = k // M, k % M
            jx, jy = j // M, j % M
            ix, iy = i // M, i % M
            if not (graph[kx][ky] == 0 and graph[jx][jy] == 0 and graph[ix][iy] == 0):
                continue
            graph_copy = copy.deepcopy(graph)
            graph_copy[kx][ky] = 1
            graph_copy[jx][jy] = 1
            graph_copy[ix][iy] = 1
            for h in range(N):
                for l in range(M):
                    if graph_copy[h][l] == 2:
                        bfs(graph_copy, h, l)
            safe_count = sum(row.count(0) for row in graph_copy)
            max_safety_counts = max(max_safety_counts, safe_count)

print(max_safety_counts)
