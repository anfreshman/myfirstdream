import java.util.Scanner;

/**
 * @author: 303014439
 * @date: 2021/4/6 20:44
 * @description:考虑包含N位数字的K-进制数. 定义一个数有效, 如果其K-进制表示不包含两连续的0.

考虑包含N位数字的K-进制数. 定义一个数有效, 如果其K-进制表示不包含两连续的0.

例:
1010230 是有效的7位数
1000198 无效
0001235 不是7位数, 而是4位数.

给定两个数N和K, 要求计算包含N位数字的有效K-进制数的总数.

假设2 <= K <= 10; 2 <= N; 4 <= N+K <= 18.
 */


//    原始思路：先找到k进制的N位数的上下限，求出总数量，然后排除里面有双0子串的数量
//    对于一个K进制的N位数，其每一位的最大值是K-1,所以N位共有K^N个数(0~K^(N)-1),而开头不能为0，所以K位的数字有(K^N-K^(N-1))种可能
//    限制条件还有一条为不能有两个连续的0，因此需要抛弃所有存在连续两个0的情况，一个N位的数，除首位外有N-3(N-2)^K + (N-2)^(K-1)种连续0的情况
//    这种处理方法没考虑到排列组合的重复接情况，减去了很多重复的可能性


public class K进制数 {
    static int sum = 0;
    static int N;
    static int K;
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    K = scanner.nextInt();
//    System.out.println(N);
//    System.out.println(K);
/*
    dfs暴力搜索算法:
        整体思路：
            本题可以视为一个插0的排列组合问题，从左向右进行插0，每次插0都可以分为两种情况--这个位置为0，则下一个位置为1~9,。这个位置不为0，则下一个位置为X
            每次插入0时则确定了1个或两个数的排列，直到尝试插入的长度与数的长度相同
 */
    dfs(1,1);
    System.out.println(sum);

}
//递归的深度搜索有两个参数，第一个参数为现在尝试插入的位数，当它大于等于N时，递归退出。第二个参数为现在这种情况里可以取1-K的位数的个数
    public static void dfs(int length,int num){
//        System.out.println(length);
        if(length == N){
//            此时有num位可以取1-K中情况
            sum += Math.pow(K-1,num);
//            System.out.println("N:"+sum);
            return;
        }
//        最后一次选择时，可能会出现多出来一位的情况，这时最后一个有效位为0，多出来的1-K取值位要舍弃
        if(length == N+1){
            sum += Math.pow(K-1,num-1);
//            System.out.println("N+1"+sum);
            return;
        }
//        if(length >N+1)return;
//      若没有遍历完，则选择一种情况继续遍历，每次遍历要么确定一位，要么确定两位
        for(int i = 1; i <= 2 ; i++){
//            System.out.println(i);
//            System.out.println(length);
            dfs(length + i,num +1);
        }
    }
}
