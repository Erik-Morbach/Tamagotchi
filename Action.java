
/**
 * Write a description of class Action here.
 *
 * @author Erik
 * @version 1.0.0
 */
public abstract class Action
{
    protected String actionName;
    private boolean alreadyExecuted;
    private boolean executionNeeded;
    protected Tamagotchi tamagotchi;
    public Action(String actionName, Tamagotchi tamagotchi, boolean executionNeeded){
        this.actionName = actionName;
        this.tamagotchi = tamagotchi;
        this.executionNeeded = executionNeeded;
    }
    protected void setAlreadyExecuted(){ this.alreadyExecuted = true; }
    public boolean isExecutionNeeded() { return this.executionNeeded; }
    public boolean isAlreadyExecuted(){ return this.alreadyExecuted; }
    public abstract void execute();

    public String toString(){ return this.actionName; }
}
