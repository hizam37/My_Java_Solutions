import java.util.*;

public class Calculator {

    public static String calc() throws Exception {
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
        System.out.println("Enter your Formula: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] input_Receiver = input.split(" ");
        if (input_Receiver.length > 3) {
            throw new Exception("Only one operator and two operands are allowed!");
        }
        if (input_Receiver.length < 3) {
            throw new ArrayIndexOutOfBoundsException("Only one operator and two operands are allowed!");
        }
        if (!RomanNumbers.containsKey(input_Receiver[0]) | !RomanNumbers.containsKey(input_Receiver[2])) {
            for (Map.Entry<String, Integer> entry : RomanNumbers.entrySet()) {
                String keys = entry.getKey();
                int values = entry.getValue();
                System.out.println(keys + " = " + values);
            }
            throw new NumberFormatException("Only the following Roman numerals are allowed");
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
                    int result = RomanNumbers.get(input_Receiver[0]) - RomanNumbers.get(input_Receiver[2]);
                    for (Map.Entry<String, Integer> entry : RomanNumbers.entrySet()) {
                        if (entry.getValue().equals(result)) {
                            System.out.println(entry.getKey());
                        }
                    }
                    if (result <= 0) {
                        throw new Exception("0 digit or Negative Roman numerals are not allowed!");
                    }
                }
                case "*" -> {
                    int result = RomanNumbers.get(input_Receiver[0]) * RomanNumbers.get(input_Receiver[2]);
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
                    int result = RomanNumbers.get(input_Receiver[0]) / RomanNumbers.get(input_Receiver[2]);
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
                    int result = Integer.parseInt(input_Receiver[0]) + Integer.parseInt(input_Receiver[2]);
                    System.out.println(result);
                }
                case "-" -> {
                    int result = Integer.parseInt(input_Receiver[0]) - Integer.parseInt(input_Receiver[2]);
                    System.out.println(result);
                }
                case "*" -> {
                    int result = Integer.parseInt(input_Receiver[0]) * Integer.parseInt(input_Receiver[2]);
                    System.out.println(result);
                }
                case "/" -> {
                    int result = Integer.parseInt(input_Receiver[0]) / Integer.parseInt(input_Receiver[2]);
                    System.out.println(result);
                }
            }
        }
        return calc();
    }


    public static void main(String[] args) throws Exception {
        calc();
    }
}


