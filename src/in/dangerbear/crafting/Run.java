package in.dangerbear.crafting;

import java.awt.Point;
import java.util.ArrayList;

public class Run{

	public static void main(String[] args){
		int seed = 30;
		GraphGen generator = new GraphGen(seed);
		
		int points = 50000;
		ArrayList<Point> field1;
		ArrayList<Point> field2;
		
		GraphTester tester = new GraphTester(points);
		int maxDistance = 10;
		
		for(int i = 0; i < 10; ++i){
			field1 = generator.makeGraph(points);
			field2 = generator.makeGraph(points);
			tester.bruteForce(field1, field2, maxDistance);
			tester.sortedBruteForce(field1, field2, maxDistance);
			tester.quickSelect(field1, field2, maxDistance);
			tester.spaceDivide(field1, field2, maxDistance);
			System.out.println();
		}
	}

}
