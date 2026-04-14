package bt;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            String kq;
            if(x<10){
                kq = "00" + String.valueOf(x);
            } else if(x < 100){
                kq = "0" + String.valueOf(x);
            }else {
                kq = String.valueOf(x);
            }

            System.out.println(s1 + "  "+kq);

        }
        System.out.println("================================");


        }
    }

