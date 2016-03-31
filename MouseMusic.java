package MouseMusic;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MouseMusic extends SuperMusic
{	
	public static void main(String[] args) throws InterruptedException
	{
		SuperSynth synth = new SuperSynth();
		Point oldp, newp;
		oldp = MouseInfo.getPointerInfo().getLocation();
				
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new MouseMusic().displayGUI();
            }
        });

		while(true)
		{
			newp = MouseInfo.getPointerInfo().getLocation();
			if(oldp.x != newp.x || oldp.y != newp.y)
			{
				synth.setProgram(newp.y);
				synth.play(new Note(newp.x % 128, 50));
			}
			oldp = newp;
		}
	}
	
	private void displayGUI()
    {
        final JFrame frame = new JFrame("MouseMusic");

        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                int result = JOptionPane.showConfirmDialog(
                                frame, "Do you want to Exit ?"
                                , "Exit Confirmation : ", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)               
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION)   
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        frame.setSize(50, 50);
        frame.setVisible(true);
    }

}
