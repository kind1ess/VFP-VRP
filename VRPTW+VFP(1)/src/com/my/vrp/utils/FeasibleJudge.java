package com.my.vrp.utils;


import java.util.LinkedList;

import com.my.vrp.Carriage;
import com.my.vrp.Node;
import com.my.vrp.Solution;
import static com.my.vrp.param.Param.*;
/**
 * 判断解是否可行
 * @author dell
 *
 */
public class FeasibleJudge {

	public static boolean feasibleJudge(Solution solution) {
		LoadConfirm loadConfirm = new LoadConfirm();
		int num=0;
		for(int i=0;i<solution.getRoutesSolution().size();i++) {
			LinkedList<Node> nodes = new LinkedList<Node>();
			for(int p=1;p<solution.getRoutesSolution().get(i).getNodes().size()-1;p++) {
				nodes.add(solution.getRoutesSolution().get(i).getNodes().get(p));
			}
			Carriage carriage = new Carriage();
			carriage.setLength(VEHICLE_LENGTH);
			if(loadConfirm.loadConfirm(nodes,carriage ))
				num++;
		}
		ExcessWeight excessWeight = new ExcessWeight(solution.getRoutesSolution());
		if(excessWeight.getExcessWeight()==0&&num==4)
			return true;
		return false;
		
	}
}
