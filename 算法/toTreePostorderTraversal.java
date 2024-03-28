import java.util.LinkedList;
import java.util.Stack;

// 二叉树节点类
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        value = x;
    }
}


public class toTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);

        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) {
                node[i].left = node[i * 2 + 1];
            }
            if (i * 2 + 2 < 10) {
                node[i].right = node[i * 2 + 2];
            }
        }
        postOrderRe(node[0]);
        System.out.println("***");
        postOrder(node[0]);
    }

    static void postOrderRe(TreeNode root) {
        //递归实现
        if (root == null) {
            return;
        } else {
            postOrderRe(root.left);
            postOrderRe(root.right);
            System.out.println(root.value);
        }
    }

    static void postOrder(TreeNode root) {
        //后序遍历非递归实现
        int left = 1; //在辅助栈里表示左结点
        int right = 2;//在辅助栈里表示右结点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();
        //辅助栈，用来判断子结点返回父节点时处于左结点还是右结点。
        while (root != null || !stack.empty()) {
            //将结点压入栈1，并在栈2将结点标记为左结点
            stack.push(root);
            stack2.push(left);
            root = root.left;
        }
        while (!stack.empty() && stack2.peek() == right) {
            //如果从右子结点返回父结点，则任务完成，将两个栈的栈顶弹出
            stack2.pop();
            System.out.println(stack.pop().value);
        }
        while (!stack.empty() && stack2.peek() == left) {
            //如果从左子结点返回父节点，则将标记改为右子结点
            stack2.pop();
            stack2.push(right);
            root = stack.peek().right;
        }
    }
}
