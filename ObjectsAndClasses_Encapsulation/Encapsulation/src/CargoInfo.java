import java.util.Objects;

final class CargoInfo {
    final  Dimensions dimensions;
    final private int weight;

    final private String deliveryAddress;

    public Dimensions getDimensions() {
        return dimensions;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    Boolean canItBeFlipped=false;

    String registerationNumber="";
    Boolean isItFragile = false;


    @Override
    public String toString() {
        return "CargoInfo{" +
                "dimensions=" + dimensions +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", canItBeFlipped=" + canItBeFlipped +
                ", registerationNumber='" + registerationNumber + '\'' +
                ", isItFragile=" + isItFragile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoInfo cargoInfo = (CargoInfo) o;
        return weight == cargoInfo.weight && Objects.equals(dimensions, cargoInfo.dimensions) && Objects.equals(deliveryAddress, cargoInfo.deliveryAddress) && Objects.equals(canItBeFlipped, cargoInfo.canItBeFlipped) && Objects.equals(registerationNumber, cargoInfo.registerationNumber) && Objects.equals(isItFragile, cargoInfo.isItFragile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimensions, weight, deliveryAddress, canItBeFlipped, registerationNumber, isItFragile);
    }


    public CargoInfo(Dimensions dimensions, int weight, String deliveryAddress, Boolean canItBeFlipped, String registerationNumber, Boolean isItFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.canItBeFlipped = canItBeFlipped;
        this.registerationNumber = registerationNumber;
        this.isItFragile = isItFragile;
    }
}
