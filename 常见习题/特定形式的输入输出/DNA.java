import java.util.Scanner;

/**
 * @author: 303014439
 * @date: 2021/4/5 19:46
 * @description:输入包含多组测试数据。第一个整数N（N<=15）,N表示组数，每组数据包含两个整数a,b。a表示一个单位的DNA串的行数，a为奇数且 3<=a<=39。b表示重复度(1<=b<=20)。
  * 输出DNA的形状，每组输出间有一空行。
 */
public class DNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while(i < n){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            char[][] out = paint(a,b);
            for(int m = 0;m < (a-1)*b+1;m++){
                for(int x = 0;x < a;x++){
                    System.out.print(out[m][x]);
                }
                System.out.println();
            }
            i++;
            System.out.println();
        }
    }

    public static char[][] paint(int num,int re){
//        根据行数计算出每行的列数
        int lineNum = num;
//        根据重复次数计算出总行数
        int sumNum = (num-1)*re + 1;
        char[][] out = new char[sumNum][lineNum];
//        初始化输出队列
        for(int m = 0; m<sumNum;m++){
            for(int n = 0; n< lineNum; n++){
                out[m][n] = ' ';
            }
        }
//        两个指针，一个指向对头，一个指向队尾
        int pre = 0;
        int low = lineNum - 1;
//        设置一个哨兵，判断现在的指针移动方向
        boolean flag = true;
        for(int m = 0;m<sumNum;m++){
//            当前后指针还没有相撞时
            if(flag){
                if(pre < low){
                    out[m][pre] = 'X';
                    out[m][low] = 'X';
                    pre ++;
                    low --;
//                    输出本行

                }else{
//                    相等时，修改flag
                    out[m][pre] = 'X';
                    out[m][low] = 'X';
                    pre --;
                    low ++;
                    flag = !flag;
                }
            }else{
//                指针向外移动
                if(pre > 0){
//                    System.out.println(pre);
//                    System.out.println(low);
//                    System.out.println(m);
                    out[m][pre] = 'X';
                    out[m][low] = 'X';
                    pre --;
                    low ++;
                }else{
                    out[m][pre] = 'X';
                    out[m][low] = 'X';
                    pre ++;
                    low --;
                    flag = !flag;
                }
            }
        }
        return out;
    }
}






























































//    public static void paint(int num){
////        System.out.println("执行外部方法");
////        最上面一行两个X之间相隔的空格数
//        int t = num - 2;
////        输出上一半(不包括1)
//        for(int i = t;i >= 1;i -= 2){
////            输出X之前的空格
//            int de = (t - i)/2;
//            while(de > 0){
//                System.out.print(" ");
//                de--;
//            }
//            System.out.print("X");
//            int m = i;
////            输出X中间的空格
//            while(m > 0){
//                System.out.print(" ");
//                m--;
//            }
//            System.out.println("X");
//        }
////        输出单个X
//        int x = num/2;
//        while(x > 0){
//            System.out.print(" ");
//            x--;
//        }
//        System.out.println("X");
////        输出下一半
//        for(int i = 1; i <= t;i += 2){
//            int de = (t - i)/2;
//            while(de > 0){
//                System.out.print(" ");
//                de--;
//            }
//            System.out.print("X");
//            int m = i;
//            while(m > 0){
//                System.out.print(" ");
//                m--;
//            }
//            System.out.println("X");
//        }
//    }
