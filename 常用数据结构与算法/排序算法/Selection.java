

/**
 * @author: 303014439
 * @date: 2021/4/14 20:56
 * @description:选择排序，最简单的排序，O(n^2)，不稳定
 * 依次寻找最小的数据，然后放到当前序列的最前面
 * 优化思路：可以同时寻找最大值放在数组末尾，这样可以减少一半的比较时间
 */
public class Selection {
    public static int[] select(int[] input){
        int [] out = new int[input.length];
//        类似于打擂算法
        for(int i = 0; i< input.length;i++){
            int min = input[i];
            for(int j = i;j < input.length;j++){
                if(input[j] < min){
                    int temp = min;
                    min = input[j];
                    input[j] = temp;
                }
            }
            out[i] = min;
        }
        return out;
    }


    public static void main(String[] args) {
        int[] out = select(new int[]{3,5,9,8,5,2,1,6,5});
        for(int i : out){
            System.out.println(i);
        }

//        对算法的正确性进行验证(测试)
//          1.肉眼观察
//          2.产生足够多随机样本，用正确算法算一遍，并产生结果，与编写的算法对比，实现算法检测(类似随机测试)

    }

}