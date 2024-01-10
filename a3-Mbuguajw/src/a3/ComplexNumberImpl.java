package a3;

public class ComplexNumberImpl implements ComplexNumber {

    private double real;

    private double imag;

    // Constructor
    public ComplexNumberImpl(double _r, double _d) {

        real = _r;

        imag = _d;
    }

    // Instance methods go here.

    @Override
    public double getReal () {
        return real;
    }

    @Override
    public double getImaginary () {
        return imag;
    }

    @Override
    public double getAbsValue () {

        double squaredReal = Math.pow(this.getReal(), 2);

        double squaredImag = Math.pow(this.getImaginary(), 2);

        double add = squaredImag + squaredReal;

        double aV = Math.pow(add, 0.5);

        return aV;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber other){

        double multImaginary = (this.getReal() * other.getImaginary()) + (this.getImaginary() * other.getReal());

        double multReal = (this.getReal() * other.getReal()) - (this.getImaginary() * other.getImaginary());

        ComplexNumber multiplied = new ComplexNumberImpl(multReal, multImaginary);

        return multiplied;
    }

    @Override
    public ComplexNumber add(ComplexNumber other){

        double addImaginary = this.getImaginary() + other.getImaginary();

        double addReal = this.getReal() + other.getReal();

        ComplexNumber added = new ComplexNumberImpl(addReal, addImaginary);

        return added;
    }

    @Override
    public boolean equals (ComplexNumber other) {
        boolean equalReals;

        boolean equalImag;

        boolean equivalent;

        if (this.getReal() == other.getReal()) {
            equalReals = true;
        }
        else {
            equalReals = false;
        }
        if (this.getImaginary() == other.getImaginary()) {
            equalImag = true;
        }
        else {
            equalImag = false;
        }
        if (equalReals && equalImag) {
            equivalent = true;
        }
        else {
            equivalent = false;
        }
        return equivalent;
    }
}