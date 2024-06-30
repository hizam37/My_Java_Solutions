public class TopManager implements Empleyee {

    private final double fixedSalary;

    @Override
    public double getMonthSalary() {
        return this.fixedSalary;
    }





    TopManager(double fixedSalary,Company companyIncome) {
        if (companyIncome.getIncome() > 10_000_000) {
            this.fixedSalary = fixedSalary * 1.5;
        } else {
            this.fixedSalary = fixedSalary;
        }
    }

    @Override
    public String toString() {
        return "TopManager's = " + fixedSalary;
    }


}
