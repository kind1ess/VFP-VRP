package com.my.vrp.utils;

import java.util.List;

import com.my.vrp.Node;
import com.my.vrp.Route;
import com.my.vrp.Solution;

public class ExcessTime {
	private double excessTime;
	public ExcessTime(Solution solution) {
		/*
		 * List<Node> clients = ReachTime.caculateReachTime(solution); Node pre = null;
		 */
		solution = ReachTime.caculateReachTime(solution);
		List<Route> routes = solution.getRoutesSolution();
		for (Route route : routes) {
			Node pre = null;
			for (Node node : route.getNodes()) {
				double reachTime = node.getReachTime();
				double beginTime = node.getBeginTime();
				double endTime = node.getEndTime();
				if(pre!=null&&node.getXCoor()==pre.getXCoor()&&node.getYCoor()==pre.getYCoor())
					continue;
				if(reachTime<beginTime||reachTime>endTime) {
					excessTime += reachTime<beginTime ? (beginTime-reachTime):(reachTime-endTime);
				}
				pre = node;
			}	
		}
	}
	
	public double getExcessTime() {
		return excessTime;
	}
}
