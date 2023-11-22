package model;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.time.LocalTime;

public class Tiktok extends Canvas {

	/**
	 * This class uses to create a timer clock graphics
	 */
	private static final long serialVersionUID = 1L;
	private static final int HLENT = 40;
	private static final int MLENT = 70;
	private static final int SLENT = 90;
	
	private boolean isRunning;
	private Point center;
	private Point hourHand;
	private Point minHand;
	private Point secHand;
	private Integer hours;
	private Integer mins;
	private Integer secs;
	private Integer radius;
	private Graphics2D g2d;
	
	public Tiktok() {
		this.isRunning = true;
		this.hourHand = new Point();
		this.minHand = new Point();
		this.secHand = new Point();
	}
	
	public Tiktok(Point hourHand, Point minHand, Point secHand) {
		this.isRunning = true;
		this.hourHand = hourHand;
		this.minHand = minHand;
		this.secHand = secHand;
	}
	
	public void displayCurrentTime(Graphics2D g2d) {
		LocalTime now = LocalTime.now();
		setHours(now.getHour());
		setMins(now.getMinute());
		setSecs(now.getSecond()); 
//		Draw hour hand of clock
		setHourHand(hours * 30.0 + mins / 2, HLENT);
		g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
		g2d.drawLine(center.x, center.y, hourHand.x, hourHand.y);
//		Draw minute hand of clock
		setMinHand(mins * 6.0, MLENT);
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
		g2d.drawLine(center.x, center.y, minHand.x, minHand.y);
//		Draw second hand of clock
		setSecHand(secs * 6.0, SLENT);
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
		g2d.drawLine(center.x, center.y, secHand.x, secHand.y);
	}

	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D) g;
		center = new Point(getWidth() / 2 , getHeight() / 2);
		Ellipse2D circle = new Ellipse2D.Double();
		radius = 110;
		circle.setFrameFromCenter(center.x, center.y, center.x + radius, center.y + radius);
		g2d.draw(circle);
//		Draw the number
		for (int i = 0; i < 12; ++i) {
			double angle = 30 * i;
			setSecHand(angle, 100);
			g2d.fillRect(secHand.x - 5, secHand.y - 5, 10, 10);
		}
		
//		Draw the current time
		displayCurrentTime(g2d);
	}
	
	public Point getHourHand() {
		System.out.println("Hour point: " + hourHand.toString());
		return hourHand;
	}

	public void setHourHand(Double angle, Integer length) {
		double rads = Math.toRadians(angle - 90);
		this.hourHand.setLocation(center.x + length * Math.cos(rads), center.y + length * Math.sin(rads));
	}

	public Point getMinHand() {
		System.out.println("Minute point: " + minHand.toString());
		return minHand;
	}

	public void setMinHand(Double angle, Integer length) {
		double rads = Math.toRadians(angle - 90);
		this.minHand.setLocation(center.x + length * Math.cos(rads), center.y + length * Math.sin(rads));
	}

	public Point getSecHand() {
		System.out.println("Second point: " + secHand.toString());
		return secHand;
	}

	public void setSecHand(Double angle, Integer length) {
		double rads = Math.toRadians(angle - 90);
		this.secHand.setLocation(center.x + length * Math.cos(rads), center.y + length * Math.sin(rads));
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMins() {
		return mins;
	}

	public void setMins(Integer mins) {
		this.mins = mins;
	}

	public Integer getSecs() {
		return secs;
	}

	public void setSecs(Integer secs) {
		this.secs = secs;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Graphics2D getG2d() {
		return g2d;
	}

	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}
}
