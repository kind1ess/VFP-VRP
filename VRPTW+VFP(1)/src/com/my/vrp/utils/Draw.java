package com.my.vrp.utils;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.vrp.Node;
import com.my.vrp.Route;
import com.my.vrp.Solution;
import com.my.vrp.param.Client;
import com.my.vrp.param.Depot;
import com.my.vrp.param.Param;
import com.my.vrp.task.TabuSearchForBestSolution;

public class Draw extends Frame{
	public static void draw() {
		Draw draw = new Draw();
		draw.setSize(1000,1000);
		draw.setLocationRelativeTo(null);
		draw.setVisible(true);
		draw.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
		    	System.exit(0);
			}
		});
	}
	
	public void paint (Graphics g) {
		Solution solution = TabuSearchForBestSolution.globalBestSolution;
		List<Route> routeSolution = solution.getRoutesSolution();
		g.setColor(Color.BLACK);
		for(Route route:routeSolution) {
			for(int i=0;i<route.getNodes().size()-1;i++) {
				int x1 = (int)route.getNodes().get(i).getXCoor()*10;
				int y1 = (int)route.getNodes().get(i).getYCoor()*10;
				int x2 = (int)route.getNodes().get(i+1).getXCoor()*10;
				int y2 = (int)route.getNodes().get(i+1).getYCoor()*10;
				g.drawLine(x1, y1, x2, y2);
				g.fillOval(x1-5, y1-5,10, 10);
			}
		}
		Depot depot = new Depot();
		Node node = depot.getDepot();
		String depotName = "Depot"+"("+node.getXCoor()+","+node.getYCoor()+")";
		int depotX = (int)node.getXCoor()*10;
		int depotY = (int)node.getYCoor()*10;
		g.drawString(depotName, depotX, depotY);
		Client client = new Client();
		ArrayList<Node> clients = client.getClients();
		Map<String,Boolean> flagMap = new HashMap<String, Boolean>();
		for(int i=0,num=1;i<clients.size();i++) {
			int x = (int) clients.get(i).getXCoor();
			int y = (int) clients.get(i).getYCoor();
			String temp = x+""+y;
			if(flagMap.get(temp)==null||!flagMap.get(temp)) {
				String name = "Client"+num+"("+clients.get(i).getXCoor()+","+
						clients.get(i).getYCoor()+")";
				g.drawString(name, x*10, y*10);
				flagMap.put(temp, true);
				num++;
			}
		}
	}
}
