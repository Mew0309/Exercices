class Exercise_13_09 {
    /** Main method */
    public static void main(String[] args) {
        // Create three Circle objects
        Circle circle1 = new Circle(5, "red", true);
        Circle circle2 = new Circle(5, "green", false);
        Circle circle3 = new Circle(4, "green", false);

        // Display results
        System.out.println("Circle1 radius: " + circle1.getRadius());
        System.out.println("Circle2 radius: " + circle2.getRadius());
        System.out.println("Circle3 radius: " + circle3.getRadius());

        System.out.println("Circle1 is " + (circle1.equals(circle2) ? "" : "not ") +
                "equal to circle2");

        System.out.println("Circle1 is " + (circle1.equals(circle3) ? "" : "not ") +
                "equal to circle3");
    }
}

class Circle {
    private double radius;
    private String color;
    private boolean filled;

    // Constructor
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    // Getter for filled status
    public boolean isFilled() {
        return filled;
    }

    // Setter for filled status
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0 &&
                filled == circle.filled &&
                color.equals(circle.color);
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        int result = 17;
        long temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        result = 31 * result + (filled ? 1 : 0);
        return result;
    }
}
