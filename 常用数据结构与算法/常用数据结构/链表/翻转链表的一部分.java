
/**
 * @author: 303014439
 * @date: 2021/5/16 20:14
 * @description:给定一个链表和两个整数m,n，翻转链表从m-n个的节点，使用一趟扫描完成
 * 解题思路：要求只进行一趟扫描，那么还是使用三个指针指向前中后三个元素，然后使用循环条件限制翻转的范围
 *
 */
public class 翻转链表的一部分 {
    public static SimpleList returnListMToN(SimpleList input ,int m ,int n){
        SimpleList pre,tnode,next,temp,fnode,fprenode;
        temp = input;
        int i;
        //        得到第m-1个节点,第m-1和m个节点的指向需要在得到最后一个节点后进行特殊处理
        for(i = 1; i<m - 1;i++){

            temp = temp.next;
//            System.out.println(temp.data);
        }
//        初始化pre与tnode
        fprenode = temp;
//        对从头结点开始翻转的情况进行特殊处理
        if(m - 1 ==0){
            fnode = temp;
        }else fnode = temp.next;
        pre = temp;
        tnode = temp.next;
        i++;
//        进行一次遍历
        while(i <= n){
//            System.out.println(tnode.data);
            next = tnode.next;
            tnode.next = pre;
            pre = tnode;
            tnode = next;
            i++;
        }
//        得到第m个节点后，将第m个节点的后继赋值给tnode
        fnode.next = tnode;
//        System.out.println(tnode.data);
//        对从头结点开始翻转的情况进行特殊处理
        if(m-1 != 0) fprenode.next = pre;
        else {
            fprenode.next = null;
//            System.out.println(pre.data);
            return pre;
        }
        return input;
//        System.out.println(pre.data);
    }


    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7,8,9};
        SimpleList input = SimpleList.getList(data);

        input = returnListMToN(input,2,9);
        while (input != null){
            System.out.println(input.data);
            input = input.next;
        }
    }
}
