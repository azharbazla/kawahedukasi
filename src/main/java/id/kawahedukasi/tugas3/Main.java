package id.kawahedukasi.tugas3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //outputKalimat();
        //duaVariable();
        //tigaString();
        //castingVariable();
        //hariLibur();
        //loopingAngka();
        //reformatTanggal();
        tanggalKadaluarsa();

    }

    static void reformatTanggal() {
        LocalDateTime time = LocalDateTime.of(2022,11,12,9,11,12);
        System.out.println(time.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss")));
    }

    static void tanggalKadaluarsa() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expTime =
                (currentTime.plusYears(1).
                        plusMonths(6).
                        plusDays(12).
                        plusHours(3).
                        plusMinutes(12).
                        plusSeconds(20));
        System.out.println("Tanggal Sekarang : " +
                currentTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
        System.out.println("Tanggal Kadaluarsa : " +
                expTime.format((DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
    }

    static void outputKalimat() {
        Scanner scanner = new Scanner(System.in);
        String nama = scanner.nextLine();
        System.out.println("Selamat datang di bootcamp Kawah Edukasi, " + nama);
    }

    static void duaVariable() {
        short short1 = 1, short2 = 2;
        double double1 = 0.1, double2 = 0.2;
        char char1 = 'A', char2 = 'B';
        boolean boolean1 = true, boolean2 = false;
    }

    static void tigaString() {
        String a ,b, c;
        a = "Saya senang";
        b = "belajar";
        c = "Java Language";

        System.out.println(a + " " + b + " " + c);
        System.out.println(a.concat(" " +b.concat(" "+c)));
    }

    static void castingVariable() {
        double myDouble = 999.99d;

        //double to integer
        int myInt = (int) myDouble;
        System.out.println(myInt);

        //integer to float
        float myFloat = (float) myInt;
        System.out.println(myFloat);

        short myShort = (short) myFloat;
        System.out.println(myShort);
    }

    public static final String HARI_LIBUR = "Hari Libur";
    public static final String HARI_KERJA = "Hari Kerja";
    static void hariLibur() {
        Scanner scanner = new Scanner(System.in);
        String hari = scanner.nextLine();
        if (hari.equalsIgnoreCase("sabtu") || hari.equalsIgnoreCase("minggu")) {
            System.out.println(hari + " merupakan " + HARI_LIBUR);
        }
        else {
            System.out.println("Apakah Hari Libur? (true/false)");
            boolean isLibur = scanner.nextBoolean();
            if (isLibur) {
                System.out.println(hari + " merupakan " + HARI_LIBUR);
            }
            else {
                System.out.println(hari + " merupakan " + HARI_KERJA);
            }
        }
    }

    static void loopingAngka() {
        for (int i = 1; i <= 100; i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.print("KawahEdukasi,");
            } else if (i % 3 == 0) {
                System.out.print("Kawah,");
            } else if (i % 5 == 0) {
                System.out.print("Edukasi,");
            } else {
                System.out.print(i + ",");
            }
        }
    }
}
