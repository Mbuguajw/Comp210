package lec7;

public class MutableRationalImpl implements MutableRational {
    private int _n;
    private int _d;

    public MutableRationalImpl(int n, int d) {
        if (d==0) {
            throw new RuntimeException("Illegal denominator");
        }

        _n = n/gcd(n,d);
        _d = d/gcd(n,d);
    }

    @Override
    public int getNumerator() {
        return _n;
    }

    @Override
    public int getDenominator() {
        return _d;
    }

    @Override
    public void setNumerator(int n) {
        _n = n / gcd(n,_d);
    }

    @Override
    public void setDenominator(int d) {
        if (d==0) {
            throw new RuntimeException("Illegal denominator");
        }

        _d = d/gcd(_n,d);
    }

    private static int gcd(int a, int b) {
        return (b==0) ? a : gcd(b, a%b);
    }
}
