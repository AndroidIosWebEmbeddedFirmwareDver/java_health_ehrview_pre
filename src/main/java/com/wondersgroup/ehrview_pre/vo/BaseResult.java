package com.wondersgroup.ehrview_pre.vo;

/**
 * WebService返回结果基类,定义所有返回码.
 */
public class BaseResult {
	// -- 返回代码定义 --//
	// 按项目的规则进行定义, 比如4xx代表客户端参数错误，5xx代表服务端业务错误等.
	public static final String SUCESS = "0";
	public static final String PARAMETER_ERROR = "400";

	public static final String SYSTEM_ERROR = "500";
	public static final String SYSTEM_ERROR_MESSAGE = "Runtime unknown internal error.";

	// -- WSResult基本属性 --//
	private String resultCode = SUCESS;
	
	private String resultDesc = "";

	/**
	 * 创建结果.
	 */
	public void setError(String resultCode, String resultDesc) {
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
	}

	/**
	 * 创建默认异常结果.
	 */
	public void setDefaultError() {
		setError(SYSTEM_ERROR, SYSTEM_ERROR_MESSAGE);
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
}
