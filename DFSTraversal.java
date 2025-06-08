import java.util.Iterator;
import java.util.LinkedList;

public class DFSTraversal {
    private LinkedList<Integer> adj[];
    private boolean visited[];
    DFSTraversal(int v){
        adj = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    void insertEdge(int src, int dest){
        adj[src].add(dest); //ini untuk directed (graf terarah) graph
    }
    void DFS(int vertex){
        visited[vertex] = true; //tandai node/vertex yang dikunjungi
        System.out.println(vertex +" ");

        Iterator<Integer> iterator = adj[vertex].listIterator();
        while (iterator.hasNext()){
            int node = iterator.next(); // jika tetangganya ada maka ambil node tetangga nya
            if (!visited[node]){
                DFS(node); // melakukan DFS secara rekursif untuk mengunjugi lebih dalam
            } //ketika sudah sampe mengunjungi node terakhir maka dia akan naik kembali ke node yg telah dikunjungi dan sambil cek apakah ada node yang belum dikunjungi
        }
    }
   public static void main(String[] args) {
        DFSTraversal graph = new DFSTraversal(8);

        graph.insertEdge(0,1);
        graph.insertEdge(0,2);
        graph.insertEdge(0,3);
        graph.insertEdge(1,3);
        graph.insertEdge(2,4);
        graph.insertEdge(3,5);
        graph.insertEdge(3,6);
        graph.insertEdge(4,7);
        graph.insertEdge(4,5);
        graph.insertEdge(5,2);

        System.out.println("Depth First Traversal untuk graf adalah: ");
        graph.DFS(0);
    }
}
