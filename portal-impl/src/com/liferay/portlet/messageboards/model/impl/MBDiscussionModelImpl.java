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

package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.MBDiscussionModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the MBDiscussion service. Represents a row in the &quot;MBDiscussion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.messageboards.model.MBDiscussionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MBDiscussionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBDiscussionImpl
 * @see com.liferay.portlet.messageboards.model.MBDiscussion
 * @see com.liferay.portlet.messageboards.model.MBDiscussionModel
 * @generated
 */
public class MBDiscussionModelImpl extends BaseModelImpl<MBDiscussion>
	implements MBDiscussionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message boards discussion model instance should use the {@link com.liferay.portlet.messageboards.model.MBDiscussion} interface instead.
	 */
	public static final String TABLE_NAME = "MBDiscussion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "discussionId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "threadId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table MBDiscussion (discussionId LONG not null primary key,classNameId LONG,classPK LONG,threadId LONG)";
	public static final String TABLE_SQL_DROP = "drop table MBDiscussion";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.messageboards.model.MBDiscussion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.messageboards.model.MBDiscussion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.messageboards.model.MBDiscussion"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long THREADID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.messageboards.model.MBDiscussion"));

	public MBDiscussionModelImpl() {
	}

	public long getPrimaryKey() {
		return _discussionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDiscussionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_discussionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return MBDiscussion.class;
	}

	public String getModelClassName() {
		return MBDiscussion.class.getName();
	}

	public long getDiscussionId() {
		return _discussionId;
	}

	public void setDiscussionId(long discussionId) {
		_discussionId = discussionId;
	}

	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_columnBitmask |= THREADID_COLUMN_BITMASK;

		if (!_setOriginalThreadId) {
			_setOriginalThreadId = true;

			_originalThreadId = _threadId;
		}

		_threadId = threadId;
	}

	public long getOriginalThreadId() {
		return _originalThreadId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public MBDiscussion toEscapedModel() {
		if (isEscapedModel()) {
			return (MBDiscussion)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (MBDiscussion)ProxyUtil.newProxyInstance(_classLoader,
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
					MBDiscussion.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		MBDiscussionImpl mbDiscussionImpl = new MBDiscussionImpl();

		mbDiscussionImpl.setDiscussionId(getDiscussionId());
		mbDiscussionImpl.setClassNameId(getClassNameId());
		mbDiscussionImpl.setClassPK(getClassPK());
		mbDiscussionImpl.setThreadId(getThreadId());

		mbDiscussionImpl.resetOriginalValues();

		return mbDiscussionImpl;
	}

	public int compareTo(MBDiscussion mbDiscussion) {
		long primaryKey = mbDiscussion.getPrimaryKey();

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

		MBDiscussion mbDiscussion = null;

		try {
			mbDiscussion = (MBDiscussion)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = mbDiscussion.getPrimaryKey();

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
		MBDiscussionModelImpl mbDiscussionModelImpl = this;

		mbDiscussionModelImpl._originalClassNameId = mbDiscussionModelImpl._classNameId;

		mbDiscussionModelImpl._setOriginalClassNameId = false;

		mbDiscussionModelImpl._originalClassPK = mbDiscussionModelImpl._classPK;

		mbDiscussionModelImpl._setOriginalClassPK = false;

		mbDiscussionModelImpl._originalThreadId = mbDiscussionModelImpl._threadId;

		mbDiscussionModelImpl._setOriginalThreadId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<MBDiscussion> toCacheModel() {
		MBDiscussionCacheModel mbDiscussionCacheModel = new MBDiscussionCacheModel();

		mbDiscussionCacheModel.discussionId = getDiscussionId();

		mbDiscussionCacheModel.classNameId = getClassNameId();

		mbDiscussionCacheModel.classPK = getClassPK();

		mbDiscussionCacheModel.threadId = getThreadId();

		return mbDiscussionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{discussionId=");
		sb.append(getDiscussionId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", threadId=");
		sb.append(getThreadId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.messageboards.model.MBDiscussion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>discussionId</column-name><column-value><![CDATA[");
		sb.append(getDiscussionId());
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
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MBDiscussion.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			MBDiscussion.class
		};
	private long _discussionId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _threadId;
	private long _originalThreadId;
	private boolean _setOriginalThreadId;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private MBDiscussion _escapedModelProxy;
}