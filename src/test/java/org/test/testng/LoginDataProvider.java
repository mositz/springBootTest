package org.test.testng;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	private static Object[][] obj;
	private static List parList = new ArrayList();
	private static List sonList = new ArrayList();

	 @DataProvider(name="loginProvider")
//	@DataProvider()
	public static Object[][] loginProvider(Method method) {
//		System.out.println("@DataProvider(name='loginProvider')");
//		System.out.println("dataProvider" + method.getName());
		// 读取xml内容
		// parList = XmlUtil.getXmlComent(FilePath.LoginTestData);

		parList = XmlUtil.getXmlComent();
		System.out.println(parList);

		for (int i = 0; i < parList.size(); i++) {
			Map map = (Map) parList.get(i);
			
//			System.out.println("parList的长度为哈哈哈哈哈好："+parList.get(i));
			System.out.println("parList的0为哈哈哈哈哈好："+parList.get(0));
			System.out.println("parList的1为哈哈哈哈哈好："+parList.get(1));
			System.out.println("parList的2为哈哈哈哈哈好："+parList.get(2));
//			if (map.containsKey(method.getName())) {
//				Map<String, String> submap = (Map<String, String>) map.get(method.getName());
//				System.out.println("submap的值，值，值为为为为为："+submap);
//				sonList.add(submap);
//
//			}
		}
//		System.out.println("lallalllllll d ,parList"+parList);
//		System.out.println("lallalllllll d ,parList的size"+parList.size());

		if (sonList.size() > 0) {

			obj = new Object[sonList.size()][];
			for (int i = 0; i < sonList.size(); i++) {
				obj[i] = new Object[] { sonList.get(i) };
			}
			return obj;
		} else {
			
//			Assert.assertTrue(sonList.size() != 0, parList + "为空，找不到属性值：" + method.getName());
			
			System.out.println("sonList的长度为："+sonList.size());
			return null;
		}
		

	}

}
