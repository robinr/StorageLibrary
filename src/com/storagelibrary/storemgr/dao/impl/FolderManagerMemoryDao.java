package com.storagelibrary.storemgr.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.storagelibrary.storemgr.dao.FolderManagerDao;
import com.storagelibrary.storemgr.model.FolderAttributes;
import com.storagelibrary.storemgr.model.OperationResponse;
import com.storagelibrary.storemgr.model.Storage;
import com.storagelibrary.storemgr.model.StorageResponse;

public class FolderManagerMemoryDao implements FolderManagerDao {
	
	static  List<File>  allfiles;
	List<Storage> allstorage = new ArrayList<Storage>();
	StorageResponse response = new StorageResponse();
	
	public static List<File> listf(String directoryName)
	{
		File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        return resultList;

	}
	
	
	public FolderManagerMemoryDao()
	{
        String directoryName = new String("M:");
        allfiles = listf(directoryName);	
        FolderAttributes attributes = new FolderAttributes();
		Integer count = 1;
		
		//System.out.println("\n\n\n\n\n");
		for(File fl :allfiles)
		{
			String[] names;
			Storage  folder = new Storage();
			//System.out.println("Id"+count);
			folder.setId(count);
		    //System.out.println("Name :"+fl.toString());
		    folder.setFolder(fl.getAbsolutePath());
		    //System.out.println("Size :"+fl.length());
		    folder.setTotalsize(fl.length());
		    names = fl.list();
		    if(names != null)
		    {	
		    	/*for(String name : names)
		    	{
		    		System.out.println("Filenames"+name);
		    	}*/
		    	folder.setFilenames(names);
		    }
		    if(fl.canRead() == true)
		    {
		    	if(fl.canWrite() == true)
		    	{
		    		if(fl.canExecute() == true)
		    		{
		    			//System.out.println("READ_WRITE_EXECUTE");
		    			folder.setOption(attributes.getOption3());
		    		}
		    		else
		    		{
		    			//System.out.println("READ_WRITE");
		    			folder.setOption(attributes.getOption2());
		    		}
		    	}
		    	else
		    	{
		    		//System.out.println("READ");
		    		folder.setOption(attributes.getOption1());
		    	}
		    }
		    /*System.out.println(fl.getAbsolutePath());
		    System.out.println("\n");*/
		    count = count + 1;
		    allstorage.add(folder);
		}
        
	}


	@Override
	public StorageResponse CreateMediaFolder(String mediafolder) {
		// TODO Auto-generated method stub
		String directoryName = new String("M:/");
		String targetString = directoryName.concat(mediafolder);
		Boolean   temp = new File(targetString).mkdirs();
		
		
		Storage  folder = new Storage();
		folder.setFilenames(null);
		folder.setFolder(targetString);
		folder.setOption("READ_WRITE");
		folder.setTotalsize(0);
		folder.setId(allstorage.size() + 2);
		
		allstorage.add(folder);
		response.setAllfolders(allstorage);
		response.setOperationname("CreateMediaFolder");
		response.setResult(true);
		response.setSize(0);
		return response;
	}


	@Override
	public OperationResponse GetStorageSize() {
		long totalsize = 0;
		OperationResponse opsresponse = new OperationResponse();
		
		for(Storage store : allstorage)
		{
			totalsize = totalsize + store.getTotalsize();
		}
		opsresponse.setOperation("GetStorageSize");	
		opsresponse.setSize(totalsize);
		opsresponse.setResult(true);
		return opsresponse;
	}


	@Override
	public OperationResponse BackupStorage(String folder) {
		long totalsize = 0;
		OperationResponse opsresponse = new OperationResponse();
		
		opsresponse.setOperation("BackupStorage");	
		opsresponse.setSize(totalsize);
		opsresponse.setResult(true);
		return opsresponse;
		
	}

}
