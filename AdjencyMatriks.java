import java.util.LinkedList;

public class AdjencyMatriks {
    private LinkedList<Integer> adj[];
    AdjencyMatriks(int v){
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void insertEdge(int V, int E){
        adj[V].add(E);
    }
    public void printGraph(){
        System.out.println("Daftar graph: ");
        for (int i = 0; i < adj.length; i++){
            for (int j : adj[i]){
                System.out.println("Edge "+i+"->"+j);
            }
        }
    }
    public void printAdjencyMatriks(){
        System.out.println("\nAdjancency Matrix");
        System.out.print("   ");
        for (int i = 0; i < adj.length; i++){
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = 0; i < adj.length; i++){
            System.out.printf("%3d", i);
            for (int j = 0; j < adj.length; j++){
                if (adj[i].contains(j)){
                    System.out.printf("%3d", 1);
                }else {
                    System.out.printf("%3d", 0);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        AdjencyMatriks adjencyMatriks = new AdjencyMatriks(10);

        adjencyMatriks.insertEdge(0,1);
        adjencyMatriks.insertEdge(0,2);
        adjencyMatriks.insertEdge(0,3);
        adjencyMatriks.insertEdge(1,3);
        adjencyMatriks.insertEdge(2,3);
        adjencyMatriks.insertEdge(2,4);
        adjencyMatriks.insertEdge(3,5);
        adjencyMatriks.insertEdge(3,6);
        adjencyMatriks.insertEdge(4,5);
        adjencyMatriks.insertEdge(4,7);
        adjencyMatriks.insertEdge(7,8);
        adjencyMatriks.insertEdge(8,9);

        adjencyMatriks.printGraph();
        adjencyMatriks.printAdjencyMatriks();



    }
}
