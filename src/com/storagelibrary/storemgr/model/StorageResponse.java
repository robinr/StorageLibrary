package com.storagelibrary.storemgr.model;

import java.util.List;

public class StorageResponse {
	List<Storage> allfolders;
	Integer       size;
	String        Operationname;
	Boolean       result;
	public List<Storage> getAllfolders() {
		return allfolders;
	}
	public void setAllfolders(List<Storage> allfolders) {
		this.allfolders = allfolders;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getOperationname() {
		return Operationname;
	}
	public void setOperationname(String operationname) {
		Operationname = operationname;
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}

}
