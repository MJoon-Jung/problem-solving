# from collections import deque

# def solution(numbers, target):
#     pass

# def dfs(numbers, target):
#     i=0
#     start=numbers[i]
#     queue=deque()
#     queue.append(start)
#     while queue:
#         x = queue.popleft()
#         y = numbers[i]
#         z = numbers[i] * -1
#         i += 1
#         queue.append(x+y)
#         queue.append(x+z)