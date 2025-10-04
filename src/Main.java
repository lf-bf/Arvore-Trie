package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);

        System.out.println("TRIE (multiway)");
        System.out.println("Comandos: INS palavra | REM palavra | BUSCA palavra | PREF prefixo | LISTA | SAIR");
        System.out.println("Exemplo: INS palmeiras  | REM palmeiras| BUSCA mundial | PREF palm | LISTA");

        boolean rodando = true;
        while (rodando) {
            System.out.print("> ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("INS")) {
                String w = sc.next();
                trie.inserir(w);
                System.out.println("palavra inserida '" + w + "'");
            } else if (cmd.equalsIgnoreCase("REM")) {
                String w = sc.next();
                boolean ok = trie.remover(w);
                if (ok) {
                    System.out.println("Palavra removida da arvore");
                } else {
                    System.out.println("Palavra não encontrada na arvore");
                }
            } else if (cmd.equalsIgnoreCase("BUSCA")) {
                String w = sc.next();
                System.out.println(trie.contemPalavra(w) ? "palavra encontrada na arvore" : "palavra não encontrada");
            } else if (cmd.equalsIgnoreCase("PREF")) {
                String p = sc.next();
                trie.palavrasComPrefixo(p);
            } else if (cmd.equalsIgnoreCase("LISTA")) {
                trie.listarTodas();
            } else if (cmd.equalsIgnoreCase("SAIR")) {
                rodando = false;
            } else {
                System.out.println("Comando invalido.");
                sc.nextLine();
            }
        }

        sc.close();
        System.out.println("Sistema da Arvore Fechado!");
    }
}

