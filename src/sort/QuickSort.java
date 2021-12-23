package sort;

/**
 *
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/13
 * @since practice 1.0.0
 */
public class QuickSort {

    public static void quickSort(int[] array){
        int len;
        if (array == null || (len = array.length) == 0 || len == 1){
            return;
        }
    }
    //核心算法：依靠分治策略进行递归
    public static void sort(int[] array, int left, int right){
        if(left > right){
            return;
        }
        //pivot中存放基准数
        int pivot = array[left];
        int i = left , j = right;


    }

}
