package id.kawahedukasi.tugas5;

public class Main {
    public static void main(String[] args) {
        Account akun = new Account();
        Address alamatBudi = new Address(
                "Jl. Sudirman",
                "Central Jakarta",
                "Jakarta",
                "DKI Jakarta"
        );
        Account akunFull = new Account(
                "Budi",
                "budi123",
                "Budi Santoso",
                "Budi123@gmail.com",
                "081212341234",
                "01 Januari 2000",
                "Jakarta",
                alamatBudi
        );

        System.out.println(akun.getUsername());
        System.out.println(akunFull.getFullName());
        System.out.println(akunFull.getAddress().getStreet());
    }
}

