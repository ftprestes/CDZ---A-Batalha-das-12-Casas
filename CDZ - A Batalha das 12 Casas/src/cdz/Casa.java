package cdz;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.StringBuffer;

/**
 * Class Room - a room in an adventure game.
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Casa {
    private String descricao, nome;
    private HashMap<String, Casa> exits;                // hashMap das saídas das casas
    private HashMap<String, Item> itens;                // hashMap dos itens da casa
    private HashMap<String, Personagem> personagens;    // hashMap dos personagens da casa.

   //Cria uma casa passando como parâmetro o nome e a descrição
    public Casa(String nome, String descricao){
        
        this.descricao = descricao;
        exits = new HashMap<>();
        itens = new HashMap<>();
        personagens = new HashMap<>();
        this.nome = nome;
    }

    // método que adiciona uma saída na casa 
    public void setExit(String direction, Casa neighbor) {
        exits.put(direction, neighbor);
    }
    
    //método que retorna o nome da casa
    public String getNome(){
        return nome;
    }
    
    //método que retorna a descrição da casa
    public String getShortDescription(){
        return descricao;
    }
    
    //método que retorna uma descição grande da casa
    //contendo seus inimigos e saídas
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

    // retorna uma string com as saídas das casas
    private String getExitString(){
        String returnString = "Saídas: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    //método que retorna a casa da direção passada como parâmetro
    //caso não tenha saída na direção retorna null
    public Casa getExit(String direction){
        return exits.get(direction);
    }
    
    // método que adiciona item na casa
    public void addItem(Item item){
    		itens.put(item.getNome(), item);
    }
    
    //método que remove o item da casa
    public void removeItem(String itemName){
    		itens.remove(itemName);
    }
    
    //método que adiciona um personagem na casa
    public void addPersonagem(Personagem personagem){
    		personagens.put(personagem.getNome(), personagem);
    }
    
    //método que remove um personagem da casa
    public void removePersonagem(String name){
    		personagens.remove(name);
    }
    
    //método que retorna o personagem da casa dando uma string nome como parâmetro
    public Personagem getPersonagem(String name){
        return personagens.get(name);
    }
    
    //método que retorna o Item da casa dando uma string nome como parâmetro
    public Item getItem(String name){
        return itens.get(name);
    }
    
}