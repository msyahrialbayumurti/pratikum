public class InsertionSort {

    /**
     * Metode untuk melakukan pengurutan menggunakan algoritma Insertion Sort.
     * 
     * @param array Array yang akan diurutkan
     * @return Array yang telah diurutkan
     */
    static int[] insertion(int[] array) {
        int ukuran = array.length;
        int max, j;
        int i = 1;

        // Loop untuk memproses seluruh elemen dalam array
        while (i < ukuran) {
            max = array[i];
            j = i;

            // Loop untuk mencari posisi yang benar untuk elemen saat ini
            for (j = i; j > 0; j--) {
                // Jika elemen sebelumnya lebih besar, lakukan pertukaran
                if (max < array[j - 1]) {
                    array[j] = array[j - 1];
                }
            }

            // Menempatkan elemen pada posisi yang benar
            array[j] = max;
            i++;
        }

        return array;
    }
}
