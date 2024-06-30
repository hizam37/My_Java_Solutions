
public class Main {
    public static void main(String[] args) {
        Processor processorOfHP = new Processor(1,2,Manufacturer.HP,4);
        InformationStorage informationStorageOfHP = new InformationStorage(MemoryType.SDD,20,20);
        RAM ramOfHP = new RAM(RamType.DRAM,2,3);
        Screen screenOfHP = new Screen("20x30",ScreenType.IPS,30);
        Keyboard keyboardOfHP = new Keyboard(KeyboardType.Ergonomic,KeyboardHasLight.YES,3);
        Computer HP = new Computer(informationStorageOfHP,processorOfHP,ramOfHP,screenOfHP,keyboardOfHP);
        System.out.println(HP);

        Processor processorOfAcer = new Processor(1,2,Manufacturer.HP,4);
        InformationStorage informationStorageOfAcer = new InformationStorage(MemoryType.HDD,40,20);
        RAM ramOfAcer = new RAM(RamType.DRAM,2,3);
        Screen screenOfAcer = new Screen("20x60",ScreenType.IPS,30);
        Keyboard keyboardOfAcer = new Keyboard(KeyboardType.Wired,KeyboardHasLight.NO,3);
        Computer Acer = new Computer(informationStorageOfAcer,processorOfAcer,ramOfAcer,screenOfAcer,keyboardOfAcer);
        System.out.println(Acer);
    }


}
