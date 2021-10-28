from collections import deque
import sys
input = sys.stdin.readline

dx = [1, 1, 2, 2, -1, -1, -2, -2]
dy = [2, -2, 1, -1, 2, -2, 1, -1]


def bfs(graph, visited, x, y):
    global N
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        for i in range(len(dx)):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if graph[nx][ny] == -1:
                    graph[nx][ny] = graph[x][y]+1
                    queue.clear()
                    break
                if graph[nx][ny] == 0 and not visited[nx][ny]:
                    graph[nx][ny] = graph[x][y]+1
                    queue.append((nx, ny))
                    visited[nx][ny] = True


T = int(input())

for i in range(T):
    N = int(input())
    graph = [[0 for i in range(N)] for _ in range(N)]
    l, k = map(int, input().split())
    graph[l][k] = 1
    z, c = map(int, input().split())
    if l == z and k == c:
        print(0)
        continue
    graph[z][c] = -1
    visited = [[False for i in range(N)] for _ in range(N)]
    bfs(graph, visited, l, k)
    print(graph[z][c] - 1)
