package cc150;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Q1_7SetZero {
	public int[][] setZero(int[][] m) {
		Map<Integer, Integer> rowZero = new HashMap<Integer, Integer>();
		Map<Integer, Integer> colZero = new HashMap<Integer, Integer>();
		
		int row = m.length;
		int col = m[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (m[i][j] == 0) {
					if (!rowZero.containsKey(i)) rowZero.put(i, 1);	//store row of zero site
					if (!colZero.containsKey(j)) colZero.put(j, 1);	//store col of zero site
				}
			}
		}
		if (!rowZero.isEmpty()) {
			Iterator<Entry<Integer, Integer>> itRow = rowZero.entrySet().iterator();
			while (itRow.hasNext()) {
				Entry<Integer, Integer> entry = itRow.next();
				int k = entry.getKey();
				for (int i = 0; i < col; i++) m[k][i] = 0;
			}
		}
		
		if (!colZero.isEmpty()) {
			Iterator<Entry<Integer, Integer>> itCol = colZero.entrySet().iterator();
			while (itCol.hasNext()) {
				Entry<Integer, Integer> entry = itCol.next();
				int k = entry.getKey();
				for (int i = 0; i < row; i++) m[i][k] = 0;
			}
		}
		return m;
	}
	
	public static void main(String[] args) {
		Q1_7SetZero test = new Q1_7SetZero();
		
		int [][] m = {{1, 2, 3, 4}, {5, 6, 0, 7}, {8, 0, 9, 10}};
		test.setZero(m);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + "\t");
				
			}
			System.out.println();
		}
	}
}
