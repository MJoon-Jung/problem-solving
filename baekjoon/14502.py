import copy
import sys
from collections import deque

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]  # 그래프 생성

graph_copy = copy.deepcopy(graph)  # 그래프 복사

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]  # 상하좌우 이동

safe_region = 0  # 최대 안전 영역


def dfs(x, y, wall):
    wall[x][y] = 2
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if wall[nx][ny] == 0:
                dfs(nx, ny, wall)


def bfs(x, y, wall):
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


def select_wall(start, count):
    global safe_region
    if count == 3:
        wall = copy.deepcopy(graph_copy)
        for i in range(N):
            for j in range(M):
                if wall[i][j] == 2:
                    bfs(i, j, wall)
                    # dfs(i, j, wall)
        safe_count = sum(_.count(0) for _ in wall)
        safe_region = max(safe_region, safe_count)
        return
    else:
        for i in range(start, N*M):
            r = i//M
            c = i % M
            if graph_copy[r][c] == 0:
                graph_copy[r][c] = 1
                select_wall(i, count+1)
                graph_copy[r][c] = 0


select_wall(0, 0)
print(safe_region)
