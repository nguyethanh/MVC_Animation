package view;

import javax.swing.JFrame;

import model.Tiktok;

public class ClockInterface extends JFrame{
	/**
	 * This view uses for displaying a clock with really time
	 */
	private static final long serialVersionUID = 1L;
	private Tiktok clock;
	
	public ClockInterface() {
		clock = new Tiktok();

		add(clock);
		setSize(280, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (getFocusableWindowState()) {
			try {
				clock.repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public Tiktok getClock() {
		return clock;
	}

	public void setClock(Tiktok clock) {
		this.clock = clock;
	}
	
}
