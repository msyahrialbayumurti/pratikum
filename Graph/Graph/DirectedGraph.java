package Graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat objek DirectedGraph
    public DirectedGraph() {
        // Inisialisasi struktur data untuk menyimpan hubungan antar node
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Jika node belum ada dalam graf, tambahkan sebagai kunci baru
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke dalam graf (hanya satu arah untuk graf berarah)
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    // Mendapatkan daftar tetangga dari suatu node
    public List<String> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dari node atau daftar kosong jika node tidak
        // ditemukan
        return adjacencyList.getOrDefault(node, Collections.emptyList());
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

    // Metode utama untuk menguji implementasi DirectedGraph
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

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
