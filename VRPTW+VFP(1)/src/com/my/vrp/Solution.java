package com.my.vrp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 算法的解类
 * distanceSolution:距离解<br/>
 * routeSolution:路线解<br/>
 * @author dell
 *
 */
public class Solution implements Cloneable{

	private double distanceSolution;
	private ArrayList<Route> routesSolution = new ArrayList<Route>();
	public void updateSolution(Solution solution) {
		this.distanceSolution = solution.distanceSolution;
		this.routesSolution = solution.routesSolution;
	}
	public double getDistanceSolution() {
		return distanceSolution;
	}
	public ArrayList<Route> getRoutesSolution() {
		return routesSolution;
	}
	
	public void setDistanceSolution(double distanceSolution) {
		this.distanceSolution = distanceSolution;
	}
	public void setRoutesSolution(ArrayList<Route> routesSolution) {
		this.routesSolution = routesSolution;
	}
	@Override
	public String toString() {
		return "Solution [distanceSolution=" + distanceSolution + ", routesSolution=" + routesSolution + "]";
	}
	public void showSolution() {
		System.out.println("Routes：");
		for (Route route : this.routesSolution) {
			System.out.print(route.getName()+" :\t");
			for (Node node : route.getNodes()) {
				System.out.print(node.getNumber()+"-->");
			}
			System.out.println();
		}
		System.out.println("Distance：");
		System.out.println(this.distanceSolution);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Solution solution = null;
		try {
			solution = (Solution)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		ArrayList<Route> routes = new ArrayList<Route>();
		Iterator<Route> iterator = routesSolution.iterator();
		while(iterator.hasNext()) {
			routes.add((Route) iterator.next().clone());
		}
		solution.setRoutesSolution(routes);
		return solution;
	}
	
}
