import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int senha[] = new int[4];
        int tentativa[] = new int[4];
        pSenha(senha);
        pTentativa(tentativa, senha);

    }

    public static void pSenha(int senha[]) {
        Random shuffle = new Random();
        for (int i = 0; i < senha.length; i++) {
            senha[i] = shuffle.nextInt(6) + 1;
        }
    }

    public static void pTentativa(int tentativa[], int senha[]) {
        Scanner in = new Scanner(System.in);

        int digCorreto = 0;
        int digDeslocados = 0;
        int contTentativa = 0;

        for (contTentativa = 1; ((contTentativa <= 10) && digCorreto < 4); contTentativa++) {
            System.out.println("TENTATIVA " + contTentativa);

            System.out.print("Informe a senha: ");
            int senhaUsu = in.nextInt();
            String senhaUsuStr = String.valueOf(senhaUsu);
            while (senhaUsuStr.length() != 4) {
                System.out.print("Digite uma senha de 4 dígitos: ");
                senhaUsu = in.nextInt();
                senhaUsuStr = String.valueOf(senhaUsu);
            }

            for (int i = 0; i < tentativa.length; i++) {
                tentativa[i] = Character.getNumericValue(senhaUsuStr.charAt(i));
            }

            for (int i = 0; i < tentativa.length; i++) {
                boolean validacao[] = new boolean[4];
                if (tentativa[i] == senha[i]) {
                    digCorreto++;
                    validacao[i] = true;
                } else {
                    for (int j = 0; j < tentativa.length; j++) {
                        for (int k = 0; k < tentativa.length; k++) {
                            if ((!validacao[i]) && (tentativa[i] == senha[j]) && (tentativa[i] != tentativa[k])
                                    && (tentativa[k] != tentativa[j])) {
                                digDeslocados++;
                                validacao[i] = true;
                            }
                        }
                    }
                }
            }

            System.out.println("Tentativa " + contTentativa + ": " + Arrays.toString(tentativa));
            System.out.println("Dígitos corretos: " + digCorreto);
            System.out.println("Dígitos deslocados: " + digDeslocados);
            if (digCorreto < 4) {
                System.out.println("SENHA INCORRETA!");
                digCorreto = 0;
                digDeslocados = 0;
            }
            System.out.println();

        }

        if (digCorreto == 4) {
            System.out.println("PARABÉNS! SENHA CORRETA!");
            System.out.println("Tentativa " + contTentativa + ": " + Arrays.toString(tentativa));
        } else {
            System.out.println("O computador venceu! ;)");
            System.out.println("Senha correta: " + Arrays.toString(senha));

        }

    }
}
