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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupModel;
import com.liferay.portal.model.GroupSoap;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the Group service. Represents a row in the &quot;Group_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.GroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupImpl
 * @see com.liferay.portal.model.Group
 * @see com.liferay.portal.model.GroupModel
 * @generated
 */
@JSON(strict = true)
public class GroupModelImpl extends BaseModelImpl<Group> implements GroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a group model instance should use the {@link com.liferay.portal.model.Group} interface instead.
	 */
	public static final String TABLE_NAME = "Group_";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "creatorUserId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "parentGroupId", Types.BIGINT },
			{ "liveGroupId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "type_", Types.INTEGER },
			{ "typeSettings", Types.VARCHAR },
			{ "friendlyURL", Types.VARCHAR },
			{ "site", Types.BOOLEAN },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Group_ (groupId LONG not null primary key,companyId LONG,creatorUserId LONG,classNameId LONG,classPK LONG,parentGroupId LONG,liveGroupId LONG,name VARCHAR(75) null,description STRING null,type_ INTEGER,typeSettings STRING null,friendlyURL VARCHAR(100) null,site BOOLEAN,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Group_";
	public static final String ORDER_BY_JPQL = " ORDER BY group_.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Group_.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.Group"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.Group"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Group toModel(GroupSoap soapModel) {
		Group model = new GroupImpl();

		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreatorUserId(soapModel.getCreatorUserId());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setParentGroupId(soapModel.getParentGroupId());
		model.setLiveGroupId(soapModel.getLiveGroupId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());
		model.setFriendlyURL(soapModel.getFriendlyURL());
		model.setSite(soapModel.getSite());
		model.setActive(soapModel.getActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Group> toModels(GroupSoap[] soapModels) {
		List<Group> models = new ArrayList<Group>(soapModels.length);

		for (GroupSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return Group.class;
	}

	public String getModelClassName() {
		return Group.class.getName();
	}

	public static final String MAPPING_TABLE_GROUPS_ORGS_NAME = "Groups_Orgs";
	public static final Object[][] MAPPING_TABLE_GROUPS_ORGS_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "organizationId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_GROUPS_ORGS_SQL_CREATE = "create table Groups_Orgs (groupId LONG not null,organizationId LONG not null,primary key (groupId, organizationId))";
	public static final boolean FINDER_CACHE_ENABLED_GROUPS_ORGS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.Groups_Orgs"), true);
	public static final String MAPPING_TABLE_GROUPS_PERMISSIONS_NAME = "Groups_Permissions";
	public static final Object[][] MAPPING_TABLE_GROUPS_PERMISSIONS_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "permissionId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_GROUPS_PERMISSIONS_SQL_CREATE = "create table Groups_Permissions (groupId LONG not null,permissionId LONG not null,primary key (groupId, permissionId))";
	public static final boolean FINDER_CACHE_ENABLED_GROUPS_PERMISSIONS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.Groups_Permissions"), true);
	public static final String MAPPING_TABLE_GROUPS_ROLES_NAME = "Groups_Roles";
	public static final Object[][] MAPPING_TABLE_GROUPS_ROLES_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "roleId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_GROUPS_ROLES_SQL_CREATE = "create table Groups_Roles (groupId LONG not null,roleId LONG not null,primary key (groupId, roleId))";
	public static final boolean FINDER_CACHE_ENABLED_GROUPS_ROLES = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.Groups_Roles"), true);
	public static final String MAPPING_TABLE_GROUPS_USERGROUPS_NAME = "Groups_UserGroups";
	public static final Object[][] MAPPING_TABLE_GROUPS_USERGROUPS_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "userGroupId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_GROUPS_USERGROUPS_SQL_CREATE = "create table Groups_UserGroups (groupId LONG not null,userGroupId LONG not null,primary key (groupId, userGroupId))";
	public static final boolean FINDER_CACHE_ENABLED_GROUPS_USERGROUPS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.Groups_UserGroups"), true);
	public static final String MAPPING_TABLE_USERS_GROUPS_NAME = "Users_Groups";
	public static final Object[][] MAPPING_TABLE_USERS_GROUPS_COLUMNS = {
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_USERS_GROUPS_SQL_CREATE = "create table Users_Groups (userId LONG not null,groupId LONG not null,primary key (userId, groupId))";
	public static final boolean FINDER_CACHE_ENABLED_USERS_GROUPS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.Users_Groups"), true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.Group"));

	public GroupModelImpl() {
	}

	public long getPrimaryKey() {
		return _groupId;
	}

	public void setPrimaryKey(long primaryKey) {
		setGroupId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_groupId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getCreatorUserId() {
		return _creatorUserId;
	}

	public void setCreatorUserId(long creatorUserId) {
		_creatorUserId = creatorUserId;
	}

	public String getCreatorUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreatorUserId(), "uuid",
			_creatorUserUuid);
	}

	public void setCreatorUserUuid(String creatorUserUuid) {
		_creatorUserUuid = creatorUserUuid;
	}

	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@JSON
	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	public long getParentGroupId() {
		return _parentGroupId;
	}

	public void setParentGroupId(long parentGroupId) {
		_parentGroupId = parentGroupId;
	}

	@JSON
	public long getLiveGroupId() {
		return _liveGroupId;
	}

	public void setLiveGroupId(long liveGroupId) {
		if (!_setOriginalLiveGroupId) {
			_setOriginalLiveGroupId = true;

			_originalLiveGroupId = _liveGroupId;
		}

		_liveGroupId = liveGroupId;
	}

	public long getOriginalLiveGroupId() {
		return _originalLiveGroupId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	@JSON
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeSettings;
		}
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@JSON
	public String getFriendlyURL() {
		if (_friendlyURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _friendlyURL;
		}
	}

	public void setFriendlyURL(String friendlyURL) {
		if (_originalFriendlyURL == null) {
			_originalFriendlyURL = _friendlyURL;
		}

		_friendlyURL = friendlyURL;
	}

	public String getOriginalFriendlyURL() {
		return GetterUtil.getString(_originalFriendlyURL);
	}

	@JSON
	public boolean getSite() {
		return _site;
	}

	public boolean isSite() {
		return _site;
	}

	public void setSite(boolean site) {
		_site = site;
	}

	@JSON
	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	@Override
	public Group toEscapedModel() {
		if (isEscapedModel()) {
			return (Group)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (Group)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Group.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		GroupImpl groupImpl = new GroupImpl();

		groupImpl.setGroupId(getGroupId());
		groupImpl.setCompanyId(getCompanyId());
		groupImpl.setCreatorUserId(getCreatorUserId());
		groupImpl.setClassNameId(getClassNameId());
		groupImpl.setClassPK(getClassPK());
		groupImpl.setParentGroupId(getParentGroupId());
		groupImpl.setLiveGroupId(getLiveGroupId());
		groupImpl.setName(getName());
		groupImpl.setDescription(getDescription());
		groupImpl.setType(getType());
		groupImpl.setTypeSettings(getTypeSettings());
		groupImpl.setFriendlyURL(getFriendlyURL());
		groupImpl.setSite(getSite());
		groupImpl.setActive(getActive());

		groupImpl.resetOriginalValues();

		return groupImpl;
	}

	public int compareTo(Group group) {
		int value = 0;

		value = getName().toLowerCase().compareTo(group.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Group group = null;

		try {
			group = (Group)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = group.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		GroupModelImpl groupModelImpl = this;

		groupModelImpl._originalCompanyId = groupModelImpl._companyId;

		groupModelImpl._setOriginalCompanyId = false;

		groupModelImpl._originalClassNameId = groupModelImpl._classNameId;

		groupModelImpl._setOriginalClassNameId = false;

		groupModelImpl._originalClassPK = groupModelImpl._classPK;

		groupModelImpl._setOriginalClassPK = false;

		groupModelImpl._originalLiveGroupId = groupModelImpl._liveGroupId;

		groupModelImpl._setOriginalLiveGroupId = false;

		groupModelImpl._originalName = groupModelImpl._name;

		groupModelImpl._originalFriendlyURL = groupModelImpl._friendlyURL;
	}

	@Override
	public CacheModel<Group> toCacheModel() {
		GroupCacheModel groupCacheModel = new GroupCacheModel();

		groupCacheModel.groupId = getGroupId();

		groupCacheModel.companyId = getCompanyId();

		groupCacheModel.creatorUserId = getCreatorUserId();

		groupCacheModel.classNameId = getClassNameId();

		groupCacheModel.classPK = getClassPK();

		groupCacheModel.parentGroupId = getParentGroupId();

		groupCacheModel.liveGroupId = getLiveGroupId();

		groupCacheModel.name = getName();

		String name = groupCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			groupCacheModel.name = null;
		}

		groupCacheModel.description = getDescription();

		String description = groupCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			groupCacheModel.description = null;
		}

		groupCacheModel.type = getType();

		groupCacheModel.typeSettings = getTypeSettings();

		String typeSettings = groupCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			groupCacheModel.typeSettings = null;
		}

		groupCacheModel.friendlyURL = getFriendlyURL();

		String friendlyURL = groupCacheModel.friendlyURL;

		if ((friendlyURL != null) && (friendlyURL.length() == 0)) {
			groupCacheModel.friendlyURL = null;
		}

		groupCacheModel.site = getSite();

		groupCacheModel.active = getActive();

		return groupCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", creatorUserId=");
		sb.append(getCreatorUserId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", parentGroupId=");
		sb.append(getParentGroupId());
		sb.append(", liveGroupId=");
		sb.append(getLiveGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append(", friendlyURL=");
		sb.append(getFriendlyURL());
		sb.append(", site=");
		sb.append(getSite());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.Group");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatorUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentGroupId</column-name><column-value><![CDATA[");
		sb.append(getParentGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>liveGroupId</column-name><column-value><![CDATA[");
		sb.append(getLiveGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friendlyURL</column-name><column-value><![CDATA[");
		sb.append(getFriendlyURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>site</column-name><column-value><![CDATA[");
		sb.append(getSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Group.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Group.class
		};
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _creatorUserId;
	private String _creatorUserUuid;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _parentGroupId;
	private long _liveGroupId;
	private long _originalLiveGroupId;
	private boolean _setOriginalLiveGroupId;
	private String _name;
	private String _originalName;
	private String _description;
	private int _type;
	private String _typeSettings;
	private String _friendlyURL;
	private String _originalFriendlyURL;
	private boolean _site;
	private boolean _active;
	private transient ExpandoBridge _expandoBridge;
	private Group _escapedModelProxy;
}