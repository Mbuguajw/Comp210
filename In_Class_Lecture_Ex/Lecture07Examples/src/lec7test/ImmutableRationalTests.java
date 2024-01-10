package lec7test;

import lec7.ImmutableRational;
import lec7.ImmutableRationalImpl;
import lec7.Rational;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutableRationalTests {

    // Test for axiom
    // numer(create(A,B)) = A / gcd(A,B)
    @Test
    public void testNumer() {
        Rational r = new ImmutableRationalImpl(4, 8);
        assertEquals(4/gcd(4,8), r.getNumerator());

        assertEquals(5/gcd(5,7), new ImmutableRationalImpl(5, 7).getNumerator());
    }

    // Test for axiom
    // denom(create(A,B)) = B / gcd(A,B)
    @Test
    public void testDenom() {
        Rational r = new ImmutableRationalImpl(4, 8);
        assertEquals(8/gcd(4,8), r.getDenominator());

        assertEquals(7/gcd(5,7), new ImmutableRationalImpl(5, 7).getDenominator());
    }

    // Test for axiom
    // add(create(A,B), C) = create(A*denom(C) + B*numer(C), B*denom(C))
    @Test
    public void testAdd() {
        int a = 3;
        int b = 8;
        Rational c = new ImmutableRationalImpl(2, 7);
        Rational lhs = new ImmutableRationalImpl(a,b).add(c);
        Rational rhs = new ImmutableRationalImpl(a*c.getDenominator() + b*c.getNumerator(), b*c.getDenominator());

        assertEquals(lhs.getNumerator(), rhs.getNumerator());
        assertEquals(lhs.getDenominator(), rhs.getDenominator());
    }

    // Test for axiom
    // add(C, create(A,B)) = add(create(A,B), C)
    @Test
    public void testAddAlternate() {
        int a = 3;
        int b = 8;
        ImmutableRational c = new ImmutableRationalImpl(2, 7);
        Rational lhs = c.add(new ImmutableRationalImpl(a,b));
        Rational rhs = new ImmutableRationalImpl(a,b).add(c);

        assertEquals(lhs.getNumerator(), rhs.getNumerator());
        assertEquals(lhs.getDenominator(), rhs.getDenominator());
    }

    // Test for axiom
    // mult(create(A,B), C)) = create(A*numer(C), B*denom(C))
    @Test
    public void testMult() {
        int a = 3;
        int b = 8;
        ImmutableRational c = new ImmutableRationalImpl(2, 7);

        Rational lhs = new ImmutableRationalImpl(a,b).multiply(c);
        Rational rhs = new ImmutableRationalImpl(a*c.getNumerator(), b*c.getDenominator());

        assertEquals(lhs.getNumerator(), rhs.getNumerator());
        assertEquals(lhs.getDenominator(), rhs.getDenominator());
    }


    // Test for axiom
    // mult(C, create(A,B)) = mult(create(A,B), C)
    @Test
    public void testMultAlternate() {
        int a = 3;
        int b = 8;
        ImmutableRational c = new ImmutableRationalImpl(2, 7);

        Rational lhs = c.multiply(new ImmutableRationalImpl(a, b));
        Rational rhs = new ImmutableRationalImpl(a, b).multiply(c);

        assertEquals(lhs.getNumerator(), rhs.getNumerator());
        assertEquals(lhs.getDenominator(), rhs.getDenominator());
    }

    // Test for axiom
    // recip(create(A,B)) = create(B,A) if A != 0, undefined (i.e., error) otherwise.
    @Test
    public void testRecip() {
        int a = 2;
        int b = 7;

        Rational lhs = new ImmutableRationalImpl(a, b).reciprocal();
        Rational rhs = new ImmutableRationalImpl(b, a);

        assertEquals(lhs.getNumerator(), rhs.getNumerator());
        assertEquals(lhs.getDenominator(), rhs.getDenominator());

        // To test for an exception, put code that should cause the
        // exception into a "try" block with a fail assertion after
        // the operation that should cause an exception.
        // Following try block should be an empty catch block
        // for the type of exception expected.
        try {
            a = 0;
            lhs = new ImmutableRationalImpl(a, b).reciprocal();
            fail("Line above should have caused exception");
        } catch (RuntimeException ignored) {
        }
    }

    @Test
    public void testAddSomeMore() {
        ImmutableRational r1 = new ImmutableRationalImpl(4, 7);
        Rational r2 = new ImmutableRationalImpl(2, 7);
        Rational r3 = r1.add(r2);
        assertEquals(6, r3.getNumerator());
        assertEquals(7, r3.getDenominator());

        Rational r4 = new ImmutableRationalImpl(1, 14);
        Rational r5 = r1.add(r4);
        assertEquals(9, r5.getNumerator());
        assertEquals(14, r5.getDenominator());
    }

    private static int gcd(int a, int b) {
        return (b==0) ? a : gcd(b, a%b);
    }
}
