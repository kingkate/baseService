package com.baseService.baseTools.autotest.params;

public class UseCase {
	
	private String caseName;
	private String group;
	private int caseId;
	private PreData preData; 
	private CaseResult caseResult;
	
	
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	public PreData getPreData() {
		return preData;
	}
	public void setPreData(PreData preData) {
		this.preData = preData;
	}
	public CaseResult getCaseResult() {
		return caseResult;
	}
	public void setCaseResult(CaseResult caseResult) {
		this.caseResult = caseResult;
	}
}
