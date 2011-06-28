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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.UserIdMapper;
import com.liferay.portal.model.UserIdMapperModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the UserIdMapper service. Represents a row in the &quot;UserIdMapper&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.UserIdMapperModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserIdMapperImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserIdMapperImpl
 * @see com.liferay.portal.model.UserIdMapper
 * @see com.liferay.portal.model.UserIdMapperModel
 * @generated
 */
public class UserIdMapperModelImpl extends BaseModelImpl<UserIdMapper>
	implements UserIdMapperModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user ID mapper model instance should use the {@link com.liferay.portal.model.UserIdMapper} interface instead.
	 */
	public static final String TABLE_NAME = "UserIdMapper";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userIdMapperId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "type_", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "externalUserId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table UserIdMapper (userIdMapperId LONG not null primary key,userId LONG,type_ VARCHAR(75) null,description VARCHAR(75) null,externalUserId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table UserIdMapper";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.UserIdMapper"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.UserIdMapper"),
			true);

	public Class<?> getModelClass() {
		return UserIdMapper.class;
	}

	public String getModelClassName() {
		return UserIdMapper.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.UserIdMapper"));

	public UserIdMapperModelImpl() {
	}

	public long getPrimaryKey() {
		return _userIdMapperId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserIdMapperId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userIdMapperId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getUserIdMapperId() {
		return _userIdMapperId;
	}

	public void setUserIdMapperId(long userIdMapperId) {
		_userIdMapperId = userIdMapperId;

		_escapedModelProxy = null;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;

		_escapedModelProxy = null;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;

		_escapedModelProxy = null;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

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

		_escapedModelProxy = null;
	}

	public String getExternalUserId() {
		if (_externalUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _externalUserId;
		}
	}

	public void setExternalUserId(String externalUserId) {
		if (_originalExternalUserId == null) {
			_originalExternalUserId = _externalUserId;
		}

		_externalUserId = externalUserId;

		_escapedModelProxy = null;
	}

	public String getOriginalExternalUserId() {
		return GetterUtil.getString(_originalExternalUserId);
	}

	@Override
	public UserIdMapper toEscapedModel() {
		if (isEscapedModel()) {
			return (UserIdMapper)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (UserIdMapper)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					UserIdMapper.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		UserIdMapperImpl userIdMapperImpl = new UserIdMapperImpl();

		userIdMapperImpl.setUserIdMapperId(getUserIdMapperId());
		userIdMapperImpl.setUserId(getUserId());
		userIdMapperImpl.setType(getType());
		userIdMapperImpl.setDescription(getDescription());
		userIdMapperImpl.setExternalUserId(getExternalUserId());

		userIdMapperImpl.resetOriginalValues();

		return userIdMapperImpl;
	}

	public int compareTo(UserIdMapper userIdMapper) {
		long primaryKey = userIdMapper.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserIdMapper userIdMapper = null;

		try {
			userIdMapper = (UserIdMapper)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userIdMapper.getPrimaryKey();

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
		UserIdMapperModelImpl userIdMapperModelImpl = this;

		userIdMapperModelImpl._originalUserId = userIdMapperModelImpl._userId;

		userIdMapperModelImpl._setOriginalUserId = false;

		userIdMapperModelImpl._originalType = userIdMapperModelImpl._type;

		userIdMapperModelImpl._originalExternalUserId = userIdMapperModelImpl._externalUserId;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{userIdMapperId=");
		sb.append(getUserIdMapperId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", externalUserId=");
		sb.append(getExternalUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.UserIdMapper");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userIdMapperId</column-name><column-value><![CDATA[");
		sb.append(getUserIdMapperId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalUserId</column-name><column-value><![CDATA[");
		sb.append(getExternalUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserIdMapper.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			UserIdMapper.class
		};
	private long _userIdMapperId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _type;
	private String _originalType;
	private String _description;
	private String _externalUserId;
	private String _originalExternalUserId;
	private transient ExpandoBridge _expandoBridge;
	private UserIdMapper _escapedModelProxy;
}