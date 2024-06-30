public class Manager implements Empleyee {


    private final double fixedsalary;

    @Override
    public double getMonthSalary() {
        return this.fixedsalary;
    }


    Manager(double fixedsalary) {
        double bonus = 0.05;
        this.fixedsalary = fixedsalary + Math.round((Math.random() * (140000 - 115000)) + 115000) + bonus;
    }


    @Override
    public String toString() {
        return "Manager's fixedsalary = " + fixedsalary;
    }


}

