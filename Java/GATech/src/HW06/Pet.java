package HW06;

public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = Math.max(0.0, Math.min(1.0, health));
        this.painLevel = Math.max(1, Math.min(10, painLevel));
    }

    public String getName() {
        return this.name;
    }

        public double getHealth() {
        return this.health;
    }

        public int getPainLevel() {
        return this.painLevel;
    }

    public abstract int treat();

    public void speak() {
        boolean painful = this.painLevel > 5;
        if(!painful)
            System.out.print("Hello! My name is " + this.name);
        else
            System.out.print(("Hello! My name is " + this.name).toUpperCase());
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Pet)) return false;
        Pet other = (Pet) o;
        return this.getName().equals(other.getName());
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}
