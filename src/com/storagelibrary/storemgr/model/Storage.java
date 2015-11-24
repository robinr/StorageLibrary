package com.storagelibrary.storemgr.model;


public class Storage {
		Integer       id;
		String[]      filenames;
		long          totalsize;
		String        folder;
        String        option;
        
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String[] getFilenames() {
			return filenames;
		}
		public void setFilenames(String[] filenames) {
			this.filenames = filenames;
		}
		public long getTotalsize() {
			return totalsize;
		}
		public void setTotalsize(long totalsize) {
			this.totalsize = totalsize;
		}
		public String getFolder() {
			return folder;
		}
		public void setFolder(String folder) {
			this.folder = folder;
		}
		public String getOption() {
			return option;
		}
		public void setOption(String option) {
			this.option = option;
		}
}
