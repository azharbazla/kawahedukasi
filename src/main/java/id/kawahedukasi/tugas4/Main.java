package id.kawahedukasi.tugas4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//      a. List Nama makanan minimal 10 data
        List<String> makanan = new ArrayList<>(Arrays.asList(
                "Bakso", "Mie Ayam", "Nasi Goreng", "Ayam Bakar", "Ayam Goreng",
                "Ayam Bakar", "Nasi Liwet", "Nasi Uduk", "Lontong Sayur", "Sate"
        ));
        System.out.println(makanan);

//      b. List Tahun Piala Dunian minimal 3 data
        List<Integer> tahunPildun = new ArrayList<>() {{
            for (int tahun = 1930; tahun <= 2030; tahun += 4) {
                add(tahun);
            }
        }};
        System.out.println(tahunPildun);

//      c. Implement sort pada list nama provinsi minimal 10 data secara descending
        List<String> provinsi = new ArrayList<>(Arrays.asList(
                "Naggroe Aceh Darussalam", "Sumatra Utara", "Sumatra Selatan", "Sumatra Barat", "Jambi",
                "Bengkulu", "Riau", "Kepulauan Riau", "Lampung", "Bangka Belitung"
        ));
        provinsi.sort(Comparator.reverseOrder());
        System.out.println(provinsi);

//      d. Implement penghapusan data pada sebuah list
        provinsi.remove("Bangka Belitung");
        int index = 0;
        for (String s : provinsi) {
            index++;
            if (index == provinsi.size()) {
                System.out.print(s + ".");
            } else {
                System.out.print(s + ", ");
            }
        }

        ArrayList<String> test = new ArrayList<>(Arrays.asList("a", "b", "c"));
        test.sort(Comparator.naturalOrder());
        System.out.println(test);
    }
}

