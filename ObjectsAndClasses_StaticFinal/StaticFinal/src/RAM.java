final class RAM {
    final RamType ramType;
    final int Volume;
    final int Weight;


    public int getVolume() {
        return Volume;
    }

    public int getWeight() {
        return Weight;
    }

    public RAM(RamType ramType, int volume, int weight) {
        this.ramType = ramType;
        Volume = volume;
        Weight = weight;
    }

    public RamType getRamType() {
        return ramType;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "ramType=" + ramType +
                ", Volume=" + Volume +
                ", Weight=" + Weight +
                '}';
    }
}
