import java.math.BigInteger;

class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    // Default constructor
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Constructor with BigInteger arguments for numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        BigInteger gcd = numerator.gcd(denominator); // Find the GCD
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);

        // Make sure denominator is positive
        if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
    }

    // Return numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    // Return denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // Add two rational numbers
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Subtract two rational numbers
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Multiply two rational numbers
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Divide two rational numbers
    public Rational divide(Rational secondRational) {
        if (secondRational.getNumerator().equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero");
        }
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    // Return a double value of the rational number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // Return a string representation of the rational number
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    // Implement compareTo to compare two rational numbers
    @Override
    public int compareTo(Rational o) {
        BigInteger n1 = numerator.multiply(o.getDenominator());
        BigInteger n2 = o.getNumerator().multiply(denominator);
        return n1.compareTo(n2);
    }

    // Implement abstract methods from the Number class
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public short shortValue() {
        return (short) doubleValue();
    }
}
