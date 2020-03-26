package com.my.vrp.task; 

import com.my.vrp.Solution;
import com.my.vrp.operator.CrossOver;
import com.my.vrp.operator.Move;
import com.my.vrp.operator.MoveClient;
import com.my.vrp.operator.TwoSwap;

import static com.my.vrp.param.Param.*;
import static com.my.vrp.utils.FeasibleJudge.feasibleJudge;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 禁忌搜索算法第一阶段
 * @author dell
 *
 */
public class TabuSearchForFiledSolution {

	private Solution solution;
	public Solution getSolution() {
		return solution;
	}
	@SuppressWarnings("unchecked")
	public boolean tabuSearch() {
		SAForInitSolutionII saForInitSolutionII = new SAForInitSolutionII();
		saForInitSolutionII.savingAlgorithm();
		System.out.println("++++++++++Initial Solution+++++++++");
		saForInitSolutionII.getIniSolution().showSolution();
		Solution initSolution =null ;//设置初始解
		try {
			initSolution = (Solution)saForInitSolutionII.getIniSolution().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[][] tabuClient = new int[CLIENT_NUM1][CLIENT_NUM1];//客户禁忌表，用于存放变换的操作的关键客户
		int[][] tabuRoute = new int[CLIENT_NUM1][initSolution.getRoutesSolution().size()];//路径禁忌表，用于存放变换操作的关键客户和路径
		int tabuLength = 30;//禁忌长度
		int maxIter = 5000;
		int iter=1;//当前迭代次数
		int solutionSpace = 100;//解空间大小
		Solution incumbentSolution = null;//设置当前解
		try {
			incumbentSolution = (Solution)initSolution.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Solution bestSolution =null;//当前全局最优解为当前解
		try {
			bestSolution  = (Solution)incumbentSolution.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean feasible=false;
		while(iter<maxIter) {
			feasible = feasibleJudge(incumbentSolution);
			
			if(feasible)
				break;
		
			ArrayList<Move> moves = new ArrayList<Move>();
			int i=0;
			while(i<solutionSpace) {
				double p = Math.random();
					if(p<=0.167) {
						Move twoSwap = new TwoSwap();
						twoSwap.fieldTransformation(incumbentSolution);
						moves.add(twoSwap);
					}
					else if(p>0.167&&p<=0.5) {
						Move moveClient = new MoveClient();
						moveClient.fieldTransformation(incumbentSolution);
						moves.add(moveClient);
					}
					else {
						Move crossOver = new CrossOver();
						crossOver.fieldTransformation(incumbentSolution);
						moves.add(crossOver);
					}
						
				i++;
			}
			Collections.sort(moves);
			Move bestMove = moves.get(0);
			int[] temp = bestMove.getMovePattern();
			String name = bestMove.getName();
			if(name=="crossOver"||name=="twoSwap") {
				int i1=temp[0]-1;
				int j1=temp[1]-1;
				if(iter-tabuClient[i1][j1]>tabuLength||tabuClient[i1][j1]==0
						||feasibleJudge(bestMove.getSolution())||bestMove.getSolution().getDistanceSolution()
						<bestSolution.getDistanceSolution()){
					try {
						incumbentSolution = (Solution) bestMove.getSolution().clone();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tabuClient[i1][j1]=iter;
				}
			}
			else {
				int p1=temp[0]-1;
				int j1=temp[1];
				if(iter-tabuRoute[p1][j1]>tabuLength||tabuRoute[p1][j1]==0
						||feasibleJudge(bestMove.getSolution())||bestMove.getSolution().getDistanceSolution()
						<bestSolution.getDistanceSolution()) {
					try {
						incumbentSolution = (Solution) bestMove.getSolution().clone();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tabuRoute[p1][j1]=iter;
				}
			}
			if(incumbentSolution.getDistanceSolution()<bestSolution.getDistanceSolution())
				try {
					bestSolution = (Solution) incumbentSolution.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			iter++;
		}
		if(feasible) {
			//bestSolution.setDistanceSolution(caculateDistanceSolutionII(bestSolution));
			try {
				this.solution = (Solution) bestSolution.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			System.out.println("No Feasible Solution");
		return feasible;
	}
}
