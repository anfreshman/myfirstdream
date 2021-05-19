package 常见数据结构.链表;

/**
 * @author: 303014439
 * @date: 2021/5/17 10:52
 * @description:给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 思路：新建一个链表，将小于m的节点移动到新的链表，然后连接两个链表
 * 这里解题的纠结重新引发了我对于指针概念的思考
 * 对于一个链表指针，我在初始时将其保留了一个副本，指向开头的地址
 * 但是在链表移动的过程中，链表头发生了变化，使得链表实际开头地址和保留的副本中的开头地址不再相同，这时候也许需要特殊处理保证副本的正确性
 */
public class 分隔链表 {
    public static SimpleList divideList(SimpleList input,int m){
//        设置一个头结点，指向大于x的部分的链表的头部，这里指向的input目前所指地点的引用，而不是input本身
        SimpleList head = input;
        SimpleList temp = new SimpleList();
        SimpleList pre = null;
        SimpleList rhead = temp;
//        对输入链表中的所有节点进行循环
//        可能出现的结果如下：
//            1.遇到一个节点，大于m，保留
//            2.遇到一个节点，小于m，且不为头结点，删除，即令其前驱指针的后继指向该节点的后继。同时将其添加到新的链表中
//            3.遇到一个节点，小于m，且为头结点，删除，即令头指针指向其头指针的后继
        for(;input != null;input = input.next){
            if(input.data < m ){
//                在新链表中添加该节点
                temp.data = input.data;
//                在原链表中删除该节点
//                判断是不是头结点被删除，若是，则将头结点后移
                if(head == input){
                    head = head.next;
                    pre = null;
                }else
                    pre.next = input.next;
//                提前判断退出条件
                if(input.next != null){
                    temp.next = new SimpleList();
                    temp = temp.next;
                }
            }
            pre = input;
        }
//        合并两链表
        rhead.next = head;
        return rhead;
    }


    public static void main(String[] args) {
        int[] data = new int[]{5,4,3,2,1};
        SimpleList input = SimpleList.getList(data);
        SimpleList simpleList = divideList(input, 3);
        while(simpleList != null){
            System.out.println(simpleList.data);
            simpleList = simpleList.next;
        }
    }
}
