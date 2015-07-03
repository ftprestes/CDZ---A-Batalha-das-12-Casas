package cdz;

/**
 *
 * @author prestes
 */
public class Personagem {
    
    private int moedas;
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;
    
    public Personagem(String nome, int vida, int ataque, int armadura, int moedas){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
        this.moedas = moedas;
    }
    
    public int getVida(){
        return vida;
    }
    public String getNome(){
        return nome;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getArmadura(){
        return armadura;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    public void setArmadura(int armadura){
        this.armadura = armadura;
    }  
    public int getMoedas(){
        return moedas;
    }
    public void setMoedas(int moedas){
        this.moedas = moedas;
    }
}
