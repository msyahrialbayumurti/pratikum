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

class DijkstraGraph {
    private final Map<Integer, List<Node>> adjacencyList;

    public DijkstraGraph() {
        // Inisialisasi struktur data untuk menyimpan hubungan antar node
        adjacencyList = new HashMap<>();
    }

    // Menambahkan rute (edge) baru ke dalam graf
    public void addEdge(int source, int destination, int weight) {
        // Jika node sumber belum ada dalam graf, tambahkan sebagai kunci baru
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        // Tambahkan node tujuan bersama dengan bobot (weight) ke dalam daftar tetangga
        // node sumber
        adjacencyList.get(source).add(new Node(destination, weight));
    }

    // Algoritma Dijkstra untuk menemukan lintasan terpendek
    public int dijkstra(int start, int end) {
        // Antrian prioritas untuk mengelola node berdasarkan jarak terpendek
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        // Menyimpan jarak terpendek dari node awal ke setiap node
        Map<Integer, Integer> distances = new HashMap<>();
        // Set untuk melacak node yang sudah dikunjungi
        Set<Integer> visited = new HashSet<>();

        // Inisialisasi jarak awal
        for (int node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(start, 0);
        queue.add(new Node(start, 0));

        // Algoritma Dijkstra
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentNodeId = currentNode.node;

            // Skip node yang sudah dikunjungi
            if (visited.contains(currentNodeId)) {
                continue;
            }
            visited.add(currentNodeId);

            // Periksa tetangga-tetangga dari currentNode
            for (Node neighbor : adjacencyList.getOrDefault(currentNodeId, Collections.emptyList())) {
                int newDist = distances.get(currentNodeId) + neighbor.weight;

                // Jika ditemukan jarak yang lebih pendek, perbarui jarak dan tambahkan ke
                // antrian
                if (newDist < distances.get(neighbor.node)) {
                    distances.replace(neighbor.node, newDist);
                    queue.add(new Node(neighbor.node, newDist));
                }
            }
        }
        // Mengembalikan jarak terpendek dari node awal ke node akhir
        return distances.get(end);
    }

    // Representasi node dalam graf
    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Metode utama untuk menguji implementasi DijkstraGraph
    public static void main(String[] args) {
        DijkstraGraph graph = new DijkstraGraph();

        // Menambahkan rute-rute pada graf
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);

        // Menggunakan algoritma Dijkstra untuk mencari lintasan terpendek dari node 0
        // ke node 3
        int shortestPath = graph.dijkstra(0, 3);

        // Menampilkan hasil
        System.out.println("Jarak terpendek dari 0 ke 3: " + shortestPath);
    }
}
