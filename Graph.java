
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public abstract class Graph {
	protected int[][] matrix;

	public Graph(String pathText) throws IOException {
		super();

		loadGraph(pathText);

	}

	public void loadGraph(String pathFile) throws IOException {

		File file = new File(pathFile);
		try {

			FileReader fl = new FileReader(file);
			BufferedReader br = new BufferedReader(fl);
			String line = "";
			int size = Integer.valueOf(br.readLine());
			int rows = 0;
			this.matrix = new int[size][size];
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(" ");
				for (int i = 0; i < temp.length; i++) {
					this.matrix[rows][i] = Integer.valueOf(temp[i]);

				}
				rows++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printArr() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public void printWeightArr() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0)
					matrix[i][j] = 1000;
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}

	}

	public abstract void algDjik(int s, int dest);

	public abstract void algDjik(int src);

	public boolean isConnected() {
	    boolean[] visited = new boolean[matrix.length];
	    int start = 0;

	    // Khởi chạy BFS từ đỉnh start
	    bfs(start, visited);

	    // Kiểm tra xem tất cả các đỉnh đã được duyệt chưa
	    for (boolean v : visited) {
	        if (!v) {
	            return false;
	        }
	    }

	    return true;
	}

	private void bfs(int start, boolean[] visited) {
	    Queue<Integer> queue = new LinkedList<>();
	    queue.offer(start);
	    visited[start] = true;

	    while (!queue.isEmpty()) {
	        int v = queue.poll();

	        for (int i = 0; i < matrix.length; i++) {
	            if (matrix[v][i] != 0 && !visited[i]) {
	                queue.offer(i);
	                visited[i] = true;
	            }
	        }
	    }
	}





	public static void main(String[] args) {
		String url = "C:\\Users\\FPT - ADMIN\\Downloads\\Bo du lieu test\\test1.txt";
		String url1 = "C:\\Users\\FPT - ADMIN\\Downloads\\Bo du lieu test\\Dijktra.txt";
		

		try {
			Graph m1 = new DoThiVoHuong(url1);
			
			System.out.println("Thuat toan Dijktra từ nguồn đến tất cả các đỉnh");
			m1.algDjik(1);
			System.out.println("-----------");
			System.out.println("Thuat toan Dijktra từ nguồn tới đích");
			m1.algDjik(0,5);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
