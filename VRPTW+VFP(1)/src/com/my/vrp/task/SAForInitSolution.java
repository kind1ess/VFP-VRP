package com.my.vrp.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import com.my.vrp.Carriage;
import com.my.vrp.Node;
import com.my.vrp.Route;
import com.my.vrp.Solution;
import com.my.vrp.param.AllNodes;
import com.my.vrp.param.Client;
import com.my.vrp.param.Depot;
import com.my.vrp.param.L;
import com.my.vrp.param.PenaltyFactor;
import com.my.vrp.utils.DisMatrix;
import com.my.vrp.utils.ExcessLength;
import com.my.vrp.utils.ExcessWeight;
import com.my.vrp.utils.LoadConfirm;
import static com.my.vrp.param.Param.*;
import static com.my.vrp.utils.DistanceSolution.caculateDistanceSolution;
import static com.my.vrp.utils.CaculateDistance.caculateDistance;

/**
 * 节约算法第一阶段
 * @author dell
 *
 */
@SuppressWarnings("unused")
public class SAForInitSolution {
	private Solution initSolution = new Solution();
	public Solution getInitSolution() {
		return initSolution;
	}
	private DisMatrix disMatrix = new DisMatrix();
	private AllNodes allNodes = new AllNodes(); 
	private Client clients = new Client();
	private Depot depot = new Depot();
	@SuppressWarnings("unchecked")
	public ArrayList<L> caculateLSequence() {
		ArrayList<L> LSequence = new ArrayList<L>();
		double[][] Graph = disMatrix.getDisMatrix();
		for(int i=1;i<NODE_NUM;i++) {
			for(int j=1;j<NODE_NUM;j++) {
				if(i!=j) {
					L l = new L();
					l.setI(i-1);
					l.setJ(j-1);
					double sij = Graph[0][i]+Graph[0][j]-Graph[i][j];
					l.setSij(sij);
					LSequence.add(l);
				}else continue;
			}
		}
		Collections.sort(LSequence);
		return LSequence;
	}
	public Solution initSolution() {
		Solution solution = new Solution();
		for(int i=0;i<CLIENT_NUM;i++) {
			Route route = new Route("Route"+i);
			LinkedList<Node> nodes = new LinkedList<Node>();
			nodes.add(depot.getDepot());
			nodes.add(clients.getClients().get(i));
			nodes.add(depot.getDepot());
			route.setNodes(nodes);
			solution.getRoutesSolution().add(route);
		}
		return solution;
	}
	public ArrayList<Carriage> initCarriages(){
		ArrayList<Carriage> carriages = new ArrayList<Carriage>();
		//初始化n辆车
		for(int i=0;i<CLIENT_NUM;i++) {
			carriages.add(new Carriage());
		}
		return carriages;
	}
	public Solution  savingAlgorithm(Solution solution1,ArrayList<Carriage> carriages1) {
		Solution solution = solution1; 
		ArrayList<Carriage> carriages = carriages1;
		ArrayList<L> LSequence = caculateLSequence();
		//这个嵌套循环我很无奈，不知道以后可不可以改一改
		for(int i=0;i<LSequence.size();i++) {
			if(solution.getRoutesSolution().size()<=VEHICLE_NUM)
				break;
			//System.out.println("i="+i);
			for(int j=0;j<solution.getRoutesSolution().size();j++) {
				//System.out.println("j="+j);
				if(clients.getClients().get(LSequence.get(i).getI()).getNumber()
						==solution.getRoutesSolution().get(j).getNodes()
						.get(solution.getRoutesSolution().get(j).getNodes().size()-2).getNumber()
						) {
					for(int k=0;k<solution.getRoutesSolution().size();k++) {
						if(clients.getClients().get(LSequence.get(i).getJ()).getNumber()
								==solution.getRoutesSolution().get(k).getNodes().get(1).getNumber()&&k!=j
								) {
							LinkedList<Node> temp1 = new LinkedList<Node>();
							LinkedList<Node> temp2 = new LinkedList<Node>();
							for(int p=1;p<solution.getRoutesSolution().get(j).getNodes().size()-1;p++) {
								temp1.add(solution.getRoutesSolution().get(j).getNodes().get(p));
							}
							for(int q=1;q<solution.getRoutesSolution().get(k).getNodes().size()-1;q++) {
								temp2.add(solution.getRoutesSolution().get(k).getNodes().get(q));
							}
							temp1.addAll(temp2);
							LoadConfirm loadConfirm = new LoadConfirm();
							if(loadConfirm.loadConfirm(temp1,carriages.get(j))) {
								solution.getRoutesSolution().get(j).getNodes().removeLast();
								solution.getRoutesSolution().get(k).getNodes().removeFirst();
								solution.getRoutesSolution().get(j).getNodes()
								.addAll(solution.getRoutesSolution().get(k).getNodes());
								solution.getRoutesSolution().remove(k);
								carriages.remove(k);
							}
							else continue;
						}
					}
				}
				
			}
		}
		solution.setDistanceSolution(caculateDistanceSolution(solution));
		this.initSolution = solution;
		return solution;
	}
}
