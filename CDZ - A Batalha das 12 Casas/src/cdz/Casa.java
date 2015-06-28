package cdz;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.StringBuffer;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Casa {
    private String descricao, nome;
    private HashMap<String, Casa> exits;        // stores exits of this room.
    private HashMap<String, Item> itens;        // stores exits of this room.
    private HashMap<String, Personagem> personagens;        // stores exits of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param descricao The room's description.
     */
    public Casa(String nome, String descricao){
        this.descricao = descricao;
        exits = new HashMap<>();
        itens = new HashMap<>();
        personagens = new HashMap<>();
        this.nome = nome;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Casa neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    public String getNome(){
        return nome;
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return descricao;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription(){
        StringBuffer description = new StringBuffer();
    		description.append(this.descricao + ".\n");
    		description.append(getExitString()  + "\n");
    		
    		description.append("-- Lista de Inimigos: ");
    		for (String name : personagens.keySet())
    			description.append(name+" ");
        
    		description.append("\n-- Lista de Itens: ");
    		for (String name : itens.keySet())
    			description.append(name+" ");
        
    		description.append("\n");
    		
    		return description.toString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString(){
        String returnString = "Saídas: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Casa getExit(String direction){
        return exits.get(direction);
    }
    
    public void addItem(Item item){
    		itens.put(item.getNome(), item);
    }
    
    public void removeItem(String itemName){
    		itens.remove(itemName);
    }
    
    public void addPersonagem(Personagem personagem){
    		personagens.put(personagem.getNome(), personagem);
    }
    
    public void removeCharacter(String name){
    		personagens.remove(name);
    }

    public Personagem getCharacter(String name){
        return personagens.get(name);
    }
    
    public Item getItem(String name){
        return itens.get(name);
    }
    
}