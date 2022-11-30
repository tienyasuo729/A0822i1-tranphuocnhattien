import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.getA() * this.getC();
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(this.getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(this.getDiscriminant())) / (2 * a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value a = ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value b = ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value c = ");
        double c = scanner.nextDouble();

        QuadraticEquation expression = new QuadraticEquation(a, b, c);
        if (expression.getDiscriminant() > 0) {
            System.out.print("The equation has 2 roots " + expression.getRoot1() + " and " + expression.getRoot2());
        } else if (expression.getDiscriminant() == 0) {
            System.out.print("Results of the equation: " + expression.getRoot1());
        } else {
            System.out.println("The equation has not roots");
        }

    }
}
