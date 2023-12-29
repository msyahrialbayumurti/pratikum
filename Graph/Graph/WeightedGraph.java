package Graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edge {
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edge berbobot
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor untuk membuat objek WeightedGraph
    public WeightedGraph() {
        // Inisialisasi struktur data untuk menyimpan hubungan antar node dengan bobot
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Jika node belum ada dalam graf, tambahkan sebagai kunci baru dengan daftar
        // tetangga kosong
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke dalam graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot ke daftar tetangga dari source
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Mencetak graf, menampilkan setiap node dan edge berbobot yang terhubung
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Metode utama untuk menguji implementasi WeightedGraph
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        // Menambahkan node-node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge berbobot ke graf
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Mencetak graf untuk menunjukkan hubungan antar node dengan bobot
        graph.printGraph();
    }
}
