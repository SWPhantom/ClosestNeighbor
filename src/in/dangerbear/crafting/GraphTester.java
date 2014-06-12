package in.dangerbear.crafting;

import java.awt.Point;
import java.util.ArrayList;

public class GraphTester{
	long startTime;
	long stopTime;
	long elapsedTime;
	int[] closeness;
	
	public GraphTester(ArrayList<Point> field1){
		startTime = 0;
		stopTime = 0;
		elapsedTime = 0;
		closeness = new int[field1.size()];
	}

	/**
	 * method bruteForce
	 * 
	 * Does an n^2 scan through both of the given unsorted fields.
	 * For every Point in field1, see how many field2 Points are <= distance.
	 * 
	 * @param field1
	 * @param field2
	 * @param distance
	 */
	public void bruteForce(ArrayList<Point> field1, ArrayList<Point> field2, int distance){
		startTimer("Starting :: Brute Force.\n");
		
		double distanceSq = distance * distance;
		for(int i = 0; i < field1.size(); ++i){
			closeness[i] = 0;
			Point source = field1.get(i);
			for(int j = 0; j < field2.size(); ++j){
				Point destination = field2.get(j);
				if(source.distanceSq(destination) <= distanceSq){
					++closeness[i];
				}
			}
		}
		
		endTimer("Stopping :: Brute Force. ");
		results();
	}
	
	public void sortedBruteForce(ArrayList<Point> field1, ArrayList<Point> field2, int distance){
		
	}

	public void quickSelect(ArrayList<Point> field1, ArrayList<Point> field2,
			int distance){
		// TODO Auto-generated method stub
		
	}

	public void spaceDivide(ArrayList<Point> field1, ArrayList<Point> field2,
			int distance){
		// TODO Auto-generated method stub
		
	}
	
	private void startTimer(String message){
		pr(message);
		startTime = System.currentTimeMillis();
	}

	private void endTimer(String message){
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		pr(message + "Time (ms): " + elapsedTime + "\n");
	}

	private void results(){
		for(int i = 0; i< closeness.length; ++i){
			pr(closeness[i] + ", ");
		}
		pr("\n");
	}
	
	private void pr(String string){
		System.out.print(string);
	}
}
