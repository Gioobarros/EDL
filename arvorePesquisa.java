import java.util.LinkedList;
import java.util.Queue;

class No {
    int valor;
    No esquerdo;
    No direito;

    No (int valor) {
        this.valor = valor;
    }
}

class ArvoreBinariaBusca {
    private No raiz; 

    public boolean isEmpty (){
        return raiz == null;
    }

    public void inserir (int valor) {
        raiz = inserirRecursivo (raiz, valor);
    }

    public boolean buscar (int valor) {
        return buscarRecursivo (raiz, valor) != null;
    }

    public void remover (int valor) {
        raiz = removerRecursivo (raiz, valor);
    }

    private No inserirRecursivo (No atual, int valor) {
        if (atual == null) {
            return new No (valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserirRecursivo (atual.esquerdo, valor); 
        }

        else if (valor > atual.valor) {
            atual.direito = inserirRecursivo (atual.direito, valor);
        }
        return atual; 
    }

    private No buscarRecursivo (No atual, int valor) {
        if (atual == null || atual.valor == valor){
            return atual;
        }

        if (valor < atual.valor) {
            return buscarRecursivo (atual.esquerdo, valor);
        }        
        return buscarRecursivo (atual.direito, valor);
    }

    private No removerRecursivo (No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor < atual.valor) {
            atual.esquerdo = removerRecursivo (atual.esquerdo, valor);
        }

        else if (valor > atual.valor) {
            atual.direito = removerRecursivo (atual.direito, valor);      
        }

        else {
            if (atual.esquerdo == null) {
                return atual.direito;            
            }
            else if (atual.direito == null) {
                return atual.esquerdo;
            }
            No sucessor = menorNo (atual.direito);
            atual.valor = sucessor.valor;
            atual.direito = removerRecursivo (atual.direito, sucessor.valor);
        }
        return atual;
    }

    private No menorNo (No atual) {
        while (atual != null && atual.esquerdo != null) {
            atual = atual.esquerdo;
        }
        return atual;
    }

    private No maiorNo (No atual) {
        while (atual != null && atual.direito != null) {
            atual = atual. direito;
        }
        return atual;
    }

    public Integer minimo () {
        No n = menorNo (raiz);
        if (n == null) {
            return null;
        }
        return n.valor;
    }

    public Integer maximo () {
        No n = maiorNo (raiz);
        if (n == null) {
            return null;
        }
        return n.valor;
    }

    public int altura () {
        return alturaRecursiva (raiz);
    }

    public int tamanho () {
        return tamanhoRecursivo (raiz);
    }

    private int alturaRecursiva (No atual) {
        if (atual == null) {
            return -1; //vazia
        }
        int alturaEsquerdo = alturaRecursiva (atual.esquerdo);
        int alturaDireito = alturaRecursiva (atual.direito);
        if (alturaEsquerdo > alturaDireito) {
            return 1 + alturaEsquerdo;
        }
        else {
            return 1 + alturaDireito;
        }
    }

    private int tamanhoRecursivo (No atual) {
        if (atual == null) {
            return 0;
        }
        int tamanhoEsquerdo = tamanhoRecursivo (atual.esquerdo);
        int tamanhoDireito = tamanhoRecursivo (atual.direito);
        return 1 + tamanhoEsquerdo + tamanhoDireito;
    }

    public void preOrdem () {
        preOrdemRecursivo (raiz);
        System.out.println ();
    }

    private void preOrdemRecursivo (No atual) {
        if (atual == null) {
            return;
        }
        System.out.print (atual.valor + " ");
        preOrdemRecursivo (atual.esquerdo);
        preOrdemRecursivo (atual.direito);
    }

    public void emOrdem () {
        emOrdemRecursivo (raiz);
        System.out.println ();
    }

    private void emOrdemRecursivo (No atual) {
        if (atual == null) {
            return;
        }
        emOrdemRecursivo (atual.esquerdo);
        System.out.print (atual.valor + " ");
        emOrdemRecursivo (atual.direito);
    }

    public void posOrdem () {
        posOrdemRecursivo (raiz);
        System.out.println ();
    }

    private void posOrdemRecursivo (No atual) {
        if (atual == null) {
            return;
        }
        posOrdemRecursivo (atual.esquerdo);
        posOrdemRecursivo (atual.direito);
        System.out.print (atual.valor + " ");
    }

    public void mostrar () {
        mostrarRecursivo (raiz, 0);
    }

    private void mostrarRecursivo (No atual, int nivel) {
        if (atual == null) {
            return;
        }

        mostrarRecursivo (atual.direito, nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print ("   ");
        }
        System.out.println (atual.valor);
        mostrarRecursivo (atual.esquerdo, nivel + 1);
    }

    public void mostrarPorNivel () {
        if (raiz == null) {
            System.out.println ("vazia");
            return;
        }

        Queue<No>fila = new LinkedList<>();
        fila.add (raiz);
        while (!fila.isEmpty()) {
            int qnt = fila.size ();
            for (int i = 0; i < qnt; i++){
                No n = fila.poll ();
                System.out.print (n.valor + " ");
                if (n.esquerdo != null) {
                    fila.add (n.esquerdo);
                }
                if (n.direito != null) {
                    fila.add (n.direito);
                }
            }
        }
    }



}