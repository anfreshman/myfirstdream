
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 303014439
 * @date: 2021/4/9 21:34
 * @description:给你一个整数数组 nums ，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 *  解集不能包含重复的子集。你可以按任意顺序返回解集。
 */
public class Find {
    static List<List<Integer>>  out = new ArrayList<>();
    public  List<List<Integer>> Solution(int[] num){
        num = new int[]{1,2,3};
//        返回值
//       对于任意一个数，可以与其后面的数进行排列组合
        List<Integer> path = new ArrayList<>();
        int offset = 0;
        update(num,offset,path);
        return out;
    }

//   传入参数：out为需要更新的排列序列，num为输入数组，offset为偏移量,List<Integer> path为选择路径，即选择中的某一步(不是最终结果)
    public void update(int[] num,int offset,List<Integer> path){
//    对path对象进行克隆，否则会导致out里的所有的对象都是同一个对象
        List temp = new ArrayList();
        for(Integer i : path){
            temp.add(i);
        }
        path = temp;
        out.add(path);





        for(int i =offset; i < num.length;i++){
//            if(offset == 0){
//                path  = new ArrayList<Integer>();
//            }
//            进行选择
            path.add(Integer.valueOf(num[i]));
//            递归调用，进行下一步选择,这里的offset应该是i+1,以第一层递归为例，在一次循环中，offset对于不同的起始位应该是依次后移的
            update(num,i + 1,path);
//            撤销选择
            path.remove(Integer.valueOf(num[i]));
        }


    }


    public static void main(String[] args) {
        new 寻找数字的所有子集().Solution(new int[1]);
        for(List<Integer> list : out){
            for(int i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}


