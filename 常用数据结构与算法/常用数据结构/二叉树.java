
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 303014439
 * @date: 2021/3/29 20:59
 * @description:二叉树是一种特殊的树状结构，也是最常用的树状结构，它有五种遍历方式，且其中三种又可以分为递归形式和非递归形式
 *  非递归的核心思想就是使用栈进行递归下降，把原本JVM做的事进行手动模拟
 */
public class BinaryTree {


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

    //后序遍历(非递归版)
//    后序遍历的非递归就是最后一次接触到某一个元素的时候再访问它
//    所以对于任意一个节点，首先访问它的左子树，并压入栈，直到到达当前最左端，然后以相同方式访问其右子树的左子树，直到为null
//    最后到达的节点才是可以访问的节点，对于上一层的节点，只有从右子树返回时才可以访问
//    所以设置pre指向上一次访问到节点，访问节点前不能弹栈，所以去处元素后需要再压回去，访问节点时才可以弹栈，并标记指针为null
//    二叉树的后序非递归遍历有一条特性，访问某一节点时，当前栈内的节点就是其到根节点的一条路径，该特性可用来解决最短公共双亲等问题
    public static void afterOrderNoRe(binaryTree input){
        binaryTree temp = input;
        binaryTree pre = null;
        while(temp != null || !stack.isEmpty()){
//            当左节点存在时，遍历访问到最左下的节点
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
//                得到栈顶节点
                temp = stack.pop();
                stack.push(temp);
                //当左节点不存在时，尝试访问右节点
                if(temp.right != null && pre != temp.right){
//                    右节点存在且未被访问过，则进行压栈
                    temp = temp.right;
                    stack.push(temp);
                    temp = temp.left;
                }else{
//                    弹栈并访问该节点
                    stack.pop();
                    visit(temp.data);
//                  记录此次访问的节点
                    pre = temp;
                    temp = null;
                }
            }
        }
    }

//    深度优先遍历
//    深度优先遍历的规则:先遍历最左端的子树，然后逐层上升，遍历右子树
//    深度优先遍历（栈实现）
    public static  void dfs(binaryTree input){
        binaryTree temp = input;
//      将根节点入栈
        stack.push(temp);
        while(temp != null&!stack.isEmpty()){
            temp = stack.pop();
            visit(temp.data);
//            如果它有右子树，将右子树先入栈(后访问)
            if(temp.right != null){
                stack.push(temp.right);
            }
//            将temp指向它的左子树
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

//    深度优先遍历(递归法)
    public static void dfs2(binaryTree input){
        if(input != null){
            visit(input.data);
        }
        if(input.left != null){
            dfs2(input.left);
        }
        if(input.right != null){
            dfs2(input.right);
        }
    }

//    广度优先遍历，广度优先遍历就是逐层遍历，需要用到辅助数据结构队列
//    具体思路为：对于一个节点，先入队，若有左孩子，入队，有有孩子，入队，访问该节点。a
//    广度优先遍历(循环法)，核心在于使用一个中间指针与队列进行遍历，广度优先遍历没有递归法
    static Queue queue = new Queue();
    public static void bfs(binaryTree input){
//        根节点入队
        binaryTree temp = input;
        queue.push(temp);
        while(temp != null || !queue.isEmpty()){
            temp = queue.pop();
            if(temp.left != null){
                queue.push(temp.left);
            }
            if(temp.right!=null){
                queue.push(temp.right);
            }
            visit(temp.data);
            temp = null;
        }
    }



    //测试方法(主方法)
    public static void main(String[] args) {
        binaryTree head = binaryTree.getBanlanceTree();
        dfs(head);
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
        root.left.right = new binaryTree();
        root.left.right.data = 6;
        root.right = new binaryTree();
        root.right.data = 3;
        root.right.left = new binaryTree();
        root.right.left.data = 7;
        root.right.right = new binaryTree();
        root.right.right.data = 5;
        return root;
    }
}

//遍历所用的辅助数据类型-栈
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



/*
 * 遍历所用的辅助数据类型，队列
 * 队列的特点：从一端插入，从另一端输出，而且先入先输出，后入后输出
 */
class Queue{
    List<binaryTree> queue = new ArrayList<>();

//    判断是否为空
    public boolean isEmpty(){
        if(queue.size() == 0){
            return true;
        }
        return false;
    }

//    入队
    public void push(binaryTree input){
        queue.add(input);
    }

//    出队
    public binaryTree pop(){
        binaryTree out = queue.get(0);
        queue.remove(0);
        return out;
    }
}