package com.my.vrp.utils;

import static com.my.vrp.utils.CaculateDistance.caculateDistance;
import static com.my.vrp.param.Param.*;
import java.util.ArrayList;
import java.util.LinkedList;

import com.my.vrp.Carriage;
import com.my.vrp.Node;
import com.my.vrp.Route;
import com.my.vrp.Solution;
/**
 * 求距离解的类
 * @author dell
 *
 */
public class DistanceSolution {
/**
 * 用于求带有惩罚的距离的方法
 * @param solution
 * @return
 */
	public static double caculateDistanceSolution(Solution solution) {
				ArrayList<Carriage> carriages = new ArrayList<Carriage>();
				for(int p=0;p<solution.getRoutesSolution().size();p++) {
					Carriage carriage = new Carriage();
					carriage.setLength(INF);
					LoadConfirm loadConfirm = new LoadConfirm();
					LinkedList<Node> nodes = new LinkedList<Node>();
					for(int q=1;q<solution.getRoutesSolution().get(p).getNodes().size()-1;q++) {
						nodes.add(solution.getRoutesSolution().get(p).getNodes().get(q));
					}
					loadConfirm.loadConfirm(nodes, carriage);
					carriages.add(carriage);
				}
				double distance = caculateDistanceSolutionII(solution);
				ExcessLength excessLength = new ExcessLength(carriages);
				ExcessWeight excessWeight = new ExcessWeight(solution.getRoutesSolution());
				double excessLengthPunish = excessLength.getExcessLength();
				double excessWeightPulish = excessWeight.getExcessWeight();
				double excessTimePunish = new ExcessTime(solution).getExcessTime();
				distance+=Math.pow(excessLengthPunish, 2)*B+Math.pow(excessWeightPulish, 2)*A
						+Math.pow(excessTimePunish, 2)*C;
				return distance;
	}
	/**
	 * 用于求不带惩罚的距离
	 * @param solution
	 * @return
	 */
	public static double caculateDistanceSolutionII(Solution solution) {
		double distance = 0;
		for (Route route : solution.getRoutesSolution()) {
			for(int i1=0;i1<route.getNodes().size()-1;i1++) {
				distance+=caculateDistance(route.getNodes().get(i1), route.getNodes().get(i1+1));
			}
		}
		return distance;
	}
}
