package Leetcode_Array_String;

public class H_Index {
    public static int hIndex(int[] citations) {
        int h=0;
        for(int i=0;i<citations.length;i++){
            for(int j=i+1;j<citations.length;j++){
                if(citations[i]<citations[j]){
                    int temp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = temp;
                }
            }
        }

        for(int i = 0;i<citations.length;i++){
            if(citations[i]>=i+1){
                h = i+1;
            }
        }
        return h;

    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        int kq = hIndex(citations);
        System.out.println(kq);
    }
}
