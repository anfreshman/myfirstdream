package 常见数据结构;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 303014439
 * @date: 2021/3/29 20:59
 * @description:二叉树是一种特殊的树状结构，也是最常用的树状结构，它有五种遍历方式，且其中三种又可以分为递归形式和非递归形式
 *  非递归的核心思想就是使用栈进行递归下降，把原本JVM做的事进行手动模拟
 */
public class 二叉树 {


    //访问某节点
    public static void  visit(int node){
        System.out.println(node);
    }
    //二叉树的前序遍历，先根节点，再左子树，再右子树
    public static void preOrder(binaryTree input){
        if(input == null){
            return;
        }
        visit(input.data);
        preOrder(input.left);
        preOrder(input.right);
    }
    //二叉树的前序遍历(非递归版)，核心思想就是使用栈+循环，达到先遍历一边的目的
    //前序遍历，即从根节点开始，第一次接触到某节点就可以对其进行访问,所以我们对任意一个节点，先将其压入栈中，然后弹出并访问，若其右节点不为空，压入，左节点不为空，压入
    static Stack stack = new Stack();
    public static void preOrderNoRe(binaryTree input){
        binaryTree temp = input;
        stack.push(temp);
        while (!stack.isEmpty()){
            temp = stack.pop();
            visit(temp.data);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    //中序遍历
    public static void midOrder(binaryTree input){
        if(input == null) return;
        midOrder(input.left);
        visit(input.data);
        midOrder(input.left);
    }

    //中序遍历(非递归版)，中序遍历，即当第二次接触到某个节点(深入到左子树最底层)之后，才可以对其进行遍历
    public static void midOrderNoRe(binaryTree input){
        binaryTree temp = input;
        while(!stack.isEmpty()||temp != null){
            //先深入左子树
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                //若temp为空，说明已经到了某一次的最底层，访问stack顶数据，并回退到上一层，开始访问右子树
                temp = stack.pop();
                visit(temp.data);
                temp = temp.right;
            }
        }
    }
    //后序遍历
    public static void afterOrder(binaryTree input){
        if(input == null) return;
        midOrder(input.left);
        midOrder(input.left);
        visit(input.data);
    }

    //测试方法(主方法)
    public static void main(String[] args) {
        binaryTree head = binaryTree.getBanlanceTree();
        preOrderNoRe(head);
    }

}


class binaryTree{
    int data;
    binaryTree left;
    binaryTree right;
    //测试方法
    public static binaryTree getTree(){
        binaryTree root;
        binaryTree temp;
        int[] testinput = new int[]{1,2,5,6,8,4,6,5,4};
        root = new binaryTree();
        root.data = testinput[0];
        temp = root;
        for(int i = 1; i< testinput.length;i++){
            if(testinput[i] > temp.data){
                temp.right = new binaryTree();
                temp.right.data = testinput[i];
                temp = temp.right;
            }else{
                temp.left = new binaryTree();
                temp.left.data = testinput[i];
                temp = temp.left;
            }
        }
        return root;
    }
    //构造一个对称的测试树
    public static binaryTree getBanlanceTree(){
        binaryTree root = new binaryTree();
        root.data = 1;
        root.left = new binaryTree();
        root.left.data = 2;
        root.left.left = new binaryTree();
        root.left.left.data = 4;
        root.right = new binaryTree();
        root.right.data = 3;
        root.right.right = new binaryTree();
        root.right.right.data = 5;
        return root;
    }
}

class Stack{
    List<binaryTree> stack = new ArrayList<>();
    public void push(binaryTree input){
        stack.add(input);
    }
    public binaryTree pop(){
        binaryTree re =  stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return re;
    }
    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
}