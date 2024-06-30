final class InformationStorage {
    final MemoryType memoryType;
    final int MemoryCapacity;
    final int Weight;

    public MemoryType getType() {
        return memoryType;
    }

    public int getMemoryCapacity() {
        return MemoryCapacity;
    }

    public int getWeight() {
        return Weight;
    }

    public InformationStorage(MemoryType memoryType, int memoryCapacity, int weight) {
        this.memoryType = memoryType;
        MemoryCapacity = memoryCapacity;
        Weight = weight;
    }


    @Override
    public String toString() {
        return "InformationStorage{" +
                "memoryType=" + memoryType +
                ", MemoryCapacity=" + MemoryCapacity +
                ", Weight=" + Weight +
                '}';
    }
}
