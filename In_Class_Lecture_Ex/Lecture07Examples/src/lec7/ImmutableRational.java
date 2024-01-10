package lec7;

public interface ImmutableRational extends Rational {
    default ImmutableRational add(Rational other) {
        int n = getNumerator()*other.getDenominator() + getDenominator()* other.getNumerator();
        int d = getDenominator()*other.getDenominator();
        return new ImmutableRationalImpl(n,d);
    }

    default ImmutableRational multiply(Rational other) {
        int n = getNumerator()*other.getNumerator();
        int d = getDenominator()*other.getDenominator();
        return new ImmutableRationalImpl(n,d);
    }

    default ImmutableRational reciprocal() {
        return new ImmutableRationalImpl(getDenominator(),getNumerator());
    }
}
