

public class Main {
    public static void main(String[] args) {

        Company playStation = new Company();

        playStation.setIncome(12_000_000);

        for (int i = 0; i < 180; i++) {

            playStation.hire(new Operator(30_000));

        }

        for (int i = 0; i < 80; i++) {

            playStation.hire(new Manager(30_000));

        }

        for (int i = 0; i < 10; i++) {

            playStation.hire(new TopManager(900_000, playStation));

        }

        System.out.println("List of Highest Salary " + playStation.getTopSalaryStaff(15));

        System.out.println("List of Lowest Salary " + playStation.getLowestSalaryStaff(30));

        playStation.fireHalf();

        System.out.println("List of Highest Salary " + playStation.getTopSalaryStaff(15));

        System.out.println("List of Lowest Salary " + playStation.getLowestSalaryStaff(30));

    }

}