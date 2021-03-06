package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    public MazeCycles(Maze m) {
        super(m);
    }

    @Override
    public void solve() {
        cycleDetect(0);
    }

    private void cycleDetect(int v) {
        marked[v] = true;
        announce();

        for (int w : maze.adj(v)) {
            if (marked[w]) {
                if (w != edgeTo[v]) {
                    return;
                }
            } else {
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                cycleDetect(w);
            }
        }
    }
}

