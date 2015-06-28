package cdz;

import Interface.Interface;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author prestes
 */
public class Jogo {
    
    private Cavaleiro cavaleiro;
    private Parser parser;
    private Casa casaAtual;

    private Item espadaInicial, armaduraInicial, espada1, espada2, espada3, espada4, espada5,
            espada6, espada7, armadura1, armadura2, armadura3, armadura4, armadura5,
            armadura6, armadura7, pocao;

    private CavaleiroDeOuro mu, aldebaran, saga, mascara, aioria, shaka,
            dohko, milo, aioros, shura, camus, afrodite;

    private CavaleiroDePrata marin, misty, babel,
            jamian, algol, algethi, dio,
            sirius, ptolemy, orphee;

    private CavaleiroDeAco sho, daichi, usho;

    private Casa outside, corredorNorte, aries, touro, gemeos, cancer, leao, virgem, libra, escorpiao,
            sagitario, capricornio, aquario, peixes, saori, acos, pratas, mestre, pratas1, pratas2, pratas3, acos1, acos2, acos3;
    
    Interface i = new Interface();
    
    public Jogo() {
        parser = new Parser();
    }

    public void entraLoopJogo() {
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
    }

    public void welcome() {
        System.out.println("Na luta para defender Atena e colocá-la em seu lugar de direito, ");
        System.out.println("os Cavaleiros de Bronze lutam para superar o Mestre do Santuário");
        System.out.println("e os poderosos Cavaleiros de Ouro, guardiões das 12 casas.");
        System.out.println("");
        System.out.println("Você deve escolher um cavaleiro para conquistar seu objetivo.");
        System.out.println("Seiya - Shun - Shiryu - Ikki - Hyoga");
        System.out.println("Digite o nome do seu cavaleiro de bronze:");
    }

    public void createJogo() {

        createItens();
        createCavaleiro();
        i.setIconCavaleiro(cavaleiro);
        createCavaleirosDeOuro();
        createCavaleirosDePrata();
        createCavaleirosDeAco();
        createCasas();
    }

    // método createItems cria os itens do jogo passando como parâmetro 
    // suas características na seguinte ordem:
    // nome   descricao    peso    ataque    armadura    vida   tipo
    // tipo 0 = poção, tipo  1 = arma, tipo 2 = armadura 
    private void createItens() {
        espadaInicial = new Item("Espadinha", "+1 de ataque", 1, 1, 0, 0, 1);
        armaduraInicial = new Item("Armadurinha", "+1 de ataque", 1, 0, 1, 0, 2);
        
        espada1 = new Item("Espada1", "+10 de ataque", 2, 3, 0, 0, 1);
        espada2 = new Item("Espada2", "+10 de ataque", 3, 5, 0, 0, 1);
        espada3 = new Item("Espada3", "+10 de ataque", 5, 8, 0, 0, 1);
        espada4 = new Item("Espada4", "+10 de ataque", 7, 12, 0, 0, 1);
        espada5 = new Item("Espada5", "+10 de ataque", 9, 15, 0, 0, 1);
        espada6 = new Item("Espada6", "+10 de ataque", 12, 18, 0, 0, 1);
        espada7 = new Item("Espada7", "+10 de ataque", 15, 21, 0, 0, 1);
        
        armadura1 = new Item("Armadura1", "+7 de armadura", 2, 0, 2, 0, 2);
        armadura2 = new Item("Armadura2", "+7 de armadura", 3, 0, 4, 0, 2);
        armadura3 = new Item("Armadura3", "+7 de armadura", 5, 0, 6, 0, 2);
        armadura4 = new Item("Armadura4", "+7 de armadura", 7, 0, 8, 0, 2);
        armadura5 = new Item("Armadura5", "+7 de armadura", 9, 0, 10, 0, 2);
        armadura6 = new Item("Armadura6", "+7 de armadura", 12, 0, 12, 0, 2);
        armadura7 = new Item("Armadura7", "+7 de armadura", 15, 0, 15, 0, 2);
        
        pocao = new Item("Pocao", "+20 de vida", 1, 0, 0, 20, 0);
    }

    // método createCavaleirosDeOuro cria os Cavaleiros de Ouro passando 
    //como parâmetro suas características na seguinte ordem:
    // nome   signo   vida   ataque   armadura
    private void createCavaleirosDeOuro() {

        mu = new CavaleiroDeOuro("Mu", "Aries", 100, 40, 5, 1);
        aldebaran = new CavaleiroDeOuro("Aldebaran", "Touro", 100, 40, 39, 1);
        saga = new CavaleiroDeOuro("Saga", "Gêmeos", 100, 40, 54, 1);
        mascara = new CavaleiroDeOuro("Mascara da Morte", "Câncer", 100, 40, 54, 1);
        aioria = new CavaleiroDeOuro("Aioria", "Leão", 100, 40, 54, 1);
        shaka = new CavaleiroDeOuro("Shaka", "Virgem", 100, 40, 54, 1);
        dohko = new CavaleiroDeOuro("Dohko", "Libra", 100, 40, 54, 1);
        milo = new CavaleiroDeOuro("Milo", "Escorpião", 100, 40, 54, 1);
        aioros = new CavaleiroDeOuro("Aioros", "Sagitário", 100, 40, 54, 1);
        shura = new CavaleiroDeOuro("Shura", "Capricórnio", 100, 40, 54, 1);
        camus = new CavaleiroDeOuro("Camus", "Aquário", 100, 40, 54, 1);
        afrodite = new CavaleiroDeOuro("Afrodite", "Peixes", 100, 40, 54, 1);
    }

    // método createCavaleirosDePrata cria os Cavaleiros de Prata passando 
    //como parâmetro suas características na seguinte ordem:
    // nome   tipo   vida   ataque   armadura   
    private void createCavaleirosDePrata() {

        marin = new CavaleiroDePrata("Marin", "Àguia", 100, 40, 54, 1);
        misty = new CavaleiroDePrata("Misty", "Lagarto", 100, 40, 54, 1);
        babel = new CavaleiroDePrata("Babel", "Centauro", 100, 40, 54, 1);
        jamian = new CavaleiroDePrata("Jamian", "Corvo", 100, 40, 54, 1);
        algol = new CavaleiroDePrata("Algol", "Perceu", 100, 40, 54, 1);
        algethi = new CavaleiroDePrata("Algethi", "Hércules", 100, 40, 54, 1);
        dio = new CavaleiroDePrata("Dio", "Mosca", 100, 40, 54, 1);
        sirius = new CavaleiroDePrata("Sirius", "Cão Maior", 100, 40, 54, 1);
        ptolemy = new CavaleiroDePrata("Ptolemy", "Flecha", 100, 40, 54, 1);
        orphee = new CavaleiroDePrata("Orphée", "Lira", 100, 40, 54, 1);

    }

    private void createCavaleirosDeAco() {

        sho = new CavaleiroDeAco("Sho", "Armadura do Céu", 30, 40, 54, 1);
        daichi = new CavaleiroDeAco("Daichi", "Armadura da Terra", 30, 40, 54, 1);
        usho = new CavaleiroDeAco("Ushô", "Armadura do Mar", 30, 40, 54, 1);
    }

    private void createCasas() {

        //cria as casas
        outside = new Casa("outside", "Foi aqui onde você começou o jogo, vá derrotar o Mestre!");
        corredorNorte = new Casa("corredorNorte", "Este é o caminho das 12 casas, devo seguir ao norte para derrotar o Mestre");
        aries = new Casa("aries", "Casa de Àries, a primeira casa das 12");
        touro = new Casa("touro", "Casa de Touro, a segunda casa das 12");
        gemeos = new Casa("gemeos", "Casa de Gêmeos, a terceira casa das 12");
        cancer = new Casa("cancer", "Casa de Câncer a quarta casa das 12");
        leao = new Casa("leao", "Casa de Leão a quinta casa das 12");
        virgem = new Casa("virgem", "Casa de Virgem a sexta casa das 12");
        libra = new Casa("libra", "Casa de Libra a setima casa das 12");
        escorpiao = new Casa("escorpiao", "Casa de Escorpião a oitava casa das 12");
        sagitario = new Casa("sagitario", "Casa de Sagitário a nona casa das 12");
        capricornio = new Casa("capricornio", "Casa de Capricornio a decima casa das 12");
        aquario = new Casa("aquario", "Casa de Aquario a penultima casa das 12");
        peixes = new Casa("peixes", "Casa de Sagitário a ultima casa das 12");
        saori = new Casa("saori", "Casa da Saori. Ela me traz paz. Devo seguir ao norte e derrotar o Mestre!");
        acos = new Casa("acos", "Vila dos Cavaleiros de Aço. Devo derrotá-los antes de seguir em busca do Mestre");
        acos1 = new Casa("acos1", "Casa do Cavaleiro de Aço Shô. Devo derrotá-lo antes de seguir em busca do Mestre");
        acos2 = new Casa("acos2", "Casa do Cavaleiro de Aço Daichi. Devo derrotá-lo antes de seguir em busca do Mestre");
        acos3 = new Casa("acos3", "Casa do Cavaleiro de Aço Ushô. Devo derrotá-los antes de seguir em busca do Mestre");
        pratas = new Casa("pratas", "Vila dos Cavaleiros de Prata. Devo derrotá-los antes de seguir em busca do Mestre");
        pratas1 = new Casa("pratas1", "Casa dos Cavaleiros de Prata do norte. Devo derrotá-los antes de seguir em busca do Mestre");
        pratas2 = new Casa("pratas2", "Casa dos Cavaleiros de Prata do sul. Devo derrotá-los antes de seguir em busca do Mestre");
        pratas3 = new Casa("pratas3", "Casa dos Cavaleiros de Prata do leste. Devo derrotá-los antes de seguir em busca do Mestre");
        mestre = new Casa("mestre", "Casa do Mestre, devo derrota-lo para consquistar meu objetivo");

        // cria a saída das casas
        outside.setExit("norte", corredorNorte);
        outside.setExit("sul", saori);
        outside.setExit("oeste", pratas);
        outside.setExit("leste", acos);

        corredorNorte.setExit("sul", outside);
        corredorNorte.setExit("norte", aries);

        aries.setExit("sul", corredorNorte);
        aries.setExit("norte", touro);

        touro.setExit("sul", aries);
        touro.setExit("norte", gemeos);

        gemeos.setExit("sul", touro);
        gemeos.setExit("norte", cancer);

        cancer.setExit("sul", gemeos);
        cancer.setExit("norte", leao);

        leao.setExit("sul", cancer);
        leao.setExit("norte", virgem);

        virgem.setExit("sul", leao);
        virgem.setExit("norte", libra);

        libra.setExit("sul", virgem);
        libra.setExit("norte", escorpiao);

        escorpiao.setExit("sul", libra);
        escorpiao.setExit("norte", sagitario);

        sagitario.setExit("sul", escorpiao);
        sagitario.setExit("norte", capricornio);

        capricornio.setExit("sul", sagitario);
        capricornio.setExit("norte", aquario);

        aquario.setExit("sul", capricornio);
        aquario.setExit("norte", peixes);

        peixes.setExit("sul", aquario);
        peixes.setExit("leste", mestre);

        mestre.setExit("oeste", peixes);
        mestre.setExit("sul", saori);

        saori.setExit("norte", outside);
        saori.setExit("sul", mestre);

        pratas.setExit("oeste", pratas3);
        pratas.setExit("leste", outside);
        pratas.setExit("norte", pratas1);
        pratas.setExit("sul", pratas2);

        pratas1.setExit("sul", pratas);
        pratas2.setExit("norte", pratas);
        pratas3.setExit("leste", pratas);

        acos.setExit("oeste", outside);
        acos.setExit("norte", acos1);
        acos.setExit("sul", acos2);
        acos.setExit("leste", acos3);

        acos1.setExit("sul", acos);
        acos2.setExit("norte", acos);
        acos3.setExit("oeste", acos);

        //adiciona personagem na casa
        aries.addPersonagem(mu);
        touro.addPersonagem(aldebaran);
        mestre.addPersonagem(saga);
        cancer.addPersonagem(mascara);
        leao.addPersonagem(aioria);
        virgem.addPersonagem(shaka);
        libra.addPersonagem(dohko);
        escorpiao.addPersonagem(milo);
        sagitario.addPersonagem(aioros);
        capricornio.addPersonagem(shura);
        aquario.addPersonagem(camus);
        peixes.addPersonagem(afrodite);

        acos1.addPersonagem(sho);
        acos2.addPersonagem(daichi);
        acos3.addPersonagem(usho);

        pratas1.addPersonagem(marin);
        pratas1.addPersonagem(misty);
        pratas1.addPersonagem(babel);

        pratas2.addPersonagem(jamian);
        pratas2.addPersonagem(algol);
        pratas2.addPersonagem(algethi);

        pratas3.addPersonagem(sirius);
        pratas3.addPersonagem(ptolemy);
        pratas3.addPersonagem(orphee);

        //adiciona item na casa
        saori.addItem(pocao);
        saori.addItem(espada1);
        outside.addItem(pocao);
        outside.addItem(armadura1);
        
        casaAtual = outside;  // start game outside

    }

     // método createCavaleiro cria o cavaleiro passando como parâmetro 
    // suas características na seguinte ordem:
    // nome    vida     ataque    armadura    limiteDePeso    pesoMochila    moedas
    public void createCavaleiro() {
        String nome;
        Scanner input = new Scanner(System.in);
        nome = input.nextLine();

        switch (nome) {
            case "Seiya":
                System.out.print("Seu cavaleiro é Seiya\n");
                cavaleiro = new Cavaleiro("Seiya", 100, 20, 7, 100, 0, 0, espadaInicial, armaduraInicial);
                break;
            case "Shun":
                System.out.print("Seu Cavaleiro é Shun\n");
                cavaleiro = new Cavaleiro("Shun", 100, 20, 7, 100, 0, 0, espadaInicial, armaduraInicial);
                break;
            case "Shiryu":
                System.out.print("Seu Cavaleiro é Shiryu\n");
                cavaleiro = new Cavaleiro("Shiryu", 100, 20, 7, 100, 0, 0, espadaInicial, armaduraInicial);
                break;
            case "Hyoga":
                System.out.print("Seu Cavaleiro é Hyoga\n");
                cavaleiro = new Cavaleiro("Hyoga", 100, 20, 7, 100, 0, 0, espadaInicial, armaduraInicial);
                break;
            case "Ikki":
                System.out.print("Seu Cavaleiro é Ikki\n");
                cavaleiro = new Cavaleiro("Ikki", 100, 20, 7, 100, 0, 0, espadaInicial, armaduraInicial);
                break;
            default:
                System.out.println("Digite o nome do seu cavaleiro de bronze:");
                createCavaleiro();
                break;
        }
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("Não entendi o que você falou");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goCasa(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.CAVALEIRO) {
            printEstadoCavaleiro();
        } else if (commandWord == CommandWord.OLHAR) {
            System.out.println();
            System.out.println(casaAtual.getLongDescription());
        } else if (commandWord == CommandWord.ATACAR) {
            atacarAlguem(command);
        } else if (commandWord == CommandWord.INIMIGOS) {
            showInimigos(command);
        } else if (commandWord == CommandWord.PEGAR) {
            pegarItem(command);
        } else if (commandWord == CommandWord.USAR) {
            usarItem(command);
        } else if (commandWord == CommandWord.SOLTAR) {
            soltarItem(command);
        }

        // else command not recognised.
        return wantToQuit;
    }

    public void printEstadoCavaleiro() {
        cavaleiro.imprimir();
        cavaleiro.mostraInventario();
    }

    public void printHelp() {
        System.out.println("Você está um pouco perdido. Vá derrotar o Mestre!");
        System.out.println();
        System.out.println("Seus Comandos são:");
        parser.showCommands();
    }

    private void goCasa(Command command) {
        if (!command.hasSecondWord()) {
            // Se não tiver uma segunda palavra não se sabe onde ir
            System.out.println("Ir onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Sai da casa atual
        Casa nextRoom = casaAtual.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Não há saídas por este lado");
        } else {
            casaAtual = nextRoom;
            i.goIconCavaleiro(casaAtual);
            System.out.println(casaAtual.getLongDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    public void atacarAlguem(Command command) {

        if (!command.hasSecondWord()) {
            // Se não tiver uma segunda palavra não se sabe quem atacar
            System.out.println("Atacar quem?");
            return;
        }

        String name = command.getSecondWord();

        Personagem inimigo = casaAtual.getCharacter(name);

        if (inimigo == null) {
            System.out.println("Você tem certeza que é esse o nome?");
        } else {
            cavaleiro.lutar(cavaleiro, inimigo);
            cavaleiro.imprimir();
            casaAtual.removeCharacter(name);

        }
    }

    public void pegarItem(Command command) {

        if (!command.hasSecondWord()) {
            // Se não tiver uma segunda palavra, não se sabe o que pegar
            System.out.println("Pegar o que?");
            return;
        }

        String name = command.getSecondWord();

        Item item = casaAtual.getItem(name);

        if (item == null) {
            System.out.println("Você tem certeza que é esse o nome?");

        } else {
            cavaleiro.adicionaItem(item);
            casaAtual.removeItem(name);
        }
    }

    public void soltarItem(Command command) {
        if (!command.hasSecondWord()) {
            // Se não tiver uma segunda palavra, não se sabe o que soltar
            System.out.println("Soltar o que?");
            return;
        }

        String name = command.getSecondWord();

        Item item = cavaleiro.buscarItem(name);

        if (item == null) {
            System.out.println("Você tem certeza que é esse o nome?");

        } else {
            cavaleiro.removeItem(item);
            casaAtual.addItem(item);

        }
    }

    public void usarItem(Command command) {
        if (!command.hasSecondWord()) {
            // Se não tiver uma segunda palavra não se sabe quem atacar
            System.out.println("Usar o que?");
            return;
        }

        String name = command.getSecondWord();

        Item item = cavaleiro.buscarItem(name);

        if (item == null) {
            System.out.println("Você tem certeza que é esse o nome?");
        } else {
            if (item.getTipo() == 1) {
                cavaleiro.removeArmaCavaleiro();
                cavaleiro.botaArmaCavaleiro(item);
                System.out.println("Novo item equipado");
            }
            if (item.getTipo() == 2) {
                cavaleiro.removeArmaduraCavaleiro();
                cavaleiro.botaArmaduraCavaleiro(item);
                System.out.println("Novo item equipado");
                
            }
            if (item.getTipo() == 0) {
                cavaleiro.botaPocaoCavaleiro(item);
                if (cavaleiro.getVida() >= 100){
                    System.out.println("Sua vida está cheia");
                    cavaleiro.setVida(100);
                }
                else{
                    System.out.println("Sua vida foi aumentada");
                }
            }
        }
    }

    public void showInimigos(Command command) {
        if (casaAtual == outside) {
            System.out.println("Não há inimigos aqui! Vá derrotar o Mestre!");
        }
        if (casaAtual == saori) {
            System.out.println("Saori não é inimiga! Vá derrotar o Mestre!");
        }
        if (casaAtual == aries) {
            mu.imprimir();
        }
        if (casaAtual == touro) {
            aldebaran.imprimir();
        }
        if (casaAtual == gemeos) {
            saga.imprimir();
        }
        if (casaAtual == cancer) {
            mascara.imprimir();
        }
        if (casaAtual == leao) {
            aioria.imprimir();
        }
        if (casaAtual == virgem) {
            shaka.imprimir();
        }
        if (casaAtual == libra) {
            dohko.imprimir();
        }
        if (casaAtual == escorpiao) {
            milo.imprimir();
        }
        if (casaAtual == sagitario) {
            aioros.imprimir();
        }
        if (casaAtual == capricornio) {
            shura.imprimir();
        }
        if (casaAtual == aquario) {
            camus.imprimir();
        }
        if (casaAtual == peixes) {
            afrodite.imprimir();
        }
    }

    public void play() {
        welcome();
        i.setVisible(true);
        createJogo();
        entraLoopJogo();
        System.out.println("Thanks for playing");

    }
}
