package minilabz;

public class GCD {
    public static long gcd(long n, long m) {
        if (m == 0) {
            return n;
        }
        else {return gcd(m,n%m);}

    }
}
