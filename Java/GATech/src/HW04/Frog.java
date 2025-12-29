package HW04;

public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";
    private static final int defaultAge = 5;
    private static final double defaultTongueSpeed = 5.0;

    Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }

    Frog(String name, double ageInYears) {
        this(name, (int)(ageInYears * 12), defaultTongueSpeed);        
    }

    Frog(String name) {
        this(name, defaultAge, defaultTongueSpeed);
    }
    
    public void grow(int months) {
        for(int i = 0; i < months; i++)
            this.grow();
    }   

    public void grow() {
        if(age < 12) {
            tongueSpeed += 1;
            if(age > 1 && age < 7)
                isFroglet = true;
        }
        else if(age >= 30) {
            tongueSpeed = Math.max(5, tongueSpeed - 1);
        }
        age += 1;
    }

    public void eat(Fly aFly) {
        if(aFly.isDead())
            return;
        boolean caught = tongueSpeed > aFly.getSpeed();
        if(caught) {
            if(aFly.getMass() >= 0.5*age)
                grow();
            aFly.setMass(0);
        }
        else {
            aFly.grow(1);
        }
    }

    public String toString() {
        String str;
        String formattedTongueSpeed = String.format("%.2f", tongueSpeed);
        if(isFroglet)
            str = "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + formattedTongueSpeed + ".";
        else
            str = "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + formattedTongueSpeed + ".";
        return str;
    }

    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }
}
