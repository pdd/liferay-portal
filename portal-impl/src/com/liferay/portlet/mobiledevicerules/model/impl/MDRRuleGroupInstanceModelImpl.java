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

package com.liferay.portlet.mobiledevicerules.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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
import com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance;
import com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstanceModel;
import com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstanceSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the MDRRuleGroupInstance service. Represents a row in the &quot;MDRRuleGroupInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MDRRuleGroupInstanceImpl}.
 * </p>
 *
 * @author Edward C. Han
 * @see MDRRuleGroupInstanceImpl
 * @see com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance
 * @see com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstanceModel
 * @generated
 */
@JSON(strict = true)
public class MDRRuleGroupInstanceModelImpl extends BaseModelImpl<MDRRuleGroupInstance>
	implements MDRRuleGroupInstanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a m d r rule group instance model instance should use the {@link com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance} interface instead.
	 */
	public static final String TABLE_NAME = "MDRRuleGroupInstance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "ruleGroupInstanceId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "ruleGroupId", Types.BIGINT },
			{ "priority", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table MDRRuleGroupInstance (uuid_ VARCHAR(75) null,ruleGroupInstanceId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,ruleGroupId LONG,priority INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table MDRRuleGroupInstance";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long RULEGROUPID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MDRRuleGroupInstance toModel(
		MDRRuleGroupInstanceSoap soapModel) {
		MDRRuleGroupInstance model = new MDRRuleGroupInstanceImpl();

		model.setUuid(soapModel.getUuid());
		model.setRuleGroupInstanceId(soapModel.getRuleGroupInstanceId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setRuleGroupId(soapModel.getRuleGroupId());
		model.setPriority(soapModel.getPriority());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MDRRuleGroupInstance> toModels(
		MDRRuleGroupInstanceSoap[] soapModels) {
		List<MDRRuleGroupInstance> models = new ArrayList<MDRRuleGroupInstance>(soapModels.length);

		for (MDRRuleGroupInstanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance"));

	public MDRRuleGroupInstanceModelImpl() {
	}

	public long getPrimaryKey() {
		return _ruleGroupInstanceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRuleGroupInstanceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ruleGroupInstanceId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return MDRRuleGroupInstance.class;
	}

	public String getModelClassName() {
		return MDRRuleGroupInstance.class.getName();
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getRuleGroupInstanceId() {
		return _ruleGroupInstanceId;
	}

	public void setRuleGroupInstanceId(long ruleGroupInstanceId) {
		_ruleGroupInstanceId = ruleGroupInstanceId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	@JSON
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

	@JSON
	public long getRuleGroupId() {
		return _ruleGroupId;
	}

	public void setRuleGroupId(long ruleGroupId) {
		_columnBitmask |= RULEGROUPID_COLUMN_BITMASK;

		if (!_setOriginalRuleGroupId) {
			_setOriginalRuleGroupId = true;

			_originalRuleGroupId = _ruleGroupId;
		}

		_ruleGroupId = ruleGroupId;
	}

	public long getOriginalRuleGroupId() {
		return _originalRuleGroupId;
	}

	@JSON
	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public MDRRuleGroupInstance toEscapedModel() {
		if (isEscapedModel()) {
			return (MDRRuleGroupInstance)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (MDRRuleGroupInstance)ProxyUtil.newProxyInstance(_classLoader,
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
					MDRRuleGroupInstance.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		MDRRuleGroupInstanceImpl mdrRuleGroupInstanceImpl = new MDRRuleGroupInstanceImpl();

		mdrRuleGroupInstanceImpl.setUuid(getUuid());
		mdrRuleGroupInstanceImpl.setRuleGroupInstanceId(getRuleGroupInstanceId());
		mdrRuleGroupInstanceImpl.setGroupId(getGroupId());
		mdrRuleGroupInstanceImpl.setCompanyId(getCompanyId());
		mdrRuleGroupInstanceImpl.setUserId(getUserId());
		mdrRuleGroupInstanceImpl.setUserName(getUserName());
		mdrRuleGroupInstanceImpl.setCreateDate(getCreateDate());
		mdrRuleGroupInstanceImpl.setModifiedDate(getModifiedDate());
		mdrRuleGroupInstanceImpl.setClassNameId(getClassNameId());
		mdrRuleGroupInstanceImpl.setClassPK(getClassPK());
		mdrRuleGroupInstanceImpl.setRuleGroupId(getRuleGroupId());
		mdrRuleGroupInstanceImpl.setPriority(getPriority());

		mdrRuleGroupInstanceImpl.resetOriginalValues();

		return mdrRuleGroupInstanceImpl;
	}

	public int compareTo(MDRRuleGroupInstance mdrRuleGroupInstance) {
		long primaryKey = mdrRuleGroupInstance.getPrimaryKey();

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

		MDRRuleGroupInstance mdrRuleGroupInstance = null;

		try {
			mdrRuleGroupInstance = (MDRRuleGroupInstance)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = mdrRuleGroupInstance.getPrimaryKey();

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
		MDRRuleGroupInstanceModelImpl mdrRuleGroupInstanceModelImpl = this;

		mdrRuleGroupInstanceModelImpl._originalUuid = mdrRuleGroupInstanceModelImpl._uuid;

		mdrRuleGroupInstanceModelImpl._originalGroupId = mdrRuleGroupInstanceModelImpl._groupId;

		mdrRuleGroupInstanceModelImpl._setOriginalGroupId = false;

		mdrRuleGroupInstanceModelImpl._originalClassNameId = mdrRuleGroupInstanceModelImpl._classNameId;

		mdrRuleGroupInstanceModelImpl._setOriginalClassNameId = false;

		mdrRuleGroupInstanceModelImpl._originalClassPK = mdrRuleGroupInstanceModelImpl._classPK;

		mdrRuleGroupInstanceModelImpl._setOriginalClassPK = false;

		mdrRuleGroupInstanceModelImpl._originalRuleGroupId = mdrRuleGroupInstanceModelImpl._ruleGroupId;

		mdrRuleGroupInstanceModelImpl._setOriginalRuleGroupId = false;

		mdrRuleGroupInstanceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MDRRuleGroupInstance> toCacheModel() {
		MDRRuleGroupInstanceCacheModel mdrRuleGroupInstanceCacheModel = new MDRRuleGroupInstanceCacheModel();

		mdrRuleGroupInstanceCacheModel.uuid = getUuid();

		String uuid = mdrRuleGroupInstanceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			mdrRuleGroupInstanceCacheModel.uuid = null;
		}

		mdrRuleGroupInstanceCacheModel.ruleGroupInstanceId = getRuleGroupInstanceId();

		mdrRuleGroupInstanceCacheModel.groupId = getGroupId();

		mdrRuleGroupInstanceCacheModel.companyId = getCompanyId();

		mdrRuleGroupInstanceCacheModel.userId = getUserId();

		mdrRuleGroupInstanceCacheModel.userName = getUserName();

		String userName = mdrRuleGroupInstanceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			mdrRuleGroupInstanceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			mdrRuleGroupInstanceCacheModel.createDate = createDate.getTime();
		}
		else {
			mdrRuleGroupInstanceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			mdrRuleGroupInstanceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			mdrRuleGroupInstanceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		mdrRuleGroupInstanceCacheModel.classNameId = getClassNameId();

		mdrRuleGroupInstanceCacheModel.classPK = getClassPK();

		mdrRuleGroupInstanceCacheModel.ruleGroupId = getRuleGroupId();

		mdrRuleGroupInstanceCacheModel.priority = getPriority();

		return mdrRuleGroupInstanceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", ruleGroupInstanceId=");
		sb.append(getRuleGroupInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", ruleGroupId=");
		sb.append(getRuleGroupId());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ruleGroupInstanceId</column-name><column-value><![CDATA[");
		sb.append(getRuleGroupInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
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
			"<column><column-name>ruleGroupId</column-name><column-value><![CDATA[");
		sb.append(getRuleGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MDRRuleGroupInstance.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			MDRRuleGroupInstance.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _ruleGroupInstanceId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _ruleGroupId;
	private long _originalRuleGroupId;
	private boolean _setOriginalRuleGroupId;
	private int _priority;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private MDRRuleGroupInstance _escapedModelProxy;
}