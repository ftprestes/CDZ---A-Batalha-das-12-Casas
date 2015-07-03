package cdz;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public enum CommandWord{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), OLHAR("olhar"), ATACAR("atacar"),
    PEGAR("pegar"), SOLTAR("soltar"),
    QUIT("quit"), HELP("help"), UNKNOWN("?"), CAVALEIRO("cavaleiro"), 
    INIMIGOS("inimigos"), USAR("usar");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString(){
        return commandString;
    }
}
