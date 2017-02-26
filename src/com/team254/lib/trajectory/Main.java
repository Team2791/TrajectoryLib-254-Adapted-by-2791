package com.team254.lib.trajectory;


import com.team254.lib.trajectory.io.TextFileSerializer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jared341
 */
public class Main {

	/*
	 * @return the path for the file that 
	 */
	public static String joinPath(String path1, String path2)
	{
		File file1 = new File(path1);
		File file2 = new File(file1, path2);
		return file2.getPath();
	}

	/*
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

	/*
	 * the main method where the Waypoints are sent to paths which are serialized to a file
	 */
	public static void main(String[] args) {
		String directory = "C:/Users/team2791/workspace/TrajectoryLib/paths";
		//    String directory = "/paths";
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
		 * scopes for each Path
		 */
		{
			config.dt = .02;
			config.max_acc = 8.0;
			config.max_jerk = 50.0;
			config.max_vel = 10.0;
			// Path name must be a valid Java class name.
			final String path_name = "InsideLanePathFar";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(7.0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(14.0, 1.0, Math.PI / 12.0));

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
			config.dt = .02;
			config.max_acc = 8.0;
			config.max_jerk = 45.0;
			config.max_vel = 13.0;
			// Path name must be a valid Java class name.
			final String path_name = "CenterLanePathFar";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(4.0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(4.1, 0, Math.PI / 12));//can't be ontop of it self

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
			config.dt = .02;
			config.max_acc = 8.5;
			config.max_jerk = 50.0;
			config.max_vel = 12.0;
			// Path name must be a valid Java class name.
			final String path_name = "InsideLanePathClose";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(7.0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(15.0, 3, Math.PI / 12.0));

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
			//config.dt = .02;
			config.max_acc = 20;//9
			config.max_jerk = 50;//50.0
			config.max_vel = 14;//11.75
			// Path name must be a valid Java class name.
			final String path_name = "StraightAheadPath";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(6, 0, 0));//in feet

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
			final String path_name = "WallLanePath";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(2.5, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(10.5, 8, Math.PI/12.0));
			p.addWaypoint(new WaypointSequence.Waypoint(13.75, 9.5, 0.0/* * Math.PI/18.0*/));


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
			final String path_name = "TenFootSCurve";

			// Description of this auto mode path.
			// Remember that this is for the GO LEFT CASE!
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(2.0, 0, 0));
			p.addWaypoint(new WaypointSequence.Waypoint(5.0, -2.0, Math.PI/4.0));
			p.addWaypoint(new WaypointSequence.Waypoint(8.0, -4.0, 0.0));
			p.addWaypoint(new WaypointSequence.Waypoint(10.0, -4.0, 0.0));


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
			final String path_name = "Test180";

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
	}
}