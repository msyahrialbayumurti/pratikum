package Graph.Graph;

import java.util.*;

class StringGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat objek StringGraph
    public StringGraph() {
        // Inisialisasi struktur data untuk menyimpan hubungan antar node dengan label
        // string
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Jika node belum ada dalam graf, tambahkan sebagai kunci baru dengan daftar
        // tetangga kosong
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke dalam graf
    public void addEdge(String source, String destination) {
        // Tambahkan destination ke daftar tetangga dari source
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut untuk menambahkan edge
        // sebaliknya
        // adjacencyList.get(destination).add(source);
    }

    // Mencetak graf, menampilkan setiap node dan tetangganya
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode utama untuk menguji implementasi StringGraph
    public static void main(String[] args) {
        StringGraph graph = new StringGraph();

        // Menambahkan node-node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge ke graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak graf untuk menunjukkan hubungan antar node
        graph.printGraph();
    }
}
