public class Operator implements Empleyee {
    private final double fixedSalary;

    public Operator(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getMonthSalary() {
        return this.fixedSalary;
    }


    @Override
    public String toString() {
        return "Operator's salary = " + this.fixedSalary;
    }


}

