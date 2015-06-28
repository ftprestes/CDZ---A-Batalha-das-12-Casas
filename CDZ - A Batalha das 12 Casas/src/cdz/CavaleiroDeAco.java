package cdz;

/**
 *
 * @author prestes
 */
public class CavaleiroDeAco extends Personagem {
    String arma;
    
    public CavaleiroDeAco(String nome, String arma, int vida, int ataque, int armadura, int moedas){
        super(nome, vida, ataque, armadura, moedas);
        this.arma = arma;
        
    }
    
    public String getArma(){
        return arma;
    }
    
    public String imprimir(){
        System.out.println("#########################################");
        System.out.println("# Tipo do Personagem: Cavaleiro de Aço");
        System.out.println("# Nome: "+ getNome() );
        System.out.println("# Cavaleiro da casa : "+ getArma() );
        System.out.println("# Vida: "+ getVida()); 
        System.out.println("# Ataque: "+ getAtaque());
        System.out.println("# Armadura: "+ getArmadura());
        System.out.println("#########################################");
        return ("#########################################");        
    }
}