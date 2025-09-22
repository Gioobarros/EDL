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

        System.out.println(elemento + "adicionado na pilha veremelha");
    }

    //Push na pilha preta
    public void pushPreto (int elemento) {
        if (topoVermelho + 1 >= topoPreto) { //SE se encontrarem
            dobrar(capacidade * 2); // se encontrando, dobra
        }

        topoPreto --; //volta uma posição (vindo da direita p esquerda)
        array [topoPreto] = elemento; // inserir

        System.out.println(elemento + "adicionado na pilha preta");
    }
}
    




