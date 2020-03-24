package com.my.vrp.utils;

import static com.my.vrp.param.Param.*;

import java.util.ArrayList;

import com.my.vrp.Node;
import com.my.vrp.Route;
/**
 * 求车辆超重的类
 * @author dell
 *
 */
public class ExcessWeight {

	private double excessWeight;
	public ExcessWeight(ArrayList<Route> routes) {
		double excessWeightPulish = 0;
		for (Route route : routes) {
			double demands = 0;
			for(Node node:route.getNodes()) {
				demands+=node.getDemands();
			}
			if(demands>VEHICLE_CAPACITY) {
				excessWeightPulish+=demands-VEHICLE_CAPACITY;
			}
		}
		this.excessWeight = excessWeightPulish;
	}
	public double getExcessWeight() {
		return excessWeight;
	}
	
}
