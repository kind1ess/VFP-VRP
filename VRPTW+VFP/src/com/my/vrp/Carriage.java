package com.my.vrp;

import java.util.ArrayList;

import com.my.vrp.utils.BackSequence;
import com.my.vrp.utils.LeftSequence;
import com.my.vrp.utils.TopSequence;

import static com.my.vrp.param.Param.*;
/**
 * 车厢类
 * @author dell
 *
 */
public class Carriage {

	private double length = VEHICLE_LENGTH;
	private double width = VEHICLE_WIDTH;
	private double height = VEHICLE_HEIGHT;
	private double capacity = VEHICLE_CAPACITY;
	private ArrayList<Box> Boxes = new ArrayList<Box>();
	private double excessWeight;
	private double excessLength;
	

	public double getExcessWeight() {
		return excessWeight;
	}

	public void setExcessWeight(double excessWeight) {
		this.excessWeight = excessWeight;
	}

	public double getExcessLength() {
		return excessLength;
	}

	public void setExcessLength(double excessLength) {
		this.excessLength = excessLength;
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

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public ArrayList<Box> getBoxes() {
		return Boxes;
	}

	public void setBoxes(ArrayList<Box> boxes) {
		this.Boxes = boxes;
	}
/**
 * dblf算法装箱
 * @param clients
 * @return 装箱个数
 */
	public int dblf(ArrayList<Box> boxingSequence1) {
		ArrayList<Box> boxingSequence = new ArrayList<Box>();
		Box boxTop = new Box();
		Box boxBack = new Box();
		boxTop.setNumber(0);
		boxTop.setHeight(0);
		boxTop.setLength(0);
		boxTop.setWidth(0);
		boxTop.setXCoor(0);
		boxTop.setYCoor(0);
		boxTop.setZCoor(0);
		boxBack.setNumber(-1);
		boxBack.setHeight(0);
		boxBack.setLength(0);
		boxBack.setWidth(0);
		boxBack.setXCoor(0);
		boxBack.setYCoor(0);
		boxBack.setZCoor(0);
		boxingSequence.add(boxBack);
		boxingSequence.add(boxTop);
		for (Box box : boxingSequence1) {
			Box box1 = new Box();
			box1.setHeight(box.getHeight());
			box1.setLength(box.getLength());
			box1.setNumber(box.getNumber());
			box1.setWidth(box.getWidth());
			box1.setXCoor(box.getXCoor());
			box1.setYCoor(box.getYCoor());
			box1.setZCoor(box.getZCoor());
			boxingSequence.add(box);
		}
		LeftSequence left = new LeftSequence();
		BackSequence back = new BackSequence();
		TopSequence top = new TopSequence();
		back.backSequence.add(boxingSequence.get(0));
		top.topSequence.add(boxingSequence.get(1));
		back.backSequence.add(boxingSequence.get(2));
		left.leftSequence.add(boxingSequence.get(2));
		top.topSequence.add(boxingSequence.get(2));
		for(int i=3;i<boxingSequence.size();i++) {
			boolean insertConfirm = false;
			for(int j=0;j<back.backSequence.size();j++) {
				if(back.backSequence.get(j).getZCoor()+back.backSequence.get(j).getLength()+boxingSequence.get(i).getLength()<=length) {
					boxingSequence.get(i).setZCoor(back.backSequence.get(j).getZCoor()+back.backSequence.get(j).getLength());
				}
				else continue;
				for(int k=0;k<top.topSequence.size();k++) {
					if(top.topSequence.get(k).getYCoor()+top.topSequence.get(k).getHeight()+boxingSequence.get(i).getHeight()<=height) {
						boxingSequence.get(i).setYCoor(top.topSequence.get(k).getYCoor()+top.topSequence.get(k).getHeight());
					}
					else continue;
					boxingSequence.get(i).setXCoor(0);
						for(int p = 0;p<=left.leftSequence.size();p++) {
							boolean flag = false;
							if(p>left.leftSequence.size()-1||boxingSequence.get(i).getXCoor()+boxingSequence.get(i).getWidth()>width) 
								flag = true;
							else if(boxingSequence.get(i).getXCoor()+boxingSequence.get(i).getWidth()<=left.leftSequence.get(p).getXCoor())
								flag = true;
							else if(boxingSequence.get(i).getXCoor()<left.leftSequence.get(p).getXCoor()+left.leftSequence.get(p).getWidth()
									&&boxingSequence.get(i).getYCoor()<left.leftSequence.get(p).getYCoor()+left.leftSequence.get(p).getHeight()
									&&boxingSequence.get(i).getZCoor()<left.leftSequence.get(p).getZCoor()+left.leftSequence.get(p).getLength()
									)
								boxingSequence.get(i).setXCoor(left.leftSequence.get(p).getXCoor()+left.leftSequence.get(p).getWidth());
							if(flag==true) {
								if(boxingSequence.get(i).getXCoor()+boxingSequence.get(i).getWidth()<=width) {
									left.leftSequence.add(boxingSequence.get(i));
									back.backSequence.add(boxingSequence.get(i));
									top.topSequence.add(boxingSequence.get(i));
									left.leftSort();
									back.backSort();
									top.topSort();
									insertConfirm=true;
									break;
								}
								else break;
							}
						}
					if(insertConfirm)
						break;
				}
				if(insertConfirm)
					break;
			}
		}
		this.Boxes = left.leftSequence;
		if(back.backSequence.get(back.backSequence.size()-1).getZCoor()
				+back.backSequence.get(back.backSequence.size()-1).getLength()>60)
			this.excessLength = back.backSequence.get(back.backSequence.size()-1).getZCoor()
					+back.backSequence.get(back.backSequence.size()-1).getLength()-60;
		return left.leftSequence.size();
	}
	
}
