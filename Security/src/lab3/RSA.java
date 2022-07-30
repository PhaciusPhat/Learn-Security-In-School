package lab3;


import java.math.BigInteger;
import java.util.Random;
import java.io.*;
import static java.lang.Math.random;

public class RSA {

    int primeSize; // bit length of each prime number
    BigInteger p, q; // two distinct large prime numbers p and q
    BigInteger N; // modulus N
    BigInteger r; // r= (p-1) * (q-1);
    BigInteger E, D; // public exponent E and private exponent D

    public RSA() {

    }

    public RSA(int primeSize) {
        this.primeSize = primeSize;
        generatePrimeNumbers();    // generate two distinct large prime numbers p and q.  
        generatePublicPrivateKey();// generate public and private keys
    }

    public void generatePrimeNumbers() {
        Random rand = new Random();
        p = BigInteger.probablePrime(primeSize / 2, rand);
        do {
            q = BigInteger.probablePrime(primeSize / 2, rand);
        } while (q.compareTo(p) == 0);
    }

    public void generatePublicPrivateKey() {
        N = p.multiply(q);  // N = p*q
        BigInteger pp = p.subtract(BigInteger.valueOf(1)); // pp= p -1
        BigInteger qq = q.subtract(BigInteger.valueOf(1)); // qq= q -1
        r = pp.multiply(qq);

        do {
            E = new BigInteger(2 * primeSize, new Random());
        } while ((E.compareTo(r) != -1) || (E.gcd(r).compareTo(BigInteger.valueOf(1)) != 0));

        D = E.modInverse(r); // compute D, the inverse of E mod r

    }

    public BigInteger[] encrypt(String message) {
        int i;
        byte[] temp = new byte[1];
        byte[] digits = message.getBytes();
        BigInteger[] bigdigits = new BigInteger[digits.length];
        for (i = 0; i < bigdigits.length; i++) {
            temp[0] = digits[i];
            bigdigits[i] = new BigInteger(temp);
        }
        BigInteger[] encrypted = new BigInteger[bigdigits.length];
        for (i = 0; i < bigdigits.length; i++) {
            encrypted[i] = bigdigits[i].modPow(E, N);
        }
        return (encrypted);
    }

    public BigInteger[] encrypt(String message, BigInteger userD, BigInteger userN) {
        int i;
        byte[] temp = new byte[1];

        byte[] digits = message.getBytes();

        BigInteger[] bigdigits = new BigInteger[digits.length];

        for (i = 0; i < bigdigits.length; i++) {
            temp[0] = digits[i];
            bigdigits[i] = new BigInteger(temp);
        }
        BigInteger[] encrypted = new BigInteger[bigdigits.length];
        for (i = 0; i < bigdigits.length; i++) {
            encrypted[i] = bigdigits[i].modPow(userD, userN);
        }
        return (encrypted);
    }

    public String decrypt(BigInteger[] encrypted, BigInteger D, BigInteger N) {
        int i;

        BigInteger[] decrypted = new BigInteger[encrypted.length];

        for (i = 0; i < decrypted.length; i++) {
            decrypted[i] = encrypted[i].modPow(D, N);
        }
        char[] charArray = new char[decrypted.length];

        for (i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (decrypted[i].intValue());
        }
        return (new String(charArray));
    }

    public BigInteger getp() {
        return (p);
    }

    public BigInteger getq() {
        return (q);
    }

    public BigInteger getr() {
        return (r);
    }

    public BigInteger getN() {
        return (N);
    }

    public BigInteger getE() {
        return (E);
    }

    public BigInteger getD() {
        return (D);
    }
}

