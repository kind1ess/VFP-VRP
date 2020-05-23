package com.my.vrp.param;

import static com.my.vrp.param.PenaltyFactor.*;




public class Param {
	static {
		new PenaltyFactor();
	}
	
	public static final double SERVICE_TIME = 3;
	/**
	 * 包裹个数
	 */
	public static final int BOX_NUM = 62;
	/**
	 * 客户个数
	 */
	public static final int CLIENT_NUM = 29;
	/**
	 * 拆分后客户数量
	 */
	public static final int CLIENT_NUM1 = BOX_NUM;
	/**
	 * 结点个数
	 */
	public static final int NODE_NUM = CLIENT_NUM+1;
	/**
	 * 拆分后结点数量
	 */
	public static final int NODE_NUM1 = CLIENT_NUM1+1;
	/**
	 * 最大车辆数8
	 */
	public static final int VEHICLE_NUM = 8;
	/**
	 * 车辆容量（载重）
	 */
	public static final double VEHICLE_CAPACITY = 4500;
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
	 * 超重惩罚因子
	 */
	public static double A = a;
	/**
	 * 超长惩罚因子
	 */
	public static double B = b;
	/**
	 * 时间窗惩罚因子
	 */
	public static double C = 20*c/SERVICE_TIME;
	
}
