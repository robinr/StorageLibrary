package com.storagelibrary.storemgr.dao;

import com.storagelibrary.storemgr.model.OperationResponse;
import com.storagelibrary.storemgr.model.StorageResponse;

public interface FolderManagerDao {
	
	public StorageResponse CreateMediaFolder(String mediafolder);
	
	public OperationResponse GetStorageSize();
	
	public OperationResponse BackupStorage(String folder);

}
