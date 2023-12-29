package Graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Kelas untuk merepresentasikan sebuah edge (sisi) pada graf
class Edge {
    String destination; // Node tujuan
    int weight; // Bobot edge

    // Konstruktor untuk membuat edge
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class BfsGraphTraversal {
    private Map<String, List<Edge>> adjacencyList; // Adjacency list untuk merepresentasikan graf

    // Konstruktor untuk membuat objek BfsGraphTraversal
    public BfsGraphTraversal() {
        adjacencyList = new HashMap<>(); // Inisialisasi adjacency list
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>()); // Tambahkan node jika belum ada
    }

    // Menambahkan edge berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot ke daftar tetangga node sumber
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Mendapatkan daftar tetangga dan bobot dari node
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList()); // Kembalikan daftar tetangga, atau daftar
                                                                          // kosong jika node tidak ada
    }

    // BFS traversal dari node sumber
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>(); // Set untuk menyimpan node yang sudah dikunjungi
        Queue<String> queue = new LinkedList<>(); // Antrian untuk menyimpan node yang akan dikunjungi

        queue.add(start); // Tambahkan node awal ke antrian
        visited.add(start); // Tandai node awal sebagai sudah dikunjungi

        while (!queue.isEmpty()) {
            String current = queue.poll(); // Ambil node pertama dari antrian
            System.out.print(current + " "); // Cetak node saat ini

            // Iterasi melalui semua tetangga node saat ini
            for (Edge edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) { // Jika tetangga belum dikunjungi
                    queue.add(edge.destination); // Tambahkan tetangga ke antrian
                    visited.add(edge.destination); // Tandai tetangga sebagai sudah dikunjungi
                    // System.out.print("-> (" + edge.weight + ") " + edge.destination + " "); //
                    // Opsional: Cetak bobot edge
                }
            }
        }
        System.out.println(); // Cetak baris baru setelah selesai
    }

    // Metode main untuk demonstrasi
    public static void main(String[] args) {
        BfsGraphTraversal graph = new BfsGraphTraversal();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        graph.bfsTraversal("A"); // Mulai BFS traversal dari node A
    }
}