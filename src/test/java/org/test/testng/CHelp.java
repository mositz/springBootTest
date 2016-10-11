package org.test.testng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.testng.annotations.Test;

public class CHelp {

	// 解析excel
	public static Object[] getObjArrByMap(Map<String, String> cExcMap) {

		Map<String, String> cPar = new HashMap<String, String>();
		Map<String, String> cDes = new HashMap<String, String>();
		Map<String, String> cPres = new HashMap<String, String>();

		CInfo ci = new CInfo();
		for (String key : cExcMap.keySet()) {
			if (key.indexOf("{$d}") == 0) {
				cDes.put(key.replace("{$d}", ""), cExcMap.get(key));
			} else if (key.indexOf("{$p}") == 0) {
				cPres.put(key.replace("{$p}", ""), cExcMap.get(key));
			} else {
				String strValue = cExcMap.get(key);
				if (!strValue.equals("")) {
					cPar.put(key, strValue);
				}
			}
		}
		ci.setCDesc(cDes);
		ci.setCPara(cPar);
		ci.setCPres(cPres);

		return new Object[] { ci };
	}

	/// 根据excel获取的list转换为 Object[][]
	public static Object[][] getObjArrByList(List<Map<String, String>> cExcList) {
		List<Map<String, String>> cExcuteList = getExcuteList(cExcList);
		Object[][] objArray = new Object[cExcuteList.size()][];
		for (int i = 0; i < cExcuteList.size(); i++) {
			objArray[i] = getObjArrByMap(cExcuteList.get(i));
		}
		return objArray;

	}
	
	/// 筛选出需要执行的用例
	private static List<Map<String, String>> getExcuteList(List<Map<String, String>> cExcList) {
		System.out.println(cExcList);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Map<String, String> m : cExcList) {
			// String str = m.get("{$d}isexcute").trim().toLowerCase();
			// if (str.equals("y")) {
			// list.add(m);
			// }

			String str = m.get("{$d}isexcute").trim().toLowerCase();
			System.out.println(str);
		
		}
		return list;
	}
	
}
