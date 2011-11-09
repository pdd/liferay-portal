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

package com.liferay.portal.workflow;

import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Miguel Pastor
 */
public class MyWorkflowInstancesControlPanelEntry
	extends WorkflowControlPanelEntry {

	@Override
	public boolean isVisible(
			PermissionChecker permissionChecker, Portlet portlet)
		throws Exception {

		long companyId = permissionChecker.getCompanyId();
		long userId = permissionChecker.getUserId();

		if (WorkflowInstanceManagerUtil.getWorkflowInstanceCount(
				companyId, userId, null, null, Boolean.FALSE) > 0) {

			return true;
		}

		if (WorkflowInstanceManagerUtil.getWorkflowInstanceCount(
				companyId, userId, null, null, Boolean.TRUE) > 0) {

			return true;
		}

		return false;
	}

}