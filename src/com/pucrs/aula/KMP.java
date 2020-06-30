package com.pucrs.aula;

class KMP {
    public static int INSTRUCOES = 0;
    public static int ITERACOES = 0;

    static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // cria lps[] que vai guardar o maior
        // valor prefixo sufixo para o padrão
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Calcula lps[]
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]

        adicionaInstrucao(9);
        while (i < N) {
            adicionarIteracao();
            adicionaInstrucao(3);
            if (pat.charAt(j) == txt.charAt(i)) {
                adicionaInstrucao(4);
                j++;
                i++;
            }
            adicionaInstrucao(1);
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));

                adicionaInstrucao(3);
                j = lps[j - 1];
            }

            // mismatch após j matches
            else
                adicionaInstrucao(5);
            if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Não faz match dos caracteres lps[0..lps[j-1]],
                // não é necesssário, eles combinarão
                adicionaInstrucao(1);
                if (j != 0) {
                    adicionaInstrucao(3);
                    j = lps[j - 1];
                } else {
                    adicionaInstrucao(2);
                    i = i + 1;
                }
            }
        }
    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        // tamanho do maior prefixo sufixo anterior
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // loop calcula lps[i] for i = 1 to M-1
        adicionaInstrucao(5);
        while (i < M) {
            adicionarIteracao();
            adicionaInstrucao(3);
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                adicionaInstrucao(6);
            } else // (pat[i] != pat[len])
            {
                adicionaInstrucao(1);
                if (len != 0) {
                    adicionaInstrucao(3);
                    len = lps[len - 1];
                } else // if (len == 0)
                {
                    adicionaInstrucao(4);
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    static void zerarIteracoesEInstrucoes() {
        INSTRUCOES = 0;
        ITERACOES = 0;
    }

    static void adicionarIteracao() {
        ITERACOES++;
    }

    static void adicionaInstrucao(int quantidade) {
        INSTRUCOES += quantidade;
    }
}