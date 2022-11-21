public class Main
{
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("The topological sorting of the graph is given as:");
        System.out.println(g.topologicalSort());     } }