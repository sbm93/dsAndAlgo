package org.dsandalgo.problems.array;

public class findCommonFromSortedMatrix {
	public static void main(String[] args) {
		int mat[][] = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 2, 4, 5, 8, 10 }, 
				{ 3, 5, 7, 9, 11 }, 
				{ 1, 3, 5, 7, 9 }, 
				};
		int result = findCommon(mat);
		
		System.out.println(result);

	}

	public static int findCommon(int[][] mat) {
		int[] max = new int[10000];
		int minIndex = Integer.MAX_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < mat[0].length; i++) {
			max[mat[0][i]] = 1;
			if(mat[0][i] < minIndex)
				minIndex = mat[0][i];
			if(mat[0][i] > maxIndex)
				maxIndex = mat[0][i];
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (j != 0 && mat[i][j] == mat[i][j - 1])
					continue;
				if(max[mat[i][j]] != 0)
					max[mat[i][j]] = max[mat[i][j]] + 1;
			}
		}
		
		for(int i=minIndex;i<=maxIndex;i++) {
			if(max[i] == mat.length)
				return i;
		}
		return -1;
	}

}
