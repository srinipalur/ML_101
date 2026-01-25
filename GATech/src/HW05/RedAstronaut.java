package HW05;

public class RedAstronaut extends Player implements Impostor {
    private String skill;
    private static final int susLevelDefault = 15;
    private static final String skillDefault = "experienced";

    public RedAstronaut(String Name, int susLevel, String skill) {
        super(Name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String Name) {
        this(Name, susLevelDefault, skillDefault);
    }

    void emergencyMeeting() {
        if(this.isFrozen())
            return;
        int maxSus = 0;
        int maxSusPlayerIndex = 0;
        int maxDupes = 0;
        for(int i = 0; i < getPlayers().length; i++) {
            if(this.equals(getPlayers()[i]))
                continue;
            if(getPlayers()[i].getSusLevel() == maxSus)
                maxDupes++;
            if(getPlayers()[i].getSusLevel() > maxSus) {
                maxSus = getPlayers()[i].getSusLevel();
                maxSusPlayerIndex = i;
                maxDupes = 0;
            }
        }
        if(maxDupes > 0)
            return;
        else {
            getPlayers()[maxSusPlayerIndex].setFrozen(true);
            gameOver();
        }
    }

    public void freeze(Player p) {
        if(p.isFrozen() || this.isFrozen() || (p instanceof Impostor))
            return;
        if(this.getSusLevel() < p.getSusLevel())
            p.setFrozen(true);
        else
            this.setSusLevel(2*this.getSusLevel());
        gameOver();
    }

    public void sabotage(Player p) {
        if(p.isFrozen() || this.isFrozen() || (p instanceof Impostor))
            return;
        if(this.getSusLevel() < 20)
            p.setSusLevel((int)(1.5 * p.getSusLevel()));
        else
            p.setSusLevel((int)(1.25 * p.getSusLevel()));
    }

    public boolean equals(RedAstronaut p) {
        if(this.getName() == p.getName() && this.isFrozen() == p.isFrozen() && this.getSusLevel() == p.getSusLevel() && this.getSkill() == p.getSkill())
            return true;
        return false;
    }

    public String getSkill() {
        return this.skill;
    }

    public String toString() {
        String str = super.toString();
        str = str + " I am an " + this.skill + " player!";
        if(this.getSusLevel() > 15)
            return str.toUpperCase();
        return str;
    }
}