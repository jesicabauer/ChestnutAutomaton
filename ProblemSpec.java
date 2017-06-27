package fungus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ProblemSpec
{
	
	static int[][] fourteen1; 
	static int[][] fourteen2; 
	static int[][] fifteen1; 
	static int[][] fifteen2; 
	static int[][] sixteen1;
	static int[][] sixteen2; 
	static int[][] occurances; 
	public static double[][] proportions = props();
	public static int[] clock = clock(fourteen1, 1); 
    
    public static final int HEIGHT = 80; // 80
    public static final int WIDTH = 150; // 150
    
    public static final int STATUSES = 8; // how many things that go
    public static final int NORMAL_STATUS = 0;
    public static final int INFECTED_STATUS = 1;
    public static final int VIRAL_STATUS = 2;
    public static final int PEN_STATUS = 3; 
    public static final int PEZ_STATUS = 4; 
    public static final int NONCP_STATUS = 5; 
    public static final int UNKNOWN_STATUS = 6;
    public static final int HEALING_STATUS = 7; // if you want a new thing, add down here
    
    public static final int TIME_VIRUS = 100;
    public static final int TIME_NONCP = 200;
    
    public static final double PERCENT_INTRO_VIRUS = 0.2;
    public static final double PERCENT_SWAB_SUCCESS = 0.75; // 0.75
    public static final double HEALING_CP = 0; 
    public static final double HEALING_HCP = 0; 
    public static final double DAYS_TO_HEAL = 12; 
    
    public static final int NEIGHBORHOOD_SIZE = 8;
    private static final double P00 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[0][0]
    private static final double P01 = proportions[0][1] / NEIGHBORHOOD_SIZE; // 0.8
    private static final double P02 = proportions[0][2] / NEIGHBORHOOD_SIZE; // 0.4
    private static final double P03 = proportions[0][3] / NEIGHBORHOOD_SIZE; // 0.2
    private static final double P04 = proportions[0][4] / NEIGHBORHOOD_SIZE; // 0.2
    private static final double P05 = proportions[0][5] / NEIGHBORHOOD_SIZE; // 0.2
    private static final double P06 = proportions[0][6] / NEIGHBORHOOD_SIZE; // 0.01
    private static final double P07 = 0.01 / NEIGHBORHOOD_SIZE;
    
    private static final double P10 = proportions[1][0] / NEIGHBORHOOD_SIZE;
    private static final double P11 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[1][1]
    private static final double P12 = proportions[1][2] / NEIGHBORHOOD_SIZE;
    private static final double P13 = proportions[1][3] / NEIGHBORHOOD_SIZE;
    private static final double P14 = proportions[1][4] / NEIGHBORHOOD_SIZE;
    private static final double P15 = proportions[1][5] / NEIGHBORHOOD_SIZE;
    private static final double P16 = proportions[1][6] / NEIGHBORHOOD_SIZE;
    private static final double P17 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P20 = proportions[2][0] / NEIGHBORHOOD_SIZE;
    private static final double P21 = proportions[2][1] / NEIGHBORHOOD_SIZE;
    private static final double P22 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[2][2]
    private static final double P23 = proportions[2][3] / NEIGHBORHOOD_SIZE;
    private static final double P24 = proportions[2][4] / NEIGHBORHOOD_SIZE;
    private static final double P25 = proportions[2][5] / NEIGHBORHOOD_SIZE;
    private static final double P26 = proportions[2][6] / NEIGHBORHOOD_SIZE;
    private static final double P27 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P30 = proportions[3][0] / NEIGHBORHOOD_SIZE;
    private static final double P31 = proportions[3][1] / NEIGHBORHOOD_SIZE;
    private static final double P32 = proportions[3][2] / NEIGHBORHOOD_SIZE;
    private static final double P33 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[3][3]
    private static final double P34 = proportions[3][4] / NEIGHBORHOOD_SIZE;
    private static final double P35 = proportions[3][5] / NEIGHBORHOOD_SIZE;
    private static final double P36 = proportions[3][6] / NEIGHBORHOOD_SIZE;
    private static final double P37 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P40 = proportions[4][0] / NEIGHBORHOOD_SIZE;
    private static final double P41 = proportions[4][1] / NEIGHBORHOOD_SIZE;
    private static final double P42 = proportions[4][2] / NEIGHBORHOOD_SIZE;
    private static final double P43 = proportions[4][3] / NEIGHBORHOOD_SIZE;
    private static final double P44 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[4][4]
    private static final double P45 = proportions[4][5] / NEIGHBORHOOD_SIZE;
    private static final double P46 = proportions[4][6] / NEIGHBORHOOD_SIZE;
    private static final double P47 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P50 = proportions[5][0] / NEIGHBORHOOD_SIZE;
    private static final double P51 = proportions[5][1] / NEIGHBORHOOD_SIZE;
    private static final double P52 = proportions[5][2] / NEIGHBORHOOD_SIZE;
    private static final double P53 = proportions[5][3] / NEIGHBORHOOD_SIZE;
    private static final double P54 = proportions[5][4] / NEIGHBORHOOD_SIZE;
    private static final double P55 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[5][5]
    private static final double P56 = proportions[5][6] / NEIGHBORHOOD_SIZE;
    private static final double P57 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P60 = proportions[6][0] / NEIGHBORHOOD_SIZE;
    private static final double P61 = proportions[6][1] / NEIGHBORHOOD_SIZE;
    private static final double P62 = proportions[6][2] / NEIGHBORHOOD_SIZE;
    private static final double P63 = proportions[6][3] / NEIGHBORHOOD_SIZE;
    private static final double P64 = proportions[6][4] / NEIGHBORHOOD_SIZE;
    private static final double P65 = proportions[6][5] / NEIGHBORHOOD_SIZE;
    private static final double P66 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[6][6]
    private static final double P67 = 0.0 / NEIGHBORHOOD_SIZE; 
    
    private static final double P70 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P71 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P72 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P73 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P74 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P75 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P76 = 0.05 / NEIGHBORHOOD_SIZE;
    private static final double P77 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private final static double[][] probTable = { { P00, P01, P02, P03, P04, P05, P06, P07 },
    { P10, P11, P12, P13, P14, P15, P16, P17 },
    { P20, P21, P22, P23, P24, P25, P26, P27 },
    { P30, P31, P32, P33, P34, P35, P36, P37 },
    { P40, P41, P42, P43, P44, P45, P46, P47 },
    { P50, P51, P52, P53, P54, P55, P56, P57 }, 
    { P60, P61, P62, P63, P64, P65, P66, P67 },
    { P70, P71, P72, P73, P74, P75, P76, P77 } };
    
    public static double getProbability( int start, int end )
    {
        return probTable[start][end];
    }
    
public static int[] clock(int[][] array, int tree) {
    	
    	int[] clock = new int[24]; 
    	
    	for (int i = 0; i < 24; i++) {
    		clock[i] = array[tree][i]; 
    	}
    	
    	return clock; 
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
		
		
		fourteen1 = arrayGenerator(fungi, 7, 31)[0]; 
		fourteen2 = arrayGenerator(fungi, 7, 31)[1]; 
		fifteen1  = arrayGenerator(fungi, 36, 60)[0];
		fifteen2  = arrayGenerator(fungi, 36, 60)[1];
		sixteen1  = arrayGenerator(fungi, 65, 89)[0]; 
		sixteen2  = arrayGenerator(fungi, 65, 89)[1];
		
		int[][] fofi = occuranceGenerator(fourteen1, fourteen2, fifteen1, fifteen2);
		int[][] fisi = occuranceGenerator(fifteen1, fifteen2, sixteen1, sixteen2); 
		
		for (int i = 0; i < STATUSES-1; i++) {
			for (int j = 0; j < STATUSES-1; j++) {	
				occurances[i][j] = fofi[i][j] + fisi[i][j]; 
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
//				 System.out.print(proportions[i][j] + "\t| ");
			}
//			 System.out.println();
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
//				System.out.print(fungi_1[i-1][j-start] + "" + fungi_2[i-1][j-start] + " ");
			}
//			System.out.println();
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
		} else if (fungi.contains(".")) {
			fungus = NORMAL_STATUS; 
		} else if (fungi.contains("Unknown")) {
			fungus = UNKNOWN_STATUS; 
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
