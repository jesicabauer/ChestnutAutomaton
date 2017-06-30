package fungus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Fungal_Percents {
	
	public static final int STATUSES = 11; // how many things that go
    public static final int NORMAL_STATUS = 0;
    public static final int INFECTED_STATUS = 1;
    public static final int VIRAL_STATUS = 2;
    public static final int PEN_STATUS = 3; 
    public static final int PEZ_STATUS = 4; 
    public static final int UMB_STATUS = 5; 
    public static final int STRASS_STATUS = 6; 
    public static final int NECTRIA_STATUS = 7; 
    public static final int TRICH_STATUS = 8; 
    public static final int NONCP_STATUS = 9; 
    public static final int HEALING_STATUS = 10;
	
	static int[][] fourteen1; 
	static int[][] fourteen2; 
	static int[][] fifteen1; 
	static int[][] fifteen2; 
	static int[][] sixteen1;
	static int[][] sixteen2; 
	static int[][] occurances; 
	public static double[][] proportions; 

	public static void main (String[] args) throws FileNotFoundException {
		
		proportions = props(); 
		
	}
	
public static double[][] props() {
		
		FileReader file;
		try {
			file = new FileReader("test.csv");
		
		Scanner scanner = new Scanner(file); 
		scanner.useDelimiter(",");
		int rows = 62; 
		String[][] fungi = new String[rows][]; 
		
		int row = 0;
		int[] sum = new int[STATUSES-1]; 
		occurances = new int[STATUSES-1][STATUSES-1]; 
		double[][] proportions = new double[STATUSES-1][STATUSES-1]; 
		
		
		while(scanner.hasNextLine()) {
			fungi[row] = scanner.nextLine().split(",");
			row++; 
		}
		
		scanner.close(); 
		
		int[][][] temp14 = arrayGenerator(fungi, 7, 31); 
		fourteen1 = temp14[0]; 
		fourteen2 = temp14[1]; 
		System.out.println("2015");
		int[][][] temp15 = arrayGenerator(fungi, 36, 60);
		fifteen1  = temp15[0];
		fifteen2  = temp15[1];
		System.out.println("2016");
		int[][][] temp16 = arrayGenerator(fungi, 65, 89);
		sixteen1  = temp16[0]; 
		sixteen2  = temp16[1];
		
		int[][] fofi = occuranceGenerator(fourteen1, fourteen2, fifteen1, fifteen2);
		
		for (int i = 0; i < STATUSES-1; i++) {
			for (int j = 0; j < STATUSES-1; j++) {	
				occurances[i][j] = fofi[i][j]; 
				sum[i] += occurances[i][j];
				 // System.out.print(fofi[i][j] + " + ");
				 // System.out.print(fisi[i][j] + " = ");
				 // System.out.print(occurances[i][j] + "\t \t");
			}
			 // System.out.println();
		}
		
		for (int i = 0; i < STATUSES-1; i++) {
			for (int j = 0; j < STATUSES-1; j++) {	
				proportions[i][j] = (double)occurances[i][j]/sum[i]; 
				// System.out.print(fofi[i][j] + "+");
				// System.out.print(fisi[i][j] + " = ");
				 System.out.print(proportions[i][j] + "\t|");
			}
			 System.out.println();
		}
		
		
		return proportions;
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
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
				System.out.print(fungi_1[i-1][j-start] + "" + fungi_2[i-1][j-start] + " ");
			}
			System.out.println();
		}
		
		int[][][] fungi = new int[2][][]; 
		fungi[0] = fungi_1;
		fungi[1] = fungi_2; 
		
		return fungi; 
	}
    
    public static int numFinder(String fungi) {
		
		int fungus = NORMAL_STATUS; 
		
		if (fungi.contains("Cp")) {
			fungus = INFECTED_STATUS; 
		} else if (fungi.contains("Infected")) {
			fungus = VIRAL_STATUS; 
		} else if (fungi.contains("Penicillium")) {
			fungus = PEN_STATUS; 
		} else if (fungi.contains("Pezicula")) {
			fungus = PEZ_STATUS; 
		} else if (fungi.contains("Umbelopsis")) {
			fungus = UMB_STATUS;
		} else if (fungi.contains("Strasseria")) {
			fungus = STRASS_STATUS;
		} else if (fungi.contains("Nectria")) {
			fungus = NECTRIA_STATUS;
		} else if (fungi.contains("Trichoderma")) {
			fungus = TRICH_STATUS; 
		} else if (fungi.contains(".")) {
			fungus = NORMAL_STATUS; 
		} else {
			fungus = NONCP_STATUS; 
		}
		
		return fungus; 
	} 
    
    public static int[][] occuranceGenerator(int[][] array1_1, int[][] array1_2, int[][] array2_1, int[][] array2_2) {
		int[][] occur = new int[STATUSES-1][STATUSES-1]; 
		
		for (int i = 0; i < array1_1.length; i++) {
			for (int j = 0; j < array1_1[0].length; j++) {
				if (array1_1[i][j] != 0) {
					occur[array1_1[i][j]][array2_1[i][j]]++; 
					if (array2_2[i][j] != 0) {
						occur[array1_1[i][j]][array2_2[i][j]]++; 
					}
				} else {
					occur[array1_1[i][j]][array2_1[i][j]]++; 
				}
				
				if (array1_2[i][j] != 0) {
					occur[array1_2[i][j]][array2_1[i][j]]++;
					if (array2_2[i][j] != 0) {
						occur[array1_2[i][j]][array2_2[i][j]]++;
					}
				}
			}
		}
		return occur; 
	}
}
