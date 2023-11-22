package controller;

import view.ClockInterface;

public class MainProcess {
	
	public static void main(String[] args) {
//		MathInterface mathView = new MathInterface();
//		new MathController(mathView);
//		Display a clock
		
		ClockInterface clock = new ClockInterface();
		new ClockController(clock);
	}
}
