package com.hahacs.dotest;

import java.math.BigDecimal;

public class Test3 {
	public static void main(String[] args){
		BigDecimal amount = new BigDecimal(41746495.89);
		BigDecimal freezAmount = new BigDecimal(2061240.00);
		
//		amount = amount.divide(new BigDecimal(10000.00));
		System.out.println(amount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP));
		
		
	}
}
