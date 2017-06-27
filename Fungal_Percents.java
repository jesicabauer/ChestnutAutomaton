package fungus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Fungal_Percents {
	
	static int[][] fourteen1; 
	static int[][] fourteen2; 
	static int[][] fifteen1; 
	static int[][] fifteen2; 
	static int[][] sixteen1;
	static int[][] sixteen2; 
	static int[][] occurances; 
	public static double[][] proportions; 

	public static void main (String[] args) throws FileNotFoundException {
		
		FileReader file = new FileReader("test.csv");
		Scanner scanner = new Scanner(file); 
		scanner.useDelimiter(",");
		int rows = 62; 
		String[][] fungi = new String[rows][]; 
		
		int row = 0;
		int[] sum = new int[6]; 
		occurances = new int[6][6]; 
		proportions = new double[6][6]; 
		
		
		while(scanner.hasNextLine()) {
			fungi[row] = scanner.nextLine().split(",");
			row++; 
		}
		
		scanner.close(); 
		fourteen1 = arrayGenerator(fungi, 7, 31)[0]; 
		fourteen2 = arrayGenerator(fungi, 7, 31)[1]; 
		fifteen1  = arrayGenerator(fungi, 36, 60)[0];
		fifteen2  = arrayGenerator(fungi, 36, 60)[1];
		sixteen1  = arrayGenerator(fungi, 65, 89)[0]; 
		sixteen2  = arrayGenerator(fungi, 65, 89)[1];
		
		int[][] fofi = occuranceGenerator(fourteen1, fourteen2, fifteen1, fifteen2);
		int[][] fisi = occuranceGenerator(fifteen1, fifteen2, sixteen1, sixteen2); 
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {	
				occurances[i][j] = fofi[i][j] + fisi[i][j]; 
				sum[i] += occurances[i][j];
				 System.out.print(fofi[i][j] + " + ");
				 System.out.print(fisi[i][j] + " = ");
				 System.out.print(occurances[i][j] + "\t \t");
			}
			 System.out.println();
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {	
				proportions[i][j] = (double)occurances[i][j]/sum[i]; 
				// System.out.print(fofi[i][j] + "+");
				// System.out.print(fisi[i][j] + " = ");
				System.out.print(proportions[i][j] + "\t| ");
			}
			System.out.println();
		}
		
		
	}
	
	public static int[][][] arrayGenerator(String[][] array, int start, int end) {
		
		int[][] fungi_1 = new int[62][24]; 
		int[][] fungi_2 = new int[62][24];
		
		for (int i = 1; i < 62; i++) {
			for (int j = start; j < end; j++) {
				int fungi1 = 0; 
				int fungi2 = 0; 
				
				if (array[i][j].contains(" / ")) {
					String[] parts = array[i][j].split(" / "); // String array, each element is text between dots
					fungi1 = numFinder(parts[0]);
					fungi2 = numFinder(parts[1]);
				} else {
					fungi1 = numFinder(array[i][j]); 
				}
				
				//fungi[i-1][j-start] = (fungi1 + " " + fungi2);
				fungi_1[i-1][j-start] = fungi1; 
				fungi_2[i-1][j-start] = fungi2; 
//				System.out.print(fungi[i-1][j-start] + " | ");
			}
//			System.out.println();
		}
		
		int[][][] fungi = new int[2][][]; 
		fungi[0] = fungi_1;
		fungi[1] = fungi_2; 
		
		return fungi; 
	}
	
	public static int numFinder(String fungi) {
		
		/*
		public static final int NORMAL_STATUS = 0;
	    public static final int INFECTED_STATUS = 1;
	    public static final int VIRAL_STATUS = 2;
	    public static final int PEN_STATUS = 3; 
	    public static final int PEZ_STATUS = 4; 
	    public static final int NONCP_STATUS = 5; 
	    public static final int HEALING_STATUS = 6; 
	    */ 
		
		int fungus = 0; 
		
		if (fungi.contains("Cp")) {
			fungus = 1; 
		} else if (fungi.contains("Infected")) {
			fungus = 2; 
		} else if (fungi.contains("Penicillium")) {
			fungus = 3; 
		} else if (fungi.contains("Pezicula")) {
			fungus = 4; 
		} else if (!fungi.contains(".")) {
			fungus = 5; 
		}
		
		return fungus; 
	} 
	
	public static int[][] occuranceGenerator(int[][] array1_1, int[][] array1_2, int[][] array2_1, int[][] array2_2) {
		int[][] occur = new int[6][6]; 
		
		for (int i = 0; i < array1_1.length; i++) {
			for (int j = 0; j < array1_1[0].length; j++) {
				if (array1_1[i][j] != 0) {
					occur[array1_1[i][j]][array2_1[i][j]]++; 
					occur[array1_1[i][j]][array2_2[i][j]]++; 
				} else {
					occur[array1_1[i][j]][array2_1[i][j]]++; 
				}
				
				if (array1_2[i][j] != 0) {
					occur[array1_2[i][j]][array2_1[i][j]]++; 
					occur[array1_2[i][j]][array2_2[i][j]]++;
				}
			}
		}
		return occur; 
	}
	
}
