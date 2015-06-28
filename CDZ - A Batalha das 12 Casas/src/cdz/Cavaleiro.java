package cdz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author prestes
 */
public class Cavaleiro extends Personagem{
    
    private int limiteDePeso;
    private int pesoMochila; 
    private ArrayList<Item> inventario;
    private Item itemArma;
    private Item itemArmadura;
    private static final int VIDA_MAXIMA = 1000;
    
    public Cavaleiro(String nome, int vida, int ataque, int armadura, int limiteDePeso, int pesoMochila, int moedas, Item itemArma, Item itemArmadura){
        super(nome, vida, ataque, armadura, moedas);
        this.limiteDePeso = limiteDePeso;
        this.pesoMochila = pesoMochila;
        inventario = new ArrayList<Item> ();
        this.itemArma = itemArma;
        this.itemArmadura = itemArmadura;
        
    }
    
    public int getLimiteDePeso(){
        return limiteDePeso;
    }
    public void setLimiteDePeso(int limiteDePeso){
        this.limiteDePeso = limiteDePeso;
    }
    public int getPesoMochila(){
        return calcularPeso();
    }
    public void setPesoMochila(int pesoMochila){
        this.pesoMochila = pesoMochila;
    }
    public Item getItemArma(){
        return itemArma; 
    }
    public Item getItemArmadura(){
        return itemArmadura; 
    }
    public void setItemArma(Item itemArma){
        this.itemArma = itemArma;
    }
    public void setItemArmadura(Item itemArmadura){
        this.itemArmadura = itemArmadura;
    }
    public int getPesoMoedas(){
        int pesoMoedas;
        pesoMoedas = (getMoedas()/1000) + 1;
        return pesoMoedas;
    }
   
    //calcula o peso do inventario
    public int calcularPeso(){
    		int carga = 0;
    		for (Item item : inventario){
    			carga += item.getPeso();
    		}
                carga += getPesoMoedas();
                setPesoMochila(carga);
    		return carga;
    }
    
    //adiciona item no inventario
    public void adicionaItem(Item item){
                int carga;
    		if (calcularPeso() + item.getPeso() <= limiteDePeso){
    			inventario.add(item);
                        carga = calcularPeso() + item.getPeso();
                        setPesoMochila(carga); 
                }
    		else
    			System.out.println("O Cavaleiro '"+getNome()+"' não pode carregar mais itens!");
    }
    
    //remove item do inventario
    public void removeItem(Item item){	
        inventario.remove(item); 		
    }
    
    // busca item no inventaio
    Item buscarItem(String nomeItem){
    		for (Item item : inventario){
    			if (item.getNome().equals(nomeItem))
    				return item;
    		}
    		return null;
    }
    
    //pega o item do inventario e coloca no cavaleiro
    public void botaArmaCavaleiro(Item item){
        int ataque;
        ataque = item.getAtaque() + getAtaque();
        setAtaque(ataque);
        setItemArma(item);
        inventario.remove(item);
    }
    
    public void botaArmaduraCavaleiro(Item item){
        int armadura;
        armadura = item.getArmadura() + getArmadura();
        setArmadura(armadura);
        setItemArmadura(item);
        inventario.remove(item);
    }
    
    public void botaPocaoCavaleiro(Item item){
       int vida;
       vida = item.getVida() + getVida();
       setVida(vida);
       inventario.remove(item);
    }
    //
    
    //Remove a arma atual do cavaleiro e bota no inventario
    public void removeArmaCavaleiro(){
        int ataque;
        Item item = getItemArma();
        ataque = getAtaque() - item.getAtaque();
        setAtaque(ataque);
        inventario.add(item);
    }
    public void removeArmaduraCavaleiro(){
        int armadura;
        Item item = getItemArmadura();
        armadura = getArmadura() - item.getArmadura();
        setArmadura(armadura);
        inventario.add(item);
    }
    
    public String mostraInventario(){
        StringBuffer itens = new StringBuffer();
        for (Item item : inventario){
            itens.append(item.getNome() + " ");   
        }
        return itens.toString();     
    }
    
    public void lutar(Personagem cavaleiro, Personagem oponente){
        int vidaCavaleiro = cavaleiro.getVida();
        int vidaOponente = oponente.getVida();
        int ataqueCavaleiro = cavaleiro.getAtaque();
        int ataqueOponente = oponente.getAtaque();
        int armaduraCavaleiro = cavaleiro.getArmadura();
        int armaduraOponente = oponente.getArmadura();
        int moedasCavaleiro = cavaleiro.getMoedas();
        int moedasOponente = oponente.getMoedas();
        
        while(cavaleiro.getVida() > 0 && oponente.getVida() > 0){
                    
            vidaOponente += armaduraOponente - ataqueCavaleiro; 
            if (ataqueCavaleiro > armaduraOponente)
                oponente.setVida(vidaOponente);
            vidaCavaleiro += armaduraCavaleiro - ataqueOponente; 
            if (ataqueOponente > armaduraCavaleiro)
                cavaleiro.setVida(vidaCavaleiro);         
        }
        
        if (cavaleiro.getVida() > 0){
            System.out.println("Você derrotou o inimigo e ganhou " + moedasOponente + " moedas");
            System.out.println("");
            if (moedasOponente/1000 + 1  + getPesoMochila() <= limiteDePeso){
                moedasCavaleiro += moedasOponente;
                cavaleiro.setMoedas(moedasCavaleiro);
            }
            else
                System.out.println("Seu inventário está lotado, se desfaça de itens para ganhar mais moedas");          
        }
        else{
            System.out.println("Você foi Derrotado");
            System.out.println("GAME OVER");
            System.out.println("");             
        }
    } 
    
    public String imprimir(){
        System.out.println("#########################################");
        System.out.println("# Tipo do Personagem: Cavaleiro de Bronze");
        System.out.println("# Nome: "+ getNome() );
        System.out.println("# Vida: "+ getVida()); 
        System.out.println("# Ataque: "+ getAtaque());
        System.out.println("# Armadura: "+ getArmadura());
        System.out.println("# Arma: "+ itemArma.getNome() + " Armadura: " + itemArmadura.getNome());
        System.out.println("# Moedas: "+ getMoedas());
        System.out.println("# Inventario: Peso:"+ getPesoMochila() + " Itens: " +  mostraInventario());
        System.out.println("#########################################");
        return ("#########################################");        
    }
        
}

