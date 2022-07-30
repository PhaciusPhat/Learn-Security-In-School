/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nangcao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;

/**
 *
 * @author admin
 */
public class Dec_RSA {

    public Dec_RSA(){
        
    }
    
    //public static void main(String[] args) throws Exception {
    public String Decrypt() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Enc_RSA.txt")));
        String ctext = in.readLine();
        BigInteger c = new BigInteger(ctext);
        FileInputStream f = new FileInputStream("C:\\Skey_RSA_priv.txt");
        ObjectInputStream b = new ObjectInputStream(f);
        RSAPrivateKey prk = (RSAPrivateKey) b.readObject();
        BigInteger d = prk.getPrivateExponent();
        BigInteger n = prk.getModulus();
        System.out.println("d = " + d);
        System.out.println("n = " + n);
        BigInteger m = c.modPow(d, n);
        System.out.println("m = " + m);
        byte[] mt = m.toByteArray();
        System.out.print("Plaintext is:  ");
        String plaintext ="";
        for (int i = 0; i < mt.length; i++) {
            plaintext+=(char) mt[i];
            System.out.print((char) mt[i]);
        }
        System.out.println("");
        return plaintext;
    }
}
