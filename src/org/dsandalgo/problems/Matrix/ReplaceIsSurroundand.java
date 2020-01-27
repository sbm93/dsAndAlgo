package org.dsandalgo.problems.Matrix;

import java.util.Arrays;

public class ReplaceIsSurroundand {
	public static void main(String[] args) {
		char[][] mat = { 
				{ 'X', 'O', 'X', 'O', 'X', 'X' }, 
				{ 'X', 'O', 'X', 'X', 'O', 'X' },
				{ 'X', 'X', 'X', 'O', 'X', 'X' }, 
				{ 'O', 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'X', 'X', 'O', 'X', 'O' },
				{ 'O', 'O', 'X', 'O', 'O', 'O' } };

		replaceSurrounded(mat);

		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}

	static void replaceSurrounded(char[][] mat) {
		
	}

}
