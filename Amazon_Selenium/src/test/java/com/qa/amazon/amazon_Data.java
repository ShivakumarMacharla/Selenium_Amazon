package com.qa.amazon;

import org.testng.annotations.DataProvider;

public class amazon_Data {

	@DataProvider

	public String [] search_data() {

//		String[] data = {"mirror","iphone","shoes","books"};

		String[] data = {"ipnone","shoes","books","mirrors"};

		return data;

	}



}