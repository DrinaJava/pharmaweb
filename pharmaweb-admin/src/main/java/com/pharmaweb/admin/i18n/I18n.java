package com.pharmaweb.admin.i18n;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;

public class I18n {
	
	public static String INVALID_LOGIN = "login.invalid";
	
	public static String MEDICINE_CREATE_SUCCESS = "medicine.create.success";
	public static String MEDICINE_CREATE_ERROR = "medicine.create.error";
	public static String MEDICINE_EDIT_SUCCESS = "medicine.edit.success";
	public static String MEDICINE_EDIT_ERROR = "medicine.edit.error";
	public static String MEDICINE_DELETE_SUCCESS = "medicine.delete.success";
	public static String MEDICINE_DELETE_ERROR = "medicine.delete.error";
	
	
	public static String _(String key){
		
		
		String value;
		
		try {
			Ini ini = new Ini(new File("fr.ini"));
			
			value = ini.get("All",key);
			
			
		} catch(IOException e) {
			value = "String not found";
		}
		
		return value;
	}
}
