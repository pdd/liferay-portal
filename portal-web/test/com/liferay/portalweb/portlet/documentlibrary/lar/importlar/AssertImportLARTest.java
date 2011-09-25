/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.documentlibrary.lar.importlar;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertImportLARTest extends BaseTestCase {
	public void testAssertImportLAR() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=Documents and Media Library Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Documents and Media Library Test Page",
			RuntimeVariables.replace("Documents and Media Library Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder1 Name"),
			selenium.getText("xPath=(//span[@class='document-title'])[1]"));
		assertEquals(RuntimeVariables.replace("DML Folder2 Name Edit"),
			selenium.getText("xPath=(//span[@class='document-title'])[2]"));
		selenium.clickAt("xPath=(//span[@class='document-title'])[1]",
			RuntimeVariables.replace("DML Folder1 Name"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DML Folder1 Name")
										.equals(selenium.getText(
								"//li[@class='folder selected']/a[2]"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder1 Name"),
			selenium.getText("//li[@class='folder selected']/a[2]"));
		assertEquals(RuntimeVariables.replace("DML Folder1 Subfolder Name"),
			selenium.getText("//span[@class='document-title']"));
		selenium.clickAt("//span[@class='document-title']",
			RuntimeVariables.replace("DML Folder1 Subfolder Name"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DML Folder1 Subfolder Name")
										.equals(selenium.getText(
								"//li[@class='folder selected']/a"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder1 Subfolder Name"),
			selenium.getText("//li[@class='folder selected']/a"));
		assertEquals(RuntimeVariables.replace(
				"DML Folder1 Subfolder Document Title Edit"),
			selenium.getText("//span[@class='document-title']"));
		selenium.clickAt("//span[@class='document-title']",
			RuntimeVariables.replace(
				"DML Folder1 Subfolder Document Title Edit"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"DML Folder1 Subfolder Document Title Edit"),
			selenium.getText("//h2[@class='document-title']"));
		assertEquals(RuntimeVariables.replace(
				"DML Folder1 Subfolder Document Description Edit"),
			selenium.getText("//span[@class='document-description']"));
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=Documents and Media Library Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Documents and Media Library Test Page",
			RuntimeVariables.replace("Documents and Media Library Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder2 Name Edit"),
			selenium.getText("xPath=(//span[@class='document-title'])[2]"));
		selenium.clickAt("xPath=(//span[@class='document-title'])[2]",
			RuntimeVariables.replace("DML Folder2 Name Edit"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DML Folder2 Name Edit")
										.equals(selenium.getText(
								"//li[@class='folder selected']/a[2]"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("DML Folder2 Name Edit"),
			selenium.getText("//li[@class='folder selected']/a[2]"));
		assertEquals(RuntimeVariables.replace("DML Folder2 Subfolder Name Edit"),
			selenium.getText("//span[@class='document-title']"));
	}
}