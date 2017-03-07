package com.team254.lib.trajectory;


import com.team254.lib.trajectory.io.TextFileSerializer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This project should be named  "TrajectoryLib"
 * @author unbun
 * @author Jared341
 */
public class Main {


	/**
	 * the main method where the Waypoints are sent to paths which are serialized to a file
	 */
	public static void main(String[] args) {
		String directory = "../TrajectoryLib/paths";
		if (args.length >= 1) {
			directory = args[0];
		}


		TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
		config.dt = .02;
		config.max_acc = 10; //10.0;
		config.max_jerk = 60.0; //60.0;
		config.max_vel = 13; //15.0;

		final double kWheelbaseWidth = 28.0/12;

		/*
		 * Scopes for each Path
		 */
		
		{
			// Path name must be a valid Java class name.
			config.dt = .02;
			config.max_acc = 7.0;
			config.max_jerk = 50.0;
			config.max_vel = 10.0;
			final String path_name = "TestingOneTwo";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(6, -6, -Math.PI / 4));


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
			// Path name must be a valid Java class name.
			config.dt = .02;
			config.max_acc = 7.0;
			config.max_jerk = 50.0;
			config.max_vel = 10.0;
			final String path_name = "BLUELeftGear";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(8.5, 5.5, 13*Math.PI / 36)); //right gear, angle = 65 deg

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
			// Path name must be a valid Java class name.
			config.dt = .02;
			config.max_acc = 7.0;
			config.max_jerk = 50.0;
			config.max_vel = 10.0;
			final String path_name = "BLUELeftGearToLeftHopper";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(8.5, 5.5, 23*Math.PI / 36)); //right gear, 180-65
			p.addWaypoint(new WaypointSequence.Waypoint(10, -3.5, Math.PI / 2)); //right hopper, RANs

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

	/*
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
