package 蓝桥杯.递归;

import java.util.*;

/**
 * @author: 303014439
 * @date: 2021/6/4 9:03
 * @description:如下面第一个图的九宫格中，放着  1~8  的数字卡片，还有一个格子空着。与空格子相邻的格子中的卡片可以移动到空格中。经过若干次移动，可以形成第二个图所示的局面。
    我们把第一个图的局面记为：12345678.
    把第二个图的局面记为：123.46758
    显然是按从上到下，从左到右的顺序记录数字，空格记为句点。
    本题目的任务是已知九宫的初态和终态，求最少经过多少步的移动可以到达。如果无论多少步都无法到达，则输出-1。


 BFS，分别记录一步，两步...n步可以到达的所有状态，排除剩余状态，若某种状态不发产生新的状态了，则跳出
 这样有一个问题，就是非常消耗时间，因为九宫格的可能情况很多，时间复杂度极高，需要双向BFS优化，这里是未优化版本
 */
public class 九宫重排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] start = in.nextLine().trim().toCharArray();
        char[] end = in.nextLine().trim().toCharArray();
        int out = -1;
//      遍历队列
        Queue queue = new Queue();
//      去重依据
        Map<char[],Integer> map = new HashMap<>();
        queue.push(start);
//        增加首元素
        map.put(start,0);
        while(!queue.isEmpty()){
//            弹栈，得到当前状态
            char[] stute = queue.pop();
//            记录空白格地点
            int add = 0;
            for(int i = 0; i<stute.length;i++){
                if(stute[i] == '.')
                {add = i;
                break;}
            }
//            System.out.println(map.size());
//            System.out.println(queue.data.size());
//            System.out.println(Arrays.toString(stute));
//            判断当前是否为最终结果
            if(Arrays.equals(stute,end)){
                out = map.get(stute);
//                System.out.println("已得到");
                break;
            }
//            System.out.println("比对失败");
            char[] temp;
//            确定可移动方位，增加到集合中
            if(add-1 >= 0){
                temp = Arrays.copyOf(stute,stute.length);
                swap(temp,add,add-1);
                if(!map.containsKey(temp)){
                    map.put(temp,map.get(stute)+1);
                    queue.push(temp);
                }
            }
            if(add+1 < 9){
                temp = Arrays.copyOf(stute,stute.length);
                swap(temp,add,add+1);
                if(!map.containsKey(temp)){
                    map.put(temp,map.get(stute)+1);
                    queue.push(temp);
                }
            }
            if(add-3 >= 0){
                temp = Arrays.copyOf(stute,stute.length);
                swap(temp,add,add-3);
                if(!map.containsKey(temp)){
                    map.put(temp,map.get(stute)+1);
                    queue.push(temp);
                }
            }
            if(add+3 < 9){
                temp = Arrays.copyOf(stute,stute.length);
                swap(temp,add,add+3);
                if(!map.containsKey(temp)){
                    map.put(temp,map.get(stute)+1);
                    queue.push(temp);
                }
            }
        }
//
        System.out.println(out);
    }

    public static char[] swap(char[] arr,int s,int e){
        char temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        return arr;
    }

}
class Queue{
    List<char[]> data = new ArrayList<>();
    public void push(char[] in){
        data.add(in);
    }
    public char[] pop(){
        char[] out = data.get(0);
        data.remove(0);
        return out;
    }
    public boolean isEmpty(){
        if(data.isEmpty()) return true;
        return false;
    }
}