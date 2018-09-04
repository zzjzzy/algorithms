package com.itheima.demo;

/**
 * 题目要求：给定个字符串，只含有C和D，将所有的C和D移动到一边，计算移动所需要的最少步数。
 * 
 * 思路：遍历String找到每个D的位置，以及D前面有多少C，D前面有多少个C，就要移动多少步。
 * 先假设所有D都是向左移的，所有D向右移和向左移的总和等于C个数*D个数，判断左移和右移哪个步数少就是哪个。
 * @author zzj
 *
 */

public class MoveCD {

	public static void main(String[] args) {
		
		String CDs = "DCCDCCDDDCDCCCC";
		
		//previous记录前一个D的index，和当前相减，得到中间C的个数。
		//previous要初始化为-1，不然第一个D的interval计算不对。
		int previous = -1;  
		int internal = 0;  //记录两个D中间C的个数。
		int CCountBeforeD = 0;  //遍历到的当前D前面C的个数。
		int CCount = 0;  //C的个数计数。
		int DCount = 0;  //D的个数计数。
		int sumStep = 0;   //所有D移动所需要的步数。
		
		for (int i = 0; i < CDs.length(); i++) {
			if (CDs.charAt(i)=='D') {
				DCount++;
				internal = i - previous - 1;
				previous = i;
				CCountBeforeD = CCountBeforeD + internal;
				sumStep = sumStep + CCountBeforeD;
			}else{
				CCount++;
			}
		}
		
		//sumStep计算的是D向左移的情况
		//CCount*DCount - sumStep计算D向右移，哪个小就是哪个。
		int result = Math.min(sumStep, CCount*DCount - sumStep);
		
		System.out.println(result);
	}
}
