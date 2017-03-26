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
	 * All Paths are designed for the Blue Side, going forward,
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
			config.max_acc = 5; 
			config.max_jerk = 5;
			config.max_vel = 10;

			final String path_name = "TestingOneTwo"; 

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.PI/3));//right gear, 180-65
			p.addWaypoint(new WaypointSequence.Waypoint(1, 1, Math.PI/3));//right gear, 180-65
			p.addWaypoint(new WaypointSequence.Waypoint(4, -10, 0)); 


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

			final String path_name = "LoadingStationGear";


			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kLoadingStationGear));
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

		//********Scope Is Tested********
		{
			config.dt = .02;
			config.max_acc = 6.5; 
			config.max_jerk = 20;
			config.max_vel = 7;

			final String path_name = "CenterGear";

			WaypointSequence p = new WaypointSequence(10);

			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kCenterGear));

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

		//********Scope Is Tested********
		{
			config.dt = .02;
			config.max_acc = 9; 
			config.max_jerk = 20;
			config.max_vel = 12;

			//Working
			final String path_name = "BoilerGear";

			WaypointSequence p = new WaypointSequence(10);

			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kBoilerGear));


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

		//********Scope Is Tested********
		{
			config.dt = .02;
			config.max_acc = 6.5; 
			config.max_jerk = 20;
			config.max_vel = 7;

			final String path_name = "CloseShotToBoilerGear";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kBoilerWall));
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kBoilerGear));
			//			p.invertY();

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
			final String path_name = "GearToMidFieldPart2";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(2, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kMidfield));

			//			p.invertY();

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
		{
			final String path_name = "GearToMidFieldPart1";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kLoadingStationGear));
			p.addWaypoint(new WaypointSequence.Waypoint(2, 0, 0));
			//			p.invertY();

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
		//********Scope Is UnTested********
		{
			final String path_name = "GearToHopper";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kBoilerGear)); //right gear, 180-65
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kFarHopper)); 

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
		{
			final String path_name = "FarHopper";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0,0,0)); //right gear, 180-65
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kFarHopper)); 

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
		{
			final String path_name = "FarHopperNoTrigger";

			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0,0,0)); //right gear, 180-65
			p.addWaypoint(new WaypointSequence.Waypoint(Positions.kFarHopperMiddleOrigin)); 

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
