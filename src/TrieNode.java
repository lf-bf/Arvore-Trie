package src;

class TrieNode {
    TrieNode[] filhos = new TrieNode[26]; // filhos da arvore criado com as letras do alfabeto (a-z)
    boolean fimDaPalavra;

    public TrieNode() {
        fimDaPalavra = false;
        for (int i = 0; i < 26; i++) {
            filhos[i] = null;
        }
    }
}

