import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Win TWin = new Win();
        TWin.getWin("自动关机");
        Thread.sleep(10000);
        String second = TWin.getNumber();
        int sec = Integer.parseInt(second);
        //        Runtime是获取当前进程的JVM外环境，即操作系统。其中的exec方法是执行系统命令
        String exec = "shutdown -s -t " + sec;
        Runtime.getRuntime().exec(exec);//自动关机
        System.out.println(sec + "秒后自动关机");
        Thread MyThread2 = new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Runtime.getRuntime().exec("shutdown -a");//取消自动关机
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        MyThread2.start();
    }
}
