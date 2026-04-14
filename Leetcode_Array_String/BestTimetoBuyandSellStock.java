package Leetcode_Array_String;

public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // cập nhật giá mua thấp nhất
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // cập nhật lợi nhuận lớn nhất
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices){
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit += prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {2,1,4};
        int kq = maxProfit(a);
        System.out.println(kq);
    }
}
