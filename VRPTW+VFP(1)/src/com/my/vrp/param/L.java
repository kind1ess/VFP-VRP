package com.my.vrp.param;
/**
 * 用于节约算法的L序列
 * @author dell
 *
 */
@SuppressWarnings("rawtypes")
public class L implements Comparable{
	private double sij;
	private int i;
	private int j;
	public double getSij() {
		return sij;
	}
	public void setSij(double sij) {
		this.sij = sij;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		L l = (L) o;
		if(this.sij>l.sij)
			return -1;
		else if(this.sij==l.sij)
			return 0;
		else
			return 1;
	}
	@Override
	public String toString() {
		return "L [sij=" + sij + ", i=" + i + ", j=" + j + "]";
	}
}
