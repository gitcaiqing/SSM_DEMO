package com.ssm.util;

/**
 * 返回结果对象
 * @author https://blog.csdn.net/caiqing116
 */
public class ResultModel {

	//返回值 0成功 1失败
	private Integer resultCode;
	//返回的数据
	private Object data;
	//返回的信息
	private String msg;
	public ResultModel(Integer resultCode, String msg) {
		super();
		this.resultCode = resultCode;
		this.msg = msg;
	}
	public ResultModel(Integer resultCode, Object data, String msg) {
		super();
		this.resultCode = resultCode;
		this.data = data;
		this.msg = msg;
	}
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
