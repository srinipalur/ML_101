package HW06;

public class Cat extends Pet {
    private int miceCaught;
    private static final int defaultMiceCaught = 0;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = Math.max(0, miceCaught);
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, defaultMiceCaught);
    }

    public int getMiceCaught() {
        return this.miceCaught;
    }

    public int treat() {
        double treatmentTime;
        if(this.getMiceCaught() < 4)
            treatmentTime = getPainLevel()*2/getHealth();
        else if(this.getMiceCaught() >= 4 && this.getMiceCaught() <= 7)
            treatmentTime = getPainLevel()/getHealth();
        else
            treatmentTime = getPainLevel()/(2*getHealth());
        this.heal();
        return (int)Math.ceil(treatmentTime);
    }
    
    public void speak() {
        super.speak();
        String barkNoise = this.getPainLevel() > 5 ? " MEOW" : " meow";
        for (int i = 0; i < this.getPainLevel(); i++) {
            System.out.print(barkNoise);
        }
        System.out.println();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Cat)) return false;
        Cat other = (Cat) o;
        return super.equals(o) && this.getMiceCaught() == other.getMiceCaught();
    }
}
