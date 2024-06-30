

final class Processor {
    final int Frequency;
    final int NumberOfCores;
    final Manufacturer manufacturer;
    final int Weight;

    public int getFrequency() {
        return Frequency;
    }

    public int getNumberOfCores() {
        return NumberOfCores;
    }


    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getWeight() {
        return Weight;
    }

    public Processor(int frequency, int numberOfCores, Manufacturer manufacturer, int weight) {
        Frequency = frequency;
        NumberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "Frequency=" + Frequency +
                ", NumberOfCores=" + NumberOfCores +
                ", manufacturer=" + manufacturer +
                ", Weight=" + Weight +
                '}';
    }
}