import java.util.ArrayDeque;
import java.util.Queue;

public class Test {

	static int M= 10;
	static int N=10;
	
	private static final int row[] = { -1, 0, 0, 1 };
	private static final int col[] = { 0, -1, 1, 0 };
	public static void main(String[] args) {

		// input maze
				int[][] mat =
				{
						{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
						{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
						{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
						{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
						{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
						{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
						{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
						{ 0, 1, 1, 1, 1, 9, 1, 1, 0, 0 },
						{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
						{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
				};
				
				BFS(mat, 0, 0 , 9);
	}

	private static void BFS(int[][] mat, int i, int j, int k) {
		
		boolean visited[][] = new boolean[10][10];
		int dist[][] = new int[10][10];
		
	
		Queue<Integer> queue = new ArrayDeque<Integer>();
		Queue<Integer> yqueue = new ArrayDeque<Integer>();
		Queue<Integer> distqueue = new ArrayDeque<Integer>();
		queue.add(i);
		yqueue.add(j);
		dist[i][j]=0;
		distqueue.add(dist[i][j]);
		int minDist =0;
		while(!queue.isEmpty()) {
			 i = queue.poll();
			 j = yqueue.poll();
			int distVal = distqueue.poll();
			if(mat[i][j] == k) {
				minDist = distVal;
				System.out.println("enteredt");
				break;
			}
			
			if(i==7 && j==5) {
				minDist = distVal;
				System.out.println("enteredt");
				break;
			}
			for(int l=0;l<4;l++) {
				int rowTest = i+row[l];
				int colTest = j+col[l];
				if(isValid(mat,visited, rowTest,colTest)) {
					
					//System.out.print(rowTest+" "+ colTest);
					queue.add(rowTest);
					yqueue.add(colTest);
					visited[rowTest][colTest] = true;
					dist[rowTest][colTest] =distVal+1;
					distqueue.add(dist[rowTest][colTest]);
				}
			//	System.out.println(" ");
			}
			
		}
		
		System.out.println(minDist);
	}

	private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
			if(row<M && row>=0 && col >=0 && col<N && !visited[row][col] && mat[row][col]!=0) {
				return true;
			}
		
		return false;
	}

}
