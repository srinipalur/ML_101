package HW04;

public class Fly {
    private double mass;
    private double speed;
    private final static double massDefault = 5.0;
    private final static double speedDefault = 10.0;
    
    Fly() {
        this(massDefault, speedDefault);
    }

    Fly(double mass) {
        this(mass, speedDefault);
    }

    Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public double getMass() {
        return mass;
    }

    public String toString() {
        String str;
        String formattedSpeed = String.format("%.2f", speed);
        String formattedMass = String.format("%.2f", mass);
        if(mass == 0)
            str = "I'm dead, but I used to be a fly with a speed of " + formattedSpeed + ".";
        else
            str = "I'm a speedy fly with " + formattedSpeed + " speed and " + formattedMass + " mass.";
        return str;
    }

    public void grow(int addedMass) {
        while(addedMass > 0) {
            if(mass < 20)
                speed += 1;
            else
                speed -= 0.5;
            mass += 1;
            addedMass -= 1;
        }
    }

    public boolean isDead() {
        if(mass == 0)
            return true;
        return false;
    }
}