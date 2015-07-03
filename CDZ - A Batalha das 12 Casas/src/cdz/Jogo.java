package cdz;

import Interface.Interface;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author prestes
 */
public class Jogo {

    private Cavaleiro cavaleiro;
    private Parser parser;
    private Interface i;
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

    public Jogo() {
        parser = new Parser();
        i = new Interface();
    }
    
    // o método invoca os métodos de criação do jogo(Itens, Cavaleiros e Casas).
    // é aqui também que é setado o icone do cavaleiro com o método setIconCavaleiro da classse Interface
    public void createJogo() {

        createItens();
        createCavaleiro();
        i.setIconCavaleiro(cavaleiro);
        createCavaleirosDeOuro();
        createCavaleirosDePrata();
        createCavaleirosDeAco();
        createCasas();
    }
    
    //método que mantem o jogo no loop
    //método invoca o método testaCasa, que testará se o herói pode seguir com o objetivo
    public void entraLoopJogo() {
        
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            testaCasa();
        }
    }
    
    //método que printa o welcome do jogo
    public void welcome() {
        System.out.println("Na luta para defender Atena e colocá-la em seu lugar de direito, ");
        System.out.println("os Cavaleiros de Bronze lutam para superar o Mestre do Santuário");
        System.out.println("e os poderosos Cavaleiros de Ouro, guardiões das 12 casas.");
        System.out.println("");
        System.out.println("O jogo é livre, a opção de ir em qualquer casa é válida, porém");
        System.out.println("é sugerido que o jogador se fortaleça para ir em busca de seu");
        System.out.println("objetivo. O jogador se fortalece destruindo os inimigos e pegando");
        System.out.println("os itens das casas.");
        System.out.println("Os cavaleiros de Aço ao leste são os mais vulneráveis, seguido dos cavaleiros");
        System.out.println("de prata ao oeste e após os cavaleiros de ouro ao norte, os mais fortes.");
        System.out.println("Além disso, SOMENTE será possível avançar nas casas ao norte se o inimigo");
        System.out.println("de cada casa for derrotado.");
        System.out.println("");
        System.out.println("Após escolher seu cavaleiro, digite 'help' para conhecer suas opções.");
        System.out.println("Você deve escolher um cavaleiro para conquistar seu objetivo.");
        System.out.println("Seiya - Shun - Shiryu - Ikki - Hyoga");
        System.out.println("Digite o nome do seu cavaleiro de bronze:");
    }

    // método createItems cria os itens do jogo passando como parâmetro 
    // suas características na seguinte ordem:
    // nome   descricao    peso    ataque    armadura    vida   tipo
    // tipo 0 = poção, tipo  1 = arma, tipo 2 = armadura 
    private void createItens() {
        espadaInicial = new Item("Espadinha", "+0 de ataque", 1, 0, 1);
        armaduraInicial = new Item("Armadurinha", "+0 de ataque", 1, 0, 2);

        espada1 = new Item("Espada1", "+3 de ataque", 2, 3, 1);
        espada2 = new Item("Espada2", "+5 de ataque", 3, 5, 1);
        espada3 = new Item("Espada3", "+8 de ataque", 5, 8, 1);
        espada4 = new Item("Espada4", "+12 de ataque", 7, 12, 1);
        espada5 = new Item("Espada5", "+15 de ataque", 9, 15, 1);
        espada6 = new Item("Espada6", "+18 de ataque", 12, 18, 1);
        espada7 = new Item("Espada7", "+21 de ataque", 15, 21, 1);

        armadura1 = new Item("Armadura1", "+2 de armadura", 2, 2, 2);
        armadura2 = new Item("Armadura2", "+4 de armadura", 3, 4, 2);
        armadura3 = new Item("Armadura3", "+6 de armadura", 5, 6, 2);
        armadura4 = new Item("Armadura4", "+8 de armadura", 7, 8, 2);
        armadura5 = new Item("Armadura5", "+10 de armadura", 9,10, 2);
        armadura6 = new Item("Armadura6", "+12 de armadura", 12, 12, 2);
        armadura7 = new Item("Armadura7", "+15 de armadura", 15, 15, 2);

        pocao = new Item("Pocao", "+20 de vida", 4, 20, 0);
    }

    // método createCavaleirosDeOuro cria os Cavaleiros de Ouro passando 
    //como parâmetro suas características na seguinte ordem:
    // nome   signo   vida   ataque   armadura   moedas
    private void createCavaleirosDeOuro() {

        mu = new CavaleiroDeOuro("Mu", "Aries", 50, 24, 10, 30);
        aldebaran = new CavaleiroDeOuro("Aldebaran", "Touro", 50, 25, 11, 32);
        saga = new CavaleiroDeOuro("Saga", "Gêmeos", 100, 37, 12, 100);
        mascara = new CavaleiroDeOuro("Mascara", "Câncer", 100, 28, 12, 33);
        aioria = new CavaleiroDeOuro("Aioria", "Leão", 50, 28, 12, 35);
        shaka = new CavaleiroDeOuro("Shaka", "Virgem", 50, 29, 14, 38);
        dohko = new CavaleiroDeOuro("Dohko", "Libra", 60, 30, 15, 40);
        milo = new CavaleiroDeOuro("Milo", "Escorpião", 60, 32, 15, 43);
        aioros = new CavaleiroDeOuro("Aioros", "Sagitário", 60, 32, 16, 45);
        shura = new CavaleiroDeOuro("Shura", "Capricórnio", 60, 32, 17, 47);
        camus = new CavaleiroDeOuro("Camus", "Aquário", 70, 40, 18, 50);
        afrodite = new CavaleiroDeOuro("Afrodite", "Peixes", 70, 35, 20, 60);

    }

    // método createCavaleirosDePrata cria os Cavaleiros de Prata passando 
    //como parâmetro suas características na seguinte ordem:
    // nome   tipo   vida   ataque   armadura   moedas
    private void createCavaleirosDePrata() {

        marin = new CavaleiroDePrata("Marin", "Àguia", 40, 17, 8, 20);
        misty = new CavaleiroDePrata("Misty", "Lagarto", 40, 17, 8, 22);
        babel = new CavaleiroDePrata("Babel", "Centauro", 40, 18, 8, 23);
        jamian = new CavaleiroDePrata("Jamian", "Corvo", 40, 18, 9, 22);
        algol = new CavaleiroDePrata("Algol", "Perceu", 40, 19, 9, 25);
        algethi = new CavaleiroDePrata("Algethi", "Hércules", 40, 19, 8, 22);
        dio = new CavaleiroDePrata("Dio", "Mosca", 40, 19, 9, 21);
        sirius = new CavaleiroDePrata("Sirius", "Cão Maior", 40, 18, 9, 23);
        ptolemy = new CavaleiroDePrata("Ptolemy", "Flecha", 40, 19, 7, 24);
        orphee = new CavaleiroDePrata("Orphée", "Lira", 40, 19, 8, 25);

    }
    
    // método createCavaleirosDePrata cria os Cavaleiros de Aço passando 
    // como parâmetro suas características na seguinte ordem:
    // nome   arma   vida   ataque   armadura   moedas
    private void createCavaleirosDeAco() {

        sho = new CavaleiroDeAco("Sho", "Armadura do Céu", 30, 15, 7, 13);
        daichi = new CavaleiroDeAco("Daichi", "Armadura da Terra", 30, 16, 6, 15);
        usho = new CavaleiroDeAco("Ushô", "Armadura do Mar", 30, 17, 6, 16);
    }
    
    //método que cria as casas, cria suas saídas e cria os personagens e itens em cada casa 
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
        
        touro.setExit("sul", aries);
        
        gemeos.setExit("sul", touro);
       
        cancer.setExit("sul", gemeos);  

        leao.setExit("sul", cancer);

        virgem.setExit("sul", leao);

        libra.setExit("sul", virgem);

        escorpiao.setExit("sul", libra);

        sagitario.setExit("sul", escorpiao);

        capricornio.setExit("sul", sagitario);

        aquario.setExit("sul", capricornio);

        peixes.setExit("sul", aquario);

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
        acos1.addItem(espada2);
        acos2.addItem(armadura2);
        pratas2.addItem(espada3);
        pratas3.addItem(armadura3);
        touro.addItem(espada4);
        aries.addItem(armadura4);
        gemeos.addItem(pocao);
        leao.addItem(armadura5);
        virgem.addItem(espada5);
        escorpiao.addItem(espada6);
        sagitario.addItem(armadura6);
        aquario.addItem(armadura7);
        peixes.addItem(espada7);
        mestre.addItem(pocao);
        acos.addItem(pocao);
        pratas.addItem(pocao);
        pratas1.addItem(pocao);
        corredorNorte.addItem(pocao);
        touro.addItem(pocao);
        leao.addItem(pocao);
        virgem.addItem(pocao);
        sagitario.addItem(pocao);
        peixes.addItem(pocao);
        libra.addItem(pocao);
        aquario.addItem(pocao);

        casaAtual = outside;  // start game outside

    }

    // método createCavaleiro cria o cavaleiro passando como parâmetro 
    // suas características na seguinte ordem:
    // nome   vida    ataque    armadura   moedas   armaInicial e armaduraInicial
    // Conforme consta na Classe Cavaleiro, o seu construtor foi criado dessa forma para dar liberdade
    // de mudar as características dos cavaleiros(heróis) do jeito que for necessessário
    public void createCavaleiro() {
        String nome;
        Scanner input = new Scanner(System.in);
        nome = input.nextLine();

        switch (nome) {
            case "Seiya":
                System.out.print("Seu cavaleiro é Seiya\n");
                cavaleiro = new Cavaleiro("Seiya", 100, 20, 7, 0, espadaInicial, armaduraInicial);
                break;
            case "Shun":
                System.out.print("Seu Cavaleiro é Shun\n");
                cavaleiro = new Cavaleiro("Shun", 100, 20, 7, 0, espadaInicial, armaduraInicial);
                break;
            case "Shiryu":
                System.out.print("Seu Cavaleiro é Shiryu\n");
                cavaleiro = new Cavaleiro("Shiryu", 100, 20, 7, 0, espadaInicial, armaduraInicial);
                break;
            case "Hyoga":
                System.out.print("Seu Cavaleiro é Hyoga\n");
                cavaleiro = new Cavaleiro("Hyoga", 100, 20, 7, 0, espadaInicial, armaduraInicial);
                break;
            case "Ikki":
                System.out.print("Seu Cavaleiro é Ikki\n");
                cavaleiro = new Cavaleiro("Ikki", 100, 20, 7, 0, espadaInicial, armaduraInicial);
                break;
            default:
                System.out.println("Digite o nome do seu cavaleiro de bronze:");
                createCavaleiro();
                break;
        }
    }
    
    //método que testa a vida dos cavaleiros de Ouro
    //o objetivo do método é não deixar o herói seguir seu objetivo antes de derrotar o inimigo da casa
    private void testaCasa() {
        if (mu.getVida() ==  0){
            aries.setExit("norte", touro);         
        }
        if (aldebaran.getVida() ==  0){
            touro.setExit("norte", gemeos);        
        }
        if (aldebaran.getVida() ==  0){
            gemeos.setExit("norte", cancer);         
        }
        if (mascara.getVida() ==  0){
            cancer.setExit("norte", leao);     
        }
        if (aioria.getVida() ==  0){
            leao.setExit("norte", virgem);
        }
        if (shaka.getVida() ==  0){
            virgem.setExit("norte", libra);
        }
        if (dohko.getVida() ==  0){
            libra.setExit("norte", escorpiao);       
        }
        if (milo.getVida() ==  0){
            escorpiao.setExit("norte", sagitario);       
        }
        if (aioros.getVida() ==  0){
           sagitario.setExit("norte", capricornio);      
        }
        if (shura.getVida() ==  0){
            capricornio.setExit("norte", aquario);  
        }
        if (camus.getVida() ==  0){
            aquario.setExit("norte", peixes);
        }
        if (afrodite.getVida() ==  0){
            peixes.setExit("leste", mestre);  
        }      
    }
    
    // o método recebe um comando e retorna o método a ser executado com tal comando
    // caso não seja reconhecido o comando retorna false
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
            cavaleiro.imprimir();
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
    
    
    // método que printa os comandos disponiveis no jogo e detalha suas funções
    public void printHelp() {
        System.out.println("Você está um pouco perdido. Vá derrotar o Mestre!");
        System.out.println();
        System.out.println("Seus Comandos são:");
        parser.showCommands();
        System.out.println();
        System.out.println("help - mostra os comandos e suas funções.");
        System.out.println("go - vai na direção indicada (se for uma saída existente).");
        System.out.println("quit - termina o jogo.");
        System.out.println("cavaleiro - mostra o estado atual do cavaleiro.");
        System.out.println("olhar - olha os itens e inimigos da casa atual.");
        System.out.println("atacar - ataca o inimigo digitado (ele deve estar na casa).");
        System.out.println("inimigos - mostra o estado atual dos inimigos da casa atual.");
        System.out.println("pegar - pega o item indicado e coloca no inventario.");
        System.out.println("usar - usa o item do inventario indicado.");
        System.out.println("soltar - solta na casa atual o item indicado.");

    }
    
    //método recebe um comando e vai na direção dada na segunda palavra
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
            if (casaAtual == gemeos) {
                System.out.println("Onde está Saga? O cavaleiro da casa de Gêmeos");
            }
        }
    }
    
    //método que finaliza o jogo após receber o comando quit
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Se deseja finalizar o jogo digite somente 'quit'");
            return false;
        } else {
            return true;
        }
    }
    
    //método que ataca o personagem da casa após receber uma segunda palavra
    //essa segunda palavra deve ser o nome do Inimigo, caso não haja inimigo
    //com esse nome não ataca ninguém
    //Neste método é invocado o método lutar da classe Cavaleiro
    //caso o cavaleiro ganhe a luta e a casa atual é a do mestre você ganha o jogo
    public void atacarAlguem(Command command) {

        if (!command.hasSecondWord()) {
            // Se não tiver uma segunda palavra não se sabe quem atacar
            System.out.println("Atacar quem?");
            return;
        }

        String name = command.getSecondWord();

        Personagem inimigo = casaAtual.getPersonagem(name);

        if (inimigo == null) {
            System.out.println("Você tem certeza que é esse o nome?");
        } else {
            cavaleiro.lutar(cavaleiro, inimigo);
            casaAtual.removePersonagem(name);
            if (casaAtual == mestre) {
                cavaleiro.imprimir();
                System.out.println("");
                System.out.println("PARABÉNS, VOCE GANHOU O JOGO!");
                exit(0);
            }
        }
    }
    
    //método que invoca o método adicionaItem da classe Cavaleiro
    // e removeItem da classe Casa
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
            System.out.println("O item foi adicionado ao inventário!");
        }
    }
    
    //método que invoca o método remove item da classe Cavaleiro
    //e adiciona item da classe casa
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
            System.out.println("O item foi jogado no chão");
        }
    }
    
    //método que invoca os métodos da classe Cavaleiro removeArmaCavaleiro e botaArmaCavaleiro 
    //para itens de tipo 1. removeArmaduraCavaleiro e  botaArmaduraCavaleiro para tipo 2
    //e botaPocaoCavaleiro para itens de tipo 0
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
                if (cavaleiro.getVida() >= 100) {
                    System.out.println("Sua vida está cheia");
                    cavaleiro.setVida(100);
                } else {
                    System.out.println("Sua vida foi aumentada");
                }
            }
        }
    }
    
    // método que imprime as características do(s) inimigo(s) da casa
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
        if (casaAtual == mestre) {
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
        if (casaAtual == pratas1) {
            marin.imprimir();
            misty.imprimir();
            babel.imprimir();
        }
        if (casaAtual == pratas2) {
            jamian.imprimir();
            algol.imprimir();
            algethi.imprimir();
        }
        if (casaAtual == pratas3) {
            sirius.imprimir();
            ptolemy.imprimir();
            orphee.imprimir();
        }
        if (casaAtual == acos1) {
            sho.imprimir();
        }
        if (casaAtual == acos2) {
            daichi.imprimir();
        }
        if (casaAtual == acos3) {
            usho.imprimir();
        }
    }
    
    //método de inicio do jogo
    public void play() {
        welcome();
        i.setVisible(true);
        createJogo();
        entraLoopJogo();
        System.out.println("Thanks for playing");
    }
}
