
import java.util.Arrays;

/**
 * @author: 303014439
 * @date: 2021/4/19 20:54
 * @description:分治法练习-归并排序
 * (两路)归并排序的主体思路为：把两个有序的序列，合并为一个有序的序列，即使用擂台算法，依次比较对应位的元素，直到一个序列全部排序完，另一个序列整个加到
 * 它后面
 * 我们可以使用三个指针把一个数组分为两部分，用于替代把一个数组截成两半的过程,传入一个输出数组，作为排序结果的存储位置
 * 要点：
 *      1.注意地规定时的边界条件，需要注意右半边的入口为mid+1，否则在分隔到1时会有OOM
 *      2.注意归并序列为分隔出来的两部分序列，即left-mid与mid+1-right，传入参数时right为下标值，所以可以取到
 *      3.注意要把有序的部分赋值给输入数组
 *
 *
 * Java的对象排序使用的就是改进的归并排序(叫TIM Sort)
 */
public class 归并排序 {
    public static void mergeSort(int[] input,int left,int right,int[] out) {
//        当传入初始序列时，我们认为序列是肯定无序的，所以我们将序列不断分隔至只有0个或一个元素时，对序列进行归并，将归并后的有序结果送入上一层进行归并
        if(left < right){
            int mid = (left+right)/2;
//        对左边进行归并
            mergeSort(input,left,mid,out);
//            System.out.println("left:"+left+"mid:"+mid+"right:" + right);
//            这里必须对mid进行+1，否则在分割到单个元素的时候，就会出现mid=0，right=1的情况，导致无限递归调用
            mergeSort(input,mid+1,right,out);
            sort(input,left,right,mid,out);
        }

    }

    public static void sort(int[] input,int left,int right,int mid,int[] out){
//        System.out.println("left:"+left+"mid:"+mid+"right:" + right+Arrays.toString(out));
        int i = 0,j = 0,num = 0;
//      当左右两边都没有填充完毕的时候，这里的边界条件要注意，由于分隔时使用的是mid+1，所以有序的序列也是mid+1-right,和left-mid，合并时需要合并这两个序列
        for(i = left,j=mid+1;i<=mid&&j<=right;num++){
//            向目标地址填充元素
            if(input[i] > input[j]){
                out[left+num]=input[j];
//                System.out.println("i:"+input[i] + "j:" + input[j] + "out" + out[left+num]);
                j++;
//                System.out.println("j:" + j + "num:"+num);
            }else{
                out[left+num]=input[i];
//                System.out.println("i:"+input[i] + "j:" + input[j] + "out" + out[left+num]);
                i++;
//                System.out.println("i:" + i + "num:"+num);
            }
        }
//        System.out.println("left:" + left + "right" + right + "num:"+num);
//      当左右两边有一边填充完，将剩下的一边完全填入
        while(i<=mid){
            out[left + num] = input[i];
            i++;num++;
        }
        while(j<=right){
            out[left + num] = input[j];
            j++;num++;
        }
//        System.out.println("left:"+left+"mid:"+mid+"right:" + right+Arrays.toString(out));
//        将结果赋值给input
        for(int n = left; n <= right;n++){
            input[n] = out[n];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,3,3,9,3};
        int[] out = new int[input.length];
        mergeSort(input,0,input.length -1,out);
        System.out.println(Arrays.toString(out));


//        对sort()方法的单元测试
//        int[] input = new int[]{3,5,6,1,2,4};
//        int[] out = new int[6];
//        sort(input,0,6,3,out);
//        System.out.println(Arrays.toString(out));
    }
}
