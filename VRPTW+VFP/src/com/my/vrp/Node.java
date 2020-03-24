package com.my.vrp;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 结点类<br/>
 * number:客户编号<br/>
 * XCoor:X坐标<br/>
 * YCoor:Y坐标<br/>
 * goodsNum:货物数量<br/>
 * demands:需求货物的重量<br/>
 * beginTime:时间窗最早到达时间<br/>
 * endTime:时间窗最晚到达时间<br/>
 * serviceTime:服务时间<br/>
 * goods:货物信息<br/>
 * @author dell
 *
 */
public  class Node implements Cloneable{
	private int number;
	private double XCoor;
	private double YCoor;
	private int goodsNum;
	private double demands;
	private double beginTime;//时间窗最早达到时间
	private double endTime;//最晚到达时间
	private double serviceTime;//服务时间
	private ArrayList<Box> goods = new ArrayList<Box>();//客户的货物
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getXCoor() {
		return XCoor;
	}
	public void setXCoor(double xCoor) {
		XCoor = xCoor;
	}
	public double getYCoor() {
		return YCoor;
	}
	public void setYCoor(double yCoor) {
		YCoor = yCoor;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public double getDemands() {
		return demands;
	}
	public void setDemands(double demands) {
		this.demands = demands;
	}
	public double getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(double beginTime) {
		this.beginTime = beginTime;
	}
	public double getEndTime() {
		return endTime;
	}
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	public double getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(double serviceTime) {
		this.serviceTime = serviceTime;
	}
	public ArrayList<Box> getGoods() {
		return goods;
	}
	public void setGoods(ArrayList<Box> goods) {
		this.goods = goods;
	}
	
	@Override
	public String toString() {
		return "Node [number=" + number + ", XCoor=" + XCoor + ", YCoor=" + YCoor + ", goodsNum=" + goodsNum
				+ ", demands=" + demands + ", beginTime=" + beginTime + ", endTime=" + endTime + ", serviceTime="
				+ serviceTime + ", goods=" + goods + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Node node = null;
		try {
			node = (Node)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		ArrayList<Box> boxes = new ArrayList<Box>();
		Iterator<Box> iterator = goods.iterator();
		while(iterator.hasNext()) {
			boxes.add((Box) iterator.next().clone());
		}
		node.setGoods(boxes);
		return node;
	}
	
}
