// Deque com lista duplamente encadeada
//Nó que aponta para os dois lados

class NoDuplo {
    int data;
    NoDuplo next; //prox nó 
    NoDuplo prev; //nó anterior

    public NoDuplo(int valor) {
        this.data = valor;
        this.next = null;
        this.prev = null;
    }
}

// deque duplamente encadeada

class DequeDuplamenteEncadeado {
    private NoDuplo head; //primeiro nó
    private NoDuplo tail; // último nó
    private int size; // qnt de elementos

    public DequeDuplamenteEncadeado() {
        head = null;
        tail = null;
        size = 0;
    }

    //verifica se está vazio
    public boolean isEmpty() {
        return size == 0;
    }

    //verifica o tamanho
    public int size() {
        return size;
    }

    //inserir no inicio
    public void inserirInicio (int valor) {
        NoDuplo novoNo = new NoDuplo(valor); //novo nó

        if (isEmpty()) { //se estiver vazio
            head = novoNo; // novo nó é o primeiro
            tail = novoNo; // novo nó é o último tb
        } 
        else { // liga o novo nó antes do primeito atual
            novoNo.next = head; // novo nó aponta para atual head ->
            head.prev = novoNo; // atual head aponta de volta <-
            head = novoNo; // novo nó eleito a head 
        }
        size++; //adicionou 1, aumenta o tamanho
        System.out.println(valor + " foi inserido no início do deque.");
    }

    //inserir no final
    public void inserirFim (int valor) {
        NoDuplo novoNo = new NoDuplo(valor); // novo nó 

        if (isEmpty()) { //se estiver vazio
            head = novoNo; //novo nó é o primeiro
            tail = novoNo; //novo nó é o último tb
        }
        else {
            tail.next = novoNo; // atual tail aponta para o novo ->
            novoNo.prev = tail; // novo nó aponta de volta <-
            tail = novoNo; // novo nó vira atual tail 
        }
        size++; //aumenta o tamanho
        System.out.println(valor + " foi inserido no final do deque.");
    }

    //remover do inicio
    public int removerInicio() {
        if (isEmpty()) {
            System.out.println("O deque está vazio, não há o que remover.");
            return -1;
        }
    
    int valor = head.data; //tira o valor do head q será removido e armazena 

    if (size == 1) { //se só tinha 1, fica vazio
        head = null;
        tail = null;
    }
    else { // se não, remove o primeiro e atualizq o head 
        head = head.next; // head vira o 2º nó
        head.prev = null; //tira a referencia do antigo head
    }

    size--; //removeu 1, diminui o tamanho
    System.out.println(valor + " foi removido do início do deque.");
    return valor; //informa o valor rem 
    }

    //remover fim
    public int removerFim(){
        if (isEmpty()) {
            System.out.println ("O deque está vazio, não há o que remover.");
            return -1;
        }

        int valor = tail.data; // tira o valor que está no tail para remover e armazena

        if (size == 1){ //se só tinha 1, fica vazio e zera tail e head
           head = null;
           tail = null; 
        }
        else { //se não, remove o último e atualiza o tail
             tail = tail.prev; // tail vira o penultimo nó
             tail.next = null; // tira a referencia do antigo tail
        }

        size--; // diminui tamanho
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
        NoDuplo atual = head; //começa no head
        while (atual != null) { // enqt não chegar no final}
            System.out.print (atual.data + " "); //mostra o valor 
            atual = atual.next; //vai para o prox e volta p o while 
        }
        System.out.println(); 
    }
}

// ================================================================
// Deque com lista simplemente encadeada
//Nó que aponta só para o próximo

class NoSimples {
    int data;
    NoSimples next; // próx nó 

    public NoSimples (int valor) {
        this.data = valor;
        this.next = null; //inicia vazio
    }
}

class DequeSimplesmenteEncadeado {
    private NoSimples head; //primeiro nó
    private NoSimples tail; //último nó 
    private int size; // elementos 

    public DequeSimplesmenteEncadeado () {
        head = null;
        tail = null;
        size = 0; //inicia tudo vazio
    }

    public boolean isEmpty (){
        return size == 0;
    }

    public int size (){
        return size;
    }

    public void inserirInicio (int valor) {
        NoSipmples novoNo = new NoSimples (valor); // novo

        if (isEmpty()) {
            head = novoNo; 
            tail = novoNo;
        }
        else {
            novoNo.next = head; // novo nó aponta para a atual head 
            head = novoNo; // novo nó vira a nova head 
        }
        size++;
        System.out.println (valor + " foi inserido no início do deque.");
    }

    public void inserirFim (int valor) {
        NoSimples novoNo = new NoSimples (valor); //novo

        if (isEmpty()) {
            head = novoNo;
            tail = novoNo;
        }
        else {
            tail.next = novoNo; //atual tail aponta para novo nó
            tail = novoNo; // novo nó vira o novo tail
        }
        size++;
        System.out.println (valor + " foi inserido no final do deque.");
    }

    public int removerInicio () {
        if (isEmpty()) {
            System.out.println ("O deque está vazio, não há o que remover.");
            return -1;
        }

        int valor = head.data; // tira o valor do inicio e armazena após remover

        if (size == 1) { // se só tem 1, fica vazio
            head = null;
            tail = null;
        }
        else {
            head = head.next; // o head vira o atual 2º nó
        }

        size--;
        System.out.println (valor + " foi removido do início do deque.");
        return valor; // informa removido
    }

    public int removerFim () {
        if (isEmpty()) {
            System.out.println ("O deque está vazio, não há o que remover.");
            return -1;
        }

        int valor = tail.data; // tira o valor do fim e armazena 

        if (size == 1) { // se só tem 1, tudo fica vazio
            head = null;
            tail = null; 
        }
        else {
            NoSimples atual = head;
            while (atual.next != tail) { //enqt o próx do atual não for tail
                atual = atual.next; // percorre a lista
            }
            // agora o atual é o penúltimo
            atual.next = null; // tira a ligação com o antigo tail
            tail = atual; // atual vira o novo tail
        }
        size--;
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
        NoSimples atual = head; //inicia no head
        while (atual != null) {
            System.out.print (atual.data + " ");
            atual = atual.next; //vai p o próx e faz o while de novo
        }
        System.out.println ();
    }


}
