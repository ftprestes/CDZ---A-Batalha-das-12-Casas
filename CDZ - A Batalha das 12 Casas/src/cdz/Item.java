package cdz;

public class Item {
	private String nome;
	private String descricao;
	private int peso;
        private int ataque;
        private int armadura;
        private int vida;
        private int tipo;
	
	public Item (String nome, String descricao, int peso, int ataque, int armadura, int vida , int tipo)
	{
		this.nome = nome;
		this.descricao = descricao;
		this.peso = peso;
                this.ataque = ataque;
                this.armadura = armadura;
                this.vida = vida;
                this.tipo = tipo;
	}
	
	public String getNome(){
		return nome;
	}

	public String getDescricao(){
		return descricao;
	}
	
	public int getPeso(){
		return peso;
	}
        
        public int getAtaque(){
            return ataque;
        } 
        
        public int getArmadura(){
            return armadura;
        }
        
        public int getVida(){
            return vida;
        }
        public int getTipo(){
            return tipo;
        }

}