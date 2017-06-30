package fungus;

public class ChangeGenerator
{
    private int[][] canker = new int[ProblemSpec.HEIGHT][ProblemSpec.WIDTH];
    private int[][] neighborhood = new int[3][3];
    
    private final int GRID_SIZE = ProblemSpec.HEIGHT * ProblemSpec.WIDTH;
    
    private int counter = 0;
    private int numInfected = 1;
    private int numVirus = 0;
    private double percentInfected;
    private double percentVirus = 0.0;
    private boolean virusIntroduced = false;
    private int fungusTop, fungusBottom, fungusRight, fungusLeft; // keeps track of the edges of the lump
    
    
    public void StartUp() {
    	int centerCol = canker[0].length / 2;
        int centerRow = canker.length / 2;
        percentInfected = 1.0 / GRID_SIZE;
        fungusTop = centerRow;
        fungusBottom = centerRow;
        fungusRight = centerCol;
        fungusLeft = centerCol;
        
        // 1: 26, 17, 10, 6, 32 
        // 2: 33, 20, 11, 3, 25
        // 3: 32, 23, 9, 3, 24
        // 4: 27, 37, 8, 1, 21
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.INFECTED_STATUS; 
//        }
//      
//        for (int i = 0; i < 1; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.VIRAL_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.PEN_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.PEZ_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.UMB_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.STRASS_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.NECTRIA_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.TRICH_STATUS; 
//        }
//        
//        for (int i = 0; i < 0.5*GRID_SIZE; i++) {
//        	int rowInfect = (int)(Math.random()*canker.length); 
//        	int colInfect = (int)(Math.random()*canker[0].length); 
//        	canker[rowInfect][colInfect] = ProblemSpec.NONCP_STATUS; 
//        }
        
        
        // THIS IS WHERE THE CLOCK IS
        // canker[centerRow][centerCol] = ProblemSpec.HEALING_STATUS; // center
         
//        canker[centerRow - 20][centerCol + 10] = ProblemSpec.clock[0]; // 1
//        canker[centerRow - 11][centerCol + 16] = ProblemSpec.clock[1]; // 2
//        canker[centerRow][centerCol + 20]      = ProblemSpec.clock[2]; // 3
//        canker[centerRow + 11][centerCol + 16] = ProblemSpec.clock[3]; // 4
//        canker[centerRow + 20][centerCol + 10] = ProblemSpec.clock[4]; // 5
//        canker[centerRow + 25][centerCol]      = ProblemSpec.clock[5]; // 6
//        canker[centerRow + 20][centerCol - 10] = ProblemSpec.clock[6]; // 7
//        canker[centerRow + 11][centerCol - 16] = ProblemSpec.clock[7]; // 8
//        canker[centerRow][centerCol - 20]      = ProblemSpec.clock[8]; // 9
//        canker[centerRow - 11][centerCol - 16] = ProblemSpec.clock[9]; // 10
//        canker[centerRow - 20][centerCol - 10] = ProblemSpec.clock[10]; // 11
//        canker[centerRow - 25][centerCol]      = ProblemSpec.clock[11]; // 12
//        canker[centerRow - 11][centerCol + 10] = ProblemSpec.clock[12]; // 1i
//        canker[centerRow - 5][centerCol + 5]   = ProblemSpec.clock[13]; // 2i
//        canker[centerRow + 5][centerCol - 5]   = ProblemSpec.clock[14]; // 3i
//        canker[centerRow + 11][centerCol - 10] = ProblemSpec.clock[15]; // 4i
//        canker[centerRow - 11][centerCol - 10] = ProblemSpec.clock[16]; // 5i
//        canker[centerRow - 5][centerCol - 5]   = ProblemSpec.clock[17]; // 6i
//        canker[centerRow + 5][centerCol + 5]   = ProblemSpec.clock[18]; // 7i
//        canker[centerRow + 11][centerCol + 10] = ProblemSpec.clock[19]; // 8i
//        canker[centerRow][centerCol - 12]      = ProblemSpec.clock[20]; // 9i
//        canker[centerRow][centerCol - 5]       = ProblemSpec.clock[21]; // 10i
//        canker[centerRow][centerCol + 5]       = ProblemSpec.clock[22]; // 11i
//        canker[centerRow][centerCol + 12]      = ProblemSpec.clock[23]; // 12i
//        
        for (int i = -3; i < 3; i++) {
        	for (int j = -3; j < 3; j++) {
	      canker[centerRow - 20 + i][centerCol + 10 + j] = ProblemSpec.clock[0]; // 1
	      canker[centerRow - 11 + i][centerCol + 16 + j] = ProblemSpec.clock[1]; // 2
	      canker[centerRow + i][centerCol + 20 + j]      = ProblemSpec.clock[2]; // 3
	      canker[centerRow + 11 + i][centerCol + 16 + j] = ProblemSpec.clock[3]; // 4
	      canker[centerRow + 20 + i][centerCol + 10 + j] = ProblemSpec.clock[4]; // 5
	      canker[centerRow + 25 + i][centerCol + j]      = ProblemSpec.clock[5]; // 6
	      canker[centerRow + 20 + i][centerCol - 10 + j] = ProblemSpec.clock[6]; // 7
	      canker[centerRow + 11 + i][centerCol - 16 + j] = ProblemSpec.clock[7]; // 8
	      canker[centerRow + i][centerCol - 20 + j]      = ProblemSpec.clock[8]; // 9
	      canker[centerRow - 11 + i][centerCol - 16 + j] = ProblemSpec.clock[9]; // 10
	      canker[centerRow - 20 + i][centerCol - 10 + j] = ProblemSpec.clock[10]; // 11
	      canker[centerRow - 25 + i][centerCol + j]      = ProblemSpec.clock[11]; // 12
	      canker[centerRow - 11 + i][centerCol + 10 + j] = ProblemSpec.clock[12]; // 1i
	      canker[centerRow - 5 + i][centerCol + 5 + j]   = ProblemSpec.clock[13]; // 2i
	      canker[centerRow + 5 + i][centerCol - 5 + j]   = ProblemSpec.clock[14]; // 3i
	      canker[centerRow + 11 + i][centerCol - 10 + j] = ProblemSpec.clock[15]; // 4i
	      canker[centerRow - 11 + i][centerCol - 10 + j] = ProblemSpec.clock[16]; // 5i
	      canker[centerRow - 5 + i][centerCol - 5 + j]   = ProblemSpec.clock[17]; // 6i
	      canker[centerRow + 5 + i][centerCol + 5 + j]   = ProblemSpec.clock[18]; // 7i
	      canker[centerRow + 11 + i][centerCol + 10 + j] = ProblemSpec.clock[19]; // 8i
	      canker[centerRow + i][centerCol - 12 + j]      = ProblemSpec.clock[20]; // 9i
	      canker[centerRow + i][centerCol - 5 + j]       = ProblemSpec.clock[21]; // 10i
	      canker[centerRow + i][centerCol + 5 + j]       = ProblemSpec.clock[22]; // 11i
	      canker[centerRow + i][centerCol + 12 + j]      = ProblemSpec.clock[23]; // 12i
        	}
        }
         
        
    }
    
    public ChangeGenerator()
    {
        StartUp(); 
    }
    
    public int[][] getGrid()
    {
        return canker;
    }
    
    public void reset()
    {
        canker = new int[ProblemSpec.HEIGHT][ProblemSpec.WIDTH];
        StartUp(); 
        counter = 0;
        numInfected = 1;
        numVirus = 0;
        percentVirus = 0.0;
        virusIntroduced = false;
    }
    
    public int[][] getNext()
    {
        int[][] next = new int[ProblemSpec.HEIGHT][ProblemSpec.WIDTH];
        
        for ( int row = 0; row < next.length; row++ )
            for ( int col = 0; col < next[row].length; col++ )
            {
                getNeighbors( row, col );
                int oldStatus = canker[row][col];
                int newStatus = getNewStatus( row, col );
                
                if ( newStatus != oldStatus ) // THIS IS WHERE YOU PUT THE MOVING THINGS! :D
                {
                    if ( newStatus == ProblemSpec.INFECTED_STATUS )
                    {
                        numInfected++ ;
                        
                        // until virus is introduced, track bounding box on
                        // fungus
                        if ( !virusIntroduced )
                        {
                            if ( row < fungusTop )
                            {
                                fungusTop = row;
                            }
                            else if ( row > fungusBottom )
                            {
                                fungusBottom = row;
                            }
                            
                            if ( col < fungusLeft )
                            {
                                fungusLeft = col;
                            }
                            else if ( col > fungusRight )
                            {
                                fungusRight = col;
                            }
                        }
                    }
                    else if ( newStatus == ProblemSpec.VIRAL_STATUS )
                    {
                        numVirus++ ;
                    }
                    
                    if ( oldStatus == ProblemSpec.INFECTED_STATUS )
                    {
                        numInfected-- ;
                    }
                }
                
                next[row][col] = newStatus;
            }
        
        percentInfected = (double) ( numInfected ) / GRID_SIZE;
        percentVirus = (double) ( numVirus ) / GRID_SIZE;
        
        // ADD THIS BACK IF YOU WANT THE SQUARE
        if ( !virusIntroduced )
        {
            if ( percentInfected >= ProblemSpec.PERCENT_INTRO_VIRUS )
            {
                // addVirusBox( next );
                // addVirusEdge( next );
                virusIntroduced = true;
            }
        }
        
       
        counter++ ;
        /**
         * COMMENTED OUT FOLLOWING: 21 JAN 2013
         *
         * Removes code to introduce virus at fixed time.
         * Replaces with code (above) to introduce when fungal load
         * exceeds given threshold.
         */
        /*
         * 
         *
         * if ( counter == ProblemSpec.TIME_VIRUS )
         * {
         * addVirusEdge( next );
         * }
         */
        
        /**
         * COMMENTED OUT FOLLOWING: 21 JAN 2013
         *
         * Removes code temporarily for non-CP fungus growth
         */
        /*
         * else if ( counter == ProblemSpec.TIME_NONCP )
         * {
         * int centerCol = canker[0].length / 2;
         * int centerRow = canker.length / 2;
         * next[centerRow][centerCol] = ProblemSpec.PEN_STATUS;
         * }
         */
        
        //System.out.println( percentInfected + " " + percentVirus );
        
        canker = next;
        return canker;
    }
    
    private void addVirusBox( int[][] state )
    {
        int top = fungusTop - 1;
        int bottom = fungusBottom + 1;
        int right = fungusRight + 1;
        int left = fungusLeft - 1;
        
        // top and bottom of box
        for ( int col = left; col <= right; col++ )
        {
            if ( Math.random() < ProblemSpec.PERCENT_SWAB_SUCCESS )
            {
                state[top][col] = ProblemSpec.HEALING_STATUS; // CHANGE
                numVirus++ ;
            }
            if ( Math.random() < ProblemSpec.PERCENT_SWAB_SUCCESS )
            {
                state[bottom][col] = ProblemSpec.HEALING_STATUS; // CHANGE
                numVirus++ ;
            }
        }
        
        // right and left edges of box
        for ( int row = top + 1; row < bottom; row++ )
        {
            if ( Math.random() < ProblemSpec.PERCENT_SWAB_SUCCESS )
            {
                state[row][left] = ProblemSpec.HEALING_STATUS; // CHANGE
                numVirus++;
            }
            
            if ( Math.random() < ProblemSpec.PERCENT_SWAB_SUCCESS )
            {
                state[row][right] = ProblemSpec.HEALING_STATUS; // CHANGE
                numVirus++;
            }
        }
        
    }
    
    private void addVirusEdge( int[][] state )
    {
        int sep = state.length / 5;
        
        state[0][0] = ProblemSpec.VIRAL_STATUS;
        state[sep][0] = ProblemSpec.VIRAL_STATUS;
        state[sep * 2][0] = ProblemSpec.VIRAL_STATUS;
        state[sep * 3][0] = ProblemSpec.VIRAL_STATUS;
        state[sep * 4][0] = ProblemSpec.VIRAL_STATUS;
        
        numVirus = 5;
    }
    
    private int getNewStatus( int row, int col )
    {
        double pInfect = 0.0;
        double pVirus = 0.0;
        double pPen = 0.0;
        double pPez = 0.0;
        double pUmb = 0.0; 
        double pStrass = 0.0; 
        double pNect = 0.0; 
        double pTrich = 0.0; 
        double pNonCP = 0.0; 
        double pHealthy = 0.0; 
        double pNormal = 0.0;
        
        int currStatus = neighborhood[1][1];
        
        for ( int i = 0; i < neighborhood.length; i++ )
            for ( int j = 0; j < neighborhood[i].length; j++ )
            {
                if ( i != 1 || j != 1 )
                {
                    switch ( neighborhood[i][j] )
                    {
                        case ProblemSpec.INFECTED_STATUS:
                            pInfect += ProblemSpec.getProbability( currStatus,
                                                                  ProblemSpec.INFECTED_STATUS );
                            break;
                        case ProblemSpec.VIRAL_STATUS:
                            pVirus += ProblemSpec.getProbability( currStatus,
                                                                 ProblemSpec.VIRAL_STATUS );
                            break;
                        case ProblemSpec.PEN_STATUS:
                            pPen += ProblemSpec.getProbability( currStatus,
                                                                 ProblemSpec.PEN_STATUS );
                            break;
                        case ProblemSpec.PEZ_STATUS:
                        	pPez += ProblemSpec.getProbability( currStatus, 
                        			  							 ProblemSpec.PEZ_STATUS );
                        	break;
                        case ProblemSpec.UMB_STATUS: 
                        	pUmb += ProblemSpec.getProbability(currStatus, 
                        											ProblemSpec.UMB_STATUS);
                        	break;
                        case ProblemSpec.STRASS_STATUS:
                        	pStrass += ProblemSpec.getProbability(currStatus, ProblemSpec.STRASS_STATUS);
                        	break;
                        case ProblemSpec.NECTRIA_STATUS:
                        	pNect += ProblemSpec.getProbability(currStatus, ProblemSpec.NECTRIA_STATUS);
                        	break;
                        case ProblemSpec.TRICH_STATUS:
                        	pTrich += ProblemSpec.getProbability(currStatus, ProblemSpec.TRICH_STATUS);
                        	break;
                        case ProblemSpec.NONCP_STATUS:
                        	pNonCP += ProblemSpec.getProbability(currStatus, ProblemSpec.NONCP_STATUS);
                        	break;
                        case ProblemSpec.HEALING_STATUS:
                        	pHealthy += ProblemSpec.getProbability(currStatus, 
                        											ProblemSpec.HEALING_STATUS);
                        	break;
                        case ProblemSpec.NORMAL_STATUS:
                            pNormal += ProblemSpec.getProbability( currStatus,
                                                                  ProblemSpec.NORMAL_STATUS );
                            break;
                        default:
                            break;
                    }
                }
            }
        
        // get interval points
        pVirus += pInfect;
        pPen += pVirus; 
        pPez += pPen;
        pUmb += pPez;
        pStrass += pUmb;
        pNect += pStrass;
        pTrich += pNect; 
        pNonCP += pNect;
        pHealthy += pNonCP; 
        pNormal += pHealthy;
        
        if ( pNormal > 1.0 )
            System.out.println( "ERROR: pNormal == " + pNormal );
        
        double chance = Math.random();
        
        if ( chance < pInfect )
        {
        	if (Math.random() > ProblemSpec.HEALING_CP | counter < ProblemSpec.DAYS_TO_HEAL) {
        		return ProblemSpec.INFECTED_STATUS;
        	} else if (currStatus != ProblemSpec.INFECTED_STATUS) {
        		
        		return ProblemSpec.HEALING_STATUS; 
        	}
        }
        else if ( chance < pVirus )
        {
        	if (Math.random() > ProblemSpec.HEALING_CP | counter < ProblemSpec.DAYS_TO_HEAL) {
        		return ProblemSpec.VIRAL_STATUS;
        	} else if (currStatus != ProblemSpec.VIRAL_STATUS) {
        		
        		return ProblemSpec.HEALING_STATUS; 
        	}
        }
        else if ( chance < pPen )
        {
            return ProblemSpec.PEN_STATUS;
        }
        
        else if ( chance < pPez )
        {
            return ProblemSpec.PEZ_STATUS;
        }
        else if ( chance < pUmb )
        {
            return ProblemSpec.UMB_STATUS;
        }
        else if ( chance < pStrass )
        {
            return ProblemSpec.STRASS_STATUS;
        }
        else if ( chance < pNect )
        {
            return ProblemSpec.NECTRIA_STATUS;
        }
        else if ( chance < pTrich )
        {
            return ProblemSpec.TRICH_STATUS;
        }
        else if ( chance < pNonCP )
        {
            return ProblemSpec.NONCP_STATUS;
        }
        else if ( chance < pHealthy )
        {
            return ProblemSpec.HEALING_STATUS;
        }
        else if ( chance < pNormal )
        {
            return ProblemSpec.NORMAL_STATUS;
        }
        
        return currStatus;
    }
    
    private void getNeighbors( int row, int col )
    {
        int up = row - 1;
        int down = row + 1;
        int left = ( col - 1 + ProblemSpec.WIDTH ) % ProblemSpec.WIDTH;
        int right = ( col + 1 + ProblemSpec.WIDTH ) % ProblemSpec.WIDTH;
        
        if ( row == 0 )
        {
            neighborhood[0][0] = -1;
            neighborhood[0][1] = -1;
            neighborhood[0][2] = -1;
            neighborhood[1][0] = canker[row][left];
            neighborhood[1][1] = canker[row][col];
            neighborhood[1][2] = canker[row][right];
            neighborhood[2][0] = canker[down][left];
            neighborhood[2][1] = canker[down][col];
            neighborhood[2][2] = canker[down][right];
        }
        else if ( row == canker.length - 1 )
        {
            neighborhood[0][0] = canker[up][left];
            neighborhood[0][1] = canker[up][col];
            neighborhood[0][2] = canker[up][right];
            neighborhood[1][0] = canker[row][left];
            neighborhood[1][1] = canker[row][col];
            neighborhood[1][2] = canker[row][right];
            neighborhood[2][0] = -1;
            neighborhood[2][1] = -1;
            neighborhood[2][2] = -1;
        }
        else
        {
            neighborhood[0][0] = canker[up][left];
            neighborhood[0][1] = canker[up][col];
            neighborhood[0][2] = canker[up][right];
            neighborhood[1][0] = canker[row][left];
            neighborhood[1][1] = canker[row][col];
            neighborhood[1][2] = canker[row][right];
            neighborhood[2][0] = canker[down][left];
            neighborhood[2][1] = canker[down][col];
            neighborhood[2][2] = canker[down][right];
        }
    }
}
