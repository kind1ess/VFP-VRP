package com.my.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.my.vrp.Node;
import com.my.vrp.param.Client;

public class Test {
	public static void main(String[] args) {
		Client client = new Client();
		List<Node> clients = client.getClients();
		Iterator<Node> iterator = clients.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
