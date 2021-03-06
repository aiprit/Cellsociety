package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import block.AgentBlock;
import block.Block;
import block.Location;
import block.SugarBlock;
import javafx.scene.paint.Color;
import parameter.Parameters;

public class SugarSim1 extends AbstractSimulation{
	private double sugarhi;
	private int vision;
	private int metabolism;
	private double blood;
	private double growth;
	public SugarSim1(Parameters parameter){
		super(parameter);
		sugarhi = parameter.get_param_map().get("maxsugar");
		vision =  parameter.get_param_map().get("vision").intValue();
		metabolism = parameter.get_param_map().get("metabolism").intValue();
		blood = parameter.get_param_map().get("maxsugarblood");
		double agent = parameter.get_param_map().get("agent_fract");
		growth = parameter.get_param_map().get("sugargrowth");
		reset(sugarhi,agent);

	}
	@Override
	public void populateWorld(double maxsugar, double fraction2) {

		if(fraction2 > 1) {
			// too many creatures. scale each
			fraction2= fraction2 / 3;
		}
		int num2 = (int) (fraction2 * getNumSpots());
		populateIndefinite((int)maxsugar, num2);
	}

	@Override
	public Block chooseBlock(boolean placeBlock) {
		return null;
	}
	@Override
	public void populateDefinite(int num1, int num2) {
	}
	@Override
	public void populateIndefinite(int maxsugar, int num2) {
		 ArrayList<Location> locs = new ArrayList<Location>();
		 Random r1 = new Random();
		for(int r = 0, rLimit = theWorld.getNumRows(); r < rLimit; r++){
            for(int c = 0, cLimit = theWorld.getNumCols(); c < cLimit; c++){
            	locs.add(new Location(r, c));
            }
        }
		 Collections.shuffle(locs);
	        for(int i = 0; i < num2; i++){
	             new AgentBlock(0,maxsugar,growth,blood,r1.nextInt(metabolism),r1.nextInt(vision)).putSelfInGrid(theWorld, locs.get(i));
	            locs.remove(locs.get(i));
	        }
	        for(int i = 0; i < locs.size(); i++){
	        	 new SugarBlock(r1.nextInt(25),maxsugar,growth).putSelfInGrid(theWorld,locs.get(i));
	        }
	}
	@Override
	public Color getEmptyColor() {
		// TODO Auto-generated method stub
		return Color.WHITE;
	}

}
