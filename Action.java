
/**
 * Classe abstrata que define a estrutura da funcionalidade de uma ação
 *
 * @author Erik
 * @version 1.0.0
 */
public abstract class Action
{
    /**
     * Nome da ação, é utilizado no momento de apresentação
     */
    protected String name;
    /**
     * Flag que define se a ação ja foi executada
     */
    private boolean alreadyExecuted;
    /**
     * Flag que define se esta ação é necessária para o Tamagotchi
     */
    private boolean executionNeeded;
    /**
     * Referencia ao tamagotchi
     */
    protected Tamagotchi tamagotchi;


    /**
     * Método construtor
     */
    public Action(String name, boolean executionNeeded, Tamagotchi tamagotchi){
        this.name = name;
        this.executionNeeded = executionNeeded;
        this.tamagotchi = tamagotchi;
    }

    /**
     * Metodo de acesso alreadyExecuted
     */
    private void setAlreadyExecuted(boolean alreadyExecuted){ this.alreadyExecuted = alreadyExecuted; }
    /**
     * Metodo de acesso alreadyExecuted
     */
    public boolean isAlreadyExecuted(){ return this.alreadyExecuted; }

    /**
     * Metodo de acesso executionNeeded
     */
    public boolean isExecutionNeeded() { return this.executionNeeded; }

    /**
     * Metodo de acesso executionNeeded
     */
    public void setExecutionNeeded(boolean executionNeeded) { this.executionNeeded = executionNeeded; }


    /**
     * método abstrato contendo a implementação da ação
     */
    protected abstract void executeImpl();

    /**
     * Método chamado para executar a ação.
     * Além de utilizar a implementação da subclasse seta a flag alreadyExecuted.
     * Caso ja tenha sido alreadyExecuted, o método retorna sem fazer nada.
     */
    public void execute(){
        if(this.alreadyExecuted) return;
        this.setAlreadyExecuted(true);
        this.executeImpl();
    }

    /**
     * retorna o name da ação
     *
     * @return actionName
     */
    public String toString(){ return this.name; }

}
