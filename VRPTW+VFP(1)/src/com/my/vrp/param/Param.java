package com.my.vrp.param;

import static com.my.vrp.param.PenaltyFactor.*;




public class Param {
	static {
		new PenaltyFactor();
	}
	
	public static final double SERVICE_TIME = 3;
	/**
	 * Box quantity
	 */
	public static final int BOX_NUM = 62;
	/**
	 * Client quantity
	 */
	public static final int CLIENT_NUM = 29;
	/**
	 * Client quantity after splitting
	 */
	public static final int CLIENT_NUM1 = BOX_NUM;
	/**
	 * Node quantity
	 */
	public static final int NODE_NUM = CLIENT_NUM+1;
	/**
	 * Node quantity after splitting
	 */
	public static final int NODE_NUM1 = CLIENT_NUM1+1;
	/**
	 * Max quantity of vehicle
	 */
	public static final int VEHICLE_NUM = 8;
	/**
	 * Vehicle capacity
	 */
	public static final double VEHICLE_CAPACITY = 4500;
	/**
	 * Vehicle height
	 */
	public static final double VEHICLE_HEIGHT = 30;
	/**
	 * Vehicle width
	 */
	public static final double VEHICLE_WIDTH = 25;
	/**
	 * Infinity
	 */
	public static final double INF = Double.MAX_VALUE;
	/**
	 * Vehicle length
	 */
	public static final double VEHICLE_LENGTH = 60;
	/**
	 * Max number of iterations
	 */
	public static final int MAX_ITER = 10000;
	/**
	 * Overweight penalty factor
	 */
	public static double A = a;
	/**
	 * Over length penalty factor
	 */
	public static double B = b;
	/**
	 * Time window penalty factor
	 */
	public static double C = 20*c/SERVICE_TIME;
	
}
