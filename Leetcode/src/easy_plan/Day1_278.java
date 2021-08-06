package easy_plan;

//找出第一个出错的版本
public class Day1_278 {
    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n){
        int l = 1;
        int r = n;
        int mid = 0;
        //
        while(l < r){
            mid = l + (r - l) / 2;
            //如果mid版本是badversion，则第一个错误版本区间为【l,mid】
            //如果不是badversion，则第一个错误版本区间为（mid,r】
            if(isBadVersion(mid) == false){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
    //随便写的一个函数，用来判断某个版本是不是错误版本
    public static boolean isBadVersion(int bad){
        return true;
    }
}
