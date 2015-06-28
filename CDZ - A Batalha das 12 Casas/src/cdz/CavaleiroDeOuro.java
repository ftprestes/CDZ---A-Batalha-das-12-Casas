package cdz;

/**
 *
 * @author prestes
 */
public class CavaleiroDeOuro extends Personagem {
    String signo;
    
    public CavaleiroDeOuro(String nome, String signo, int vida, int ataque, int armadura, int moedas){
        super(nome, vida, ataque, armadura, moedas);
        this.signo = signo;
        
    }
    
    public String getSigno(){
        return signo;
    }
    
    public String imprimir(){
        System.out.println("#########################################");
        System.out.println("# Tipo do Personagem: Cavaleiro de Ouro");
        System.out.println("# Nome: "+ getNome() );
        System.out.println("# Cavaleiro da casa : "+ getSigno() );
        System.out.println("# Vida: "+ getVida()); 
        System.out.println("# Ataque: "+ getAtaque());
        System.out.println("# Armadura: "+ getArmadura());
        System.out.println("#########################################");
        return ("#########################################");        
    }
}