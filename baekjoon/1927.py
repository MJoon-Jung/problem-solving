import heapq

N = int(input())
arr = []
result = []
for _ in range(N):
    tmp = int(input())
    if tmp == 0:
        if len(arr) == 0:
            result.append(0)
            continue
        result.append(heapq.heappop(arr))
    else:
        heapq.heappush(arr, tmp)

[print(val) for val in result]


# import heapq

# N = int(input())
# arr = []
# result = []
# for _ in range(N):
#     tmp = int(input())
#     if tmp == 0:
#         if len(arr) == 0:
#             print(0)
#             continue
#         print(heapq.heappop(arr))
#     else:
#         heapq.heappush(arr, tmp)
