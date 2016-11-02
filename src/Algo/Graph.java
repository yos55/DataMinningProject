package Algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Graph {

    ArrayList<String[]> graph[];
    private int cols;
    static final String fileName = "matrix_init.txt";
    BufferedReader br;

    public Graph() {
        readFromFile();
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    @SuppressWarnings("unchecked")
	private void readFromFile() {
        String line;
        try {
            br = new BufferedReader(new FileReader(fileName));
            line = br.readLine();
            StringTokenizer st0 = new StringTokenizer(line, ",");
            cols = Integer.parseInt(st0.nextToken());
            graph = new ArrayList[cols];
            int i = 0;
            while ((line = br.readLine()) != null) {
                graph[i] = new ArrayList<String[]>();
                StringTokenizer st1 = new StringTokenizer(line, ",");
                while (st1.hasMoreTokens()) {
                    String filed = st1.nextToken();
                    StringTokenizer st2 = new StringTokenizer(filed, " ");
                    String[] attributes = new String[st2.countTokens()];
                    int j = 0;
                    while (st2.hasMoreTokens()) {
                        String attribute = st2.nextToken();
                        attributes[j] = attribute;
                        j++;
                    }
                    graph[i].add(attributes);
                }
                i++;

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String[] getAttributes(int VertexX, int VertexY) {
        return graph[VertexX].get(VertexY);
    }

    public void readFromMatrixCreator() {

    }

    @Override
    public String toString() {
        String toPrint = "";
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                for (int r = 0; r < graph[i].get(j).length; r++) {
                    toPrint += graph[i].get(j)[r] + ", ";
                }
                toPrint += " | ";
            }
            toPrint += "\n";
        }
        return toPrint;
    }

    
}
