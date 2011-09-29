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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BrowserTracker;
import com.liferay.portal.model.BrowserTrackerModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the BrowserTracker service. Represents a row in the &quot;BrowserTracker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.BrowserTrackerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BrowserTrackerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserTrackerImpl
 * @see com.liferay.portal.model.BrowserTracker
 * @see com.liferay.portal.model.BrowserTrackerModel
 * @generated
 */
public class BrowserTrackerModelImpl extends BaseModelImpl<BrowserTracker>
	implements BrowserTrackerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a browser tracker model instance should use the {@link com.liferay.portal.model.BrowserTracker} interface instead.
	 */
	public static final String TABLE_NAME = "BrowserTracker";
	public static final Object[][] TABLE_COLUMNS = {
			{ "browserTrackerId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "browserKey", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table BrowserTracker (browserTrackerId LONG not null primary key,userId LONG,browserKey LONG)";
	public static final String TABLE_SQL_DROP = "drop table BrowserTracker";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.BrowserTracker"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.BrowserTracker"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.BrowserTracker"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.BrowserTracker"));

	public BrowserTrackerModelImpl() {
	}

	public long getPrimaryKey() {
		return _browserTrackerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBrowserTrackerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_browserTrackerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return BrowserTracker.class;
	}

	public String getModelClassName() {
		return BrowserTracker.class.getName();
	}

	public long getBrowserTrackerId() {
		return _browserTrackerId;
	}

	public void setBrowserTrackerId(long browserTrackerId) {
		_browserTrackerId = browserTrackerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
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

	public long getBrowserKey() {
		return _browserKey;
	}

	public void setBrowserKey(long browserKey) {
		_browserKey = browserKey;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public BrowserTracker toEscapedModel() {
		if (isEscapedModel()) {
			return (BrowserTracker)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (BrowserTracker)ProxyUtil.newProxyInstance(_classLoader,
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
					BrowserTracker.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		BrowserTrackerImpl browserTrackerImpl = new BrowserTrackerImpl();

		browserTrackerImpl.setBrowserTrackerId(getBrowserTrackerId());
		browserTrackerImpl.setUserId(getUserId());
		browserTrackerImpl.setBrowserKey(getBrowserKey());

		browserTrackerImpl.resetOriginalValues();

		return browserTrackerImpl;
	}

	public int compareTo(BrowserTracker browserTracker) {
		long primaryKey = browserTracker.getPrimaryKey();

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

		BrowserTracker browserTracker = null;

		try {
			browserTracker = (BrowserTracker)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = browserTracker.getPrimaryKey();

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
		BrowserTrackerModelImpl browserTrackerModelImpl = this;

		browserTrackerModelImpl._originalUserId = browserTrackerModelImpl._userId;

		browserTrackerModelImpl._setOriginalUserId = false;

		browserTrackerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BrowserTracker> toCacheModel() {
		BrowserTrackerCacheModel browserTrackerCacheModel = new BrowserTrackerCacheModel();

		browserTrackerCacheModel.browserTrackerId = getBrowserTrackerId();

		browserTrackerCacheModel.userId = getUserId();

		browserTrackerCacheModel.browserKey = getBrowserKey();

		return browserTrackerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{browserTrackerId=");
		sb.append(getBrowserTrackerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", browserKey=");
		sb.append(getBrowserKey());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.BrowserTracker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>browserTrackerId</column-name><column-value><![CDATA[");
		sb.append(getBrowserTrackerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>browserKey</column-name><column-value><![CDATA[");
		sb.append(getBrowserKey());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BrowserTracker.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			BrowserTracker.class
		};
	private long _browserTrackerId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _browserKey;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private BrowserTracker _escapedModelProxy;
}