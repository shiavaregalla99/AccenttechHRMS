package com.accenttech.hrms.base;

import com.accenttech.hrms.pages.LoginPage;

public class PageIntializer extends BaseClass {

	public static LoginPage login;
	
	public static void intialize() {
		login = new LoginPage();
	}
}
