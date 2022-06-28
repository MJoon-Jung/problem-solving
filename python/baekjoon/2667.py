def dfs(x, y, count):
    if graph[x][y] == 0:
        return count
    graph[x][y] = 0
    count += 1
    for i in range(4):
        nx = x+dir1[i]
        ny = y+dir2[i]
        if nx < 0 or ny < 0 or nx >= N or ny >= M:
            continue
        if graph[nx][ny] == 0:
            continue
        count = dfs(nx, ny, count)
    return count


N = int(input())

graph = []

dir1 = [-1, 1, 0, 0]
dir2 = [0, 0, -1, 1]


for i in range(N):
    graph.append(list(map(int, input())))
M = len(graph[0])
result = []

for i in range(N):
    for j in range(M):
        a = dfs(i, j, 0)
        if a:
            result.append(a)

print(len(result))
result.sort()
for val in result:
    print(val)


# def dfs(x, y, count: set):
#     if graph[x][y] == 0:
#         return False, count
#     count.add((x, y))
#     graph[x][y] = 0
#     for i in range(4):
#         nx = x+dir1[i]
#         ny = y+dir2[i]
#         if nx < 0 or ny < 0 or nx >= N or ny >= M:
#             continue
#         if graph[nx][ny] == 0:
#             continue
#         dfs(nx, ny, count)
#     return True, count


# N = int(input())

# graph = []

# dir1 = [-1, 1, 0, 0]
# dir2 = [0, 0, -1, 1]


# for i in range(N):
#     graph.append(list(map(int, input())))
# M = len(graph[0])
# result = []

# for i in range(N):
#     for j in range(M):
#         a, b = dfs(i, j, set([]))
#         if a:
#             result.append(len(b))

# print(len(result))
# result.sort()
# for val in result:
#     print(val)
