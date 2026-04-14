package basicsort;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicSort {
    public static void bubbleSort(int[] array){
        for(int i = array.length - 1 ; i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {  // Chỉ cần đến length-1
            int minIndex = i;  // Giả sử phần tử đầu tiên là nhỏ nhất

            // Tìm phần tử nhỏ nhất trong đoạn [i+1, length-1]
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {  // So sánh đúng
                    minIndex = j;  // Cập nhật vị trí phần tử nhỏ nhất
                }
            }

            // Hoán đổi nếu tìm thấy phần tử nhỏ hơn
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    //merge sort

    public static int[] merge(int[] array1, int[] array2){
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j= 0;
        while (i<array1.length && j<array2.length){
            if(array1[i]<array2[j]){
                combined[index] = array1[i];
                i++;
                index++;
            }else {
                combined[index] = array2[j];
                j++;
                index++;
            }
        }

        // Vét các phần tử còn lại của array1
        while (i<array1.length){
            combined[index] = array1[i];
            i++;
        }
        // Vét các phần tử còn lại của array2
        while (j<array2.length){
            combined[index] = array2[j];
            j++;
        }
        return combined;
    }

    public static int[] mergeSort(int[] array) {
        // Điều kiện dừng: Nếu mảng chỉ còn 1 phần tử (hoặc rỗng) thì không cần sắp xếp
        if (array.length <= 1) return array;

        // Tìm vị trí giữa để chia đôi mảng
        int midIndex = array.length / 2;

        // Chia mảng thành 2 nửa: Trái và Phải
        int[] left = Arrays.copyOfRange(array, 0, midIndex);
        int[] right = Arrays.copyOfRange(array, midIndex, array.length);

        // Đệ quy tiếp tục chia nhỏ và sau đó gộp lại
        return merge(mergeSort(left), mergeSort(right));
    }

    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};
        int[] sort = mergeSort(myArray);
        System.out.println(Arrays.toString(sort));
    }
}
