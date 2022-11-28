package com.cleancode;

public class PrimePrinter {
    public static void main(String[] args) {
        //start!!

        int Primes[] = new int[getLinePageRowCol(1000, 1)];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int column;
        int canDidate=1;
        int PrimeIndex=1;
        boolean possiblyPrime;
        int ORD = 2;
        int SQUARE = 9;
        int N=0;
        int multiples[] = new int[getLinePageRowCol(30, 1)];


        Primes[1] = 2;
        // ??


        while (PrimeIndex < 1000) {
            do {
                canDidate += 2;
                if( canDidate == SQUARE) {
                    ORD++;
                    SQUARE= getColumn(Primes[ORD], Primes[ORD]);
                    multiples[ORD-1]=canDidate;
                }
                N=2;
                possiblyPrime = primeTruePoss(Primes, canDidate, ORD, N, multiples);
            } while (!possiblyPrime);
            PrimeIndex++;
            Primes[PrimeIndex]=canDidate;
        }
        PAGENUMBER = 1;
        PAGEOFFSET = 1;


        pageResultprint(1000, 50, 4, Primes, PAGENUMBER, PAGEOFFSET);

    }

    private static boolean primeTruePoss(int[] Primes, int canDidate, int ORD, int N, int[] multiples) {
        boolean possiblyPrime;
        possiblyPrime= true;
        possiblyPrime = isPossiblyPrime(Primes, canDidate, possiblyPrime, ORD, N, multiples);
        return possiblyPrime;
    }

    private static boolean isPossiblyPrime(int[] Primes, int canDidate, boolean possiblyPrime, int ORD, int N, int[] multiples) {
        while (N < ORD && possiblyPrime) {
            getMultiRowCol(Primes, canDidate, N, multiples);
            possiblyPrime = isPossiblyPrime(canDidate, possiblyPrime, N, multiples);
            N++;
        }
        return possiblyPrime;
    }

    private static void getMultiRowCol(int[] Primes, int canDidate, int N, int[] multiples) {
        while (multiples[N]< canDidate)
            multiples[N] += getLinePageRowCol(Primes[N], Primes[N]);
    }

    private static boolean isPossiblyPrime(int canDidate, boolean possiblyPrime, int N, int[] multiples) {
        if (multiples[N] == canDidate)
            possiblyPrime =false;
        return possiblyPrime;
    }

    private static void pageResultprint(int numberOfPrimes, int linesPerPage, int columnNumbers, int[] Primes, int PAGENUMBER, int PAGEOFFSET) {
        while (PAGEOFFSET <= numberOfPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfPrimes));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");

            pagePrimeprint(numberOfPrimes, linesPerPage, columnNumbers, Primes, PAGEOFFSET);

            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += getColumn(columnNumbers, linesPerPage);

        }
    }

    private static void pagePrimeprint(int numberOfPrimes, int linesPerPage, int columnNumbers, int[] Primes, int PAGEOFFSET) {
        int column;
        int ROWOFFSET;
        for (ROWOFFSET= PAGEOFFSET; ROWOFFSET <= getLinePageRowCol(PAGEOFFSET, linesPerPage) -1; ROWOFFSET++) {
            for (column = 0; column <= columnNumbers - 1; column++)
                if (getLinePageRowCol(ROWOFFSET, getColumn(linesPerPage, column)) <= numberOfPrimes)
                    System.out.printf("%10d", Primes[getLinePageRowCol(ROWOFFSET, getColumn(linesPerPage, column))]);
            System.out.println();
        }
    }

    private static int getColumn(int linesPerPage, int column) {
        return column * linesPerPage;
    }

    private static int getLinePageRowCol(int ROWOFFSET, int column) {
        return ROWOFFSET + column;
    }
}