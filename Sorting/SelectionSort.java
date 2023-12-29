public class SelectionSort {

    /**
     * Metode untuk melakukan pengurutan menggunakan algoritma Selection Sort.
     * 
     * @param array Array yang akan diurutkan
     * @return Array yang telah diurutkan
     */
    public static int[] selectionSort(int[] array) {
        int n = array.length;

        // Loop untuk memproses seluruh elemen dalam array
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            // Loop untuk mencari elemen terkecil di antara elemen yang belum diurutkan
            for (int j = i + 1; j < n; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            // Pertukaran elemen terkecil dengan elemen pertama yang belum diurutkan
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        // Array awal yang akan diurutkan
        int[] array = { 5, 2, 4, 1, 3 };

        // Memanggil metode selectionSort untuk mengurutkan array
        array = selectionSort(array);

        // Menampilkan array yang telah diurutkan
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
