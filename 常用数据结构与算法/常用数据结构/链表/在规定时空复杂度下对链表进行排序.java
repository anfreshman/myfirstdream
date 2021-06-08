package 常见数据结构.链表;

import java.util.Arrays;

/**
 * @author: 303014439
 * @date: 2021/5/29 20:25
 * @description:要求时间复杂度、空间复杂度均为O(nlogn)
 *      自顶向下的归并排序(递归)：可以基本满足要求，其时间复杂度为O(nlogn),空间复杂度为O(logn)
 *      当为我们要求空间复杂度为O(1)时，我们需要将实现方式改为自底向上，即非递归
 *      自底向上的实现方式：将链表视为每一个单节有序的链表，而后两两合并，循环到将整条链表均合并
 *
 *
 * 思路：归并排序似乎可以满足要求
 * 归并排序的思路：
 *      对于一个已经排序好的队列，进行两两归并，得到更长的有序队列，依次执行，直到所有的元素都被归并入输出数组
 */
public class 在规定时空复杂度下对链表进行排序 {
    public static int[] fastSort(SimpleList input){
        int num = 0;
//        得到链表的长度
        for (SimpleList i1 = input;i1!=null;i1=i1.next){
            num++;
        }
//        将链表排序转换为数组排序，得到每个元素
        int[] temp = new int[num];
        int i = 0;
        for(SimpleList i1 = input;i1!=null;i1=i1.next){
            temp[i] = i1.data;
            i++;
        }
//        对每个元素进行归并排序
        sort(temp,0,temp.length-1);
        return temp;
    }

/*   归并排序的具体实现思路：
 *      一个sort方法，sort方法内部反复调用自身，将数组前后两部分都排序，最后调用meger()方法进行拼接
 *
 */
    public static void sort(int[] input,int start,int end){
        int mid = (start + end)/2;
        System.out.println("start" + start + "mid" + mid + "end" + end);
        if(start < end){
            sort(input,start,mid);
//
            sort(input,mid+1,end);
            meger(input,start,mid,end);
        }
        return;
    }

    public static void meger(int[] input,int start,int mid,int end){
//        对两个有序数组进行归并
//        先将两个有序数组的值分别取出
        int[] temp1 = new int[mid - start+1];
        int[] temp2 = new int[end - mid];
        for(int i = 0;;i++){
            boolean flag = false;
            if(i+start <= mid){
                flag = true;
                temp1[i] = input[i+start];
            }
            if(i+mid+1 <= end){
                flag = true;
                System.out.println(i+mid);
                temp2[i] = input[i + mid +1];
            }
            if (!flag) break;
        }
//        对比归并赋值
        int i1,i2;
        for(i1=0,i2 = 0;i1<temp1.length&i2<temp2.length;){
            if(temp1[i1]<temp2[i2]){
                input[start + i1 +i2] = temp1[i1];
                i1++;
            }else{
                input[start + i1 + i2] = temp2[i2];
                i2++;
            }
        }
        while(i1 < temp1.length){
            input[start + i1 + i2] = temp1[i1];
            i1++;
        }
        while(i2 < temp1.length) {
            input[start + i1 + i2] = temp2[i2];
            i2++;
        }
    }

    public static void sortWithoutRecursive(SimpleList input){
//        使用非递归的算法两两合并，由于使用栈展开其实是递归的底层思想，使用到的空间复杂度与递归相仿，所以也不可以用栈
//        得到链表的中间节点可以使用快慢指针技巧，当一个指针指向末尾时，另一个指针指向链表的中间
        int len;
        int subLength;
        SimpleList temp = input;
//        得到链表的长度
        for(len = 1;temp.next != null;len++){
            temp = temp.next;
        }
//        System.out.println(len);

//       最外层大循环，每次归并两组
        for(subLength = 1;subLength < len;subLength *= 2){
//            重置temp
            temp = input;
            for(int i = 0;i<len;i+=2*subLength-1){
                int interval;
                for(interval = 0;temp!= null & interval < i;interval++){
                    temp = temp.next;
                }
//                System.out.println(temp.data);
                SimpleList head1 = temp;
                for(interval = 0;temp!= null & interval < subLength;interval++){
                    temp = temp.next;
                }
                SimpleList head2 = temp;
//                System.out.println("head1: "+ head1.data);
                megerWithoutRecursive(head1,head2,subLength);
            }

        }
    }

    public static void megerWithoutRecursive(SimpleList head1,SimpleList head2,int subLength){
//        System.out.println("head1" + head1.data);
        SimpleList temp = head1;
        int[] out = new int[2*subLength];
        int i = 0,i1 =0,i2 = 0;
        for(i1 =0,i2 = 0;head1!=null&head2!=null&i1 < subLength&i2 <subLength;i++){
            if(head1.data < head2.data){
                out[i] = head1.data;
                head1 = head1.next;
                i1++;
            }else {
                out[i] = head2.data;
                head2 = head2.next;
                i2++;
            }
        }
        while(head1 != null&i1++<subLength){
            out[i++] = head1.data;
            head1 = head1.next;
        }
        while(head2 != null&i2++ <subLength){
            out[i++] = head2.data;
            head2 = head2.next;
        }
        i = 0;
        System.out.println(Arrays.toString(out));
        while(temp != null&i <= subLength*2-1){
            temp.data = out[i++];
            temp = temp.next;
        }
    }





    public static void main(String[] args) {
        SimpleList input = SimpleList.getList(new int[]{4,2,1,3});
        sortWithoutRecursive(input);
        while(input != null){
            System.out.println(input.data);
            input = input.next;
        }
    }



}
