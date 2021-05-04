
/**
 * @author: 303014439
 * @date: 2021/5/4 20:47
 * @description:给定一个二叉树，返回其最大深度
 * 思路：分治法，返回左右子树中深度较大的那个
 */
public class 二叉树的最大深度 {
    public static int getDeep(binaryTree input){
        int leftDeep = 0,rightDeep = 0;
//        如果左右孩子都为null，则返回深度0
        if (input.left == null && input.right ==null){
            return 1;
        }else{
//            如果左右孩子中有一个不为0，返回左右子树的深度并赋值给局部变量
            if(input.left != null) leftDeep = getDeep(input.left) + 1;
            if(input.right != null) rightDeep = getDeep(input.right) + 1;
//            返回左右子树中深度较大的一个
            return leftDeep>rightDeep?leftDeep:rightDeep;
        }
    }

    public static void main(String[] args) {
        binaryTree input = binaryTree.getBanlanceTree();
        System.out.println(getDeep(input));
    }
}

