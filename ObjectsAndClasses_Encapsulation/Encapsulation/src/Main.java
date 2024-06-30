import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Elevator elevator = new Elevator(-3, 26);
//
//        while (true) {
//            System.out.print("Enter floor №: "3);
//            int floor = new Scanner(System.in).nextInt();
//            elevator.move(floor);
//            if (floor > elevator.maxFloor | floor < elevator.minFloor) {
//                System.out.println("Wrong floor entered! ");
//            }
//        }
        CargoInfo liquidBulk = new CargoInfo(new Dimensions(1, 2, 3), 3, "Mockoskaya",true,"34RED3534",true);
        Dimensions dimensionsOfLiquidBulk = liquidBulk.dimensions;
        dimensionsOfLiquidBulk.volumeCalculator();
        CargoInfo Foods = new CargoInfo(new Dimensions(1, 2, 4), 3, "Akademichskaya",true,"DEF234556",true);
        Dimensions dimensionsOfLiquidBulkk = Foods.dimensions;
        dimensionsOfLiquidBulkk.volumeCalculator();


    }
}
