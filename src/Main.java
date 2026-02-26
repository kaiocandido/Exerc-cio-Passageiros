import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de passageiros: ");
        int N = Integer.parseInt(sc.nextLine());

        // Lista com nomes de passageiros
        String[] nomes = new String[N];
        // Entrada
        int[] E = new int[N];
        // Saida
        int[] S = new int[N];

        // Lê N passageiros: nome, entrada e saída
        for (int i = 0; i < N; i++) {
            System.out.println("\nPassageiro " + (i + 1) + ":");

            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();

            System.out.print("Entrada (1..1000): ");
            E[i] = Integer.parseInt(sc.nextLine());

            System.out.print("Saída (1..1000): ");
            S[i] = Integer.parseInt(sc.nextLine());
        }

        // delta[t] representa a variação da lotação no tempo t
        int[] delta = new int[1002];

        // Marca entradas e saídas
        for (int i = 0; i < N; i++) {
            delta[E[i]] += 1; // entra
            delta[S[i]] -= 1; // sai
        }

        // Varre o tempo e acha o máximo
        int atuais = 0;
        int maximo = 0;

        for (int t = 1; t < delta.length; t++) {
            atuais += delta[t];
            if (atuais > maximo) maximo = atuais;
        }

        System.out.println("\nLotação máxima na sala: " + maximo);

        sc.close();
    }
}