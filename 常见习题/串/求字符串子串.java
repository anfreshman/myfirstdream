
/**
 * @author: 303014439
 * @date: 2021/4/7 20:39
 * @description:
 *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从 0 开始)。如果不存在，则返回 -1。
 */
public class 求字符串子串 {
//    简单字符串匹配，设置两个辅助指针i,j
    public static int subSort(String mainString,String subStirng){
//        获得两个字符串的字符数组
        char[] mains = mainString.toCharArray();
        char[] subs = subStirng.toCharArray();
//      主字符串指针i，辅助字符串指针j
        int i = 0;
        int j = 0;
//      记录当前已匹配的字符串长度
        int len = 0;
//        逐个对比，当子字符串或主字符串匹配完的时候退出
        for(;i<mains.length&&j<subs.length;i++,j++){
            len ++;
            if(mains[i] != subs[j]){
                i = i - j + 1;
                j = 0;
                len = 0;
            }
        }
        if(len == subs.length - 1){
            return i - len;
        }
        return -1;
    }


    public static void main(String[] args) {
        int index = subSort("asdfghjkl","ghjl");
        System.out.println(index);
    }
}




















//        for(;i < mains.length;i++){
//            for(;j < subs.length;j++){
//
////                System.out.println("j:" + j);
//                len++;
////              如果该字符串发生失配，则进行回退,i回退到开始时的下一个字符，j回退到1
//                if(mains[i] != subs[j]){
//                    i = i - j + 1;
//                    j = 0;
//                    len = 0;
//                }
//            }
//            if(len == subs.length){
//                return i - len;
//            }
//        }
//        return -1;