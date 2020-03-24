package com.my.vrp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.my.vrp.Box;
import com.my.vrp.Carriage;
import com.my.vrp.Node;

public class LoadConfirm {


	@SuppressWarnings("unchecked")
	public  boolean loadConfirm(LinkedList<Node> routes,Carriage carriage) {
		ArrayList<Box> boxingSequence = new ArrayList<Box>();
		Collections.reverse(routes);//LIFO原则
		for (Node node : routes) {
			for (Box box : node.getGoods()) {
				boxingSequence.add(box);
			}
		}
		Collections.sort(boxingSequence);
		int maxIter=150;
		boolean flag=false;
		int a,b;
		for(int i=0;i<maxIter;i++) {
			int k = carriage.dblf(boxingSequence);
			if (k == boxingSequence.size()) {
				flag = true;
				break;
			}
			else {
				Random random = new Random();
				do {
					a=random.nextInt(k);
					b=random.nextInt(boxingSequence.size());
				}while(a!=b);
				Collections.swap(boxingSequence, a, b);
			}
		}
		return flag;
	}
	
	public ArrayList<Box> loadConfirm(ArrayList<Box> boxes,Carriage carriage) {
		Collections.reverse(boxes);
		int maxIter = 150;
		int a,b;
		for(int i=0;i<maxIter;i++) {
			int k = carriage.dblf(boxes);
			if(k == boxes.size()) {
				return null;
			}else {
				Random random = new Random();
				do {
					a=random.nextInt(k);
					b=random.nextInt(boxes.size());
				}while(a!=b);
				Collections.swap(boxes, a, b);
			}
		}
		ArrayList<Box> returnBoxes = new ArrayList<Box>();
		for (Box box : boxes) {
			if(!carriage.getBoxes().contains(box))
				returnBoxes.add(box);
		}
		return returnBoxes;
	}
}
