## Desenvolvedores
Emanuel Ferreira, Kauã Araújo, Lucas Marques, [Marcio Ventura](https://github.com/cau-r) e [Rodrigo Santos](https://github.com/rodrigosantos-eng).

## Descrição
Projeto referente a uma avaliação de Lógica de Programação em Algoritmos da 2ª unidade.

**Disciplina**: Lógica de Programação e Algoritmos.

**Profa.**: Christianne Orrico Dalforno 

### Instruções: 


**Jogo da senha**

Segundo a Wikipedia, o jogo da senha (Mastermind) foi criado por Mordechai Meirowitz. Consistia num jogo de tabuleiro em que uma senha de quatro dígitos representados por pinos coloridos (sendo 6 possibilidades de cores) era estabelecida pelo jogador desafiador e deveria ser descoberta em 10 tentativas pelo jogador desafiado.

Para tanto, a cada tentativa, o desafiador informava ao desafiado quantos pinos estavam na posição correta e quantos faziam parte da senha mas estavam em posição equivocada. 

**Implementação**

Como será utilizada interface de texto, ao invés de cores serão usados números (de 1 a 6) para compor a senha de quatro dígitos.

A senha deve ser gerada aleatoriamente pelo programa.

A senha deve ser armazenada num vetor de quatro posições e um outro vetor similar deve ser usado para receber as tentativas do jogador desafiado.

A cada tentativa, o programa deve informar a quantidade de números corretos em posição correta e a quantidade de números corretos (ou seja que fazem parte da senha) em posição equivocada.

#### Exemplo: 

**Senha correta: 1 1 3 5**
<br><br>
**Tentativa 1**: 1 1 1 1 
<br>
Dígitos corretos: 2 
<br>
Dígitos deslocados: 0 

**Tentativa 2**: 1 1 2 3 
<br>
Dígitos corretos: 2 
<br>
Dígitos deslocados: 1 

E assim sucessivamente. 

O jogo termina quando o jogador desafiado acerta a senha, sendo portanto vencedor, ou quando terminam as dez tentativas, sendo vencedor o computador.