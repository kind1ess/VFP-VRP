package com.my.vrp.utils;

import com.my.vrp.Node;
/**
 * 计算距离的工具类
 * @author dell
 *
 */
public class CaculateDistance {

	public static double caculateDistance(Node node1,Node node2) {
		return Math.sqrt(Math.pow((node1.getXCoor()-node2.getXCoor()), 2)+
				Math.pow((node1.getYCoor()-node2.getYCoor()), 2));
	}
}
