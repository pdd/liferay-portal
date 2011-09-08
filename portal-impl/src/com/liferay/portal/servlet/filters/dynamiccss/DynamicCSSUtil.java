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

package com.liferay.portal.servlet.filters.dynamiccss;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Theme;
import com.liferay.portal.scripting.ruby.RubyExecutor;
import com.liferay.portal.service.ThemeLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.ContentUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Raymond Augé
 * @author Sergio Sánchez
 */
public class DynamicCSSUtil {

	public static void init() {
		try {
			_rubyScript = ContentUtil.get(
				PortalClassLoaderUtil.getClassLoader(),
				"com/liferay/portal/servlet/filters/dynamiccss/main.rb");
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public static String parseSass(
			HttpServletRequest request, String cssRealPath, String content)
		throws ScriptingException {

		String cssThemePath = getCssThemePath(request);

		if (!DynamicCSSFilter.ENABLED || (cssThemePath == null)) {
			return content;
		}

		Map<String, Object> inputObjects = new HashMap<String, Object>();

		inputObjects.put("content", content);
		inputObjects.put("cssRealPath", cssRealPath);
		inputObjects.put("cssThemePath", cssThemePath);
		inputObjects.put("sassCachePath", _SASS_CACHE_DIR);

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		UnsyncPrintWriter unsyncPrintWriter = UnsyncPrintWriterPool.borrow(
			unsyncByteArrayOutputStream);

		inputObjects.put("out", unsyncPrintWriter);

		_rubyExecutor.eval(null, inputObjects, null, _rubyScript);

		unsyncPrintWriter.flush();

		String parsedContent = unsyncByteArrayOutputStream.toString();

		if (Validator.isNotNull(parsedContent)) {
			return parsedContent;
		}

		return content;
	}

	protected static String getCssThemePath(HttpServletRequest request) {
		if (request == null) {
			return null;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (themeDisplay != null) {
			return themeDisplay.getPathThemeCss();
		}

		long companyId = PortalUtil.getCompanyId(request);

		String themeId = ParamUtil.getString(request, "themeId");

		if (Validator.isNull(themeId)) {
			return null;
		}

		try {
			Theme theme = ThemeLocalServiceUtil.getTheme(
				companyId, themeId, false);

			String themeStaticResourcePath = theme.getStaticResourcePath();

			return themeStaticResourcePath.concat(theme.getCssPath());
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return null;
	}

	private static final String _SASS_CACHE_DIR =
		SystemProperties.get(SystemProperties.TMP_DIR) + "/liferay/sassCache";

	private static Log _log = LogFactoryUtil.getLog(DynamicCSSUtil.class);

	private static RubyExecutor _rubyExecutor = new RubyExecutor();
	private static String _rubyScript;

}