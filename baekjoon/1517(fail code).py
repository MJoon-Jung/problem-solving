def merge(left, right):
    i = 0
    j = 0
    sorted_list = []

    while (i < len(left)) & (j < len(right)):
        if left[i] < right[j]:
            sorted_list.append(left[i])
            i += 1
        else:
            sorted_list.append(right[j])
            j += 1
    while i < len(left):
        sorted_list.append(left[i])
        i += 1
    while j < len(right):
        sorted_list.append(right[j])
        j += 1

    return sorted_list


def merge_sort(unsorted_list):
    if len(unsorted_list) <= 1:
        return unsorted_list

    mid = len(unsorted_list) // 2
    left = unsorted_list[:mid]
    right = unsorted_list[mid:]

    left2 = merge_sort(left)
    right2 = merge_sort(right)

    return merge(left2, right2)


ar = [1, 532, 352, 3, 356, 13, 3, 78874, 35]

print(merge_sort(ar))
