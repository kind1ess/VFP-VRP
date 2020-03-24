package com.my.vrp;
/**
 * 货物箱子类
 * @author dell
 *
 */
@SuppressWarnings("rawtypes")
public class Box implements Comparable ,Cloneable{
	private int number;
	private double length;
	private double width;
	private double height;
	private double XCoor;
	private double YCoor;
	private double ZCoor;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getXCoor() {
		return XCoor;
	}
	public void setXCoor(double xCoor) {
		this.XCoor = xCoor;
	}
	public double getYCoor() {
		return YCoor;
	}
	public void setYCoor(double yCoor) {
		this.YCoor = yCoor;
	}
	public double getZCoor() {
		return ZCoor;
	}
	public void setZCoor(double zCoor) {
		this.ZCoor = zCoor;
	}
	@Override
	public String toString() {
		return "Box [number=" + number + ", length=" + length + ", width=" + width + ", height=" + height + ", XCoor="
				+ XCoor + ", YCoor=" + YCoor + ", ZCoor=" + ZCoor + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Box box = (Box) o;
		double volume1=this.height*this.length*this.width;
		double volume2=box.height*box.length*box.width;
		if(volume1>volume2)
			return -1;
		else if(volume1==volume2)
			return 0;
		else
			return 1;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Box box = null;
		try {
			box = (Box)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return box;
	}
	
	
}
