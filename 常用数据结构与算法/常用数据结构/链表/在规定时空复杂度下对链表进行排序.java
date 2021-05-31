package 常见数据结构.链表;

/**
 * @author: 303014439
 * @date: 2021/5/29 20:25
 * @description:要求时间复杂度、空间复杂度均为O(nlogn)
 * 思路：归并排序似乎可以满足要求
 * 归并排序的思路：
 *      对于一个已经排序好的队列，进行两两归并，得到更长的有序队列，依次执行，直到所有的元素都被归并入输出数组
 */
public class 在规定时空复杂度下对链表进行排序 {
    public void fastSort(SimpleList input){
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

    }

/*   归并排序的具体实现思路：
 *      一个sort方法，sort方法内部反复调用自身，将数组前后两部分都排序，最后调用meger()方法进行拼接
 *
 */
    public void sort(int[] input , int start,int end){
        int mid = (start + end)/2;
        if(start != end){
            sort(input,start,mid);
            sort(input,mid,end);
            meger(input,start,mid,end);
        }
    }

    public int[] meger(int[] input,int start,int mid,int end){

        return null;
    }
}
