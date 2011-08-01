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

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ResourceTypePermission service. Represents a row in the &quot;ResourceTypePermission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ResourceTypePermissionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ResourceTypePermissionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTypePermission
 * @see com.liferay.portal.model.impl.ResourceTypePermissionImpl
 * @see com.liferay.portal.model.impl.ResourceTypePermissionModelImpl
 * @generated
 */
public interface ResourceTypePermissionModel extends BaseModel<ResourceTypePermission> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a resource type permission model instance should use the {@link ResourceTypePermission} interface instead.
	 */

	/**
	 * Returns the primary key of this resource type permission.
	 *
	 * @return the primary key of this resource type permission
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this resource type permission.
	 *
	 * @param primaryKey the primary key of this resource type permission
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the resource type permission ID of this resource type permission.
	 *
	 * @return the resource type permission ID of this resource type permission
	 */
	public long getResourceTypePermissionId();

	/**
	 * Sets the resource type permission ID of this resource type permission.
	 *
	 * @param resourceTypePermissionId the resource type permission ID of this resource type permission
	 */
	public void setResourceTypePermissionId(long resourceTypePermissionId);

	/**
	 * Returns the company ID of this resource type permission.
	 *
	 * @return the company ID of this resource type permission
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this resource type permission.
	 *
	 * @param companyId the company ID of this resource type permission
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this resource type permission.
	 *
	 * @return the group ID of this resource type permission
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this resource type permission.
	 *
	 * @param groupId the group ID of this resource type permission
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the name of this resource type permission.
	 *
	 * @return the name of this resource type permission
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this resource type permission.
	 *
	 * @param name the name of this resource type permission
	 */
	public void setName(String name);

	/**
	 * Returns the role ID of this resource type permission.
	 *
	 * @return the role ID of this resource type permission
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this resource type permission.
	 *
	 * @param roleId the role ID of this resource type permission
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the action IDs of this resource type permission.
	 *
	 * @return the action IDs of this resource type permission
	 */
	public long getActionIds();

	/**
	 * Sets the action IDs of this resource type permission.
	 *
	 * @param actionIds the action IDs of this resource type permission
	 */
	public void setActionIds(long actionIds);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ResourceTypePermission resourceTypePermission);

	public int hashCode();

	public CacheModel<ResourceTypePermission> toCacheModel();

	public ResourceTypePermission toEscapedModel();

	public String toString();

	public String toXmlString();
}