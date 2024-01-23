package anoop.test.sample;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {

    int pIndex = -1;
    int ti = -1;

    public static void main(String[] args) {
        InorderSuccessor i = new InorderSuccessor();

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inorder = new ArrayList<>();
        inorder(root, p, inorder);

        return pIndex == -1 ? null : pIndex + 1 >= inorder.size()? null : inorder.get(pIndex+1);
    }

    private void inorder(TreeNode root, TreeNode p, List<TreeNode> inorder){
        if(root != null){

            if(root.left != null)
                inorder(root.left, p, inorder);

            inorder.add(root);
            ti++;
            if(root.val == p.val){
                pIndex = ti;
            }

            if(root.right != null)
                inorder(root.right, p, inorder);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
