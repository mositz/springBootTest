package org.test.testng;

import java.util.Map;

public class CInfo {

	private Map<String, String> cPara;
	// 用例说明 在excel中以{$d}开头
	private Map<String, String> cDesc;
	// 用例预置条件 在excel中以{$p}开头
	private Map<String, String> cPres;

	public Map<String, String> getCPara() {
		return cPara;
	}

	public void setCPara(Map<String, String> cPara) {
		this.cPara = cPara;
	}

	public Map<String, String> getCDesc() {
		return cDesc;
	}

	public void setCDesc(Map<String, String> cDesc) {
		this.cDesc = cDesc;
	}

	public Map<String, String> getCPres() {
		return cPres;
	}

	public void setCPres(Map<String, String> cPres) {
		this.cPres = cPres;
	}

}
