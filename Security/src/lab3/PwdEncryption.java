/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PwdEncryption {
    
    private RSA rsa = new RSA(8);
    
    public String Encrypt(String str){
        BigInteger[] ciphertext = null;
        BigInteger n = null;
        BigInteger d = null;
        n=rsa.getN();
        d=rsa.getD();
        ciphertext = rsa.encrypt(str);
        StringBuffer bf = new StringBuffer();
        for(int i=0; i<ciphertext.length; i++){
            bf.append(ciphertext[i].toString(16).toUpperCase());
            if(i!=ciphertext.length -1)
                System.out.println("");
        }
        return bf.toString();
    }
    
    public String Decrypt(String str){
        BigInteger[] ciphertext = null;
        BigInteger n = null;
        BigInteger d = null;
        n=rsa.getN();
        d=rsa.getD();
        ciphertext = rsa.encrypt(str);
        return rsa.decrypt(ciphertext, d, n);
    }
   
}
