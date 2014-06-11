package in.dangerbear.crafting;

import java.awt.Point;
import java.util.ArrayList;

public class GraphTester{
	
	public GraphTester(){
	}

	/**
	 * method bruteForce
	 * 
	 * Does an n^2 scan through both of the given unsorted fields.
	 * 
	 * @param field1
	 * @param field2
	 * @param distance
	 */
	public void bruteForce(ArrayList<Point> field1, ArrayList<Point> field2,
			int distance){
		int[] closeness = new int[field1.size()];
		pr("Starting brute force algorithm.\n");
		long startTime = System.currentTimeMillis();
		
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
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		pr("Stopping brute force algorithm. Time (ms): " + elapsedTime + "\n");
		for(int i = 0; i< closeness.length; ++i){
			pr(closeness[i] + ", ");
		}
		pr("\n");
	}
	
	

	public void sortedBruteForce(ArrayList<Point> field1, ArrayList<Point> field2,
			int distance){
		// TODO
	}

	public void quickSelect(ArrayList<Point> field1, ArrayList<Point> field2,
			int distance){
		// TODO Auto-generated method stub
		
	}

	public void spaceDivide(ArrayList<Point> field1, ArrayList<Point> field2,
			int distance){
		// TODO Auto-generated method stub
		
	}
	
	private void pr(String string){
		System.out.print(string);
	}
}
