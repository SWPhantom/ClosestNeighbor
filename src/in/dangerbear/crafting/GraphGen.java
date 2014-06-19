package in.dangerbear.crafting;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class GraphGen{
	private Random rand;
	
	public GraphGen(){
		rand = new Random();
	}
	
	public GraphGen(int seed){
		rand = new Random(seed);
	}

	/**
	 * function makeGraph
	 * 
	 * Creates a specified number of 
	 * @param points
	 * @return
	 */
	public ArrayList<Point> makeGraph(int points){
		ArrayList<Point> output = new ArrayList<Point>();
		for(int i = 0; i < points; ++i){
			int x = rand.nextInt(1000); // TODO these can be changed.
			int y = rand.nextInt(1000);
			output.add(new Point(x, y));
		}
		return output;
	}
}
