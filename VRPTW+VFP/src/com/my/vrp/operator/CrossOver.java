package com.my.vrp.operator;



import java.util.LinkedList;
import java.util.Random;

import com.my.vrp.Node;
import com.my.vrp.Solution;
import static com.my.vrp.utils.DistanceSolution.caculateDistanceSolution;
public class CrossOver extends Move{

	@Override
	public void fieldTransformation(Solution solution1) {
		// TODO Auto-generated method stub
		//随机选择路径i,j
		Solution solution = null;
		try {
			solution = (Solution)solution1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random random = new Random();
		int i,j;
		do {
			i = random.nextInt(solution.getRoutesSolution().size());
			j = random.nextInt(solution.getRoutesSolution().size());
		}while(i==j);
		//随即在两条路径选择客户点
		int a,b;
		a = random.nextInt(solution.getRoutesSolution().get(i).getNodes().size()-2)+1;
		b = random.nextInt(solution.getRoutesSolution().get(j).getNodes().size()-2)+1;
		int a1 = solution.getRoutesSolution().get(i).getNodes().get(a).getNumber();
		int b1 = solution.getRoutesSolution().get(j).getNodes().get(b).getNumber();
		LinkedList<Node> nodesi1 = new LinkedList<Node>();
		for(int p=0;p<=a;p++) {
			nodesi1.add(solution.getRoutesSolution().get(i).getNodes().get(p));
		}
		LinkedList<Node> nodesi2 = new LinkedList<Node>();
		for(int p=a+1;p<solution.getRoutesSolution().get(i).getNodes().size();p++) {
			nodesi2.add(solution.getRoutesSolution().get(i).getNodes().get(p));
		}
		LinkedList<Node> nodesj1 = new LinkedList<Node>();
		for(int p=0;p<=b;p++) {
			nodesj1.add(solution.getRoutesSolution().get(j).getNodes().get(p));
		}
		LinkedList<Node> nodesj2 = new LinkedList<Node>();
		for(int p=b+1;p<solution.getRoutesSolution().get(j).getNodes().size();p++) {
			nodesj2.add(solution.getRoutesSolution().get(j).getNodes().get(p));
		}
		nodesi1.addAll(nodesj2);
		nodesj1.addAll(nodesi2);
		solution.getRoutesSolution().get(i).setNodes(nodesi1);
		solution.getRoutesSolution().get(j).setNodes(nodesj1);
		solution.setDistanceSolution(caculateDistanceSolution(solution));
		this.setSolution(solution);
		this.setSolution(solution);
		int[] movePattern = new int[] {a1,b1};
		this.setMovePattern(movePattern);
		this.setName("crossOver");
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Move move = (Move) o;
		if(this.getSolution().getDistanceSolution()>move.getSolution().getDistanceSolution())
			return 1;
		else if(this.getSolution().getDistanceSolution()==move.getSolution().getDistanceSolution())
			return 0;
		else
			return -1;
	}
}
