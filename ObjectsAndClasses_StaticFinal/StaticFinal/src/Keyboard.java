public class Keyboard {
    final KeyboardType keyboardType;
    final KeyboardHasLight keyboardHasLight;
    final int weight;

    public Keyboard(KeyboardType keyboardType, KeyboardHasLight keyboardHasLight, int weight) {
        this.keyboardType = keyboardType;
        this.keyboardHasLight = keyboardHasLight;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "keyboardType=" + keyboardType +
                ", keyboardHasLight=" + keyboardHasLight +
                ", weight=" + weight +
                '}';
    }
}
