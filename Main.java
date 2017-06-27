package fungus;

public class Main
{
    private GUI gui;
    private ChangeGenerator gen;
    private Fungal_Percents fungi; 
    
    public static void main( String[] args )
    {
        Main m = new Main();
        m.makeSimulator();
    }
    
    private void makeSimulator()
    {
    	fungi = new Fungal_Percents(); 
        gen = new ChangeGenerator();
        gui = new GUI( gen );
    }
}
