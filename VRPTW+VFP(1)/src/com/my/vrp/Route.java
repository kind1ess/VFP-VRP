package com.my.vrp;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 路线类
 * @author dell
 *
 */
public class Route implements Cloneable{

	private String name;
	private double distance;
	private LinkedList<Node> nodes;
	public Route() {
		
	}
	public Route(String name) {
		this.name = name;
	}
	
	
	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public LinkedList<Node> getNodes() {
		return nodes;
	}


	public void setNodes(LinkedList<Node> nodes) {
		this.nodes = nodes;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Route route = null;
		try {
			route = (Route)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		LinkedList<Node> nodes1 = new LinkedList<Node>();
		Iterator<Node> iterator = nodes.iterator();
		while(iterator.hasNext()) {
			nodes1.add((Node) iterator.next().clone());
		}
		route.setNodes(nodes1);
		return route;
	}
	
}
