package parameter;

import simulation.AbstractSimulation;
import simulation.GameOfLifeSim;

/**
 * Created by Rob on 9/19/15.
 */
public class Game_of_Life_Param extends Parameters {
    public Game_of_Life_Param(){
        super();
    }

    public void fill_param_array(){
        list_of_parameters.add("percent_alive");
        list_of_parameters.add("percent_dead");

    }

    protected AbstractSimulation get_sim(){
        return new GameOfLifeSim(this);
    }
}
