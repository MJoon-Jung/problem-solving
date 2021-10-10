# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.traver(root)
        return self.result

    def traver(self, root: Optional[TreeNode]):
        if root == None:
            return
        self.traver(root.left)
        self.result.append(root.val)
        self.traver(root.right)
