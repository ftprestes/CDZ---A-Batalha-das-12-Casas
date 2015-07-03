package cdz;

import static java.lang.System.exit;
import java.util.ArrayList;

/**
 *
 * @author prestes
 */
public class Cavaleiro extends Personagem {

    private int limiteDePeso = 100, level = 0, pesoMochila = 0, cavaleirosAbatidos = 0;
    private ArrayList<Item> inventario;
    private Item itemArma, itemArmadura;
    
    //construtor do cavaleiro foi feito com o objetivo de ter a liberdade na hora de criação do cavaleiro
    //de setar seus atributos com que eles tenham características diferentes
    public Cavaleiro(String nome, int vida, int ataque, int armadura, int moedas, Item itemArma, Item itemArmadura) {
        super(nome, vida, ataque, armadura, moedas);
        this.pesoMochila = pesoMochila;
        inventario = new ArrayList<Item>();
        this.itemArma = itemArma;
        this.itemArmadura = itemArmadura;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCavaleirosAbatidos() {
        return cavaleirosAbatidos;
    }

    public void setCavaleirosAbatidos(int cavaleirosAbatidos) {
        this.cavaleirosAbatidos = cavaleirosAbatidos;
    }

    public int getLimiteDePeso() {
        return limiteDePeso;
    }

    public void setLimiteDePeso(int limiteDePeso) {
        this.limiteDePeso = limiteDePeso;
    }

    public int getPesoMochila() {
        return calcularPeso();
    }

    public void setPesoMochila(int pesoMochila) {
        this.pesoMochila = pesoMochila;
    }

    public Item getItemArma() {
        return itemArma;
    }

    public Item getItemArmadura() {
        return itemArmadura;
    }

    public void setItemArma(Item itemArma) {
        this.itemArma = itemArma;
    }

    public void setItemArmadura(Item itemArmadura) {
        this.itemArmadura = itemArmadura;
    }

    //método que aumenta o level, armadura e ataque do cavaleiro caso ele mude seu level
    //ele aumenta o level em +1 cada vez que derrota 3 inimigos
    public void checaLevel() {
        if ((getCavaleirosAbatidos() >= 3) && (getCavaleirosAbatidos() % 3 == 0)) {
            setLevel(getLevel() + 1);
            setAtaque(getAtaque() + 2);
            setArmadura(getArmadura() + 1);
        }
    }

    //método que faz o calculo e retorna o peso das moedas
    public int getPesoMoedas() {
        int pesoMoedas;
        if(getMoedas() == 0)
            return 0;
        else
        pesoMoedas = (getMoedas() / 100) + 1;
        return pesoMoedas;
    }

    //método que calcula e retorna o peso do inventario
    public int calcularPeso() {
        int carga = 0;
        for (Item item : inventario) {
            carga += item.getPeso();
        }
        carga += getPesoMoedas();
        setPesoMochila(carga);
        return carga;
    }

    //método que adiciona um item no inventario
    public void adicionaItem(Item item) {
        int carga;
        if (calcularPeso() + item.getPeso() <= limiteDePeso) {
            inventario.add(item);
            carga = calcularPeso() + item.getPeso();
            setPesoMochila(carga);
        } else {
            System.out.println("O Cavaleiro '" + getNome() + "' não pode carregar mais itens!");
        }
    }

    //remove item do inventario
    public void removeItem(Item item) {
        inventario.remove(item);
    }

    // busca item no inventaio
    Item buscarItem(String nomeItem) {
        for (Item item : inventario) {
            if (item.getNome().equals(nomeItem)) {
                return item;
            }
        }
        return null;
    }

    //método que pega o item do tipo arma do inventario e coloca no cavaleiro
    public void botaArmaCavaleiro(Item item) {
        int ataque;
        ataque = item.getAtaque() + getAtaque();
        setAtaque(ataque);
        setItemArma(item);
        inventario.remove(item);
    }

    //método que pega o item do tipo armadura do inventario e coloca no cavaleiro
    public void botaArmaduraCavaleiro(Item item) {
        int armadura;
        armadura = item.getArmadura() + getArmadura();
        setArmadura(armadura);
        setItemArmadura(item);
        inventario.remove(item);
    }

    //método que pega o item do tipo poção do inventario e coloca no cavaleiro
    public void botaPocaoCavaleiro(Item item) {
        int vida;
        vida = item.getVida() + getVida();
        setVida(vida);
        inventario.remove(item);
    }

    //método que remove a arma atual do cavaleiro e bota no inventario
    public void removeArmaCavaleiro() {
        int ataque;
        Item item = getItemArma();
        ataque = getAtaque() - item.getAtaque();
        setAtaque(ataque);
        inventario.add(item);
    }
    
    //método que remove a armadura atual do cavaleiro e bota no inventario
    public void removeArmaduraCavaleiro() {
        int armadura;
        Item item = getItemArmadura();
        armadura = getArmadura() - item.getArmadura();
        setArmadura(armadura);
        inventario.add(item);
    }
    
    //método que mostra todos os itens do inventario do cavaleiro
    public String mostraInventario() {
        StringBuffer itens = new StringBuffer();
        for (Item item : inventario) {
            itens.append(item.getNome() + " ");
        }
        return itens.toString();
    }
    
    //método em que um cavaleiro luta com um oponente;
    //o método trava as batalhas no while e só sai deste caso uma das vidas(cavaleiro ou oponente)
    //seja menor ou igual a 0.
    //caso o oponente seja o derrotado, o cavaleiro pega as moedas do oponente,
    //o contador de cavaleleiros abatidos do cavaleiro é aumentado e é executado o método
    //checaLevel para aumentar ou não o nível do cavaleiro
    //caso o cavaleiro seja derrotado termina o jogo
    public void lutar(Personagem cavaleiro, Personagem oponente) {
        int vidaCavaleiro = cavaleiro.getVida();
        int vidaOponente = oponente.getVida();
        int ataqueCavaleiro = cavaleiro.getAtaque();
        int ataqueOponente = oponente.getAtaque();
        int armaduraCavaleiro = cavaleiro.getArmadura();
        int armaduraOponente = oponente.getArmadura();
        int moedasCavaleiro = cavaleiro.getMoedas();
        int moedasOponente = oponente.getMoedas();

        while (cavaleiro.getVida() > 0 && oponente.getVida() > 0) {

            vidaOponente += armaduraOponente - ataqueCavaleiro;
            if (ataqueCavaleiro > armaduraOponente) {
                oponente.setVida(vidaOponente);
            }
            vidaCavaleiro += armaduraCavaleiro - ataqueOponente;
            if (ataqueOponente > armaduraCavaleiro) {
                cavaleiro.setVida(vidaCavaleiro);
            }
        }

        if (cavaleiro.getVida() > 0) {
            System.out.println("Você derrotou o inimigo e ganhou " + moedasOponente + " moedas");
            System.out.println("");
            oponente.setVida(0);
            setCavaleirosAbatidos(getCavaleirosAbatidos() + 1);
            checaLevel();
            if (moedasOponente / 1000 + 1 + getPesoMochila() <= limiteDePeso) {
                moedasCavaleiro += moedasOponente;
                cavaleiro.setMoedas(moedasCavaleiro);
                oponente.setMoedas(0);
            } else {
                System.out.println("Seu inventário está lotado, se desfaça de itens para ganhar mais moedas");
            }
        } else {
            cavaleiro.setVida(0);
            cavaleiro.setMoedas(0);
            System.out.println("Você foi Derrotado");
            System.out.println("GAME OVER");
            exit(0);
        }
    }
    
    //método que imprime o estado atual do cavaleiro
    public String imprimir() {
        System.out.println("#########################################");
        System.out.println("# Tipo do Personagem: Cavaleiro de Bronze");
        System.out.println("# Nome: " + getNome());
        System.out.println("# Level: " + getLevel());
        System.out.println("# Vida: " + getVida());
        System.out.println("# Ataque: " + getAtaque());
        System.out.println("# Armadura: " + getArmadura());
        System.out.println("# Arma: " + itemArma.getNome() + " Armadura: " + itemArmadura.getNome());
        System.out.println("# Moedas: " + getMoedas());
        System.out.println("# Inventario: Peso:" + getPesoMochila() + " Itens: " + mostraInventario());
        System.out.println("#########################################");
        return ("#########################################");
    }

}
