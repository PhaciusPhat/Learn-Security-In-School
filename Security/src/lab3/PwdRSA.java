package lab3;


import java.math.BigInteger;
import java.util.Random;
import java.io.*;
import static java.lang.Math.random;
import java.util.Scanner;

public class PwdRSA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger[] ciphertext = null;
        BigInteger n = null;
        BigInteger d = null;
        String password = "";
        System.out.println("Enter text to be encrypted: ");
        password = in.nextLine();

        System.out.println("Password (Input): " + password);

        RSA rsa = new RSA(8);
        n = rsa.getN();
        d = rsa.getD();
        ciphertext = rsa.encrypt(password);
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < ciphertext.length; i++) {
            bf.append(ciphertext[i].toString(16).toUpperCase());
            if( i!= ciphertext.length-1)
                System.out.print(" ");
        }
        
        String message = bf.toString();
        System.out.println("");
        System.out.println("Encrypted Message : " + message);
        
        String dhash = rsa.decrypt ( ciphertext,d,n);
        System.out.println("");
        System.out.println("Decrypted Message :" + dhash);
    }

}
