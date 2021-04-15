
import jdk.internal.org.objectweb.asm.commons.Method;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author: 303014439
 * @date: 2021/4/15 21:29
 * @description:
 */
public class 对数检测器 {
    public static boolean detection(String sortClass,String sortFunction) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        循环产生100个随机数组，看排序结果是否相同
        int i = 0;
        while(i++ < 100){
//            生成一个随机数组
            int len = (int) (Math.random() * 1000);
            int[] right = new int[len];
            int[] ans = new int[len];
            for(int j = 0; j<len;j++){
                right[j] = (int) (Math.random()*100);
                ans[j] = right[j];
            }

//            使用正确的排序得到一个结果
            Arrays.sort(right);
//            通过反射得到我们的排序类
            Class sortclass = Class.forName(sortClass);
            java.lang.reflect.Method[] methods = sortclass.getMethods();
//            打印所有可以获得的方法
//            for(java.lang.reflect.Method me : methods){
//                System.out.println(me.toString());
//            }
//            通过反射得到我们的排序方法
            java.lang.reflect.Method mySort = sortclass.getMethod(sortFunction,int[].class);
            ans = (int[]) mySort.invoke(null,ans);

//            对比得到的结果，如果有不同，则返回false
            for(int m = 0;m < len;m++){
                if(right[m] != ans[m])return  false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        boolean flag = detection("常用算法.排序.Selection","select");
        System.out.println(flag);
    }
}
