
import java.util.List;

/**
 * This is an interface for graph.
 * @author Twinkle Garg
 *
 */
public interface GraphInterface {

    boolean isConnected();

    List<Integer> reachable(int vertex);

    List<Edge> mst();

    int shortestPath(int vertex1, int vertex2);
}