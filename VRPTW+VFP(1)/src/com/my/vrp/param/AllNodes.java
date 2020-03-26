package com.my.vrp.param;

import java.util.ArrayList;

import com.my.vrp.Node;
/**
 * 所有节点信息
 * @author dell
 *
 */
public class AllNodes {

	private ArrayList<Node> allNodes = new ArrayList<Node>();
	private Client client = new Client();
	private Depot depot = new Depot();
	public AllNodes() {
		new Depot();
		new Client();
		this.allNodes.add(depot.getDepot());
		this.allNodes.addAll(client.getClients());
	}
	public ArrayList<Node> getAllNodes() {
		return allNodes;
	}
	
}
