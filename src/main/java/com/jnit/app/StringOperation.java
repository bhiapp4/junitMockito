package com.jnit.app;

public class StringOperation {

	public boolean checkForRepeatedChars(String str){
		//if (str == null || str.trim().length() == 0){
			//return false;
		//}
		if(!this.checkIfNullOrEmpty(str)){
			char[]cArray = str.toCharArray();
			for (char c :cArray){
				if (str.indexOf(c) != str.lastIndexOf(c)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkIfNullOrEmpty(String str){
		if (str == null || str.trim().length() == 0){
			return true;
		}	
		return false;
		
	}
}
