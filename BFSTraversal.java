import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int node;
    private LinkedList<Integer> adj[]; //artinya ini bukan linkedlist biasa melainkan akan dibuatkan array dari linkedlist ini
    private Queue<Integer> que;
    BFSTraversal(int v){
        node = v;
        adj = new LinkedList[node]; //membuat array dari linkedlist
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>(); //linkedlist dari array indeks ke i
        }
        que = new LinkedList<>(); //linkedlist adalah salah satu implementasi dari queue di java, jadi queue itu hanya cara aksesnya dengan menggunakan FIFO sedangkan linkedlist itu cara simpan datanya
    }
    public void insertEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);
        //ini berlaku untuk undirect (tidak berarah) graph
    }
    public void BFS(int n){
        boolean nodes[] = new boolean[node];
        nodes[n] = true;
        que.add(n);
        while (que.size() != 0){
            n = que.poll();
            System.out.println(n + " ");
            for (int i = 0; i < adj[n].size(); i++){
                int a = adj[n].get(i);
                if (!nodes[a]){ //cek apakah node a ada
                    nodes[a] = true; //tandai node a
                    que.add(a); //simpan node a
                }
            }
        }
    }
    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 3);
        graph.insertEdge(0, 4);
        graph.insertEdge(4, 5);
        graph.insertEdge(3, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 0);
        graph.insertEdge(2, 1);
        graph.insertEdge(4, 1);
        graph.insertEdge(3, 1);
        graph.insertEdge(5, 4);
        graph.insertEdge(5, 3);

        System.out.println("Breadth First Traversal unutk graf adalah: ");
        graph.BFS(0);
        System.out.println("\nKalo dimulai dari 3");
        graph.BFS(3);
    }
}