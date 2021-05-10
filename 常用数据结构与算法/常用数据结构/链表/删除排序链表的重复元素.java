package 常见数据结构.链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 303014439
 * @date: 2021/5/10 19:47
 * @description:给定一个排序链表，删除所有重复的元素
 * 因为排序链表所有重复的元素都是相邻的，所以可以直接删除相邻的重复元素，直到相邻链表元素不相同了，转到下一个元素
 */
public class 删除排序链表的重复元素 {
//    删除所有重复元素的函数
    public static void DeleteRepotitionNum(List<Integer> input){
//        使用两个指针，一个指针指向当前首个为改值的元素，另一指针用于向后遍历，不可以让for循环一直向后遍历
//        因为删除链表元素之后，链表的长度会变，所以要手动控制循环条件
        for(int i = 1,j=0; i < input.size();){
            if(i<input.size()-1 && input.get(j)==input.get(i)){
                input.remove(i);
            }else {
                j=i++;
            }
            System.out.println("j"+j+"i"+i);
            System.out.println(Arrays.toString(input.toArray()));
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,2,2,2,3,4,5,5,5,6,6,6,6,6,7,8,9};
        List<Integer> input = new ArrayList();
        for (int in  : data){
            input.add(Integer.valueOf(in));
        }
        DeleteRepotitionNum(input);
//        for(int i : input){
//            System.out.println(i);
//        }
}
}
