public interface Empleyee extends Comparable<Empleyee> {
    double getMonthSalary();

    @Override
    default int compareTo(Empleyee o) {

        return Double.compare(getMonthSalary(), o.getMonthSalary());
    }



}
