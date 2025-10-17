class pilha {
// variáveis
    private int array [];
    private int topoVermelho;
    private int topoPreto;
    private int capacidade;

    public pilha (){
        capacidade = 10;
        array = new int [capacidade];
        topoVermelho = -1; //iniciar no primeiro
        topoPreto = capacidade; // assim, inicia no último
    }

    //Push na pilha vermwelha
    public void pushVermelho (int elemento) {
        if (topoVermelho + 1 >= topoPreto){
            dobrar(capacidade * 2); // se não houver espaço, dobrar
        }

        topoVermelho++; // próx posição
        array [topoVermelho] = elemento; // inserir

        System.out.println(elemento + " adicionado na pilha veremelha");
    }

    //Push na pilha preta
    public void pushPreto (int elemento) {
        if (topoVermelho + 1 >= topoPreto) { //SE se encontrarem
            dobrar(capacidade * 2); // se encontrando, dobra
        }

        topoPreto --; //volta uma posição (vindo da direita p esquerda)
        array [topoPreto] = elemento; // inserir

        System.out.println(elemento + " adicionado na pilha preta");
    }

    //Pop na pilha vermelha 
    public int popVermelho() {
        if (topoVermelho == -1) { // se vazia
            System.out.println("A pilha vermelha está vazia");
            return -1; //
        }

        int elemento = array [topoVermelho]; // pegar o elemento 
        topoVermelho --; 

        //Verificando a regra de diminuir quando chegar a 1/3
        verificarDiminuir();

        System.out.println(elemento + " removido da pilha vermelha");
        return elemento;
    }

    //Pop pilha preta
    public int popPreto() {
        if (topoPreto == capacidade) { // se vazia
            System.out.println ("A pilha preta está vazia");
            return -1;
        }

        int elemento = array [topoPreto]; // pega o elemento
        topoPreto ++; // "diminui" a pilha para a direita (pq ela cresce para a esquerda)
        
        //Verificando a regra de diminuir quando chegar a 1/3
        verificarDiminuir();

        System.out.println (elemento + " removido da pilha preta");
        return elemento;
    }

    //Verificar se deve diminuir
    private void verificarDiminuir() {
        // verificando quantos elementosd
        int elementosVermelho = topoVermelho + 1;
        int elementosPreto = capacidade - topoPreto;
        int totalElementos = elementosVermelho + elementosPreto;

        if (totalElementos <= capacidade / 3 && capacidade > 10) {
            diminuir (capacidade / 2); // reduzido pela metade
            System.out.println (" Capacidade diminuída pela metade. Capacidade atual: " + capacidade);
        }
    }

    //Dobrando a capacidade
    private void dobrar (int novaCapacidade) {
        int [] novoArray = new int [novaCapacidade]; //criando novo array com tam maior
        
        //para copiar da pilha vermelha
        for (int i = 0; i <= topoVermelho; i++) { // enqt i for menor ou == ao topoVermelho
            novoArray[i] = array [i]; //copiando            
        }

        int elementosPreto = capacidade - topoPreto; // quantidade de elementos
        int novoTopoPreto = novaCapacidade - elementosPreto; //topo

        //para copiar a pilha preta
        for (int i = 0; i < elementosPreto; i++) { //enqt i for menor q a qt de elementos
            novoArray [novoTopoPreto + i] = array [topoPreto + i];
        }

        array = novoArray; 
        topoPreto = novoTopoPreto;
        capacidade = novaCapacidade;
        
        System.out.println ("A capacidade foi aumentada para: " + capacidade);
    }

    //Diminui a capacidade
    private void diminuir (int novaCapacidade) {
        int [] novoArray = new int [novaCapacidade]; // criando novo array com tam menor 

        //copiando a pilha vermelha 
        for (int i = 0; i <= topoVermelho; i++) { // enqt o índice for < ou == ao topoVerm 
            novoArray[i] = array[i]; //copia 
        }

        int elementosPreto = capacidade -topoPreto; //qnt elementos
        int novoTopoPreto = novaCapacidade - elementosPreto; //novo 

        //copiando a preta
        for (int i = 0; i < elementosPreto; i++) { //enqt i for menor q a qnt de elemtos 
            novoArray [novoTopoPreto + i] = array [topoPreto + i]; // copiando 
        }

        array = novoArray;
        topoPreto = novoTopoPreto; 
        capacidade = novaCapacidade;

        System.out.println ("A capacidade foi diminuída para: " + capacidade);
    }

    //Mostrar as pilhas
    public void mostrarPilhas() {
        System.out.println ("\n --- Estado das Pilhas ---");
        System.out.println ("Capacidade do array: " + capacidade);
        System.out.println ("Topo vermelho atual: " + topoVermelho);
        System.out.println ("Topo preto atual: " + topoPreto);
        
        System.out.println ("Pilha vermelha: ");
        for (int i = 0; i <= topoVermelho; i++) {
            System.out.print (array [i] + " ");
        }
        System.out.println ();

        System.out.print ("Pilha preta: ");
        for (int i = topoPreto; i < capacidade; i++) {
            System.out.println (array [i] + " ");
        }
    }

    //Teste 
    public static void main (String [] args) {
        pilha p = new pilha ();

        p.pushVermelho(10);
        p.pushVermelho(20);
        p.pushVermelho(30);
        p.pushPreto(300);
        p.pushPreto(200);
        p.pushPreto(100);
        p.popVermelho();
        p.popPreto();
        p.mostrarPilhas();
    }
}




