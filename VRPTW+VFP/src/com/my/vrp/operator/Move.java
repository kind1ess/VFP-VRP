package com.my.vrp.operator;

import com.my.vrp.Solution;
/**
 * 解的移动类<br/>
 * 有三个子类：<br/>
 * 1、TwoSwap：交换一条路径上的两个客户<br/>
 * 2、MoveClient：将一个路径的一个客户随机插到另一条路径<br/>
 * 3、CrossOver：交换两个路径的前缀<br/>
 * solution是变换之后的领域解<br/>
 * movePattern是变换所进行的操作涉及的关键客户或者路径<br/>
 * 三个子类分别实现领域变换的方法
 * @author dell
 *
 */
@SuppressWarnings("rawtypes")
public abstract class Move implements Comparable{
	private String name;
	private Solution solution;
	private int[] movePattern = new int[2];
	public Solution getSolution() {
		return solution;
	}
	public int[] getMovePattern() {
		return movePattern;
	}
	
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public void setMovePattern(int[] movePattern) {
		this.movePattern = movePattern;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param solution需要进行移动的解
	 */
	public abstract void fieldTransformation(Solution solution);
}
