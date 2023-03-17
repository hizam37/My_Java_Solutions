import java.util.*;

public class Calculator {

    public static String calc(String input) throws Exception {
        LinkedHashMap<String, Integer> RomanNumbers = new LinkedHashMap<>();
        RomanNumbers.put("I", 1);
        RomanNumbers.put("II", 2);
        RomanNumbers.put("III", 3);
        RomanNumbers.put("IV", 4);
        RomanNumbers.put("V", 5);
        RomanNumbers.put("VI", 6);
        RomanNumbers.put("VII", 7);
        RomanNumbers.put("VIII", 8);
        RomanNumbers.put("IX", 9);
        RomanNumbers.put("X", 10);
        String[] input_Receiver = input.split(" ");
        {
            if (input_Receiver.length < 3) {
                throw new ArrayIndexOutOfBoundsException(
                        "Only one operator and two operands are allowed!");
            }
            if (RomanNumbers.containsKey(input_Receiver[0]) & RomanNumbers.containsKey(input_Receiver[2])) {
                switch (input_Receiver[1]) {
                    case "+" -> {
                        if (RomanNumbers.get(input_Receiver[0]) < RomanNumbers.get(input_Receiver[2])) {
                            System.out.println(input_Receiver[2] + input_Receiver[0]);
                        } else {
                            System.out.println(input_Receiver[0] + input_Receiver[2]);
                        }
                    }
                    case "-" -> {
                        int result = RomanNumbers.get(input_Receiver[0]) - RomanNumbers.get(
                                input_Receiver[2]);
                        for (Map.Entry<String, Integer> entry : RomanNumbers.entrySet()) {
                            if (entry.getValue().equals(result)) {
                                System.out.println(entry.getKey());
                            }
                        }
                        if (result <= 0) {
                            throw new Exception(
                                    "0 digit or Negative Roman numerals are not allowed!");
                        }
                    }
                    case "*" -> {
                        int result = RomanNumbers.get(input_Receiver[0]) * RomanNumbers.get(
                                input_Receiver[2]);
                        result = result / RomanNumbers.get(input_Receiver[0]);
                        for (Map.Entry<String, Integer> entry : RomanNumbers.entrySet()) {
                            for (int i = 0; i < RomanNumbers.get(input_Receiver[0]); i++) {
                                if (entry.getValue().equals(result)) {
                                    System.out.print(entry.getKey());
                                }
                            }
                        }
                        System.out.println();
                    }
                    case "/" -> {
                        int result = RomanNumbers.get(input_Receiver[0]) / RomanNumbers.get(
                                input_Receiver[2]);
                        for (Map.Entry<String, Integer> entry : RomanNumbers.entrySet()) {
                            if (entry.getValue().equals(result)) {
                                System.out.print(entry.getKey());
                            }
                        }
                        System.out.println();
                    }
                }
            } else {
                switch (input_Receiver[1]) {
                    case "+" -> {
                        int result = Integer.parseInt(input_Receiver[0]) + Integer.parseInt(
                                input_Receiver[2]);
                        System.out.println(result);
                    }
                    case "-" -> {
                        int result = Integer.parseInt(input_Receiver[0]) - Integer.parseInt(
                                input_Receiver[2]);
                        System.out.println(result);
                    }
                    case "*" -> {
                        int result = Integer.parseInt(input_Receiver[0]) * Integer.parseInt(
                                input_Receiver[2]);
                        System.out.println(result);
                    }
                    case "/" -> {
                        int result = Integer.parseInt(input_Receiver[0]) / Integer.parseInt(
                                input_Receiver[2]);
                        System.out.println(result);
                    }
                }
            }
        }
        return input;
}



    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Formula: ");
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            calc(s);
            System.out.println("Enter your Formula: ");
        }
    }
}


