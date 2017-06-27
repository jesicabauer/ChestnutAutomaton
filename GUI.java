package fungus;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener
{
    private final int POINT_SIZE = 10;
    
    private int width, height;
    
    private JFrame window;
    private JButton start, reset;
    private Timer timer;
    private JPanel mainPanel;
    
    private ChangeGenerator gen;
    private Rectangle[][] canker;
    
    public GUI( ChangeGenerator cg )
    {
        gen = cg;
        
        window = new JFrame( "Fungal Canker Simulation" );
        window.setLocation( 0, 0 );
        window.getContentPane()
        .setLayout( new BoxLayout( window.getContentPane(),
                                  BoxLayout.Y_AXIS ) );
        window.getContentPane().setBackground( Color.white );
        // window.setResizable( false );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        width = ProblemSpec.WIDTH * POINT_SIZE;
        height = ProblemSpec.HEIGHT * POINT_SIZE;
        
        mainPanel = new JPanel();
        mainPanel.setLayout( null );
        mainPanel.setBackground( window.getContentPane().getBackground() );
        mainPanel.setPreferredSize( new Dimension( width, height ) );
        setStartGrid( gen.getGrid() );
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground( window.getContentPane().getBackground() );
        buttonPanel.setPreferredSize( new Dimension( width, 40 ) );
        
        start = new JButton( "Start" );
        start.setSize( 70, 30 );
        start.addActionListener( this );
        start.setAlignmentX( Component.CENTER_ALIGNMENT );
        
        reset = new JButton( "Reset" );
        reset.setSize( 70, 30 );
        reset.addActionListener( this );
        reset.setAlignmentX( Component.CENTER_ALIGNMENT );
        
        buttonPanel.add( start );
        buttonPanel.add( reset );
        
        window.add( mainPanel );
        window.add( buttonPanel );
        window.pack();
        window.setResizable( false );
        window.setVisible( true );
        
        timer = new Timer( 100, this ); // set the time to generate
        
    }
    
    private void setStartGrid( int[][] grid )
    {
        canker = new Rectangle[grid.length][grid[0].length];
        for ( int row = 0; row < canker.length; row++ )
            for ( int col = 0; col < canker[0].length; col++ )
            {
                int xLoc = col * POINT_SIZE;
                int yLoc = row * POINT_SIZE;
                
                canker[row][col] = new Rectangle( xLoc, yLoc,
                                                 POINT_SIZE, POINT_SIZE );
                canker[row][col].setBackground( getCellColor( grid[row][col] ) );
                mainPanel.add( canker[row][col] );
            }
    }
    
    private Color getCellColor( int status )
    {
        Color c = Color.white;
        
        switch ( status )
        {
            case ProblemSpec.INFECTED_STATUS:
                c = Color.red;
                break;
            case ProblemSpec.VIRAL_STATUS:
                c = Color.green;
                break;
            case ProblemSpec.PEN_STATUS:
                c = Color.blue;
                break; 
            case ProblemSpec.PEZ_STATUS: 
            	c = Color.orange; 
            	break;
            case ProblemSpec.NONCP_STATUS: 
            	c = Color.magenta;
            	break; 
            case ProblemSpec.UNKNOWN_STATUS: 
            	c = Color.cyan;
            	break; 
            case ProblemSpec.HEALING_STATUS: 
            	c = Color.black; 
            	break;// can add more colors here
        }
        
        return c;
    }
    
    private void displayGrid( int[][] grid )
    {
        for ( int i = 0; i < grid.length; i++ )
            for ( int j = 0; j < grid[i].length; j++ )
            {
                canker[i][j].setBackground( getCellColor( grid[i][j] ) );
            }
        window.repaint(); 
    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == start )
        {
            if ( start.getText().equals( "Start" ) )
            {
                start.setText( "Pause" );
                timer.start();
            }
            else
            {
                start.setText( "Start" );
                timer.stop();
            }
        }
        else if ( e.getSource() == reset )
        {
            timer.stop();
            start.setText( "Start" );
            gen.reset();
            displayGrid( gen.getGrid() );
        }
        else if ( e.getSource() == timer )
        {
            displayGrid( gen.getNext() );
        }
    }
    
}
