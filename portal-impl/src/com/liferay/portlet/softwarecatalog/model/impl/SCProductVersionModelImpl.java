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

package com.liferay.portlet.softwarecatalog.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
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
import com.liferay.portlet.softwarecatalog.model.SCProductVersion;
import com.liferay.portlet.softwarecatalog.model.SCProductVersionModel;
import com.liferay.portlet.softwarecatalog.model.SCProductVersionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the SCProductVersion service. Represents a row in the &quot;SCProductVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.softwarecatalog.model.SCProductVersionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SCProductVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCProductVersionImpl
 * @see com.liferay.portlet.softwarecatalog.model.SCProductVersion
 * @see com.liferay.portlet.softwarecatalog.model.SCProductVersionModel
 * @generated
 */
@JSON(strict = true)
public class SCProductVersionModelImpl extends BaseModelImpl<SCProductVersion>
	implements SCProductVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s c product version model instance should use the {@link com.liferay.portlet.softwarecatalog.model.SCProductVersion} interface instead.
	 */
	public static final String TABLE_NAME = "SCProductVersion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "productVersionId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "productEntryId", Types.BIGINT },
			{ "version", Types.VARCHAR },
			{ "changeLog", Types.VARCHAR },
			{ "downloadPageURL", Types.VARCHAR },
			{ "directDownloadURL", Types.VARCHAR },
			{ "repoStoreArtifact", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table SCProductVersion (productVersionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,productEntryId LONG,version VARCHAR(75) null,changeLog STRING null,downloadPageURL STRING null,directDownloadURL VARCHAR(2000) null,repoStoreArtifact BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table SCProductVersion";
	public static final String ORDER_BY_JPQL = " ORDER BY scProductVersion.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SCProductVersion.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.softwarecatalog.model.SCProductVersion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.softwarecatalog.model.SCProductVersion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.softwarecatalog.model.SCProductVersion"),
			true);
	public static long DIRECTDOWNLOADURL_COLUMN_BITMASK = 1L;
	public static long PRODUCTENTRYID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SCProductVersion toModel(SCProductVersionSoap soapModel) {
		SCProductVersion model = new SCProductVersionImpl();

		model.setProductVersionId(soapModel.getProductVersionId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setProductEntryId(soapModel.getProductEntryId());
		model.setVersion(soapModel.getVersion());
		model.setChangeLog(soapModel.getChangeLog());
		model.setDownloadPageURL(soapModel.getDownloadPageURL());
		model.setDirectDownloadURL(soapModel.getDirectDownloadURL());
		model.setRepoStoreArtifact(soapModel.getRepoStoreArtifact());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SCProductVersion> toModels(
		SCProductVersionSoap[] soapModels) {
		List<SCProductVersion> models = new ArrayList<SCProductVersion>(soapModels.length);

		for (SCProductVersionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_SCFRAMEWORKVERSI_SCPRODUCTVERS_NAME =
		"SCFrameworkVersi_SCProductVers";
	public static final Object[][] MAPPING_TABLE_SCFRAMEWORKVERSI_SCPRODUCTVERS_COLUMNS =
		{
			{ "frameworkVersionId", Types.BIGINT },
			{ "productVersionId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_SCFRAMEWORKVERSI_SCPRODUCTVERS_SQL_CREATE =
		"create table SCFrameworkVersi_SCProductVers (frameworkVersionId LONG not null,productVersionId LONG not null,primary key (frameworkVersionId, productVersionId))";
	public static final boolean FINDER_CACHE_ENABLED_SCFRAMEWORKVERSI_SCPRODUCTVERS =
		GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.SCFrameworkVersi_SCProductVers"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.softwarecatalog.model.SCProductVersion"));

	public SCProductVersionModelImpl() {
	}

	public long getPrimaryKey() {
		return _productVersionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProductVersionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_productVersionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return SCProductVersion.class;
	}

	public String getModelClassName() {
		return SCProductVersion.class.getName();
	}

	@JSON
	public long getProductVersionId() {
		return _productVersionId;
	}

	public void setProductVersionId(long productVersionId) {
		_productVersionId = productVersionId;
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

	@JSON
	public long getProductEntryId() {
		return _productEntryId;
	}

	public void setProductEntryId(long productEntryId) {
		_columnBitmask |= PRODUCTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalProductEntryId) {
			_setOriginalProductEntryId = true;

			_originalProductEntryId = _productEntryId;
		}

		_productEntryId = productEntryId;
	}

	public long getOriginalProductEntryId() {
		return _originalProductEntryId;
	}

	@JSON
	public String getVersion() {
		if (_version == null) {
			return StringPool.BLANK;
		}
		else {
			return _version;
		}
	}

	public void setVersion(String version) {
		_version = version;
	}

	@JSON
	public String getChangeLog() {
		if (_changeLog == null) {
			return StringPool.BLANK;
		}
		else {
			return _changeLog;
		}
	}

	public void setChangeLog(String changeLog) {
		_changeLog = changeLog;
	}

	@JSON
	public String getDownloadPageURL() {
		if (_downloadPageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _downloadPageURL;
		}
	}

	public void setDownloadPageURL(String downloadPageURL) {
		_downloadPageURL = downloadPageURL;
	}

	@JSON
	public String getDirectDownloadURL() {
		if (_directDownloadURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _directDownloadURL;
		}
	}

	public void setDirectDownloadURL(String directDownloadURL) {
		_columnBitmask |= DIRECTDOWNLOADURL_COLUMN_BITMASK;

		if (_originalDirectDownloadURL == null) {
			_originalDirectDownloadURL = _directDownloadURL;
		}

		_directDownloadURL = directDownloadURL;
	}

	public String getOriginalDirectDownloadURL() {
		return GetterUtil.getString(_originalDirectDownloadURL);
	}

	@JSON
	public boolean getRepoStoreArtifact() {
		return _repoStoreArtifact;
	}

	public boolean isRepoStoreArtifact() {
		return _repoStoreArtifact;
	}

	public void setRepoStoreArtifact(boolean repoStoreArtifact) {
		_repoStoreArtifact = repoStoreArtifact;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public SCProductVersion toEscapedModel() {
		if (isEscapedModel()) {
			return (SCProductVersion)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (SCProductVersion)ProxyUtil.newProxyInstance(_classLoader,
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
					SCProductVersion.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		SCProductVersionImpl scProductVersionImpl = new SCProductVersionImpl();

		scProductVersionImpl.setProductVersionId(getProductVersionId());
		scProductVersionImpl.setCompanyId(getCompanyId());
		scProductVersionImpl.setUserId(getUserId());
		scProductVersionImpl.setUserName(getUserName());
		scProductVersionImpl.setCreateDate(getCreateDate());
		scProductVersionImpl.setModifiedDate(getModifiedDate());
		scProductVersionImpl.setProductEntryId(getProductEntryId());
		scProductVersionImpl.setVersion(getVersion());
		scProductVersionImpl.setChangeLog(getChangeLog());
		scProductVersionImpl.setDownloadPageURL(getDownloadPageURL());
		scProductVersionImpl.setDirectDownloadURL(getDirectDownloadURL());
		scProductVersionImpl.setRepoStoreArtifact(getRepoStoreArtifact());

		scProductVersionImpl.resetOriginalValues();

		return scProductVersionImpl;
	}

	public int compareTo(SCProductVersion scProductVersion) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				scProductVersion.getCreateDate());

		value = value * -1;

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

		SCProductVersion scProductVersion = null;

		try {
			scProductVersion = (SCProductVersion)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = scProductVersion.getPrimaryKey();

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
		SCProductVersionModelImpl scProductVersionModelImpl = this;

		scProductVersionModelImpl._originalProductEntryId = scProductVersionModelImpl._productEntryId;

		scProductVersionModelImpl._setOriginalProductEntryId = false;

		scProductVersionModelImpl._originalDirectDownloadURL = scProductVersionModelImpl._directDownloadURL;

		scProductVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SCProductVersion> toCacheModel() {
		SCProductVersionCacheModel scProductVersionCacheModel = new SCProductVersionCacheModel();

		scProductVersionCacheModel.productVersionId = getProductVersionId();

		scProductVersionCacheModel.companyId = getCompanyId();

		scProductVersionCacheModel.userId = getUserId();

		scProductVersionCacheModel.userName = getUserName();

		String userName = scProductVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			scProductVersionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			scProductVersionCacheModel.createDate = createDate.getTime();
		}
		else {
			scProductVersionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			scProductVersionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			scProductVersionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		scProductVersionCacheModel.productEntryId = getProductEntryId();

		scProductVersionCacheModel.version = getVersion();

		String version = scProductVersionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			scProductVersionCacheModel.version = null;
		}

		scProductVersionCacheModel.changeLog = getChangeLog();

		String changeLog = scProductVersionCacheModel.changeLog;

		if ((changeLog != null) && (changeLog.length() == 0)) {
			scProductVersionCacheModel.changeLog = null;
		}

		scProductVersionCacheModel.downloadPageURL = getDownloadPageURL();

		String downloadPageURL = scProductVersionCacheModel.downloadPageURL;

		if ((downloadPageURL != null) && (downloadPageURL.length() == 0)) {
			scProductVersionCacheModel.downloadPageURL = null;
		}

		scProductVersionCacheModel.directDownloadURL = getDirectDownloadURL();

		String directDownloadURL = scProductVersionCacheModel.directDownloadURL;

		if ((directDownloadURL != null) && (directDownloadURL.length() == 0)) {
			scProductVersionCacheModel.directDownloadURL = null;
		}

		scProductVersionCacheModel.repoStoreArtifact = getRepoStoreArtifact();

		return scProductVersionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{productVersionId=");
		sb.append(getProductVersionId());
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
		sb.append(", productEntryId=");
		sb.append(getProductEntryId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", changeLog=");
		sb.append(getChangeLog());
		sb.append(", downloadPageURL=");
		sb.append(getDownloadPageURL());
		sb.append(", directDownloadURL=");
		sb.append(getDirectDownloadURL());
		sb.append(", repoStoreArtifact=");
		sb.append(getRepoStoreArtifact());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.softwarecatalog.model.SCProductVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>productVersionId</column-name><column-value><![CDATA[");
		sb.append(getProductVersionId());
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
			"<column><column-name>productEntryId</column-name><column-value><![CDATA[");
		sb.append(getProductEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>changeLog</column-name><column-value><![CDATA[");
		sb.append(getChangeLog());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadPageURL</column-name><column-value><![CDATA[");
		sb.append(getDownloadPageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>directDownloadURL</column-name><column-value><![CDATA[");
		sb.append(getDirectDownloadURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repoStoreArtifact</column-name><column-value><![CDATA[");
		sb.append(getRepoStoreArtifact());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SCProductVersion.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SCProductVersion.class
		};
	private long _productVersionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _productEntryId;
	private long _originalProductEntryId;
	private boolean _setOriginalProductEntryId;
	private String _version;
	private String _changeLog;
	private String _downloadPageURL;
	private String _directDownloadURL;
	private String _originalDirectDownloadURL;
	private boolean _repoStoreArtifact;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private SCProductVersion _escapedModelProxy;
}