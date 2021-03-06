/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.model;

import com.liferay.portal.kernel.plugin.PluginPackage;

/**
 * @author Jorge Ferrer
 */
public interface Plugin {

	public static final String TYPE_EXT = "ext";

	public static final String TYPE_HOOK = "hook";

	public static final String TYPE_LAYOUT_TEMPLATE = "layout-template";

	public static final String TYPE_PORTLET = "portlet";

	public static final String TYPE_THEME = "theme";

	public static final String TYPE_WEB = "web";

	public PluginPackage getPluginPackage();

	public void setPluginPackage(PluginPackage pluginPackage);

	public String getPluginId();

	public String getPluginType();

	public PluginSetting getDefaultPluginSetting();

	public PluginSetting getDefaultPluginSetting(long companyId);

	public void setDefaultPluginSetting(PluginSetting pluginSetting);

}