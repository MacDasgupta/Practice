package Edureka;

import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        int length =10;
        System.out.println(Password(length));
    }

    static char[] Password(int len){
        System.out.println("Generating password : ");
        System.out.println("The Password is : ");
        String caps ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase ="abcdefghijklmnopqrstuvwxyz";
        String numbers="0123456789";
        String spcl="!@#$%^&*()";
        String val = caps+lowerCase+numbers+spcl;
        Random rnd = new Random();
        char[] password = new char[len];
        for(int i=0;i<len;i++){
            password[i]=val.charAt(rnd.nextInt(val.length()));
        }
        return password;
    }

}
