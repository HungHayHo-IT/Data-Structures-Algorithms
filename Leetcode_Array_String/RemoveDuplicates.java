package Leetcode_Array_String;

public class RemoveDuplicates {
    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public static int removeDuplicates2(int[] nums) {
        int i = 0; // vị trí ghi

        for (int num : nums) {
            // luôn giữ 2 phần tử đầu
            // hoặc nếu num khác nums[i-2] thì giữ
            if (i < 2 || num != nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return  i +1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,};
        int kq = removeDuplicates2(nums);
        System.out.println(kq);
        //        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println(); // Xuống dòng
    }
}
