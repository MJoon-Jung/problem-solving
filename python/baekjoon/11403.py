def dfs(start, graph, graph2, visisted):
    s = []
    s.push(start)
    
    while not s:
        c=s.pop()
        for i in r


N=int(input())
graph2=[]
graph=[[]]
for i in range(N):
    graph2.append(list(map(int, input().split())))
    graph.append([])


for i in range(N):
    for j in range(N):
        if graph2[i][j]:
            graph[i+1].append(j+1)



dfs(graph)

print(start, graph, graph2, visited=[False]*(N+1))



for i in range(N)








