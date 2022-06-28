pattern = ['[', ']', '(', ')']
while True:
    stack = []
    str = input()
    if str == '.':
        break
    for i in range(len(str) - 1):
        v = str[i]
        if v == '.':
            break
        if v in pattern:
            if stack:
            # if stack and stack[-1]:
                if (stack[-1] == pattern[0] and v == pattern[1]) or (stack[-1] == pattern[2] and v == pattern[3]):
                    stack.pop()
                    continue
            stack.append(v)
    print('no') if len(stack) > 0 else print('yes')
