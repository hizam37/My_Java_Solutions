public class Arithmetic {

    int a;
    int b;

    Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int multiply() {
        return a * b;
    }

    public int findmax() {
        return Math.max(this.a, this.b);
    }

    public int findmin() {
        return Math.min(this.a, this.b);
    }


    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(1, 2);
        System.out.println("sum = " + arithmetic.sum());
        System.out.println("multiplication = " + arithmetic.multiply());
        System.out.println("The maximum number entered in the arithmetic is " + arithmetic.findmax());
        System.out.println("The minimum number entered in the arithmetic is " + arithmetic.findmin());
    }
}

