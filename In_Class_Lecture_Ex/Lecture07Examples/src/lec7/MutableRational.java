package lec7;

public interface MutableRational extends Rational {
    void setNumerator(int n);
    void setDenominator(int d);

    default void add(Rational other) {
        int n = getNumerator()*other.getDenominator() + getDenominator()* other.getNumerator();
        int d = getDenominator()*other.getDenominator();
        this.setNumerator(n);
        this.setDenominator(d);
    }

    default void multiply(Rational other) {
        int n = getNumerator()*other.getNumerator();
        int d = getDenominator()*other.getDenominator();
        this.setNumerator(n);
        this.setDenominator(d);
    }

    default void reciprocal() {
        int n = getNumerator();
        int d = getDenominator();
        setNumerator(d);
        setDenominator(n);
    }
}
