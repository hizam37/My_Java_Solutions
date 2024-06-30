package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";

        String user = "root";

        String pass = "DAN123";

        try {
            Connection connection = DriverManager.getConnection(url,user,pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT avg(p.price),p.course_name,count(p.subscription_date) Month_duration FROM purchaselist p\n" +
                    "where year(p.subscription_date) = 2018\n" +
                    "group by p.course_name\n" +
                    "order by p.course_name");

            System.out.printf("%-35s %-15s %-6s%n","Course ","Average price ","Duration in Months");

            while (resultSet.next())
            {

                double avgPrice = resultSet.getDouble(1);

                String courseName = resultSet.getString(2);

                long durationOfPaymentInMonths = resultSet.getLong(3);

                System.out.printf("%-35s %-15s %-6s %n",
                        courseName,
                        avgPrice,
                        durationOfPaymentInMonths);

            }

        }catch (Exception e)

        {

            e.printStackTrace();

        }

    }

}
