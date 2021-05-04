
/**
 * @author: 303014439
 * @date: 2021/5/4 21:18
 * @description:给定一个二叉树，返回其最大路径和的结果
 */
public class 二叉树最大路径和 {
    public static int getMaxPath(binaryTree input){
        int leftvalue = 0,rightvalue = 0;
        if(input.left == null && input.right ==null){
            return input.data;
        }else{
            if(input.left != null) leftvalue =  getMaxPath(input.left);
            if(input.right != null) rightvalue =  getMaxPath(input.right);
            return leftvalue>rightvalue?leftvalue + input.data : rightvalue + input.data;
        }
    }


    public static void main(String[] args) {
        System.out.println(getMaxPath(binaryTree.getBanlanceTree()));
    }
}
