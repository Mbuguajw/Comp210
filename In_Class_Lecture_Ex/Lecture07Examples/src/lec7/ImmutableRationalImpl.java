package lec7;

public class ImmutableRationalImpl implements ImmutableRational {
    private int _n;
    private int _d;

    public ImmutableRationalImpl(int n, int d) {
        if (d == 0) {
            throw new RuntimeException("Illegal denominator");
        }

        _n = n / gcd(n,d);
        _d = d / gcd(n,d);
    }

    @Override
    public int getNumerator() {
        return _n;
    }

    @Override
    public int getDenominator() {
        return _d;
    }

    private static int gcd(int a, int b) {
        return (b==0) ? a : gcd(b, a%b);
    }
}
