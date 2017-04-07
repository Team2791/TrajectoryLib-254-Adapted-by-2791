package com.team254.lib.trajectory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.team254.lib.trajectory.io.TextFileSerializer;
import com.team254.lib.util.Positions;
/**
 * This project should be named  "TrajectoryLib"
 * @author unbun
 * @author Jared341
 */
public class Main {


	/**
	 * the main method where the Waypoints are sent to paths which are serialized to a file
	 * All Paths are designed for the RED Side, going forward,
	 * As of now (3/22) these paths are based on the Field Inventor CAD
	 * Also, if you want a negative angle, make the path with a positive angle and invert the sequence
	 */
	public static void main(String[] args) {
		String directory = "../TrajectoryLib/paths";
		if (args.length >= 1) {
			directory = args[0];
		}


		TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
		config.dt = .02;
		config.max_acc = 10; 
		config.max_jerk = 5;
		config.max_vel = 13.5;

		final double kWheelbaseWidth = 28.0/12;

		/*
		 * Scopes for each Path
		 */

		//********Scope Is Tested********
		{
			config.dt = .02;//0.02
			config.max_acc = 6; //6.5 //5
			config.max_jerk = 6;//20 //15
			config.max_vel = 4;//7 //10

			final String path_name = "TestingOneTwo"; 

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(2.5,4,Math.PI/2-.0001));
			p.addWaypoint(new WaypointSequence.Waypoint(2.5,7,Math.PI/2-.0001));


			Path path = PathGenerator.makePath(p, config,
					kWheelbaseWidth, path_name);

			// Outputs to the directory supplied as the first argument.
			TextFileSerializer js = new TextFileSerializer();
			String serialized = js.serialize(path);
			//System.out.print(serialized);
			String fullpath = joinPath(directory, path_name + ".txt");
			if (!writeFile(fullpath, serialized)) {
				System.err.println(fullpath + " could not be written!!!!");
				System.exit(1);
			} else {
				System.out.println("Wrote " + fullpath);

			}
		}


		//********Scope Is Tested********
		{
			config.dt = .02;
			config.max_acc = 6.5; 
			config.max_jerk = 20;
			config.max_vel = 7;

			final String path_name = "RED_BoilerWallToBoilerGear";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0,0,0));
			p.addWaypoint(new WaypointSequence.Waypoint(68/12.0,38/12.0,0));
			p.addWaypoint(new WaypointSequence.Waypoint(110/12.0,38/12.0,0));
			p.invertY();

			Path path = PathGenerator.makePath(p, config,
					kWheelbaseWidth, path_name);

			// Outputs to the directory supplied as the first argument.
			TextFileSerializer js = new TextFileSerializer();
			String serialized = js.serialize(path);
			//System.out.print(serialized);
			String fullpath = joinPath(directory, path_name + ".txt");
			if (!writeFile(fullpath, serialized)) {
				System.err.println(fullpath + " could not be written!!!!1");
				System.exit(1);
			} else {
				System.out.println("Wrote " + fullpath);
			}
		}
		{
			final String path_name = "RED_CenterShotToCenterGear";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(32/12.0,32/12.0, 88*Math.PI/180 + 0.00001));
			p.addWaypoint(new WaypointSequence.Waypoint(32/12.0,66/12.0, 88*Math.PI/180 + 0.00001));

			p.invertY();

			Path path = PathGenerator.makePath(p, config,
					kWheelbaseWidth, path_name);

			// Outputs to the directory supplied as the first argument.
			TextFileSerializer js = new TextFileSerializer();
			String serialized = js.serialize(path);
			//System.out.print(serialized);
			String fullpath = joinPath(directory, path_name + ".txt");
			if (!writeFile(fullpath, serialized)) {
				System.err.println(fullpath + " could not be written!!!!");
				System.exit(1);
			} else {
				System.out.println("Wrote " + fullpath);

			}

		}
		//***************************************************************
		{
			config.dt = .02;
			config.max_acc = 6.5; 
			config.max_jerk = 20;
			config.max_vel = 7;

			final String path_name = "BLUE_BoilerWallToBoilerGear";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0,0,0));
			p.addWaypoint(new WaypointSequence.Waypoint(68/12.0,38/12.0,0));
			p.addWaypoint(new WaypointSequence.Waypoint(110/12.0,38/12.0,0));

			Path path = PathGenerator.makePath(p, config,
					kWheelbaseWidth, path_name);

			// Outputs to the directory supplied as the first argument.
			TextFileSerializer js = new TextFileSerializer();
			String serialized = js.serialize(path);
			//System.out.print(serialized);
			String fullpath = joinPath(directory, path_name + ".txt");
			if (!writeFile(fullpath, serialized)) {
				System.err.println(fullpath + " could not be written!!!!1");
				System.exit(1);
			} else {
				System.out.println("Wrote " + fullpath);
			}
		}
		{
			final String path_name = "BLUE_CenterShotToCenterGear";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(32/12.0,32/12.0, 88 *Math.PI/180 + 0.00001));
			p.addWaypoint(new WaypointSequence.Waypoint(32/12.0,66/12.0, 88*Math.PI/180 + 0.00001));

			Path path = PathGenerator.makePath(p, config,
					kWheelbaseWidth, path_name);

			// Outputs to the directory supplied as the first argument.
			TextFileSerializer js = new TextFileSerializer();
			String serialized = js.serialize(path);
			//System.out.print(serialized);
			String fullpath = joinPath(directory, path_name + ".txt");
			if (!writeFile(fullpath, serialized)) {
				System.err.println(fullpath + " could not be written!!!!");
				System.exit(1);
			} else {
				System.out.println("Wrote " + fullpath);

			}
		}
		System.out.println("All Paths Reticulated");
		System.out.println("Make sure to reflect any Path Changes in AutoPaths");

	}


	/**
	 * @param path1 the relative location of the path file
	 * @param path2 the path file name
	 * @return the path for the file that 
	 */
	public static String joinPath(String path1, String path2)
	{
		File file1 = new File(path1);
		File file2 = new File(file1, path2);
		return file2.getPath();
	}

	/**
	 * @param path is the path of the file that data is written to
	 * @param data is the serialized Path that is going to be written
	 * @return t/f if the file was successfully written
	 */
	private static boolean writeFile(String path, String data) {
		try {
			File file = new File(path);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				System.out.println("Working Directory = " + file.getPath());
				System.out.println("creating new file: "+path);
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

}
