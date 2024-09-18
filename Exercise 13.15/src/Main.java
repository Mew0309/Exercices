import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    // Constructor
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Reduce to lowest terms
    }

    // Reduce the fraction to its lowest terms
    private void reduce() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        // Ensure denominator is positive
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
    }

    // Addition
    public Rational add(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Subtraction
    public Rational subtract(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .subtract(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Multiplication
    public Rational multiply(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Division
    public Rational divide(Rational other) {
        if (other.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        BigInteger newNumerator = this.numerator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }

    // Convert to decimal
    public double toDecimal() {
        return new BigDecimal(numerator)
                .divide(new BigDecimal(denominator), 20, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}



class RationalTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the first rational number
        System.out.print("Enter the first rational number: ");
        BigInteger numerator1 = new BigInteger(input.next());
        BigInteger denominator1 = new BigInteger(input.next());
        Rational r1 = new Rational(numerator1, denominator1);

        // Read the second rational number
        System.out.print("Enter the second rational number: ");
        BigInteger numerator2 = new BigInteger(input.next());
        BigInteger denominator2 = new BigInteger(input.next());
        Rational r2 = new Rational(numerator2, denominator2);

        // Perform operations
        Rational sum = r1.add(r2);
        Rational difference = r1.subtract(r2);
        Rational product = r1.multiply(r2);
        Rational quotient = r1.divide(r2);

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + sum);
        System.out.println(r1 + " - " + r2 + " = " + difference);
        System.out.println(r1 + " * " + r2 + " = " + product);
        System.out.println(r1 + " / " + r2 + " = " + quotient);
        System.out.println(r2 + " is " + r2.toDecimal());
    }
}

