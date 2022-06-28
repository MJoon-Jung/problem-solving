class Node:
    def __init__(self, val, left, right):
        self.val=val
        self.left=left
        self.right=right

def pre_order(node: Node):
    print(node.val, end='')
    if node.left != '.':
        pre_order(tree[node.left])
    if node.right != '.':
        pre_order(tree[node.right])


def in_order(node: Node):
    if node.left != '.':
        in_order(tree[node.left])
    print(node.val, end='')
    if node.right != '.':
        in_order(tree[node.right])
    
def post_order(node: Node):
    if node.left != '.':
        post_order(tree[node.left])
    if node.right != '.':
        post_order(tree[node.right])
    print(node.val, end='')


tree = {}
N = int(input())

for i in range(N):
    val, left, right = input().split()
    node = Node(val,left,right)
    tree[val] = node

pre_order(tree['A'])
print()
in_order(tree['A'])
print()
post_order(tree['A'])
print()


