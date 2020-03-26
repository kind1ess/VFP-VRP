package com.my.vrp.param;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.my.vrp.Box;
import com.my.vrp.Node;
import static com.my.vrp.param.Param.*;
/**
 * 瀹㈡埛缁撶偣淇℃伅
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
			int num = 0;
			for(int i=0;i<CLIENT_NUM;i++) {
				Node client = new Node();
				ArrayList<Box> boxes ;
				client.setNumber(scanner.nextInt());
				client.setNumber(num+1);
				client.setXCoor(scanner.nextDouble());
				client.setYCoor(scanner.nextDouble());
				client.setDemands(scanner.nextDouble());
				client.setGoodsNum(scanner.nextInt());
				for(int j=0;j<client.getGoodsNum();j++) {
					boxes = new ArrayList<Box>();
					Box box = new Box();
					box.setNumber(scanner.nextInt());
					box.setHeight(scanner.nextDouble());
					box.setWidth(scanner.nextDouble());
					box.setLength(scanner.nextDouble());
					boxes.add(box);
					try {
						Node clientClone = (Node) client.clone();
						clientClone.setNumber(client.getNumber()+j);
						clientClone.setDemands(client.getDemands()/client.getGoodsNum());
						clientClone.setGoods(boxes);
						clientClone.setBeginTime(0);
						clientClone.setEndTime(0);
						clientClone.setServiceTime(0);
						this.clients.add(clientClone);
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				num = clients.get(clients.size()-1).getNumber();
			}
			scanner.close();		
		}catch(FileNotFoundException e) {
			System.out.println("文件未找到");
			System.exit(-1);
		}
	}
}