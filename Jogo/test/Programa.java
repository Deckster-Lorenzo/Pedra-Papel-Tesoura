package academy.devdojo.maratonajava.javacore.Jogo.test;

import academy.devdojo.maratonajava.javacore.Jogo.dominio.OpcoesMao;

import java.util.Random;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        OpcoesMao[] opcoes = OpcoesMao.values();

        while(true) {
            OpcoesMao opcaoAleatoria = opcoes[random.nextInt(opcoes.length)];

            System.out.println("\n----- Pedra, Papel, Tesoura -----\n");
            System.out.println("[Pedra]  [Papel]  [Tesoura]");
            System.out.print("Digite sua escolha aqui: ");
            String escolha = entrada.nextLine();

            try {
                OpcoesMao minhaEscolha = OpcoesMao.valueOf(escolha.toLowerCase());
                System.out.println("\n");


                String resultado = "";
                if (opcaoAleatoria == minhaEscolha) {
                    resultado = "Empate";
                } else if (opcaoAleatoria == OpcoesMao.pedra && minhaEscolha == OpcoesMao.papel) {
                    resultado = "Derrota";
                } else if (opcaoAleatoria == OpcoesMao.pedra && minhaEscolha == OpcoesMao.tesoura) {
                    resultado = "Vitória";
                } else if (opcaoAleatoria == OpcoesMao.papel && minhaEscolha == OpcoesMao.pedra) {
                    resultado = "Derrota";
                } else if (opcaoAleatoria == OpcoesMao.papel && minhaEscolha == OpcoesMao.tesoura) {
                    resultado = "Vitória";
                } else if (opcaoAleatoria == OpcoesMao.tesoura && minhaEscolha == OpcoesMao.papel) {
                    resultado = "Derrota";
                } else if (opcaoAleatoria == OpcoesMao.tesoura && minhaEscolha == OpcoesMao.pedra) {
                    resultado = "Vitória";
                }

                System.out.println("Sua jogada: " + minhaEscolha);
                System.out.println("Jogada do Pc: " + opcaoAleatoria);
                System.out.println("Resultado: " + resultado);

                    System.out.println("\nGostaria de jogar denovo? [s/n]");
                    char denovo = entrada.nextLine().trim().charAt(0);
                    if (denovo == 'n' || denovo == 'N') {
                        return;
                    } else if (denovo == 's' || denovo == 'S') {
                        continue;
                    } else {
                        System.out.println("Digito inválido");
                        return;
                    }
            } catch (IllegalArgumentException e) {
                System.out.println("\nVocê digitou uma opção inválida!");
                entrada.nextLine();
            }
        }
    }
}
