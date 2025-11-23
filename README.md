## Desenvolvedores
[Emanuel Ferreira](https://github.com/emn-f/), [Kauã Araújo](https://github.com/Kauagit99), [Marcio Ventura](https://github.com/cau-r) e [Rodrigo Santos](https://github.com/rodrigosantos-eng).

## Descrição
Projeto referente a uma avaliação de LPA.

**Disciplina**: Lógica de Programação e Algoritmos.

**Profa.**: Christianne Orrico Dalforno.

**Data**: 28/11/2024.


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

## Explicação de algumas validações
**pSenha** - Método que preenche o vetor com 4 dígitos aleatórios.
```java
public static void pSenha(int senha[]) {
        Random shuffle = new Random();
        for (int i = 0; i < senha.length; i++) {
            senha[i] = shuffle.nextInt(6) + 1;
        }
    }
```

**pTentativa** -  Método que registra e trata as tentativas do usuário

```java
public static void pTentativa(int tentativa[], int senha[]) {
    Scanner in = new Scanner(System.in);
    int digCorreto = 0;
    int digDeslocados = 0;
    int contTentativa = 0;
    
    boolean validacao[] = new boolean[4];
```
**for** (1) - Responsável pra pegar a tentativa do usuário caso ele ainda não tenha tentado 10 vezes e não tenha informado 4 dígitos corretos na última tentativa.

```java
    for (contTentativa = 1; ((contTentativa <= 10) && digCorreto < 4); contTentativa++) {
        System.out.println("TENTATIVA " + contTentativa);
        System.out.print("Informe a senha: ");
        int senhaUsu = in.nextInt();
```

Passa a senha informada em int para a string senhaUsuStr para permitir a utilização do charAt.
```java
    String senhaUsuStr = String.valueOf(senhaUsu);
```
**while** - O usuário não pode informar uma senha diferente de 4 dígitos.
```java
    while (senhaUsuStr.length() != 4) {
        System.out.print("Digite uma senha de 4 dígitos: ");
        senhaUsu = in.nextInt();
        senhaUsuStr = String.valueOf(senhaUsu);
    }
```
**for** (2) - Percorre e preenche o vetor tentativa de acordo com a senha informada pelo usuário que foi atribuída à senhaUsuStr.
```java
    for (int i = 0; i < tentativa.length; i++) {
        tentativa[i] = Character.getNumericValue(senhaUsuStr.charAt(i));
    }
```
**for** (3) - Percorre tentativa e caso algum dígito esteja na posição correta, soma digCorreto + 1 e atribui true a essa posição no vetor validacao.
```java
    for (int i = 0; i < tentativa.length; i++) {
        if (tentativa[i] == senha[i]) {
            digCorreto++;
            validacao[i] = true;
        }
    }
```

for (4) -  Não imaginávamos mas esse bloco foi o que deu mais trabalho 🫠. Contagem de dígitos deslocados
```java
    for (int i = 0; i < tentativa.length; i++) {
```
Se a **tentativa[i]** for diferente da **senha[i]**.
```java
        if (tentativa[i] != senha[i]) {
```
Busca do dígito em outras posições, verifica se o valor da **tentativa** é igual a alguma valor em outra posição.<br>
A segunda condição no **if** garante que esse dígito ainda não foi validado e não foi considerado correto em sua posição original.
```java
            for (int j = 0; j < senha.length; j++) {
                if (tentativa[i] == senha[j] && !validacao[j] && !validacao[i]) {
                    digDeslocados++;
                    validacao[j] = true;
                    break;
                }
            }
        }
    }
```
