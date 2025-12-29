package HW06;

public class Dog extends Pet {
    private double droolRate;
    private static final double defaultDroolRate = 5.0;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, defaultDroolRate);        
    }

    public double getDroolRate() {
        return this.droolRate;
    }

    public int treat() {
        double treatmentTime;
        if(this.getDroolRate() < 3.5)
            treatmentTime = getPainLevel()*2/getHealth();
        else if(this.getDroolRate() >= 3.5 && this.getDroolRate() <= 7.5)
            treatmentTime = getPainLevel()/getHealth();
        else
            treatmentTime = getPainLevel()/(2*getHealth());
        this.heal();
        return (int)Math.ceil(treatmentTime);
    }

    public void speak() {
        super.speak();
        String barkNoise = this.getPainLevel() > 5 ? " BARK" : " bark";
        for (int i = 0; i < this.getPainLevel(); i++) {
            System.out.print(barkNoise);
        }
        System.out.println();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Dog)) return false;
        Dog other = (Dog) o;
        return super.equals(o) && this.getDroolRate() == other.getDroolRate();
    }
}
