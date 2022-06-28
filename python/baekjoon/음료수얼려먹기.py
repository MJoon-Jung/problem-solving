# from typing import no_type_check


# def dfs(x, y):
def dfs(x, y):
    if x < 0 or y < 0 or x >= N or y >= M:
        return False
    if graph[x][y]:
        return False
    graph[x][y] = 1
    dfs(x+1, y)
    dfs(x, y+1)
    dfs(x-1, y)
    dfs(x, y-1)
    return True


N, M = map(int, input().split())
graph = []
for i in range(N):
    graph.append(list(map(int, input())))

result = 0


for i in range(N):
    for j in range(M):
        if dfs(i, j):
            result += 1
print(result)
