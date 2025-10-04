package src;

// Classe que implementa a Trie
public class Trie {
    private TrieNode raiz;

    public Trie() {
        raiz = new TrieNode();
    }

    // INSERÇÃO
    public void inserir(String palavra) {
        TrieNode atual = raiz;
        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            int indice = c - 'a';
            if (atual.filhos[indice] == null) {
                atual.filhos[indice] = new TrieNode();
            }
            atual = atual.filhos[indice];
        }
        atual.fimDaPalavra = true;
    }

    // BUSCA
    public boolean contemPalavra(String palavra) {
        TrieNode atual = raiz;
        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            int indice = c - 'a';
            if (atual.filhos[indice] == null) return false;
            atual = atual.filhos[indice];
        }
        return atual.fimDaPalavra;
    }

    // REMOÇÃO
    public boolean remover(String palavra) {
        return removerRec(raiz, palavra, 0);
    }

    private boolean removerRec(TrieNode no, String palavra, int nivel) {
        if (no == null) return false;

        // fim da palavra
        if (nivel == palavra.length()) {
            if (!no.fimDaPalavra) {
                return false; // palavra não existe
            }

            no.fimDaPalavra = false;

            return true;
        }

        char c = palavra.charAt(nivel);
        int indice = c - 'a';

        // Se não existe esse caminho, não tem a palavra
        if (no.filhos[indice] == null) {
            return false;
        }

        boolean removida = removerRec(no.filhos[indice], palavra, nivel + 1);

        // palavra foi removida e o filho ficou vazio → limpa o filho
        if (removida && !no.filhos[indice].fimDaPalavra && semFilhos(no.filhos[indice])) {
            no.filhos[indice] = null;
        }

        return removida;
    }

    private boolean semFilhos(TrieNode no) {
        for (int i = 0; i < 26; i++) {
            if (no.filhos[i] != null) return false;
        }
        return true;
    }

    // LISTA
    public void listarTodas() {
        char[] palavra = new char[50];
        listarRec(raiz, palavra, 0);
    }

    private void listarRec(TrieNode no, char[] palavra, int nivel) {
        if (no.fimDaPalavra) {
            for (int i = 0; i < nivel; i++) {
                System.out.print(palavra[i]);
            }
            System.out.println();
        }
        for (int i = 0; i < 26; i++) {
            if (no.filhos[i] != null) {
                palavra[nivel] = (char) (i + 'a');
                listarRec(no.filhos[i], palavra, nivel + 1);
            }
        }
    }

    // PREFIXO
    public void palavrasComPrefixo(String prefixo) {
        TrieNode atual = raiz;
        for (int i = 0; i < prefixo.length(); i++) {
            char c = prefixo.charAt(i);
            int indice = c - 'a';
            if (atual.filhos[indice] == null) {
                System.out.println("Nenhuma palavra encontrada com esse prefixo.");
                return;
            }
            atual = atual.filhos[indice];
        }

        char[] palavra = new char[50];
        for (int i = 0; i < prefixo.length(); i++) {
            palavra[i] = prefixo.charAt(i);
        }
        listarRec(atual, palavra, prefixo.length());
    }
}

