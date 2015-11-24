package com.storagelibrary.storemgr.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.storagelibrary.storemgr.model.OperationResponse;
import com.storagelibrary.storemgr.model.StorageResponse;

public interface StorageManager {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/CreateMediaFolder/{folder}")
	public StorageResponse CreateMediaFolder(@PathParam("folder")String folder);
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/GetStorageSize/")
	public OperationResponse GetStorageSize();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/BackupStorage/")
	public OperationResponse BackupStorage(String folder);
}
