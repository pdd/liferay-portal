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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.OrgGroupRole;
import com.liferay.portal.model.OrgGroupRoleModel;
import com.liferay.portal.service.persistence.OrgGroupRolePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the OrgGroupRole service. Represents a row in the &quot;OrgGroupRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.OrgGroupRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrgGroupRoleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrgGroupRoleImpl
 * @see com.liferay.portal.model.OrgGroupRole
 * @see com.liferay.portal.model.OrgGroupRoleModel
 * @generated
 */
public class OrgGroupRoleModelImpl extends BaseModelImpl<OrgGroupRole>
	implements OrgGroupRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a org group role model instance should use the {@link com.liferay.portal.model.OrgGroupRole} interface instead.
	 */
	public static final String TABLE_NAME = "OrgGroupRole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "organizationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "roleId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table OrgGroupRole (organizationId LONG not null,groupId LONG not null,roleId LONG not null,primary key (organizationId, groupId, roleId))";
	public static final String TABLE_SQL_DROP = "drop table OrgGroupRole";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.OrgGroupRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.OrgGroupRole"),
			true);

	public Class<?> getModelClass() {
		return OrgGroupRole.class;
	}

	public String getModelClassName() {
		return OrgGroupRole.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.OrgGroupRole"));

	public OrgGroupRoleModelImpl() {
	}

	public OrgGroupRolePK getPrimaryKey() {
		return new OrgGroupRolePK(_organizationId, _groupId, _roleId);
	}

	public void setPrimaryKey(OrgGroupRolePK primaryKey) {
		setOrganizationId(primaryKey.organizationId);
		setGroupId(primaryKey.groupId);
		setRoleId(primaryKey.roleId);
	}

	public Serializable getPrimaryKeyObj() {
		return new OrgGroupRolePK(_organizationId, _groupId, _roleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((OrgGroupRolePK)primaryKeyObj);
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	@Override
	public OrgGroupRole toEscapedModel() {
		if (isEscapedModel()) {
			return (OrgGroupRole)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (OrgGroupRole)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public Object clone() {
		OrgGroupRoleImpl orgGroupRoleImpl = new OrgGroupRoleImpl();

		orgGroupRoleImpl.setOrganizationId(getOrganizationId());
		orgGroupRoleImpl.setGroupId(getGroupId());
		orgGroupRoleImpl.setRoleId(getRoleId());

		orgGroupRoleImpl.resetOriginalValues();

		return orgGroupRoleImpl;
	}

	public int compareTo(OrgGroupRole orgGroupRole) {
		OrgGroupRolePK primaryKey = orgGroupRole.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgGroupRole orgGroupRole = null;

		try {
			orgGroupRole = (OrgGroupRole)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		OrgGroupRolePK primaryKey = orgGroupRole.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<OrgGroupRole> toCacheModel() {
		OrgGroupRoleCacheModel orgGroupRoleCacheModel = new OrgGroupRoleCacheModel();

		orgGroupRoleCacheModel.organizationId = getOrganizationId();

		orgGroupRoleCacheModel.groupId = getGroupId();

		orgGroupRoleCacheModel.roleId = getRoleId();

		return orgGroupRoleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{organizationId=");
		sb.append(getOrganizationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.OrgGroupRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OrgGroupRole.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			OrgGroupRole.class
		};
	private long _organizationId;
	private long _groupId;
	private long _roleId;
	private OrgGroupRole _escapedModelProxy;
}