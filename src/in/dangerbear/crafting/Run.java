package in.dangerbear.crafting;

import java.awt.Point;
import java.util.ArrayList;

public class Run{

	public static void main(String[] args){
		int seed = 20;
		GraphGen generator = new GraphGen(seed);
		
		int points = 10000;
		ArrayList<Point> field1 = generator.makeGraph(points);
		ArrayList<Point> field2 = generator.makeGraph(points);
		
		GraphTester tester = new GraphTester(field1);
		int maxDistance = 300;
		
		for(int i = 0; i < 10; ++i){
			tester.bruteForce(field1, field2, maxDistance);
		}
		
		for(int i = 0; i < 10; ++i){
			tester.sortedBruteForce(field1, field2, maxDistance);
		}
		
		for(int i = 0; i < 10; ++i){
			tester.quickSelect(field1, field2, maxDistance);
		}
		
		for(int i = 0; i < 10; ++i){
			tester.spaceDivide(field1, field2, maxDistance);
		}
	}

}
