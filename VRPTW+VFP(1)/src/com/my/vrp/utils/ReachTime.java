package com.my.vrp.utils;

import java.util.ArrayList;
import java.util.List;

import com.my.vrp.Node;
import com.my.vrp.Route;
import com.my.vrp.Solution;

public class ReachTime {
	private static DisMatrix disMatrix;
	
	static {
		disMatrix = new DisMatrix();
	}
	
	public static Solution caculateReachTime(Solution solution) {
		List<Route> routes = solution.getRoutesSolution();
		double[][] graph = disMatrix.getDisMatrix();
//		List<Node> clients = new ArrayList<Node>();
		for (Route route : routes) {
			double driveTime = 0;
			for (int i=0;i<route.getNodes().size()-1;i++) {
				Node current = route.getNodes().get(i);
				Node next = route.getNodes().get(i+1);
				if(current.getXCoor()!=next.getXCoor()||current.getYCoor()!=next.getYCoor()) {
					driveTime += graph[current.getNumber()][next.getNumber()]+current.getServiceTime();	
				}
				next.setReachTime(driveTime);
				/*
				 * if (next.getNumber()!=0) clients.add(next);
				 */
			}
		}
		return solution;
	}
}
