package org.test.testng;

import org.test.testng.Fun;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class Datasource {

	@DataProvider(name = "ds")
	public Object[][] dataSource(){

		Object[][] obj = new Object[][] {new Object[]{1},new Object[]{2}};
		return obj;
	}

	@Factory(dataProvider = "ds")
	public Object[] factory(int a){

		System.out.println(a);
		Object[] result = new Object[a];
		for (int i = 0; i < a; i++) {
			result[i] = new Fun(i * 10);
		}

		return result;
	}

//	@Test
//	public static void main(String args[]){
//
//		Object[] obj = new Object[] {1,2};
//		for(int i = 0; i < obj.length ; i++){
//			System.out.println(obj[i]);
//		}
//	}

}
