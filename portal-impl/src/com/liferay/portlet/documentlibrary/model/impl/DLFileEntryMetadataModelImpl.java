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

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadataModel;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the DLFileEntryMetadata service. Represents a row in the &quot;DLFileEntryMetadata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.documentlibrary.model.DLFileEntryMetadataModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLFileEntryMetadataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileEntryMetadataImpl
 * @see com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata
 * @see com.liferay.portlet.documentlibrary.model.DLFileEntryMetadataModel
 * @generated
 */
public class DLFileEntryMetadataModelImpl extends BaseModelImpl<DLFileEntryMetadata>
	implements DLFileEntryMetadataModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document library file entry metadata model instance should use the {@link com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata} interface instead.
	 */
	public static final String TABLE_NAME = "DLFileEntryMetadata";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "fileEntryMetadataId", Types.BIGINT },
			{ "DDMStorageId", Types.BIGINT },
			{ "DDMStructureId", Types.BIGINT },
			{ "fileEntryTypeId", Types.BIGINT },
			{ "fileEntryId", Types.BIGINT },
			{ "fileVersionId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table DLFileEntryMetadata (uuid_ VARCHAR(75) null,fileEntryMetadataId LONG not null primary key,DDMStorageId LONG,DDMStructureId LONG,fileEntryTypeId LONG,fileEntryId LONG,fileVersionId LONG)";
	public static final String TABLE_SQL_DROP = "drop table DLFileEntryMetadata";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata"),
			true);

	public Class<?> getModelClass() {
		return DLFileEntryMetadata.class;
	}

	public String getModelClassName() {
		return DLFileEntryMetadata.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata"));

	public DLFileEntryMetadataModelImpl() {
	}

	public long getPrimaryKey() {
		return _fileEntryMetadataId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFileEntryMetadataId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_fileEntryMetadataId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFileEntryMetadataId() {
		return _fileEntryMetadataId;
	}

	public void setFileEntryMetadataId(long fileEntryMetadataId) {
		_fileEntryMetadataId = fileEntryMetadataId;
	}

	public long getDDMStorageId() {
		return _DDMStorageId;
	}

	public void setDDMStorageId(long DDMStorageId) {
		_DDMStorageId = DDMStorageId;
	}

	public long getDDMStructureId() {
		return _DDMStructureId;
	}

	public void setDDMStructureId(long DDMStructureId) {
		if (!_setOriginalDDMStructureId) {
			_setOriginalDDMStructureId = true;

			_originalDDMStructureId = _DDMStructureId;
		}

		_DDMStructureId = DDMStructureId;
	}

	public long getOriginalDDMStructureId() {
		return _originalDDMStructureId;
	}

	public long getFileEntryTypeId() {
		return _fileEntryTypeId;
	}

	public void setFileEntryTypeId(long fileEntryTypeId) {
		_fileEntryTypeId = fileEntryTypeId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getFileVersionId() {
		return _fileVersionId;
	}

	public void setFileVersionId(long fileVersionId) {
		if (!_setOriginalFileVersionId) {
			_setOriginalFileVersionId = true;

			_originalFileVersionId = _fileVersionId;
		}

		_fileVersionId = fileVersionId;
	}

	public long getOriginalFileVersionId() {
		return _originalFileVersionId;
	}

	@Override
	public DLFileEntryMetadata toEscapedModel() {
		if (isEscapedModel()) {
			return (DLFileEntryMetadata)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (DLFileEntryMetadata)Proxy.newProxyInstance(_classLoader,
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
					DLFileEntryMetadata.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DLFileEntryMetadataImpl dlFileEntryMetadataImpl = new DLFileEntryMetadataImpl();

		dlFileEntryMetadataImpl.setUuid(getUuid());
		dlFileEntryMetadataImpl.setFileEntryMetadataId(getFileEntryMetadataId());
		dlFileEntryMetadataImpl.setDDMStorageId(getDDMStorageId());
		dlFileEntryMetadataImpl.setDDMStructureId(getDDMStructureId());
		dlFileEntryMetadataImpl.setFileEntryTypeId(getFileEntryTypeId());
		dlFileEntryMetadataImpl.setFileEntryId(getFileEntryId());
		dlFileEntryMetadataImpl.setFileVersionId(getFileVersionId());

		dlFileEntryMetadataImpl.resetOriginalValues();

		return dlFileEntryMetadataImpl;
	}

	public int compareTo(DLFileEntryMetadata dlFileEntryMetadata) {
		long primaryKey = dlFileEntryMetadata.getPrimaryKey();

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

		DLFileEntryMetadata dlFileEntryMetadata = null;

		try {
			dlFileEntryMetadata = (DLFileEntryMetadata)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dlFileEntryMetadata.getPrimaryKey();

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
		DLFileEntryMetadataModelImpl dlFileEntryMetadataModelImpl = this;

		dlFileEntryMetadataModelImpl._originalDDMStructureId = dlFileEntryMetadataModelImpl._DDMStructureId;

		dlFileEntryMetadataModelImpl._setOriginalDDMStructureId = false;

		dlFileEntryMetadataModelImpl._originalFileVersionId = dlFileEntryMetadataModelImpl._fileVersionId;

		dlFileEntryMetadataModelImpl._setOriginalFileVersionId = false;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", fileEntryMetadataId=");
		sb.append(getFileEntryMetadataId());
		sb.append(", DDMStorageId=");
		sb.append(getDDMStorageId());
		sb.append(", DDMStructureId=");
		sb.append(getDDMStructureId());
		sb.append(", fileEntryTypeId=");
		sb.append(getFileEntryTypeId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", fileVersionId=");
		sb.append(getFileVersionId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryMetadataId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryMetadataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DDMStorageId</column-name><column-value><![CDATA[");
		sb.append(getDDMStorageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DDMStructureId</column-name><column-value><![CDATA[");
		sb.append(getDDMStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryTypeId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileVersionId</column-name><column-value><![CDATA[");
		sb.append(getFileVersionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DLFileEntryMetadata.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DLFileEntryMetadata.class
		};
	private String _uuid;
	private long _fileEntryMetadataId;
	private long _DDMStorageId;
	private long _DDMStructureId;
	private long _originalDDMStructureId;
	private boolean _setOriginalDDMStructureId;
	private long _fileEntryTypeId;
	private long _fileEntryId;
	private long _fileVersionId;
	private long _originalFileVersionId;
	private boolean _setOriginalFileVersionId;
	private transient ExpandoBridge _expandoBridge;
	private DLFileEntryMetadata _escapedModelProxy;
}