package Graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Edge implements Comparable<Edge> {
    String source;
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edge
    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Metode untuk membandingkan edge berdasarkan bobotnya
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class PrimGraphTraversal {

    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor untuk membuat objek PrimGraphTraversal
    public PrimGraphTraversal() {
        // Inisialisasi struktur data untuk menyimpan hubungan antar node dengan bobot
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Jika node belum ada dalam graf, tambahkan sebagai kunci baru
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke dalam graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot dari source ke destination
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        // Uncomment baris di bawah untuk graf tidak terarah (arah dua arah)
        // adjacencyList.get(destination).add(new Edge(destination, source, weight));
    }

    // Mendapatkan daftar tetangga dan bobot dari suatu node
    public List<Edge> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dan bobot dari node atau daftar kosong jika
        // node tidak ditemukan
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Algoritma Prim untuk mencari Minimum Spanning Tree (MST)
    public void primMST(String start) {
        // PriorityQueue untuk memilih edge dengan bobot terkecil
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> inMST = new HashSet<>();
        Map<String, Edge> edgeTo = new HashMap<>();

        // Inisialisasi dengan node awal
        inMST.add(start);
        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            pq.add(edge);
            edgeTo.put(edge.destination, edge);
        }

        // Iterasi hingga semua node tercakup dalam MST
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST.contains(edge.destination))
                continue;

            inMST.add(edge.destination);
            // Menampilkan edge yang ditambahkan ke MST
            System.out
                    .println(edgeTo.get(edge.destination).source + " - " + edge.destination + " [" + edge.weight + "]");

            // Memproses tetangga-tetangga dari node yang baru ditambahkan ke MST
            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                if (!inMST.contains(nextEdge.destination)) {
                    pq.add(nextEdge);
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }
    }

    // Metode utama untuk menguji implementasi PrimGraphTraversal
    public static void main(String[] args) {
        PrimGraphTraversal graph = new PrimGraphTraversal();

        // Menambahkan node-node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge ke graf dengan bobot
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Menjalankan algoritma Prim untuk mencari Minimum Spanning Tree (MST)
        graph.primMST("A");
    }
}
