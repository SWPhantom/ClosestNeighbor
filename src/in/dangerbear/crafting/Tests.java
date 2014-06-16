package in.dangerbear.crafting;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Tests{

	@Before
	public void setUp() throws Exception{
		int randSeed = 20;
		GraphGen generator = new GraphGen(randSeed);
		int points = 10000;
		ArrayList<Point> field1 = generator.makeGraph(points);
		ArrayList<Point> field2 = generator.makeGraph(points);
	}

	@Test
	public void generate(){
		fail("Not yet implemented");
	}

}
