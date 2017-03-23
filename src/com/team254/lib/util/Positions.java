package com.team254.lib.util;

/**
 * A Constants class with all positions that are needed for the trajectories. 
 * All positions have 3 values, x, y, theta
 * @author team2791
 */
public class Positions {

	public final static double kWheelbaseWidth = 28.0/12;
	public final static double kRobotLength = 36/12;
	
	public final static double kLoadingStationGear[] = {125/12 - kRobotLength, 81/12 - kRobotLength, Math.PI/3};
	public final static double kCenterGear[] = {100/12 - kRobotLength, 0, 0};
	public final static double kBoilerGear[] = {125/12 - kRobotLength, 81.75/12 - kRobotLength, Math.PI/3};
	
	public final static double kBoilerWall[] = {18.6/12, 19.3/12 , Math.PI/3};//facing boiler to 0 degrees
	
	public final static double kMidfield[] ={325/12 - kRobotLength, 0, 0};
	
	public final static double kFarHopper[] ={147.9/12 - kRobotLength, 37.6/12 - kRobotLength, 0};
	public final static double kFarHopperMiddleOrigin[] ={147.9/12 - kRobotLength, 107.5/12 - kRobotLength, 0};
}
