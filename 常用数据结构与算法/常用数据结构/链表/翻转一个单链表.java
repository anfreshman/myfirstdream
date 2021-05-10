package 常见数据结构.链表;

import java.util.List;

/**
 * @author: 303014439
 * @date: 2021/5/10 20:37
 * @description:给定一个单链表，对其进行翻转
 * 使用两个指针，一个保存原有的前继元素，一个保存原有的后继元素
 */
public class 翻转一个单链表 {
    public static SimpleList OverTurnList(SimpleList input){
        SimpleList pre = null;
        SimpleList next = input.next;
        while(input != null){
            input.next = pre;
            pre = input;
            input = next;
            if(input == null) break;
            next = input.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,3,5,7,9,9,9,8,7,4};
        SimpleList input = SimpleList.getList(data);
        input = OverTurnList(input);
        while(input != null){
            System.out.println(input.data);
            input=input.next;
        }
    }

}
