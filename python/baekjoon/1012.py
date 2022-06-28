# def dfs(x, y):
#     if x < 0 or y < 0 or x >= N or y >= M:
#         return False
#     if graph[x][y] == 0:
#         return False
#     graph[x][y] = 0
#     dfs(x+1, y)
#     dfs(x-1, y)
#     dfs(x, y+1)
#     dfs(x, y-1)
#     return True

from collections import deque


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x+dir1[i]
            ny = y+dir2[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if graph[nx][ny] == 0:
                continue
            graph[nx][ny] = 0
            queue.append((nx, ny))
    return True


T = int(input())

dir1 = [-1, 1, 0, 0]
dir2 = [0, 0, -1, 1]

result = []

for i in range(T):
    # M열 N행 K개수
    M, N, K = map(int, input().split())
    graph = [[0 for a in range(M)] for b in range(N)]
    r = 0
    for p in range(K):
        X, Y = map(int, input().split())
        graph[Y][X] = 1
    for v in range(N):
        for q in range(M):
            if graph[v][q] == 1:
                if bfs(v, q):
                    r += 1
    result.append(r)

for val in result:
    print(val)
