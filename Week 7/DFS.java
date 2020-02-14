import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {
    static int time = 0;

    public static void main (String args[]) {
        HashMap<String, Vertex> graph = new HashMap<String, Vertex>();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        List<Vertex> adjacency = new ArrayList<Vertex>();
        adjacency.add(v2);
        adjacency.add(v3);
        adjacency.add(v4);
        v1.setAdjacencyList(adjacency);

        adjacency = new ArrayList<Vertex>();
        adjacency.add(v4);
        adjacency.add(v5);
        v2.setAdjacencyList(adjacency);

        adjacency = new ArrayList<Vertex>();
        adjacency.add(v6);
        v3.setAdjacencyList(adjacency);

        adjacency = new ArrayList<Vertex>();
        adjacency.add(v3);
        adjacency.add(v6);
        adjacency.add(v7);
        v4.setAdjacencyList(adjacency);

        adjacency = new ArrayList<Vertex>();
        adjacency.add(v4);
        adjacency.add(v7);
        v5.setAdjacencyList(adjacency);

        adjacency = new ArrayList<Vertex>();
        v6.setAdjacencyList(adjacency);

        adjacency = new ArrayList<Vertex>();
        adjacency.add(v6);
        v7.setAdjacencyList(adjacency);

        graph.put("v1", v1);
        graph.put("v2", v2);
        graph.put("v3", v3);
        graph.put("v4", v4);
        graph.put("v5", v5);
        graph.put("v6", v6);
        graph.put("v7", v7);

        DFS dfs = new DFS();
        dfs.DFS(graph);

        for(String key : graph.keySet()) {
            System.out.println(key + " Discovery time:" + graph.get(key).getDiscoveryTime() + " Finishing time:" + graph.get(key).getFinishTime());

        }

    }

    public void DFS(HashMap<String, Vertex> graph) {
        for(String s : graph.keySet()) {
            Vertex v = graph.get(s);
            v.setColor("W");
        }

        for (String s : graph.keySet()) {
            Vertex v = graph.get(s);
            if (v.getColor().equals("W"))
                DFSVisit(v);
        }
    }

    public void DFSVisit(Vertex v) {
        v.setColor("G");
        time = time + 1;
        v.setDiscoveryTime(time);

        for (Vertex adjVertex : v.getAdjacencyList()) {
            if (adjVertex.getColor().equals("W"))
                DFSVisit(adjVertex);
        }

        v.setColor("B");
        time = time + 1;
        v.setFinishTime(time);
    }


}