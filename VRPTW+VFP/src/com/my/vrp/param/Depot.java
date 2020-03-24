package com.my.vrp.param;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.my.vrp.Box;
import com.my.vrp.Node;
/**
 * 配送中心节点信息
 * @author dell
 *
 */
public class Depot {

	private Node depot = new Node();
	public Depot() {
		try {
			Scanner scanner = new Scanner(new FileReader("3lcvrp01.txt"));	
			depot.setNumber(scanner.nextInt());
			depot.setXCoor(scanner.nextDouble());
			depot.setYCoor(scanner.nextDouble());
			depot.setBeginTime(0);
			depot.setEndTime(10000);
			depot.setServiceTime(0);
			depot.setDemands(scanner.nextDouble());
			depot.setGoodsNum(scanner.nextInt());
			depot.setGoods(new ArrayList<Box>());
			scanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("文件未找到");
			System.exit(-1);
		}
	}
	public Node getDepot() {
		return depot;
	}
	
}
