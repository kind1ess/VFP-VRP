package com.my.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.my.vrp.Node;
import com.my.vrp.Route;
import com.my.vrp.Solution;
import com.my.vrp.param.Param;
import com.my.vrp.task.TabuSearchForBestSolution;
import com.my.vrp.utils.Draw;
import com.my.vrp.utils.ExcessTime;
import com.my.vrp.utils.ReachTime;

public class ReachTimeTest {

	public static void main(String[] args) {
		TabuSearchForBestSolution tsfbs = new TabuSearchForBestSolution();
		tsfbs.tabuSearchII();
		tsfbs.globalBestSolution.showSolution();
		System.out.println(new ExcessTime(tsfbs.globalBestSolution).getExcessTime());
		Solution solution = ReachTime.caculateReachTime(tsfbs.globalBestSolution);
		List<Route> routes = solution.getRoutesSolution();
		List<Node> allNodeList = new LinkedList<>();
		for (Route route : routes) {
			List<Node> nodeList = route.getNodes();
//			Collections.sort(nodeList);
//			for (Node node : nodeList) {
////				if(node.getReachTime()<node.getBeginTime()||node.getReachTime()>node.getEndTime())
//				System.out.println(node.getNumber()+":\t"+node.getBeginTime()+"\t"+node.getEndTime()+"\t"+node.getReachTime());
//			}	
			allNodeList.addAll(nodeList);
		}
		Collections.sort(allNodeList);
		for (Node node : allNodeList) {
			if(node.getReachTime()<node.getBeginTime()||node.getReachTime()>node.getEndTime())
			System.out.println(node.getNumber()+":\t"+node.getBeginTime()+"\t"+node.getEndTime()+"\t"+node.getReachTime());
		}
	} 
}
