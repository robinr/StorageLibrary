package com.storagelibrary.storemgr.rest.services.impl;

import com.storagelibrary.storemgr.dao.FolderManagerDao;
import com.storagelibrary.storemgr.model.OperationResponse;
import com.storagelibrary.storemgr.model.StorageResponse;
import com.storagelibrary.storemgr.rest.services.StorageManager;

public class StorageManagerServices implements StorageManager {

	FolderManagerDao    store;
	
	public FolderManagerDao getStore() {
		return store;
	}

	public void setStore(FolderManagerDao store) {
		this.store = store;
	}

	@Override
	public StorageResponse CreateMediaFolder(String folder) {
		// TODO Auto-generated method stub
		return (getStore().CreateMediaFolder(folder));
	}

	@Override
	public OperationResponse GetStorageSize() {
		// TODO Auto-generated method stub
		return (getStore().GetStorageSize());
	}

	@Override
	public OperationResponse BackupStorage(String folder) {
		// function is just stubbed to be implemented later.
		return null;
	}

}
