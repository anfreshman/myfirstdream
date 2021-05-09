package 多线程;

/**
 * @author: 303014439
 * @date: 2021/5/8 22:24
 * @description:
 */
public class 死锁模拟 {
    public static void main(String[] args) {
        Obj a = new Obj();
        Obj b = new Obj();
        Thread thread1 = new Thread(new DeadThread(a,b,1));
//        反向获取资源
        Thread thread2 = new Thread(new DeadThread(b,a,2));
        thread1.start();
        thread2.start();
    }


}

class DeadThread implements Runnable{
//    两个资源先后获取
    Obj a,b;
    int input;

    public DeadThread(Obj a,Obj b,int input){
        this.a = a;
        this.b = b;
        this.input = input;
    }
    @Override
    public void run() {
        try {
//            锁住a对象
            synchronized (a){
                Thread.sleep(100);
                synchronized (b){
                    System.out.println(input);
                }
            }
        }catch (Exception e){

        }
    }
}

class Obj{}
