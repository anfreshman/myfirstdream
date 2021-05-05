/**
 * @author: 303014439
 * @date: 2021/5/5 20:21
 * @description:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 思路：如果一个节点是两个目标节点的公共祖先，那么必然其左子树(包括自身)含有一个目标节点，右子树(包含自身)含有一个公共节点
 *  根据这个特点，我们的可以写出递归条件
 */
public class 二叉树的最近公共祖先 {
    public static binaryTree getParentNode(binaryTree node1,binaryTree node2,binaryTree input){
//        两个变量的含义分别为：左子树得到的结果，右子树得到的结果，找到了赋值，没找到则为null
        binaryTree left,right;
//        当该节点比对成功其中一个节点，或该节点为null时，达到返回条件，直接返回
        if(input == node1 || input == node2 ||input == null) return input;
//        否则向下寻找
        left = getParentNode(node1,node2,input.left);
        right = getParentNode(node1,node2,input.right);
//        如果左边返回与右边返回均不为空，说明该节点就是需要的节点
        if(left != null && right != null) {
//            System.out.println("最近公共节点为" + input.data);
            return input;
        }
//        如果其中一个为空，则返回另一个，这里即是node节点向上传递，也是目标节点向上传递
        return left == null?right:left;
    }


    public static void main(String[] args) {
        binaryTree input = binaryTree.getBanlanceTree();
        System.out.println(getParentNode(input.left.left,input.left.right,input).data);;
    }
}
