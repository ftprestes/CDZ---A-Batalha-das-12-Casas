package cdz;

/**
 *
 * @author prestes
 */
public class Item {

    private String nome;
    private String descricao;
    private int peso;
    private int unidade;
    private int tipo;

    public Item(String nome, String descricao, int peso, int unidade, int tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.unidade = unidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPeso() {
        return peso;
    }

    public int getAtaque() {
        return unidade;
    }

    public int getArmadura() {
        return unidade;
    }

    public int getVida() {
        return unidade;
    }

    public int getTipo() {
        return tipo;
    }

}
