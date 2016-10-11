package org.test.testng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XmlUtil {

//	public static List getXmlComent(String fname) {

	public static void main(String[] args) {
		getXmlComent();
	}

	@Test
	public static List getXmlComent(){
//		public static void getXmlComent(){
		// 获取xml文件完全路径
		// String path=CommonFunction.getAbsolutionPath(fname);
		String path = "xmltest.xml";
		System.out.println("xml·path" + path);

		List contList = new ArrayList();
		// dom4j中读取xml文件的方法
		SAXReader saxR = new SAXReader();
		try {
			Document doc = saxR.read(path);
			// 存放顶结点
			Element eleroot = doc.getRootElement();
			// parMap，存放顶结点下一级结点
			Map sonMap = new HashMap();
			for (Iterator i = eleroot.elementIterator(); i.hasNext();) {
				// parMap中存放的结点的子结点
				Map parMap = new HashMap();
				Element elepar = (Element) i.next();
				for (Iterator j = elepar.elementIterator(); j.hasNext();) {
					Element eleSon = (Element) j.next();
//					System.out.println("++++++++++ eleson孩子的getName 和getText：：：：" + eleSon.getName() + "    " + eleSon.getText());
					sonMap.put(eleSon.getName(), eleSon.getText());
				}

				parMap.put(elepar.getName(), sonMap);
//				System.out.println("********，par父节点的getName：：：：" + elepar.getName());
				contList.add(parMap);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("嘿嘿嘿嘿嘿嘿+++++++++++"+contList);

		return contList;
	}

}
