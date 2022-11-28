package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        //start!!
        final int rowNum = 1000;
        final int colNum = 50;
        final int Num = 4;
        final int ORDMAX = 30;
        int P[] = new int[rowNum+1];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;
        int J=1;
        int K=1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE = 9;
        int N=0;
        int MULT[] = new int[ORDMAX+1];


        P[1] = 2;
        // ??


        while (K < rowNum) {
            do {
                J += 2;
                if( J == SQUARE) {
                    ORD++;
                    SQUARE=P[ORD]*P[ORD];
                    MULT[ORD-1]=J;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]=J;
        }
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= rowNum) {
            System.out.print("The First ");
            System.out.print(Integer.toString(rowNum));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+colNum-1; ROWOFFSET++) {
                for (C = 0; C <= Num - 1; C++)
                    if (ROWOFFSET + C * colNum <= rowNum)
                        System.out.printf("%10d", P[ROWOFFSET + C * colNum]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += colNum*Num;

        }
    }
}