import java.util.Objects;

public class Computer{

    private int TotallMass=0;
    private InformationStorage informationStorage;

    private Processor processor;
    private RAM ram;

    private Screen screen;

    private Keyboard keyboard;

    public InformationStorage getInformationStorage() {
        return informationStorage;
    }

    public void setInformationStorage(InformationStorage informationStorage) {
        this.informationStorage = informationStorage;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    int getTotallMass() {
        TotallMass = TotallMass + this.processor.Weight + this.ram.Weight + this.informationStorage.Weight + this.keyboard.weight + this.screen.Weight;
        return TotallMass;
    }


    public Computer(InformationStorage informationStorage, Processor processor, RAM ram, Screen screen, Keyboard keyboard) {
        this.informationStorage = informationStorage;
        this.processor = processor;
        this.ram = ram;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "TotallMass=" + getTotallMass() +
                ", informationStorage=" + informationStorage +
                ", processor=" + processor +
                ", ram=" + ram +
                ", screen=" + screen +
                ", keyboard=" + keyboard +
                '}';
    }
}
