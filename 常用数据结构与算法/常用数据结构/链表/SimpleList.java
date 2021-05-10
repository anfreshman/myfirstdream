package 常见数据结构.链表;

/**
 * @author: 303014439
 * @date: 2021/5/10 19:48
 * @description:构造一个简单的链表类
 */
public class SimpleList {
//    头元素指针
    public  SimpleList head;
//    链表长度
    private int size;
//    列表元素
    public int data;
//    尾指针
    public SimpleList next;
//    获得链表长度
    public int getSize(){
        return this.size;
    }
//    使用数组构造一个链表
    public static SimpleList getList(int[] input){
        SimpleList head = null;
        SimpleList tnode = head;
        for(int i :input){
            if(head == null){
                head=new SimpleList();
                head.data = i;
                tnode = head;
            }else{
                tnode.next = new SimpleList();
                tnode.next.data = i;
                tnode = tnode.next;
            }
        }
        head.size = input.length;
        head.head = head;
        return head;
    }
}
