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
    public static SimpleList divideList(SimpleList input,int m) {
        if (input == null){
            return null;
        }
//      创建三个链表，将小于m的所有元素移动到一个新的链表，等于m的元素移动到一个链表，大于m的元素停留在原链表，最后链接三个链表
        SimpleList pre = new SimpleList();
        SimpleList rhead = pre;
        SimpleList ltemp = new SimpleList();
        SimpleList lhead = ltemp;
//        SimpleList mtemp = new SimpleList();
//        SimpleList mhead = new SimpleList();
        pre.next = input;
//        由于有链表的元素删除操作，所以为了防止空指针异常，这里进行短路与的判断
        for(;pre!=null&&pre.next != null;){
            if(pre.next.data < m){
//                这里直接将元素赋值给新的链表的next，因为下一个next或最后的rhead会覆盖原有的next，所以这里不用做特殊处理
                ltemp.next = pre.next;
                pre.next = pre.next.next;
                ltemp = ltemp.next;
            }else pre = pre.next;
        }
//        连接链表，第一个的末尾的next指向第二个的开头
        ltemp.next = rhead.next;
        return lhead.next;
    }
    public static void main(String[] args) {
        int[] data = new int[]{5,4,3,2,1};
        SimpleList input = SimpleList.getList(data);
        SimpleList simpleList = divideList(input, 5);
        while(simpleList != null){
            System.out.println(simpleList.data);
            simpleList = simpleList.next;
        }
    }
}
