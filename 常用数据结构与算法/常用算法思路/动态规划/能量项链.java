package 常用算法.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: 303014439
 * @date: 2021/6/3 9:08
 * @description:
 *      对于N颗能量珠，每颗能量珠存在首、尾标记(s,e)，当一颗珠子的尾标记等于另一颗珠子的首标记时，两颗珠子会被吸收，释放能量为s1*e1*e2
 *      现给定两行输入，第一行为珠子个数，第二行为一列数字，第i个数组代表第i个珠子的头标记，输出能组合的最大能量
 *
 *      思路1：官方已经给定排序，我们只需要选出最大的能量释放值即可，最直接的方法是遍历每种情况计算(暴力解法，部分情况可能不对)
 *      思路2：根据观察得到，能量项链的要点是得到最大的数字们相乘，所以只要每次都将最小的数进行聚合，就可以得到最大的结果(逻辑解法，AC)
 *      思路3：区间DP，每次使用二分法取左右两段的最大值，再进行合并
 */
public class 能量项链 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        
    }
}




























//    较为正确的逻辑解法
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = Integer.valueOf(in.nextLine());
//        String text[] = in.nextLine().split(" ");
//        Integer[] input = new Integer[N];
//        for(int i = 0; i < N ; i++){
//            input[i] = Integer.valueOf(text[i]);
//        }
////        从数组得到ArrayList
//        List<Integer> data;
//        data = new ArrayList<>(Arrays.asList(input));
////        sList data = sList.getsList(input);
//        int m = N;
////        寻找最小的元素进行聚合
//        int E = 0;
//        while(m != 1){
////            sList temp = data;
////            设置默认最小位为0
//            int minadd = 0;
////            得到当前最小值
//            for(int i = 0; i < m ; i++){
//                if(data.get(minadd) > data.get(i))
//                    minadd = i;
//            }
////            聚合minadd，移动数组
////            若minadd非头非尾
//            if(minadd != 0 && minadd != data.size()-1){
//                E += data.get(minadd -1) * data.get(minadd) * data.get(minadd+ 1);
//            }
////            若minadd为头
//            else if(minadd == 0){
//                E += data.get(data.size()-1) * data.get(minadd) * data.get(minadd +1);
//            }
////            若minadd为尾
//            else if(minadd == data.size()-1){
//                E += data.get(minadd - 1) * data.get(minadd) * data.get(0);
//            }
//            data.remove(minadd);
//            m--;
//        }
//        System.out.println(E);
//    }


//
//class sList{
//    int data;
//    sList next;
////    得到符合题目要求的循环链表
//    static sList getsList(int[] input){
//        sList head = new sList();
//        sList re = head;
//        for(int i = 0; i < input.length ; i++){
//            head.data = input[i];
//            if(i+1 < input.length){
//                head.next = new sList();
//                head = head.next;
//            }
//
//        }
//        head.next = re;
//        return re;
//    }
//}











//    非常错误的暴力解法
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = Integer.valueOf(in.nextLine());
//        String[] input = in.nextLine().split(" ");
//        int[] text = new int[N];
//        for (int i = 0;i<N;i++){
//            text[i] = Integer.valueOf(input[i]);
//        }
//        sList list = sList.getsList(text);
//        int[] E = new int[N];
//        for(int i = 0 ; i < N ; i++){
//            sList temp = list;
//            sList nextTemp = temp.next;
//            for(int i2 = 0; i2 < N-1;i2 ++){
//                E[i] += temp.data * nextTemp.data * nextTemp.next.data;
////                System.out.println(E[i]);
//                nextTemp = nextTemp.next;
//            }
//            list = list.next;
//        }
////        比较每一个E[i]值
//        int max = E[0];
//        for(int data : E){
////            System.out.println(data);
//            if(max<data)
//                max = data;
//        }
//        System.out.println(max);
//    }
