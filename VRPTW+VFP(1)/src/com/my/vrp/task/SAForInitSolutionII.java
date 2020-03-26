package com.my.vrp.task;

import java.util.ArrayList;
import com.my.vrp.Carriage;
import com.my.vrp.Route;
import com.my.vrp.Solution;
import static com.my.vrp.param.Param.*;
/**
 * 节约算法第二阶段
 * @author dell
 *
 */
public class SAForInitSolutionII{

	private Solution initSolution = new Solution();
	
	public Solution getIniSolution() {
		return initSolution;
	}

	private SAForInitSolution saForInitSolution = new SAForInitSolution();
	public Solution initSolution() {
		
		saForInitSolution.savingAlgorithm(saForInitSolution.initSolution(),saForInitSolution.initCarriages());
		
		return saForInitSolution.getInitSolution();
	}

	@SuppressWarnings("unused")
	public ArrayList<Carriage> initCarriages() {
		// TODO Auto-generated method stub
		saForInitSolution.savingAlgorithm(saForInitSolution.initSolution(),saForInitSolution.initCarriages());
		ArrayList<Carriage> carriages = new ArrayList<Carriage>();
		for (Route route : saForInitSolution.getInitSolution().getRoutesSolution()) {
			Carriage carriage = new Carriage();
			carriage.setLength(INF);
			carriages.add(carriage);
		}
		return carriages;
	}

	public void savingAlgorithm() {
		// TODO Auto-generated method stub
		Solution solution = initSolution(); 
		if(solution.getRoutesSolution().size()<=VEHICLE_NUM) {
			this.initSolution = solution;
			return;
		}else {
			ArrayList<Carriage> carriages = initCarriages();
			this.initSolution = saForInitSolution.savingAlgorithm(solution, carriages);
		}
	}

	
	
}
