/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nangcao;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;

public class Enc_RSA {

    public Enc_RSA(){
        
    }
    
   // public static void main(String[] args) throws Exception {
    public String Encrypt(String s) throws Exception{
        //String s = "Hello World";
        FileInputStream f = new FileInputStream("C:\\Skey_RSA_pub.txt");
        ObjectInputStream b = new ObjectInputStream(f);
        
        RSAPublicKey pbk = (RSAPublicKey)b.readObject();
        BigInteger e = pbk.getPublicExponent();
        BigInteger n = pbk.getModulus();
        System.out.println("e= "+e);
        System.out.println("n= "+n);
        byte ptext[] = s.getBytes("UTF8");
        BigInteger m = new BigInteger(ptext);
        BigInteger c = m.modPow(e,n);
        System.out.println("c= "+c);
        String cs = c.toString();
        String file = "C:\\Enc_RSA.txt";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        out.write(cs,0,cs.length());
        out.close();        
        System.out.println("");
        return cs;
    }
}
