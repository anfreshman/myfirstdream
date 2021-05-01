
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: 303014439
 * @date: 2021/5/1 18:18
 * @description:给定一个数N，输出从1-N的素数的个数
 */
public class 输出素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
//        getNumImproveLevel1(N);
        getNumByComplex(N);
    }

//最原始的方法，当要求小于N的所有素数时，会对比2~N-1的所有值，当全部无法被小于当前数的数整除时，判断其为素数，复杂度O(n^2)
    public static void getNumByComplex(int N){
        long startTime=System.currentTimeMillis();
        int num = 0;
        if(N>2){
//        System.out.println(2);
            num++;
        }

        for(int i = 0 ; i<=N ; i++){
            for(int n = 2;n < i ; n++){
                if(i%n == 0)
                {break;}
                if(n == i-1){
                    num++;
    //                System.out.println(i);
                }
            }
        }
        System.out.println("素数个数为："+num);
        long endTime=System.currentTimeMillis();
        System.out.println("运行时间为："+(endTime-startTime)+"ms");
    }

//  对素数问题的第一次改进，有数学推断可得，可以数若不是素数，则其中一个因式必然小于等于该数对2开根号，故可以减少第二个for循环的比较次数
//    同时，为了解决循环条件，并进一步加快运算速率，我们对于2,3进行特殊验证
//    从结果来看，当N>100000时，程序优化了一百倍以上
    public static void getNumImproveLevel1(int N){
        long startTime=System.currentTimeMillis();
        int num = 0;
        for(int i = 2;i <= N; i++){
            // 对2,3进行验证，他们的特殊之处在于，当n时从2开始的时候，一开始2,3的for循环就不会执行，所以在一地个循环中去掉他们
            if(i%2 == 0){
                if(i == 2) num++;
                continue;}
            if(i%3 == 0){
                if(i == 3) num++;
                continue;}
            for(int n = 2; n<=(int)Math.sqrt(Double.valueOf(i));n++){
                if(i%n == 0){
                    break;
//              到达边界条件时
                }else if(n == (int)Math.sqrt(Double.valueOf(i))){
//                    System.out.println(i);
//                    System.out.println(n);
                    num++;
                }
            }
        }
        System.out.println("素数个数为："+num);
        long endTime=System.currentTimeMillis();
        System.out.println("运行时间为："+(endTime-startTime)+"ms");
    }

//    在level1的基础上，初始值设为1，进位设置为2，即从原理上排除偶数，同时存储已得到的素数序列，只与素数进行比较
//    这里需要证明：若一个素=数不为素数，则其分解成的因式里一定至少有一个因式的一个因数是素数
//    需要设置数组，存储现在已经得到的素数
//    测试结果表明，有一定正优化，大概50%
    public static void getNumImproveLevel2(int N){
        long startTime=System.currentTimeMillis();
        int[] numArr = new int[N];
        int num = 0;
//        为了从进位机制上排除偶数，这里将素数2单独抽离出来
        if(N > 2){
            numArr[num] = 2;
            num++;
        }
//        进位为2，排除偶数
        for(int i = 3;i <= N;i += 2){
            // 对2,3进行验证，他们的特殊之处在于，当n时从2开始的时候，一开始2,3的for循环就不会执行，所以在一地个循环中去掉他们
            if(i%2 == 0){
                continue;}
            if(i%3 == 0){
                if(i == 3) {
                    numArr[num] = i;
                    num++; }
                continue;}
            for(int n = 0; n<num;n++){
                if(i%numArr[n] == 0){
//                    System.out.println("i" + i);
                    break;
//              到达边界条件时
                }else if(n ==num -1){
//                    System.out.println(i);
//                    System.out.println(n);
                    numArr[num] = i;
                    num++;
//                    System.out.println("num" + num);
                }
            }
        }
        System.out.println("素数个数为："+num);
        long endTime=System.currentTimeMillis();
        System.out.println("运行时间为："+(endTime-startTime)+"ms");
    }

//    使用筛法求解素数，筛法的基本原理为，当某一个数被判定为素数后，就筛掉所有它的倍数，下一个没有被筛掉的数就是下一个素数
//    这里true表示不为素数，false表示为素数，可以节省掉一次初始化
//    速度比level快了几百倍
    public static void getNumImproveLevel3(int N){
        long startTime=System.currentTimeMillis();
        int num = N-2;
        boolean[] numArr = new boolean[N + 1];
        if(N<2){
            num = 0;
        }else if(N == 2){
            num = 1;
        }else if(N == 3){
            num =2;
        }else if(N > 3){
            for(int n = 2; n < N ; n++){
                if(!numArr[n]){
                    for(int i = 2;i*n<N;i++){
//                      标记为不为素数
                        if(!numArr[i*n]){
                            numArr[i*n] = true;
                            num--;
                        }

//                        System.out.println("i:" + i + "n:" + n);
                    }
                }
            }
        }
        System.out.println("素数个数为："+num);
        long endTime=System.currentTimeMillis();
        System.out.println("运行时间为："+(endTime-startTime)+"ms");
    }
}