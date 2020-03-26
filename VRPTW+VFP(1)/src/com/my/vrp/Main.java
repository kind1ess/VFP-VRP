package com.my.vrp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.my.vrp.param.Client.*;

import com.my.vrp.operator.*;
import com.my.vrp.param.AllNodes;
import com.my.vrp.param.Client;
import com.my.vrp.param.Depot;
import com.my.vrp.param.PenaltyFactor;
import com.my.vrp.task.SAForInitSolution;
import com.my.vrp.task.SAForInitSolutionII;
import com.my.vrp.task.TabuSearchForBestSolution;
import com.my.vrp.task.TabuSearchForFiledSolution;
import com.my.vrp.utils.DisMatrix;
import com.my.vrp.utils.Draw;

import static com.my.vrp.utils.DisMatrix.*;
import static com.my.vrp.param.Param.*;
/**
 * 程序入口
 * 算法步骤：
 * 首先用节约算法生成初始解
 * 生成初始解的过程需要调用装箱子程序判断能否装下
 * 节约算法第二阶段
 * 禁忌搜索第一阶段
 * 禁忌搜索第二阶段
 * @author dell
 *
 */
@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		long begintime = System.nanoTime();
			TabuSearchForBestSolution tabuSearchForBestSolution = new TabuSearchForBestSolution();
			if(tabuSearchForBestSolution.tabuSearchII()) {
				System.out.println("++++++++++最优解++++++++++");
				tabuSearchForBestSolution.getGlobalBestSolution().showSolution();
				Draw.draw();
			}
		
			
		long endtime = System.nanoTime();
		double usedTime= (endtime - begintime)/(1e9);
		System.out.println();
		System.out.println("程序耗时："+usedTime+"s");
	}
}
