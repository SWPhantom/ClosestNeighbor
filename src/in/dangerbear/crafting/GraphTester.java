package in.dangerbear.crafting;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Resources:
 * http://en.wikipedia.org/wiki/Nearest_neighbor_search
 * http://programmers.stackexchange.com/questions/129892/find-all-points-within-a-certain-distance-of-each-other
 * http://en.wikipedia.org/wiki/Quickselect
 * 
 */
public class GraphTester{
	long startTime;
	long stopTime;
	long elapsedTime;
	int[] closeness;
	
	public GraphTester(ArrayList<Point> pointField){
		startTime = 0;
		stopTime = 0;
		elapsedTime = 0;
		closeness = new int[pointField.size()];
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
	
	public void sortedBruteForce(ArrayList<Point> field1, ArrayList<Point> input2, int distance){
		ArrayList<Point> field2 = new ArrayList<Point>();
		
		deepCopy(field2, input2);
		
		startTimer("Starting :: Sorted 'Smart' Brute Force.\n");
		Collections.sort(field2, new ComparePoints());
		
		double distanceSq = distance * distance;
		for(int i = 0; i < field1.size(); ++i){
			closeness[i] = 0;
			Point source = field1.get(i);
			for(int j = 0; j < field2.size(); ++j){
				Point destination = field2.get(j);
				
				//Skip the dest point if it's too far to the left.
				if(destination.getX() < source.getX() - distance){
					continue;
				}
				
				//Don't bother checking the next dest points if they're
				//too far to the right.
				if(destination.getX() > source.getX() + distance){
					break;
				}
				
				if(source.distanceSq(destination) <= distanceSq){
					++closeness[i];
				}
			}
		}
		
		endTimer("Stopping :: Sorted 'Smart' Brute Force. ");
		
		field2.clear();
		results();
	}

	public void quickSelect(ArrayList<Point> field1, ArrayList<Point> input2, int distance){
		ArrayList<Point> field2 = new ArrayList<Point>();
		
		deepCopy(field2, input2);
		
		startTimer("Starting :: Quickselect.\n");
		Collections.sort(field2, new ComparePoints());
		
		double distanceSq = distance * distance;
		for(int i = 0; i < field1.size(); ++i){
			closeness[i] = 0;
			Point source = field1.get(i);
			
			int select = quickfind(source, field2, distance);
			
			//Scan to its left until out of bounds.
			int scanner = select;
			while(scanner >= 0 && field2.get(scanner).getX() >= source.getX() - distance){
				Point destination = field2.get(scanner);
				if(source.distanceSq(destination) <= distanceSq){
					++closeness[i];
				}
				--scanner;
			}
			//Scan to its right until out of bounds.
			scanner = select + 1;
			while(scanner < field2.size() && field2.get(scanner).getX() <= source.getX() + distance){
				Point destination = field2.get(scanner);
				if(source.distanceSq(destination) <= distanceSq){
					++closeness[i];
				}
				++scanner;
			}
		}
		
		endTimer("Stopping :: Quickselect. ");
		
		field2.clear();
		results();
		
	}

	private int quickfind(Point source, ArrayList<Point> field2, int distance){
		int max = field2.size();
		int min = 0;
		int select = max / 2;
		boolean done = false;
		while(!done){
			Point destination = field2.get(select);
			if(destination.getX() < source.getX() - distance){
				min = select;
				select = (max + min)/2;
			}else if(destination.getX() > source.getX() + distance){
				max = select;
				select = (max + min)/2;
			}else{
				done = true;
			}
		}
		
		return select;
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
		pr(message + "Time (ms): " + elapsedTime + "\n\n");
	}

	private void results(){
		for(int i = 0; i< closeness.length; ++i){
			//pr(closeness[i] + ", ");
		}
		pr("\n");
	}

	private void deepCopy(ArrayList<Point> field1, ArrayList<Point> input1){
		for(int i = 0; i < input1.size(); ++i){
			field1.add(input1.get(i).getLocation());
		}
	}
	
	private void pr(String string){
		System.out.print(string);
	}
}
