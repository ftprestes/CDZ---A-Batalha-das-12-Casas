package cdz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prestes
 */
public class CavaleiroDePrata extends Personagem{
    
    private String tipo;
    
    public CavaleiroDePrata(String nome, String tipo, int vida, int ataque, int armadura, int moedas) {
        super(nome, vida, ataque, armadura, moedas);
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }   
    
    public String imprimir(){
    System.out.println("#########################################");
    System.out.println("# Tipo do Personagem: Cavaleiro de Ouro");
    System.out.println("# Nome: "+ getNome() );
    System.out.println("# Cavaleiro de"+ getTipo() );
    System.out.println("# Vida: "+ getVida()); 
    System.out.println("# Ataque: "+ getAtaque());
    System.out.println("# Armadura: "+ getArmadura());
    System.out.println("#########################################");
    return ("#########################################");        
    }
    
    
}
