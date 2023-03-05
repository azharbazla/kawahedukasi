package id.kawahedukasi.game;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int guess = 0;
        int numGuesses = 0;

        System.out.println("Ayo main tebak angka!");
        System.out.println("Saya akan memilih sebuah angka antara 1 dan 100.");
        System.out.println("Silakan tebak angka yang saya pilih.");

        while (guess != secretNumber) {
            System.out.print("Tebakanmu: ");
            guess = scanner.nextInt();
            numGuesses++;

            if (guess < secretNumber) {
                System.out.println("Terlalu rendah! Coba lagi.");
            } else if (guess > secretNumber) {
                System.out.println("Terlalu tinggi! Coba lagi.");
            } else {
                System.out.println("Tebakanmu benar!");
                System.out.println("Jumlah tebakanmu: " + numGuesses);
            }
        }
    }
}

