import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {

    public static void main(String[] args) {
        InOrder inOrder =  new InOrder();
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(1);
        root.right = new TreeNode(7);
        inOrder.increasingBST(root);
    }

    List<Integer> finalList = new ArrayList<>();
    TreeNode finalTree = null;
    public TreeNode increasingBST(TreeNode root) {
        inOrderList(root);
        if(finalList.isEmpty()) return null;
        finalTree = new TreeNode(finalList.get(0));
        TreeNode head = finalTree;
        for(int i=1;i<finalList.size();i++){
            finalTree.right = new TreeNode(finalList.get(i));
            finalTree = finalTree.right;
        }

        finalTree.right = null;
        return head;
    }

    public  void inOrderList(TreeNode root) {
        if (root == null) return ;
        inOrderList(root.left);
        finalList.add(root.val);
        inOrderList(root.right);
        return ;
    }
}
