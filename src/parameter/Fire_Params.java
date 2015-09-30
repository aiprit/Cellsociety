package parameter;

import simulation.AbstractSimulation;
import simulation.SpreadingFireSim;

/**
 * Created by Rob on 9/19/15.
 */
public class Fire_Params extends Parameters {

    public Fire_Params(){
        super();

    }

    public void fill_param_array(){
        list_of_parameters.add("probability_catch");
        list_of_parameters.add("percent_fire");
        list_of_parameters.add("percent_tree");

    }


    protected AbstractSimulation get_sim(){
        return new SpreadingFireSim(this);
    }
}

