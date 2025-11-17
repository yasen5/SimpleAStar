import java.util.HashSet;

import javax.swing.JFrame;

public class Runner {
	private static MinHeap<Point> tree = new MinHeap<>();
	private static HashSet<Point> discovered = new HashSet<>();
    private static int[][] grid = new int[][] {
        new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0},
        new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0},
        new int[] {0, 0, 0, 1, 1, 1, 0, 0, 0},
        new int[] {0, 0, 1, 1, 1, 1, 1, 0, 0},
		new int[] {0, 0, 1, 1, 1, 1, 1, 0, 0},
		new int[] {0, 0, 1, 1, 1, 1, 1, 0, 0},
		new int[] {0, 0, 0, 1, 1, 1, 0, 0, 0},
		new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0},
		new int[] {0, 0, 0, 0, 0, 0, 2, 0, 0}
    };
	public static void main(String[] args) {
		path();
		// JFrame frame = new JFrame("Grid Scene");
		// Screen sc = new Screen();
		

		// frame.add(sc);
		// frame.pack();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setVisible(true);
	}

	public static void path() {
		tree.insert(new Point(0, 0, null));
        while (true) {
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                Point point = tree.pop();
				System.out.println("Considering point: " + point);
                if (point.dist == 0) {
                    System.out.println("Optimal path: ");
					int[][] newGrid = grid;
                    while (point != null) {
						newGrid[point.y][point.x] = 3;
                        point = point.prev;
                    }
					for (int[] row : newGrid) {
						for (int num : row) {
							System.out.print(num);
						}
						System.out.println();
					}
                    return;
                }
                if (point.y + 1 < grid.length && grid[point.y + 1][point.x] != 1) {
					Point p = new Point(point.x, point.y + 1, point);
                    if (discovered.add(p)) tree.insert(p);
                }
                if (point.x + 1 < grid[0].length && grid[point.y][point.x + 1] != 1) {
					Point p = new Point(point.x + 1, point.y, point);
                    if (discovered.add(p)) tree.insert(p);
                }
                if (point.y + 1 < grid.length && point.x + 1 < grid[0].length && grid[point.y + 1][point.x + 1] != 1) {
					Point p = new Point(point.x + 1, point.y + 1, point);
                    if (discovered.add(p)) tree.insert(p);
                }
            }
			// try {
			// 	Thread.sleep(500);
			// } catch (InterruptedException e) {
			// 	System.out.println("Well done");
			// }
        }
    }
}
