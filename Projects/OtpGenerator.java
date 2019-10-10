package Edureka;

import java.util.Random;

public class OtpGenerator {
    public static void main(String[] args) {
        //int length = Integer.parseInt(args[0]);
        int length = 5;
        System.out.println(OTP(length));
    }

    static char[] OTP(int len){
        System.out.println("Generating OTP : ");
        System.out.println("The OTP is : ");
        String numbers = "0123456789";
        Random ranMthd = new Random();
        char [] otp = new char[len];
        for (int i=0;i<len;i++){
            otp[i]=numbers.charAt(ranMthd.nextInt(numbers.length()));
        }
        return otp;
    }
}
