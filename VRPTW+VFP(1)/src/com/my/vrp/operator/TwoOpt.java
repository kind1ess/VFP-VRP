package com.my.vrp.operator;

import java.util.Random;

import com.my.vrp.Node;
import com.my.vrp.Solution;
import static com.my.vrp.utils.DistanceSolution.caculateDistanceSolution;

public class TwoOpt extends Move{

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
		}while(x==y||(x==1&&y==solution.getRoutesSolution().get(a).getNodes().size()-2)
				||(y==1&&x==solution.getRoutesSolution().get(a).getNodes().size()-2));
		int i = solution.getRoutesSolution().get(a).getNodes().get(x).getNumber();
		int j = solution.getRoutesSolution().get(a).getNodes().get(y).getNumber();
		int z=(x>y)? x-y:y-x;
		if(x<y) {
			for(int p=0;p<=z/2;p++) {
				Node temp = null;
				try {
					temp = (Node) solution.getRoutesSolution().get(a).getNodes().get(x+p).clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					solution.getRoutesSolution().get(a).getNodes().
					set(x+p, (Node) solution.getRoutesSolution().get(a).getNodes().get(y-p).clone());
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				solution.getRoutesSolution().get(a).getNodes().set(y-p, temp);
			}	
		}
		else {
			for(int p=0;p<=z/2;p++) {
				Node temp = null;
				try {
					temp = (Node) solution.getRoutesSolution().get(a).getNodes().get(y+p).clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					solution.getRoutesSolution().get(a).getNodes().
					set(y+p, (Node) solution.getRoutesSolution().get(a).getNodes().get(x-p).clone());
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				solution.getRoutesSolution().get(a).getNodes().set(x-p, temp);
			}
		}
		solution.setDistanceSolution(caculateDistanceSolution(solution));
		this.setSolution(solution);
		int[] movePattern = new int[] {i,j};
		this.setMovePattern(movePattern);
		this.setName("twoOpt");
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
