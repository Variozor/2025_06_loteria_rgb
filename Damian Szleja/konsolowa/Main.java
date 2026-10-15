import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void losuj(int[][] zestawy) {
        Random los = new Random();
        for (int i = 0; i < zestawy.length; i++) {
            for (int j = 0; j < 6; j++) {
                boolean powtorzona;
                int liczba;
                do {
                    liczba = los.nextInt(49) + 1;
                    powtorzona = false;
                    for (int k = 0; k < j; k++) {
                        if (zestawy[i][k] == liczba) {
                            powtorzona = true;
                        }
                    }
                } while (powtorzona);
                zestawy[i][j] = liczba;
            }
        }
    }

    public static void wyswietl(int[][] zestawy) {
        for (int i = 0; i < zestawy.length; i++) {
            System.out.print("Zestaw " + (i + 1) + ": ");
            for (int liczba : zestawy[i]) {
                System.out.print(liczba + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner wejscie = new Scanner(System.in);
        int n = 0;
        while (n <= 0) {
            System.out.println("Ile zestawów wylosować? Podaj liczbę dodatnią:");
            if (wejscie.hasNextInt()) {
                n = wejscie.nextInt();
            } else {
                wejscie.next();
            }
        }
        int[][] zestawy = new int[n][6];
        losuj(zestawy);
        wyswietl(zestawy);
        int[] wystapienia = new int[50];
        for (int[] zestaw : zestawy) {
            for (int liczba : zestaw) {
                wystapienia[liczba]++;
            }
        }
        for (int i = 1; i <= 49; i++) {
            System.out.println("Wystąpienia liczby " + i + ": " + wystapienia[i]);
        }
    }
}
