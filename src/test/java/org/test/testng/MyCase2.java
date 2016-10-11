package org.test.testng;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyCase2 {
	protected  static String cExcPath = "/Users/zhangxingxing/Desktop/testaaa.xlsx";
	
	@DataProvider(name = "dataInfo")
	protected Object[][] dataInfo() throws IOException {

		Object[][] myObj = null;
		List<Map<String, String>> list = ReExcel.readXlsx(cExcPath);
		myObj = CHelp.getObjArrByList(list);
		return myObj;
	}

	public static void main(String[] args) throws IOException {
		Object[][] myObj = null;
		List<Map<String, String>> list = ReExcel.readXlsx(cExcPath);
		myObj = CHelp.getObjArrByList(list);

		System.out.println(myObj);
	}


	@Test(dataProvider = "dataInfo")
	public void testByExcel_Body(CInfo c) throws IOException {
//		/// 获取用例说明
		System.out.println(c.getCDesc());
//		/// 获取用例需要的参数
//		System.out.println(c.getCaseParam());
//		// 获取执行用例需要的前置条件
//		System.out.println(c.getCasePreset());
//		System.out.println(System.getProperty("user.dir") );
	}

}
