package com.my.vrp.operator;


import java.util.Random;


import com.my.vrp.Solution;

import static com.my.vrp.utils.DistanceSolution.caculateDistanceSolution;
public class MoveClient extends Move{

	@Override
	public void fieldTransformation(Solution solution1) {
		// TODO Auto-generated method stub
		Solution solution = null;
		try {
			solution = (Solution)solution1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random random = new Random();
		int a;
		int j;
		do {
			a = random.nextInt(solution.getRoutesSolution().size());
			j = random.nextInt(solution.getRoutesSolution().size());
		}while(solution.getRoutesSolution().get(a).getNodes().size()==3||a==j);
		int x = random.nextInt(solution.getRoutesSolution().get(a).getNodes().size()-2)+1;
		int y = random.nextInt(solution.getRoutesSolution().get(j).getNodes().size()-2)+1;
		int i = solution.getRoutesSolution().get(a).getNodes().get(x).getNumber();
		solution.getRoutesSolution().get(j).getNodes().add(y, solution.getRoutesSolution().get(a).getNodes().get(x));//把a路径的结点插入到j路径
		solution.getRoutesSolution().get(a).getNodes().remove(x);
		solution.setDistanceSolution(caculateDistanceSolution(solution));
		this.setSolution(solution);
		//可复用代码标记，今后试图封装为方法
		int[] movePattern= new int[] {i,j};//i是a路径取下来要插入j路径的结点
		this.setMovePattern(movePattern);
		this.setSolution(solution);
		this.setName("moveClient");
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
