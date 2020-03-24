package com.my.vrp.param;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.my.vrp.Box;
import com.my.vrp.Node;
import static com.my.vrp.param.Param.*;
/**
 * 客户结点信息
 * @author dell
 *
 */
public class Client {

	private ArrayList<Node> clients = new ArrayList<Node>();
	
	public ArrayList<Node> getClients() {
		return clients;
	}

	public Client() {
		try {
			Scanner scanner = new Scanner(new FileReader("3lcvrp01.txt"));
			scanner.nextInt();
			scanner.nextDouble();
			scanner.nextDouble();
			scanner.nextDouble();
			scanner.nextInt();
			for(int i=0;i<CLIENT_NUM;i++) {
				Node client = new Node();
				ArrayList<Box> boxes = new ArrayList<Box>();
				client.setNumber(scanner.nextInt());
				client.setXCoor(scanner.nextDouble());
				client.setYCoor(scanner.nextDouble());
				client.setDemands(scanner.nextDouble());
				client.setGoodsNum(scanner.nextInt());
				for(int j=0;j<client.getGoodsNum();j++) {
					Box box = new Box();
					box.setNumber(scanner.nextInt());
					box.setHeight(scanner.nextDouble());
					box.setWidth(scanner.nextDouble());
					box.setLength(scanner.nextDouble());
					boxes.add(box);
				}
				client.setGoods(boxes);
				client.setBeginTime(0);
				client.setEndTime(0);
				client.setServiceTime(0);
				this.clients.add(client);
			}
			scanner.close();		
		}catch(FileNotFoundException e) {
			System.out.println("文件未找到");
			System.exit(-1);
		}
	}
}
