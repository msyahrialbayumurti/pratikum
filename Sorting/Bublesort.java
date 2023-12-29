import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bublesort {

    public static void main(String[] args) {
        // Jumlah data yang akan diurutkan
        int jumlahData = 0;
        // Variabel sementara untuk pertukaran nilai
        int temp = 0;
        // Array untuk menyimpan data
        int[] dataArray;

        // Meminta pengguna untuk memasukkan jumlah data yang akan diurutkan
        System.out.println("Berapa banyak data yang ingin Anda urutkan?");
        jumlahData = inputJumlahData();

        // Inisialisasi array berdasarkan jumlah data yang diinputkan
        dataArray = new int[jumlahData];

        // Meminta pengguna untuk memasukkan data ke dalam array
        for (int i = 0; i < jumlahData; i++) {
            System.out.print("Masukkan data ke-" + (i + 1) + ": ");
            dataArray[i] = inputData();
        }

        // Proses Bubble Sort
        for (int i = 1; i < jumlahData; i++) {
            for (int j = 0; j < jumlahData - i; j++) {
                // Jika data tidak terurut, lakukan pertukaran nilai
                if (dataArray[j] > dataArray[j + 1]) {
                    temp = dataArray[j];
                    dataArray[j] = dataArray[j + 1];
                    dataArray[j + 1] = temp;
                }
            }
        }

        // Menampilkan hasil pengurutan
        System.out.println("Setelah diurutkan: ");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Data ke-" + (i + 1) + ": " + dataArray[i]);
        }
    }

    // Metode untuk memastikan input jumlah data valid
    static int inputJumlahData() {
        int jumlahData;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Meminta input jumlah data
        try {
            jumlahData = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Mohon masukkan angka yang valid.");
            jumlahData = inputJumlahData(); // Rekursi jika input tidak valid
        }

        return jumlahData;
    }

    // Metode untuk memastikan input data valid
    static int inputData() {
        int data;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Meminta input data
        try {
            data = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Mohon masukkan angka yang valid.");
            data = inputData(); // Rekursi jika input tidak valid
        }

        return data;
    }
}
