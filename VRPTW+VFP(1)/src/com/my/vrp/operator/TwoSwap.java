package com.my.vrp.operator;

import java.util.Collections;
import java.util.Random;

import com.my.vrp.Solution;

import static com.my.vrp.utils.DistanceSolution.caculateDistanceSolution;
public class TwoSwap extends Move{

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
		int a;
		Random random = new Random();
		do {
			a = random.nextInt(solution.getRoutesSolution().size());
		}while(solution.getRoutesSolution().get(a).getNodes().size()-2<3);
		int x;
		int y;
		do {
			x = random.nextInt(solution.getRoutesSolution().get(a).getNodes().size()-2)+1;
			y = random.nextInt(solution.getRoutesSolution().get(a).getNodes().size()-2)+1;
		}while(x==y);
		int i = solution.getRoutesSolution().get(a).getNodes().get(x).getNumber();//客户x的编号
		int j = solution.getRoutesSolution().get(a).getNodes().get(y).getNumber();//客户y的编号
		Collections.swap(solution.getRoutesSolution().get(a).getNodes(), x, y);
		solution.setDistanceSolution(caculateDistanceSolution(solution));
		this.setSolution(solution);
		int[] movePattern= new int[] {i,j};
		this.setMovePattern(movePattern);
		this.setName("twoSwap");
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
