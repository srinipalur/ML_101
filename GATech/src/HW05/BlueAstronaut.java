package HW05;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;
    private static final int susLevelDefault = 15;
    private static final int numTasksDefault = 6;
    private static final int taskSpeedDefault = 10;
    
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, susLevelDefault, numTasksDefault, taskSpeedDefault);
    }

    void emergencyMeeting() {
        if(this.isFrozen())
            return;
        int maxSus = 0;
        int maxSusPlayerIndex = 0;
        int maxDupes = 0;
        for(int i = 0; i < getPlayers().length; i++) {
            if(getPlayers()[i].isFrozen())
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

    /*A BlueAstronaut that is frozen cannot complete tasks.
    If taskSpeed is greater than 20, subtract 2 from numTasks. Otherwise, subtract 1 from numTasks.
    If numTasks falls below 0, set it to 0
    After BlueAstronaut is done with their tasks, meaning numTasks is equal to 0 (only for the first time),
    Print out “I have completed all my tasks”
    Then reduce BlueAstronaut’s susLevel by 50% (round down) */
    public void completeTask() {
        if(this.isFrozen())
            return;
        if(this.taskSpeed > 20)
            this.numTasks = Math.max(this.numTasks - 2, 0);
        else
            this.numTasks = Math.max(this.numTasks - 1, 0);
        if(this.numTasks == 0) {
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int)(0.5 * this.getSusLevel()));
        }
    }

    public boolean equals(BlueAstronaut p) {
        if(this.getName() == p.getName() && this.isFrozen() == p.isFrozen() && this.getSusLevel() == p.getSusLevel() && this.numTasks == p.numTasks && this.taskSpeed == p.taskSpeed)
            return true;
        return false;
    }

    public String toString() {
        String str = super.toString();
        str = str + " I have " + this.numTasks + " left over.";
        if(this.getSusLevel() > 15)
            return str.toUpperCase();
        return str;
    }
}