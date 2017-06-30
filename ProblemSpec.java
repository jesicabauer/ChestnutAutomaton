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
	public static int[] clock = clock(sixteen1, 38); 
    
    public static final int HEIGHT = 80; // 80
    public static final int WIDTH = 80; // 150
    
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
    public static final int HEALING_STATUS = 10; // if you want a new thing, add down here
    
    public static final int TIME_VIRUS = 100;
    public static final int TIME_NONCP = 200;
    
    public static final double PERCENT_INTRO_VIRUS = 0.2;
    public static final double PERCENT_SWAB_SUCCESS = 0.75; // 0.75
    public static final double HEALING_CP = 0.5; 
    public static final double HEALING_HCP = 0.6; 
    public static final double DAYS_TO_HEAL = 12; 
    
    public static final int NEIGHBORHOOD_SIZE = 8;
    private static final double P00 = 1.0 / NEIGHBORHOOD_SIZE; // proportions[0][0]
    private static final double P01 = proportions[0][1] / NEIGHBORHOOD_SIZE; // 0.8
    private static final double P02 = proportions[0][2] / NEIGHBORHOOD_SIZE; // 0.4
    private static final double P03 = proportions[0][3] / NEIGHBORHOOD_SIZE; // 0.2
    private static final double P04 = proportions[0][4] / NEIGHBORHOOD_SIZE; // 0.2
    private static final double P05 = proportions[0][5] / NEIGHBORHOOD_SIZE; // 0.2
    private static final double P06 = proportions[0][6] / NEIGHBORHOOD_SIZE; // 0.01
    private static final double P07 = proportions[0][7] / NEIGHBORHOOD_SIZE;
    private static final double P08 = proportions[0][8] / NEIGHBORHOOD_SIZE;
    private static final double P09 = proportions[0][9] / NEIGHBORHOOD_SIZE;
    private static final double P010 = 0.02 / NEIGHBORHOOD_SIZE;
    
    private static final double P10 = proportions[1][0] / NEIGHBORHOOD_SIZE;
    private static final double P11 = proportions[1][1] / NEIGHBORHOOD_SIZE; // proportions[1][1]
    private static final double P12 = proportions[1][2] / NEIGHBORHOOD_SIZE;
    private static final double P13 = proportions[1][3] / NEIGHBORHOOD_SIZE;
    private static final double P14 = proportions[1][4] / NEIGHBORHOOD_SIZE;
    private static final double P15 = proportions[1][5] / NEIGHBORHOOD_SIZE;
    private static final double P16 = proportions[1][6] / NEIGHBORHOOD_SIZE;
    private static final double P17 = proportions[1][7] / NEIGHBORHOOD_SIZE;
    private static final double P18 = proportions[1][8] / NEIGHBORHOOD_SIZE;
    private static final double P19 = proportions[1][9] / NEIGHBORHOOD_SIZE;
    private static final double P110 = 0.0 / NEIGHBORHOOD_SIZE; 
    
    private static final double P20 = proportions[2][0] / NEIGHBORHOOD_SIZE;
    private static final double P21 = proportions[2][1] / NEIGHBORHOOD_SIZE;
    private static final double P22 = proportions[2][2] / NEIGHBORHOOD_SIZE; // proportions[2][2]
    private static final double P23 = proportions[2][3] / NEIGHBORHOOD_SIZE;
    private static final double P24 = proportions[2][4] / NEIGHBORHOOD_SIZE;
    private static final double P25 = proportions[2][5] / NEIGHBORHOOD_SIZE;
    private static final double P26 = proportions[2][6] / NEIGHBORHOOD_SIZE;
    private static final double P27 = proportions[2][7] / NEIGHBORHOOD_SIZE;
    private static final double P28 = proportions[2][8] / NEIGHBORHOOD_SIZE;
    private static final double P29 = proportions[2][9] / NEIGHBORHOOD_SIZE;
    private static final double P210 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P30 = proportions[3][0] / NEIGHBORHOOD_SIZE;
    private static final double P31 = proportions[3][1] / NEIGHBORHOOD_SIZE;
    private static final double P32 = proportions[3][2] / NEIGHBORHOOD_SIZE;
    private static final double P33 = proportions[3][3] / NEIGHBORHOOD_SIZE; // proportions[3][3]
    private static final double P34 = proportions[3][4] / NEIGHBORHOOD_SIZE;
    private static final double P35 = proportions[3][5] / NEIGHBORHOOD_SIZE;
    private static final double P36 = proportions[3][6] / NEIGHBORHOOD_SIZE;
    private static final double P37 = proportions[3][7] / NEIGHBORHOOD_SIZE;
    private static final double P38 = proportions[3][8] / NEIGHBORHOOD_SIZE;
    private static final double P39 = proportions[3][9] / NEIGHBORHOOD_SIZE;
    private static final double P310 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P40 = proportions[4][0] / NEIGHBORHOOD_SIZE;
    private static final double P41 = proportions[4][1] / NEIGHBORHOOD_SIZE;
    private static final double P42 = proportions[4][2] / NEIGHBORHOOD_SIZE;
    private static final double P43 = proportions[4][3] / NEIGHBORHOOD_SIZE;
    private static final double P44 = proportions[4][4] / NEIGHBORHOOD_SIZE; // proportions[4][4]
    private static final double P45 = proportions[4][5] / NEIGHBORHOOD_SIZE;
    private static final double P46 = proportions[4][6] / NEIGHBORHOOD_SIZE;
    private static final double P47 = proportions[4][7] / NEIGHBORHOOD_SIZE;
    private static final double P48 = proportions[4][8] / NEIGHBORHOOD_SIZE;
    private static final double P49 = proportions[4][9] / NEIGHBORHOOD_SIZE;
    private static final double P410 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P50 = proportions[5][0] / NEIGHBORHOOD_SIZE;
    private static final double P51 = proportions[5][1] / NEIGHBORHOOD_SIZE;
    private static final double P52 = proportions[5][2] / NEIGHBORHOOD_SIZE;
    private static final double P53 = proportions[5][3] / NEIGHBORHOOD_SIZE;
    private static final double P54 = proportions[5][4] / NEIGHBORHOOD_SIZE;
    private static final double P55 = proportions[5][5] / NEIGHBORHOOD_SIZE; // proportions[5][5]
    private static final double P56 = proportions[5][6] / NEIGHBORHOOD_SIZE;
    private static final double P57 = proportions[5][7] / NEIGHBORHOOD_SIZE;
    private static final double P58 = proportions[5][8] / NEIGHBORHOOD_SIZE;
    private static final double P59 = proportions[5][9] / NEIGHBORHOOD_SIZE;
    private static final double P510 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P60 = proportions[6][0] / NEIGHBORHOOD_SIZE;
    private static final double P61 = proportions[6][1] / NEIGHBORHOOD_SIZE;
    private static final double P62 = proportions[6][2] / NEIGHBORHOOD_SIZE;
    private static final double P63 = proportions[6][3] / NEIGHBORHOOD_SIZE;
    private static final double P64 = proportions[6][4] / NEIGHBORHOOD_SIZE;
    private static final double P65 = proportions[6][5] / NEIGHBORHOOD_SIZE;
    private static final double P66 = proportions[6][6] / NEIGHBORHOOD_SIZE; // proportions[6][6]
    private static final double P67 = proportions[6][7] / NEIGHBORHOOD_SIZE;
    private static final double P68 = proportions[6][8] / NEIGHBORHOOD_SIZE;
    private static final double P69 = proportions[6][9] / NEIGHBORHOOD_SIZE;
    private static final double P610 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P70 = proportions[7][0] / NEIGHBORHOOD_SIZE;
    private static final double P71 = proportions[7][1] / NEIGHBORHOOD_SIZE;
    private static final double P72 = proportions[7][2] / NEIGHBORHOOD_SIZE;
    private static final double P73 = proportions[7][3] / NEIGHBORHOOD_SIZE;
    private static final double P74 = proportions[7][4] / NEIGHBORHOOD_SIZE;
    private static final double P75 = proportions[7][5] / NEIGHBORHOOD_SIZE;
    private static final double P76 = proportions[7][6] / NEIGHBORHOOD_SIZE; 
    private static final double P77 = proportions[7][7] / NEIGHBORHOOD_SIZE;// proportions[7][7]
    private static final double P78 = proportions[7][8] / NEIGHBORHOOD_SIZE;
    private static final double P79 = proportions[7][9] / NEIGHBORHOOD_SIZE;
    private static final double P710 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P80 = proportions[8][0] / NEIGHBORHOOD_SIZE;
    private static final double P81 = proportions[8][1] / NEIGHBORHOOD_SIZE;
    private static final double P82 = proportions[8][2] / NEIGHBORHOOD_SIZE;
    private static final double P83 = proportions[8][3] / NEIGHBORHOOD_SIZE;
    private static final double P84 = proportions[8][4] / NEIGHBORHOOD_SIZE;
    private static final double P85 = proportions[8][5] / NEIGHBORHOOD_SIZE;
    private static final double P86 = proportions[8][6] / NEIGHBORHOOD_SIZE; 
    private static final double P87 = proportions[8][7] / NEIGHBORHOOD_SIZE;
    private static final double P88 = proportions[8][8] / NEIGHBORHOOD_SIZE; // proportions[8][8]
    private static final double P89 = proportions[8][9] / NEIGHBORHOOD_SIZE;
    private static final double P810 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P90 = proportions[9][0] / NEIGHBORHOOD_SIZE;
    private static final double P91 = proportions[9][1] / NEIGHBORHOOD_SIZE;
    private static final double P92 = proportions[9][2] / NEIGHBORHOOD_SIZE;
    private static final double P93 = proportions[9][3] / NEIGHBORHOOD_SIZE;
    private static final double P94 = proportions[9][4] / NEIGHBORHOOD_SIZE;
    private static final double P95 = proportions[9][5] / NEIGHBORHOOD_SIZE;
    private static final double P96 = proportions[9][6] / NEIGHBORHOOD_SIZE; 
    private static final double P97 = proportions[9][7] / NEIGHBORHOOD_SIZE;
    private static final double P98 = proportions[9][8] / NEIGHBORHOOD_SIZE;
    private static final double P99 = proportions[9][9] / NEIGHBORHOOD_SIZE; // proportions[9][9]
    private static final double P910 = 0.0 / NEIGHBORHOOD_SIZE;
    
    private static final double P100 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P101 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P102 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P103 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P104 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P105 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P106 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P107 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P108 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P109 = 0.0 / NEIGHBORHOOD_SIZE;
    private static final double P1010 = 0.05 / NEIGHBORHOOD_SIZE; 
    
    
    
    
    private final static double[][] probTable = { { P00, P01, P02, P03, P04, P05, P06, P07, P08, P09, P010 },
    { P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P110 },
    { P20, P21, P22, P23, P24, P25, P26, P27, P28, P29, P210 },
    { P30, P31, P32, P33, P34, P35, P36, P37, P38, P39, P310 },
    { P40, P41, P42, P43, P44, P45, P46, P47, P48, P49, P410 },
    { P50, P51, P52, P53, P54, P55, P56, P57, P58, P59, P510 }, 
    { P60, P61, P62, P63, P64, P65, P66, P67, P68, P69, P610 },
    { P70, P71, P72, P73, P74, P75, P76, P77, P78, P79, P710 },
    { P80, P81, P82, P83, P84, P85, P86, P87, P88, P89, P810 },
    { P90, P91, P92, P93, P94, P95, P96, P97, P98, P99, P910 },
    { P100, P101, P102, P103, P104, P105, P106, P107, P108, P109, P1010 }, };
    
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
