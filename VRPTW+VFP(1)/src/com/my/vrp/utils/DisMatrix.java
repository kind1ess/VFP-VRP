package com.my.vrp.utils;

import static com.my.vrp.utils.CaculateDistance.caculateDistance;

import com.my.vrp.param.AllNodes;
import static com.my.vrp.param.Param.*;
/**
 * 计算距离矩阵
 * @author dell
 *
 */
public class DisMatrix {
	private double[][]disMatrix;
	public  DisMatrix() {
		AllNodes allNodes = new AllNodes();
		double[][] Graph = new double[NODE_NUM1][NODE_NUM1];
		for(int i=0;i<NODE_NUM1;i++) {
			for(int j=0;j<NODE_NUM1;j++) {
				Graph[i][j] = caculateDistance(allNodes.getAllNodes().get(i), allNodes.getAllNodes().get(j));
			}
		}
		disMatrix = Graph;
	}
	public double[][] getDisMatrix() {
		return disMatrix;
	}
	public void setDisMatrix(double[][] disMatrix) {
		this.disMatrix = disMatrix;
	}
	
}
