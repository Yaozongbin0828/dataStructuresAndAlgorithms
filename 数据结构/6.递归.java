class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        // 创建一棵树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 调用递归函数遍历树
        traverseTree(root);
    }

    // 递归函数：遍历树
    public static void traverseTree(TreeNode node) {
        if (node == null) {
            return;
        }

        // 先处理当前节点
        System.out.println(node.val);

        // 递归处理左子树
        traverseTree(node.left);

        // 递归处理右子树
        traverseTree(node.right);
    }
}
