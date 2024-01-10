package a3test;

import a3.ComplexNumber;
import a3.ComplexNumberImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class A3Tests {

    // Test axiom:
    // real(create(A,B)) = ????
    @Test
    public void testReal() {
        ComplexNumber testingComNum = new ComplexNumberImpl(3, 8);
        assertEquals(1, new ComplexNumberImpl(1, 13).getReal());

        assertEquals(3, testingComNum.getReal());
    }

    // Test axiom:
    // imag(create(A,B)) = ????
    @Test
    public void testImag() {
        ComplexNumber testingComNum2 = new ComplexNumberImpl(3, 8);
        assertEquals(13, new ComplexNumberImpl(1, 13).getImaginary());

        assertEquals(8, testingComNum2.getImaginary());
    }

    // Test axiom:
    // absolute(create(A,B)) = ????
    @Test
    public void testAbsolute() {
        ComplexNumberImpl testingComNum3 = new ComplexNumberImpl(3, 4);

        assertEquals(10, new ComplexNumberImpl(8, 6).getAbsValue());
        assertEquals(5, testingComNum3.getAbsValue());
    }

    // Test axiom:
    // add(create(A,B), C) = ????
    @Test
    public void testAdd1() {
        ComplexNumber testingComNum4 = new ComplexNumberImpl(12, 7);
        ComplexNumber testingComNum5 = new ComplexNumberImpl(4, 9);
        ComplexNumber testingComNum6 = new ComplexNumberImpl(3, 10);
        ComplexNumber answer1 = new ComplexNumberImpl(16, 16);
        ComplexNumber answer2 = new ComplexNumberImpl(7, 19);
        ComplexNumber oneAnswer = testingComNum4.add(testingComNum5);
        ComplexNumber twoAnswer = testingComNum5.add(testingComNum6);

        assertEquals(answer1.getImaginary(), oneAnswer.getImaginary());
        assertEquals(answer1.getReal(), oneAnswer.getReal());
        assertEquals(answer2.getImaginary(), twoAnswer.getImaginary());
        assertEquals(answer2.getReal(), twoAnswer.getReal());
    }

    // Test axiom:
    // add(C, create(A,B)) = ????
    @Test
    public void testAdd2() {
        ComplexNumber testingComNum7 = new ComplexNumberImpl(2, 8);
        ComplexNumber testingComNum8 = new ComplexNumberImpl(9, 5);
        ComplexNumber testingComNum9 = new ComplexNumberImpl(11, 6);
        ComplexNumber answer1 = new ComplexNumberImpl(11, 13);
        ComplexNumber answer2 = new ComplexNumberImpl(20, 11);
        ComplexNumber oneAnswer = testingComNum7.add(testingComNum8);
        ComplexNumber twoAnswer = testingComNum8.add(testingComNum9);

        assertEquals(answer1.getImaginary(), oneAnswer.getImaginary());
        assertEquals(answer1.getReal(), oneAnswer.getReal());
        assertEquals(answer2.getImaginary(), twoAnswer.getImaginary());
        assertEquals(answer2.getReal(), twoAnswer.getReal());
    }

    // Test axiom:
    // multiply(create(A,B), C) = ????
    @Test
    public void testMultiply1() {

        ComplexNumber testingComNum10 = new ComplexNumberImpl(3, 4);
        ComplexNumber testingComNum11 = new ComplexNumberImpl(5, 2);
        ComplexNumber answer1 = new ComplexNumberImpl(7.0, 26.0);
        ComplexNumber oneAnswer = testingComNum10.multiply(testingComNum11);

        assertEquals(answer1.getImaginary(), oneAnswer.getImaginary());
        assertEquals(answer1.getReal(), oneAnswer.getReal());

    }

    // Test axiom:
    // multiply(C, create(A,B)) = ????
    @Test
    public void testMultiply2() {
        ComplexNumber testingComNum13 = new ComplexNumberImpl(4, 3);
        ComplexNumber testingComNum14 = new ComplexNumberImpl(8, 4);
        ComplexNumber testingComNum15 = new ComplexNumberImpl(10, 2);
        ComplexNumber answer1 = new ComplexNumberImpl(20, 40);
        ComplexNumber answer2 = new ComplexNumberImpl(72, 56);
        ComplexNumber oneAnswer = testingComNum13.multiply(testingComNum14);
        ComplexNumber twoAnswer = testingComNum14.multiply(testingComNum15);

        assertEquals(answer1.getImaginary(), oneAnswer.getImaginary());
        assertEquals(answer1.getReal(), oneAnswer.getReal());
        assertEquals(answer2.getImaginary(), twoAnswer.getImaginary());
        assertEquals(answer2.getReal(), twoAnswer.getReal());
    }


    // Test axiom:
    // equals(create(A,B), C) = ????
    @Test
    public void testEquals1() {
        ComplexNumber testingComNum16 = new ComplexNumberImpl(121, 121);
        ComplexNumber testingComNum17 = new ComplexNumberImpl(121, 12);
        ComplexNumber testingComNum18 = new ComplexNumberImpl(121, 12);

        assertEquals(false, testingComNum16.equals(testingComNum17));
        assertEquals(true, testingComNum17.equals(testingComNum18));
    }

    // Test axiom:
    // equals(C, create(A,B)) = ????
    @Test
    public void testEquals2() {
        ComplexNumber testingComNum19 = new ComplexNumberImpl(1096, 394);
        ComplexNumber testingComNum20 = new ComplexNumberImpl(1096, 394);
        ComplexNumber testingComNum21 = new ComplexNumberImpl(109, 394);

        assertEquals(true, testingComNum19.equals(testingComNum20));
        assertEquals(false, testingComNum20.equals(testingComNum21));
    }
}