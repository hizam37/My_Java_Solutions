import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Company {

    List<Empleyee> empleyees = new ArrayList<>();

    private double income;

    public void setIncome(double income) {

        this.income = income;
    }

    public double getIncome() {

        return this.income;

    }


    List<Empleyee> getTopSalaryStaff(int count) {

        Collections.sort(empleyees);

        Collections.reverse(empleyees);

        return empleyees.subList(0, count);

    }

    List<Empleyee> getLowestSalaryStaff(int count) {

        Collections.sort(empleyees);

        return empleyees.subList(0, count);

    }

    public void hire(Empleyee empleyee) {

        empleyees.add(empleyee);
    }

    List<Empleyee> hireAll(Collection<Empleyee> empleyeeList) {

        empleyees.addAll(empleyeeList);

        return empleyees;
    }


    public void fire(Empleyee empleyee) {

        empleyees.remove(empleyee);
    }

    public void fireHalf() {

        int fireHalf = empleyees.size();

        if (fireHalf % 2 == 0) {

            int divider = fireHalf / 2;

            for (int i = 0; i < divider; i++) {

                empleyees.remove(i);
            }

            System.out.println("Employee remaining " + empleyees.size());

        } else {

            System.out.println("Firing is not allowed!!!!");

        }

    }

}
