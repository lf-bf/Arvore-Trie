# Árvore Trie

## O que é uma Árvore Trie?

A **Trie** (também conhecida como árvore de prefixos ou árvore digital) é uma estrutura de dados em formato de árvore especialmente projetada para armazenar e buscar strings de forma eficiente. Cada nó da árvore representa um caractere, e os caminhos da raiz até as folhas formam palavras completas.

## Aplicações Práticas

Esta estrutura de dados é amplamente utilizada em:

- **Corretores de texto** (como o do WhatsApp) para sugestões de palavras
- **Mecanismos de busca** para autocompletar termos de pesquisa
- **Sistemas de autocompletar** em editores de texto
- **Dicionários digitais** para verificação ortográfica
- **Jogos de palavras** como Wordle ou palavras cruzadas

## Vantagens da Trie

- **Busca rápida**: O(m) onde m é o tamanho da palavra
- **Prefixos compartilhados**: Palavras com prefixos comuns compartilham nós
- **Autocompletar eficiente**: Fácil listagem de todas as palavras com um prefixo
- **Inserção e remoção dinâmica**: Modificações em tempo real

## Como Compilar e Executar

```bash
# Compilar os arquivos Java
javac src/*.java

# Executar o programa
java src.Main
```

## Comandos Disponíveis

- `INS palavra` - Insere uma palavra na Trie
- `REM palavra` - Remove uma palavra da Trie  
- `BUSCA palavra` - Verifica se uma palavra existe na Trie
- `PREF prefixo` - Lista todas as palavras que começam com o prefixo
- `LISTA` - Mostra todas as palavras armazenadas na Trie
- `SAIR` - Encerra o programa

## Demonstração do Código

```
TRIE (multiway)
Comandos: INS palavra | REM palavra | BUSCA palavra | PREF prefixo | LISTA | SAIR
Exemplo: INS palmeiras  | REM palmeiras| BUSCA mundial | PREF palm | LISTA

> INS casa
palavra inserida 'casa'

> INS casaco  
palavra inserida 'casaco'

> INS carro
palavra inserida 'carro'

> INS cama
palavra inserida 'cama'

> INS cavalo
palavra inserida 'cavalo'

> INS cachorro
palavra inserida 'cachorro'

> INS gato
palavra inserida 'gato'

> INS galinha
palavra inserida 'galinha'

> INS garrafa
palavra inserida 'garrafa'

> LISTA
cachorro
cama
carro
casa
casaco
cavalo
galinha
garrafa
gato

> PREF ca
cachorro
cama
carro
casa
casaco
cavalo

> BUSCA casa
palavra encontrada na arvore

> BUSCA mundo
palavra não encontrada

> REM casa
Palavra removida da arvore

> BUSCA casa
palavra não encontrada

> LISTA
cachorro
cama
carro
casaco
cavalo
galinha
garrafa
gato
```

## Estrutura do Projeto

```
src/
├── Main.java     - Interface de linha de comando
├── Trie.java     - Implementação da árvore Trie
└── TrieNode.java - Estrutura dos nós da árvore
```

## Como Funciona Internamente

A Trie armazena cada palavra caractere por caractere, onde:
- Cada nó possui um array de 26 posições (para a-z)
- Um flag `fimDaPalavra` marca onde uma palavra termina
- Prefixos comuns compartilham o mesmo caminho na árvore

Exemplo visual para as palavras "casa" e "carro":
```
    raiz
     |
     c
     |
     a
    / \
   r   s
   |   |
   r   a
   |   
   o   
```