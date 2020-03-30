package com.my.vrp.param;

import static com.my.vrp.param.PenaltyFactor.*;




public class Param {
	static {
		new PenaltyFactor();
	}
	/**
	 * 客户个数
	 */
	public static final int CLIENT_NUM = 100;
	/**
	 * 拆分后客户数量
	 */
	public static final int CLIENT_NUM1 = 198;
	/**
	 * 结点个数
	 */
	public static final int NODE_NUM = 101;
	/**
	 * 拆分后结点数量
	 */
	public static final int NODE_NUM1 = 199;
	/**
	 * 包裹个数
	 */
	public static final int BOX_NUM = 198;
	/**
	 * 最大车辆数
	 */
	public static final int VEHICLE_NUM = 23;
	/**
	 * 车辆容量（载重）
	 */
	public static final double VEHICLE_CAPACITY = 112;
	/**
	 * 车辆高度
	 */
	public static final double VEHICLE_HEIGHT = 30;
	/**
	 * 车辆宽度
	 */
	public static final double VEHICLE_WIDTH = 25;
	/**
	 * 无穷大
	 */
	public static final double INF = Double.MAX_VALUE;
	/**
	 * 车辆长度
	 */
	public static final double VEHICLE_LENGTH = 60;
	/**
	 * 最大迭代次数
	 */
	public static final int MAX_ITER = 10000;
	/**
	 * 惩罚因子
	 */
	public static double A = a;
	/**
	 * 惩罚因子
	 */
	public static double B = b;
}
