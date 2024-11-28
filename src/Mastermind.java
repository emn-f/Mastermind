import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) throws Exception {
        int senha[] = new int[4];
        int tentativa[] = new int[4];
        preencherSenha(senha);
        preencheTentativa(tentativa, senha);

    }

    public static void preencherSenha(int senha[]) {
        Random shuffle = new Random();
        for (int i = 0; i < senha.length; i++) {
            senha[i] = shuffle.nextInt(6) + 1;
        }
    }

    public static void preencheTentativa(int tentativa[], int senha[]) {
        Scanner in = new Scanner(System.in);

        int digCorreto = 0;
        int digDeslocados = 0;

        int contTentativa = 0;

        boolean validacao[] = new boolean[4];

        for (contTentativa = 1; ((contTentativa <= 10) && digCorreto < 4); contTentativa++) {
            
            int senhaUsu;
            String senhaUsuStr = "";
            
            System.out.println("TENTATIVA " + contTentativa);
            
            while (senhaUsuStr.length() != 4) {
                System.out.print("Digite uma senha de 4 dígitos: ");
                senhaUsu = in.nextInt();
                senhaUsuStr = String.valueOf(senhaUsu);
            }

            for (int i = 0; i < tentativa.length; i++) {
                tentativa[i] = Character.getNumericValue(senhaUsuStr.charAt(i));
            }

            Arrays.fill(validacao, false);

            for (int i = 0; i < tentativa.length; i++) {
                if (tentativa[i] == senha[i]) {
                    digCorreto++;
                    validacao[i] = true;
                }
            }

            for (int i = 0; i < tentativa.length; i++) {
                if (tentativa[i] != senha[i]) {
                    for (int j = 0; j < senha.length; j++) {
                        if (tentativa[i] == senha[j] && !validacao[j]) {
                            digDeslocados++;
                            validacao[j] = true;
                            break;
                        }
                    }
                }
            }

            System.out.println("Tentativa " + contTentativa + ": " + Arrays.toString(tentativa));
            System.out.println("Dígitos corretos: " + digCorreto);
            System.out.println("Dígitos deslocados: " + digDeslocados);
            System.out.println();
            if (digCorreto < 4) {
                System.out.println("SENHA INCORRETA!");
                digCorreto = 0;
                digDeslocados = 0;
            }
            System.out.println();

        }

        if (digCorreto == 4) {
            System.out.println("PARABÉNS! SENHA CORRETA!");
        } else {
            System.out.println("O computador venceu! ;)");
            System.out.println("Senha correta: " + Arrays.toString(senha));

        }

    }
}