package 常见数据结构.链表;

/**
 * @author: 303014439
 * @date: 2021/5/17 10:25
 * @description:给定两个升序链表，返回一个合并后的升序链表
 * 思路：两个新建一个链表，两个链表逐次比较插入新的链表，当一个链表所有的元素都插入完的时候，将另一个链表的元素全部插入后续
 */
public class 合并链表 {
    public static SimpleList mergeList(SimpleList input1,SimpleList input2){
//        对于首元素特殊处理
        SimpleList out = new SimpleList();
        SimpleList rOut = out;
        SimpleList i1 = input1,i2 = input2;
        for(;i1 != null && i2 != null;){
//          对于升序排序，这里需要拿出小的那一个元素进行赋值
            if(i1.data < i2.data ){
                out.data = i1.data;
                i1 = i1.next;
            }else{
                out.data = i2.data;
                i2 = i2.next;
            }
            out.next = new SimpleList();
            out = out.next;
        }
        while(i1 != null){
            out.data = i1.data;
            if(i1.next != null)
                out.next = new SimpleList();
            out = out.next;
            i1 = i1.next;
        }
        while(i2 != null){
            out.data = i2.data;
            if(i2.next != null)
                out.next = new SimpleList();
            out = out.next;
            i2 = i2.next;
        }
        return rOut;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1,3,5,7,9};
        int[] data2 = new int[]{2,4,6,8,10};
        SimpleList input1 = SimpleList.getList(data1);
        SimpleList input2 = SimpleList.getList(data2);
        SimpleList re = mergeList(input1,input2);
        while(re != null){
            System.out.println(re.data);
            re = re.next;
        }
    }

}
