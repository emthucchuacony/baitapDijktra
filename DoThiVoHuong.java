
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DoThiVoHuong extends Graph {

	public DoThiVoHuong(String pathText) throws IOException {
		super(pathText);

	}
	
	@Override
	public void algDjik(int s, int dest) {
		if (isConnected() == true) {
			boolean[] R = new boolean[matrix.length];
			int[] L = new int [matrix.length];
			int[] P = new int [matrix.length];
			for (int i = 0; i < matrix.length; i++) {
				L[i] = Integer.MAX_VALUE;
				P[i] = -1;
				
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] ==0) {
						matrix[i][j] = Integer.MAX_VALUE;
					}
					else {
						matrix[i][j] = matrix[i][j];
					}
				}
			}
			//////
			L[s] = 0;
			int sodinhdadaduyet = 0;
			while(sodinhdadaduyet < matrix.length-1) {
				/// min
				int v = 0;
				int minValue = Integer.MAX_VALUE;
			for (int i = 0; i < P.length; i++) {
				if (L[i] < minValue && R[i] == false) {
					minValue = L[i];
					v = i ;
					
				}
			}
			for (int i = 0; i < matrix.length; i++) {
				if (L[i]  > L[v] + matrix[v][i] && matrix[v][i] < Integer.MAX_VALUE) {
					L[i] = L[v] + matrix[v][i];
					P[i] = v;
				}
			}
			R[v] = true;
			sodinhdadaduyet++;
			if (v==dest ) {
			System.out.println("So dinh da duyet: " + sodinhdadaduyet);
			break;
			}
				
				
			}
			  if (L[dest] != Integer.MAX_VALUE) {
			        System.out.println("Độ dài đường đi từ " + s + " đến " + dest + ": " + L[dest]);
			        System.out.print("Đường đi: ");
			        printPath(P, dest);
			        System.out.println();
			    } else {
			        System.out.println("Không có đường đi từ " + s + " đến " + dest);
			    }
			
			
			
			
		}
		else {
			System.out.println("do thi k lien thong --- k ap dung dc thaut toan dijktra");
			return;
		}
		
	}
	private void printPath(int[] P, int dest) {
	    if (P[dest] == -1) {
	        System.out.print(dest);
	        return;
	    }
	    printPath(P, P[dest]);
	    System.out.print(" -> " + dest);
	}

	@Override
	public void algDjik(int src) {
	    int n = matrix.length; // 
	    int[]L = new int[n]; // dist
	    boolean[] R = new boolean[n]; // visitted
	    int[] P = new int[n]; // p

	    // Khởi tạo mảng dist với giá trị vô cùng (tương đương với khoảng cách vô hạn)
	    for (int i = 0; i < matrix.length; i++) {
			L[i] = Integer.MAX_VALUE;
			
			
		}

	    // Khoảng cách từ đỉnh nguồn tới chính nó bằng 0
	    L[src] = 0;

	    // Tìm đường đi ngắn nhất từ đỉnh nguồn đến các đỉnh còn lại
	    int sodinhdadaduyet = 0;
		while(sodinhdadaduyet < matrix.length-1) {
			/// min
			int v = 0;
			int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < P.length; i++) {
			if (L[i] < minValue && R[i] == false) {
				minValue = L[i];
				v = i ;
				
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[v][i] > 0 && !R[i] && L[v] != Integer.MAX_VALUE &&
                    L[v] + matrix[v][i] < L[i]) {
                L[i] = L[i] + matrix[v][i];
                P[i] = v;
            }
		}
		R[v] = true;
		sodinhdadaduyet++;
		
		
			
				
		}

	    // In kết quả
		for (int i = 0; i < n; i++) {
			
			
		    System.out.print("Đường đi từ " + src + " tới " + i + ": ");

		    if (L[i] == Integer.MAX_VALUE) {
		        System.out.println("Không có đường đi");
		    } else {
		        System.out.print(  src);

		        int p = P[i];

		        while (p != src) {
		            System.out.print(" -> " + p);
		            p = P[p];
		        }

		        System.out.println(" -> " + i);
		    }
		}

	}
}

