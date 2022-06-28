# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        step = 0
        self.traversal(root, step)
        self.result.reverse()
        return self.result

    def traversal(self, root: Optional[TreeNode], step: int):
        if root is None:
            return
        self.traversal(root.left, step + 1)
        self.traversal(root.right, step + 1)
        if len(self.result) < step + 1:
            while len(self.result) < step + 1:
                self.result.insert(len(self.result), [])
        self.result[step].append(root.val)
