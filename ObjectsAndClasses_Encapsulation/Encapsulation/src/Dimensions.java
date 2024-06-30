import java.util.Objects;

public class Dimensions{
    private final int width;
    private final int height;

    private final int length;
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }


    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    void volumeCalculator()
    {
        int volume = this.width*this.height*this.length;
        System.out.println("Volume of cargo is " + volume);
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return width == that.width && height == that.height && length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, length);
    }

}
