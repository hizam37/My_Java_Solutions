final class Screen {

   final String Diagonal;
   final ScreenType screenType;

   final int Weight;

    Screen(String diagonal, ScreenType screenType, int weight) {
        Diagonal = diagonal;
        this.screenType = screenType;
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "Diagonal='" + Diagonal + '\'' +
                ", screenType=" + screenType +
                ", Weight=" + Weight +
                '}';
    }
}
