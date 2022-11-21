
import java.util.*;
class Graph {
    private final int numVertices;
    private final ArrayList<ArrayList<Integer>> adjList;
    public Graph(int numVertices)
    {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; ++i)
            adjList.add(new ArrayList<Integer>());
    }
    public void addEdge(int v, int w)
    {
        adjList.get(v).add(w);
    }
    public List<Integer> topologicalSort()
    {
        int[] indegree = new int[numVertices];
        for (int i = 0; i < numVertices; i++)
        {
            ArrayList<Integer> temp = adjList.get(i);
            for (int node : temp)
            {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numVertices; i++)
        {
            if (indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int cnt = 0;
        List<Integer> topOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);
            for (int node : adjList.get(u))
            {
                if (--indegree[node] == 0)
                {
                    q.add(node);
                }
            }
            cnt++;
        }
        if (cnt != numVertices)
        {
            System.out.println("There exists a cycle in the graph");
            return null;
        }
        return topOrder;
    }
}