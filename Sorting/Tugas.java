public class Tugas {
    public static void main(String[] args) {

        // Array berisi beberapa string
        String[] strings = { "buaya", "ayam", "orang utan", "gajah", "kelinci" };

        // Memanggil metode sort untuk mengurutkan array
        sort(strings);

        // Menampilkan array yang telah diurutkan
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * Metode untuk melakukan pengurutan array string menggunakan algoritma Bubble
     * Sort.
     * 
     * @param arr Array string yang akan diurutkan
     */
    static void sort(String[] arr) {
        // Loop bersarang untuk membandingkan dan menukar elemen-elemen menggunakan
        // Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Tukar arr[j] dan arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
