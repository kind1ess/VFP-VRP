package com.my.vrp.param;

import com.my.vrp.utils.DisMatrix;

import static com.my.vrp.param.Param.*;
/**
 * 惩罚因子类
 * @author dell
 *
 */
public class PenaltyFactor {
	static {
		new DisMatrix();
	}
	public static double c;
	public static double a;
	public static double b;
	double num1 = 0;
	int num2 = 0;
	public PenaltyFactor() {
		DisMatrix disMatrix = new DisMatrix();
		for(int i=0;i<CLIENT_NUM;i++) {
			for(int j=i+1;j<CLIENT_NUM;j++) {
				num1 += disMatrix.getDisMatrix()[i][j];
				num2++;
			}
		}
		c = num1/num2;
		a = 20*c/VEHICLE_CAPACITY;
		b = 20*c/VEHICLE_LENGTH;
	}
}
