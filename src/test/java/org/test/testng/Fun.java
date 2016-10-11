package org.test.testng;

import org.testng.annotations.Test;

public class Fun {

	private int m_numTi;

	public Fun(int num2) {

		this.m_numTi = num2;

	}

	private static int num;

	@Test
	public void testServer() {
		num++;
		System.out.println("num    " + num + "  m_numTi ：" + m_numTi);
	}

}
