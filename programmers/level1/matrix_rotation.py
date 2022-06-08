test = [6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]]
test2 = [3, 3, [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]]
test3 = [100, 97, [[1, 1, 100, 97]]]


def solution(rows, columns, queries):
    graph = []
    for r in range(rows):
        graph.append([a for a in range(r*columns+1, (r+1)*columns+1)])
    result = []
    for query in queries:
        result.append(solve(graph, query))
    return result


def solve(graph, query):
    x1, y1 = query[0]-1, query[1]-1
    x2, y2 = query[2]-1, query[3]-1
    value = graph[x1][y1]
    min_value = value
    for i in range(y1+1, y2):
        tmp = graph[x1][i]
        graph[x1][i] = value
        value = tmp
        min_value = min(min_value, value)
    for i in range(x1, x2+1):
        tmp = graph[i][y2]
        graph[i][y2] = value
        value = tmp
        min_value = min(min_value, value)
    for i in range(y2-1, y1, -1):
        tmp = graph[x2][i]
        graph[x2][i] = value
        value = tmp
        min_value = min(min_value, value)
    for i in range(x2, x1-1, -1):
        tmp = graph[i][y1]
        graph[i][y1] = value
        value = tmp
        min_value = min(min_value, value)
    return min_value


# print(solution(test[0], test[1], test[2]))
# print(solution(test[0], test[1], test[2]))
# print(solution(test2[0], test2[1], test2[2]))
print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))
