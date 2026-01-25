package HW04;

public class Pond {
    public static void main(String[] args) {
        Frog frogPeepo = new Frog("Peepo");
        Frog frogPepe = new Frog("Pepe", 10, 15);
        Frog frogPeepaw = new Frog("Peepaw", 4.6);
        Frog frogTest = new Frog("Test");
        
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly flyTest = new Fly();

        Frog.setSpecies("1331 Frogs");
        System.out.println(frogPeepo);
        frogPeepo.eat(fly2);
        System.out.println(fly2);
        frogPeepo.grow(8);
        frogPeepo.eat(fly2);
        System.out.println(fly2);
        System.out.println(frogPeepo);
        System.out.println(frogTest);
        frogPeepaw.grow(4);
        System.out.println(frogPeepaw);
        System.out.println(frogPepe);
    }
}
