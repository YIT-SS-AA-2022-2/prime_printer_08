package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        //start!!
        final int numberOfPrimes = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 30;
        int P[] = new int[numberOfPrimes+1];
        int PAGENUMBER=1;
        int PAGEOFFSET=1;
        int ROWOFFSET;
        int C;
        int J=1;
        int primeIndex=1;
        boolean JPRIME;
        int ORD=2;
        int SQUARE=9;
        int N=0;
        int MULT[] = new int[ORDMAX+1];

        P[1] = 2;

        PrimeGenerator(numberOfPrimes, P, J, primeIndex, ORD, SQUARE, MULT);

        RowColumnPagePrinter(numberOfPrimes, RR, CC, P, PAGENUMBER, PAGEOFFSET);
    }

    private static void RowColumnPagePrinter(int M, int RR, int CC, int[] P, int PAGENUMBER, int PAGEOFFSET) {
        int ROWOFFSET;
        int C;
        while (PAGEOFFSET <= M) {
            System.out.print("The First ");
            System.out.print(Integer.toString(M));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET= PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + RR -1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= M)
                        System.out.printf("%10d", P[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR * CC;

        }
    }

    private static void PrimeGenerator(int M, int[] P, int J, int K, int ORD, int SQUARE, int[] MULT) {
        boolean JPRIME;
        int N;
        while (K < M) {
            do {
                J += 2;
                if( J == SQUARE) {
                    ORD++;
                    SQUARE = P[ORD]* P[ORD];
                    MULT[ORD -1]= J;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]< J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]= J;
        }
    }
}