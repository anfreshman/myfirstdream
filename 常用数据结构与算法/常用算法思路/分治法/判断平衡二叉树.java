
/**
 * @author: 303014439
 * @date: 2021/5/4 21:07
 * @description:给定一个二叉树，判断是否为平衡二叉树
 */
public class 判断平衡二叉树 {
    public static boolean judgeBanlanceTree(binaryTree input){
        boolean leftflag = true,rightflag = true;
        if(input.left == null && input.right == null){
            return true;
        }else{
            if(input.left != null && input.right != null){
                leftflag = judgeBanlanceTree(input.left);
                rightflag = judgeBanlanceTree(input.right);
                return leftflag && rightflag;
            }else return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(judgeBanlanceTree(binaryTree.getBanlanceTree()));
    }
}
