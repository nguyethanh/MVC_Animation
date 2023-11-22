package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import view.ClockInterface;

public class ClockController implements ActionListener {
	private ClockInterface clockView;
	
	public ClockController(ClockInterface view){
		clockView = view;
		clockView.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				clockView.getClock().setRunning(false);
				clockView.dispose();
				clockView.getClock().getG2d().dispose();
				System.exit(1);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) { }

	public ClockInterface getClockView() {
		return clockView;
	}

	public void setClockView(ClockInterface clockView) {
		this.clockView = clockView;
	}
	
}
