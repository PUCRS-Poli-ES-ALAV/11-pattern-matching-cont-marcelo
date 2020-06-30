package com.pucrs.aula;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    private static String CONSTANTE = "batataz";

    public static void main(String[] args) {

        int num[] = {100, 1000, 10000, 100000, 500000, 1000000};

        for (int i = 0; i < num.length; i++) {
            System.out.println();

            String palavra = geraString(num[i]);

            long startForce = System.nanoTime();
            KMP.KMPSearch(CONSTANTE, palavra);
            long elapsedTimeForce = (System.nanoTime() - startForce);
            long milissigundos = TimeUnit.NANOSECONDS.toMillis(elapsedTimeForce);

            System.out.printf("KMPSearch Tamanho: %d \n" +
                            "Tempo de Execucao: %d milissegundos\n" +
                            "Iterações: %d \n" +
                            "Instruções: %d",
                    num[i], milissigundos, KMP.ITERACOES, KMP.INSTRUCOES);

            KMP.zerarIteracoesEInstrucoes();
            System.out.println();

        }

    }

    //Gera palavras de A a Y, deixando o Z de fora, para que não seja possivel ser gerado a palavra batataz aleatoriamente.
    private static String geraString(int size) {
        StringBuilder res = new StringBuilder();
        String charStr = CONSTANTE;
        if (size > 99) {
            for (int i = 0; i < size - CONSTANTE.length(); i++) {

                Random r = new Random();
                char c = (char) (r.nextInt(25) + 'a');
                res.append(c);
            }
        }
        return res.toString() + CONSTANTE;
    }
}
