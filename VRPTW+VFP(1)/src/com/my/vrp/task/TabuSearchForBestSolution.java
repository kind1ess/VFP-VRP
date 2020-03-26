package com.my.vrp.task; 

import com.my.vrp.Solution;
import com.my.vrp.operator.CrossOver;
import com.my.vrp.operator.Move;
import com.my.vrp.operator.MoveClient;
import com.my.vrp.operator.TwoOpt;
import com.my.vrp.operator.TwoSwap;
import static com.my.vrp.utils.FeasibleJudge.feasibleJudge;

import java.util.ArrayList;
import java.util.Collections;

import static com.my.vrp.param.Param.*;
/**
 * 禁忌搜索算法第二阶段
 * @author dell
 *
 */
public class TabuSearchForBestSolution {

	private Solution globalBestSolution;

	public Solution getGlobalBestSolution() {
		return globalBestSolution;
	}
	@SuppressWarnings("unchecked")
	public boolean tabuSearchII() {
		TabuSearchForFiledSolution tabuSearchForFiledSolution = new TabuSearchForFiledSolution();
		if(tabuSearchForFiledSolution.tabuSearch()) {
			System.out.println("++++++++++禁忌搜索第一阶段可行解+++++++++");
			tabuSearchForFiledSolution.getSolution().showSolution();
			Solution incumbentSolution = null;
			try {
				incumbentSolution = (Solution) tabuSearchForFiledSolution.getSolution().clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Solution bestSolution = null;
			try {
				bestSolution = (Solution) incumbentSolution.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int[][] tabuClient = new int[CLIENT_NUM1][CLIENT_NUM1];//客户禁忌表，用于存放变换的操作的关键客户
			int[][] tabuRoute = new int[CLIENT_NUM1][incumbentSolution.getRoutesSolution().size()];//路径禁忌表，用于存放变换操作的关键客户和路径
			int tabuLength = 225;//禁忌长度
			int solutionSpace = 285;
			ArrayList<Double> bestDistance = new ArrayList<Double>();
			ArrayList<Double> incumbentDistance = new ArrayList<Double>();
			int iter = 0;//当前迭代次数
			while(iter<MAX_ITER) {
				ArrayList<Move> moves = new ArrayList<Move>();
				int i =0;
				while(i<solutionSpace) {
					double p = Math.random();
					if(p>0.097&&p<=0.248) {
						Move twoSwap = new TwoSwap();
						twoSwap.fieldTransformation(incumbentSolution);
						int[] temp = twoSwap.getMovePattern();
						int i1 = temp[0]-1;
						int j1 = temp[1]-1;
						if(tabuClient[i1][j1]==0||iter-tabuClient[i1][j1]>tabuLength||twoSwap.getSolution().getDistanceSolution()<bestSolution.getDistanceSolution())
							moves.add(twoSwap);
					}
					else if(p>0.248&&p<=0.549) {
						Move moveClient = new MoveClient();
						moveClient.fieldTransformation(incumbentSolution);
						int[] temp = moveClient.getMovePattern();
						int p1 = temp[0]-1;
						int j1 = temp[1];
						if(tabuRoute[p1][j1]==0||tabuRoute[p1][j1]-iter>tabuLength||moveClient.getSolution().getDistanceSolution()<bestSolution.getDistanceSolution())
							moves.add(moveClient);
					}
					else if(p>0.549) {
						Move crossOver = new CrossOver();
						crossOver.fieldTransformation(incumbentSolution);
						int[] temp = crossOver.getMovePattern();
						int p1 = temp[0]-1;
						int j1 = temp[1]-1;
						if(tabuClient[p1][j1]==0||tabuClient[p1][j1]-iter>tabuLength||crossOver.getSolution().getDistanceSolution()<bestSolution.getDistanceSolution())
							moves.add(crossOver);
					}
					else {
						Move twoOpt = new TwoOpt();
						twoOpt.fieldTransformation(incumbentSolution);
						int[] temp = twoOpt.getMovePattern();
						int p1 = temp[0]-1;
						int j1 = temp[1]-1;
						if(tabuClient[p1][j1]==0||tabuClient[p1][j1]-iter>tabuLength||twoOpt.getSolution().getDistanceSolution()<bestSolution.getDistanceSolution())
							moves.add(twoOpt);
					}
					i++;
				}
				Collections.sort(moves);
				if(moves.size()!=0) {
					Move bestMove = moves.get(0);
					if(feasibleJudge(bestMove.getSolution())) {
						String name = bestMove.getName();
						int[] temp = bestMove.getMovePattern();
						if(name=="twoOpt"||name=="twoSwap"||name=="crossOver") {
							int i1 = temp[0]-1;
							int j1 = temp[1]-1;
							try {
								incumbentSolution = (Solution) bestMove.getSolution().clone();
							} catch (CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							tabuClient[i1][j1]=iter;

						}
						else {
							int p1 = temp[0]-1;
							int j1 = temp[1];
								try {
									incumbentSolution = (Solution) bestMove.getSolution().clone();
								} catch (CloneNotSupportedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tabuRoute[p1][j1]=iter;
						}
					}
				}
				incumbentDistance.add(incumbentSolution.getDistanceSolution());
				if(incumbentSolution.getDistanceSolution()<bestSolution.getDistanceSolution()) {
					try {
						bestSolution = (Solution) incumbentSolution.clone();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				bestDistance.add(bestSolution.getDistanceSolution());
				iter++;
			}
			this.globalBestSolution = bestSolution;
			return true;
		}
		else {
			System.out.println("未找到可行解");
			return false;
		}
	}
}
