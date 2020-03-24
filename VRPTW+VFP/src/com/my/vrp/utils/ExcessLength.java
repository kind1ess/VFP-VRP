package com.my.vrp.utils;

import java.util.ArrayList;

import com.my.vrp.Carriage;
/**
 * 求车辆超长的类
 * @author dell
 *
 */
public class ExcessLength {

	private double excessLength;
	public ExcessLength(ArrayList<Carriage> carriages) {
		double excessLengthPunish = 0;
		for (Carriage carriage : carriages) {
			excessLengthPunish+=carriage.getExcessLength();
		}
		this.excessLength = excessLengthPunish;
	}
	public double getExcessLength() {
		return excessLength;
	}
	
}
