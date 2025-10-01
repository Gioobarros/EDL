// Deque com lista duplamente encadeada
//Nó que aponta para os dois lados

class NoDuplo {
    int valor;
    NoDuplo prox; //prox nó 
    NoDuplo anterior; //nó anterior

    public NoDuplo(int valor) {
        this.valor = valor;
        this.prox = null;
        this.anterior = null;
    }
}

// deque duplamente encadeada

class DequeDuplamenteEncadeado {
    private NoDuplo inicio; //primeiro nó
    private NoDuplo fim; // último nó
    private int tamanho; // qnt de elementos

    public DequeDuplamenteEncadeado() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    //verifica se está vazio
    public boolean isEmpty() {
        return tamanho == 0;
    }

    //verifica o tamanho
    public int tamanho() {
        return tamanho;
    }

    //inserir no inicio
    public void inserirInicio (int valor) {
        NoDuplo novoNo = new NoDuplo(valor); //novo nó

        if (isEmpty()) { //se estiver vazio
            inicio = novoNo; // novo nó é o primeiro
            fim = novoNo; // novo nó é o último tb
        } 
        else { // liga o novo nó antes do primeito atual
            novoNo.prox = inicio; // novo nó aponta para atual inicio ->
            inicio.anterior = novoNo; // atual inicio aponta de volta <-
            inicio = novoNo; // novo nó eleito a inicio 
        }
        tamanho++; //adicionou 1, aumenta o tamanho
        System.out.println(valor + " foi inserido no início do deque.");
    }

    //inserir no final
    public void inserirFim (int valor) {
        NoDuplo novoNo = new NoDuplo(valor); // novo nó 

        if (isEmpty()) { //se estiver vazio
            inicio = novoNo; //novo nó é o primeiro
            fim = novoNo; //novo nó é o último tb
        }
        else {
            fim.prox = novoNo; // atual fim aponta para o novo ->
            novoNo.anterior = fim; // novo nó aponta de volta <-
            fim = novoNo; // novo nó vira atual fim 
        }
        tamanho++; //aumenta o tamanho
        System.out.println(valor + " foi inserido no final do deque.");
    }

    //remover do inicio
    public int removerInicio() {
        if (isEmpty()) {
            System.out.println("O deque está vazio, não há o que remover.");
            return -1;
        }
    
    int valor = inicio.valor; //tira o valor do inicio q será removido e armazena 

    if (tamanho == 1) { //se só tinha 1, fica vazio
        inicio = null;
        fim = null;
    }
    else { // se não, remove o primeiro e atualizq o inicio 
        inicio = inicio.prox; // inicio vira o 2º nó
        inicio.anterior = null; //tira a referencia do antigo inicio
    }

    tamanho--; //removeu 1, diminui o tamanho
    System.out.println(valor + " foi removido do início do deque.");
    return valor; //informa o valor rem 
    }

    //remover fim
    public int removerFim(){
        if (isEmpty()) {
            System.out.println ("O deque está vazio, não há o que remover.");
            return -1;
        }

        int valor = fim.valor; // tira o valor que está no fim para remover e armazena

        if (tamanho == 1){ //se só tinha 1, fica vazio e zera fim e inicio
           inicio = null;
           fim = null; 
        }
        else { //se não, remove o último e atualiza o fim
             fim = fim.anterior; // fim vira o penultimo nó
             fim.prox = null; // tira a referencia do antigo fim
        }

        tamanho--; // diminui tamanho
        System.out.println(valor + " foi removido do final do deque.");
        return valor; //informa o removido
    }

    //mostrar deque inteiro
    public void mostrarDeque (){
        if (isEmpty()){
            System.out.println("O deque está vazio.");
            return;
        }

        System.out.print ("Deque atual: ");
        NoDuplo atual = inicio; //começa no inicio
        while (atual != null) { // enqt não chegar no final}
            System.out.print (atual.valor + " | "); //mostra o valor 
            atual = atual.prox; //vai para o prox e volta p o while 
        }
        System.out.println(); 
    }
}

// Deque com lista simplemente encadeada
//Nó que aponta só para o próximo

class NoSimples {
    int valor;
    NoSimples prox; // próx nó 

    public NoSimples (int valor) {
        this.valor = valor;
        this.prox = null; //inicia vazio
    }
}

class DequeSimplesmenteEncadeado {
    private NoSimples inicio; //primeiro nó
    private NoSimples fim; //último nó 
    private int tamanho; // elementos 

    public DequeSimplesmenteEncadeado () {
        inicio = null;
        fim = null;
        tamanho = 0; //inicia tudo vazio
    }

    public boolean isEmpty (){
        return tamanho == 0;
    }

    public int tamanho (){
        return tamanho;
    }

    public void inserirInicio (int valor) {
        NoSimples novoNo = new NoSimples (valor); // novo

        if (isEmpty()) {
            inicio = novoNo; 
            fim = novoNo;
        }
        else {
            novoNo.prox = inicio; // novo nó aponta para a atual inicio 
            inicio = novoNo; // novo nó vira a nova inicio 
        }
        tamanho++;
        System.out.println (valor + " foi inserido no início do deque.");
    }

    public void inserirFim (int valor) {
        NoSimples novoNo = new NoSimples (valor); //novo

        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        }
        else {
            fim.prox = novoNo; //atual fim aponta para novo nó
            fim = novoNo; // novo nó vira o novo fim
        }
        tamanho++;
        System.out.println (valor + " foi inserido no final do deque.");
    }

    public int removerInicio () {
        if (isEmpty()) {
            System.out.println ("O deque está vazio, não há o que remover.");
            return -1;
        }

        int valor = inicio.valor; // tira o valor do inicio e armazena após remover

        if (tamanho == 1) { // se só tem 1, fica vazio
            inicio = null;
            fim = null;
        }
        else {
            inicio = inicio.prox; // o inicio vira o atual 2º nó
        }

        tamanho--;
        System.out.println (valor + " foi removido do início do deque.");
        return valor; // informa removido
    }

    public int removerFim () { // Big-o: O(n)
        if (isEmpty()) {
            System.out.println ("O deque está vazio, não há o que remover.");
            return -1;
        }

        int valor = fim.valor; // tira o valor do fim e armazena 

        if (tamanho == 1) { // se só tem 1, tudo fica vazio
            inicio = null;
            fim = null; 
        }
        else {
            NoSimples atual = inicio;
            while (atual.prox != fim) { //enqt o próx do atual não for fim
                atual = atual.prox; // percorre a lista
            }
            // agora o atual é o penúltimo
            atual.prox = null; // tira a ligação com o antigo fim
            fim = atual; // atual vira o novo fim
        }
        tamanho--;
        System.out.println (valor + " foi removido do final do deque.");
        return valor; // informa o removido
    }

    //mostrar o deque
    public void mostrarDeque () {
        if (isEmpty()) {
            System.out.println ("O deque está vazio.");
            return;
        }
        System.out.print("Deque atual:" );
        NoSimples atual = inicio; //inicia no inicio
        while (atual != null) {
            System.out.print (atual.valor + " ");
            atual = atual.prox; //vai p o próx e faz o while de novo
        }
        System.out.println ();
    }
   
}

// testes
public class ListaDeque {
    public static void main (String [] args) {
            
        System.out.println ("\n Testando lista duplamente encadeada: ");
        DequeDuplamenteEncadeado d = new DequeDuplamenteEncadeado();
        d.inserirInicio(1);
        d.inserirFim(2);
        d.inserirInicio(3);
        d.inserirFim(4);
        d.mostrarDeque();
        d.removerInicio();
        d.mostrarDeque();
        d.removerFim();
        d.mostrarDeque();

        System.out.println ("\n Testando lista simplesmente encadeada: ");
        DequeSimplesmenteEncadeado s = new DequeSimplesmenteEncadeado();
        s.inserirInicio(1);
        s.inserirFim(2);
        s.inserirInicio(3);
        s.inserirFim(4);
        s.mostrarDeque();
        s.removerInicio();
        s.mostrarDeque();
        s.removerFim();
        s.mostrarDeque();    

    }

}
