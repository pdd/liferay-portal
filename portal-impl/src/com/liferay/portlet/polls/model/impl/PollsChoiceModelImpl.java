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

package com.liferay.portlet.polls.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.PollsChoiceModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the PollsChoice service. Represents a row in the &quot;PollsChoice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.polls.model.PollsChoiceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PollsChoiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsChoiceImpl
 * @see com.liferay.portlet.polls.model.PollsChoice
 * @see com.liferay.portlet.polls.model.PollsChoiceModel
 * @generated
 */
public class PollsChoiceModelImpl extends BaseModelImpl<PollsChoice>
	implements PollsChoiceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a polls choice model instance should use the {@link com.liferay.portlet.polls.model.PollsChoice} interface instead.
	 */
	public static final String TABLE_NAME = "PollsChoice";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "choiceId", Types.BIGINT },
			{ "questionId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table PollsChoice (uuid_ VARCHAR(75) null,choiceId LONG not null primary key,questionId LONG,name VARCHAR(75) null,description STRING null)";
	public static final String TABLE_SQL_DROP = "drop table PollsChoice";
	public static final String ORDER_BY_JPQL = " ORDER BY pollsChoice.questionId ASC, pollsChoice.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PollsChoice.questionId ASC, PollsChoice.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.polls.model.PollsChoice"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.polls.model.PollsChoice"),
			true);

	public Class<?> getModelClass() {
		return PollsChoice.class;
	}

	public String getModelClassName() {
		return PollsChoice.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.polls.model.PollsChoice"));

	public PollsChoiceModelImpl() {
	}

	public long getPrimaryKey() {
		return _choiceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setChoiceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_choiceId);
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

	public long getChoiceId() {
		return _choiceId;
	}

	public void setChoiceId(long choiceId) {
		_choiceId = choiceId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		if (!_setOriginalQuestionId) {
			_setOriginalQuestionId = true;

			_originalQuestionId = _questionId;
		}

		_questionId = questionId;
	}

	public long getOriginalQuestionId() {
		return _originalQuestionId;
	}

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

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	public String getDescription(String languageId) {
		String value = LocalizationUtil.getLocalization(getDescription(),
				languageId);

		if (isEscapedModel()) {
			return HtmlUtil.escape(value);
		}
		else {
			return value;
		}
	}

	public String getDescription(String languageId, boolean useDefault) {
		String value = LocalizationUtil.getLocalization(getDescription(),
				languageId, useDefault);

		if (isEscapedModel()) {
			return HtmlUtil.escape(value);
		}
		else {
			return value;
		}
	}

	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String description = descriptionMap.get(locale);

			setDescription(description, locale, defaultLocale);
		}
	}

	@Override
	public PollsChoice toEscapedModel() {
		if (isEscapedModel()) {
			return (PollsChoice)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (PollsChoice)Proxy.newProxyInstance(_classLoader,
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
					PollsChoice.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		PollsChoiceImpl pollsChoiceImpl = new PollsChoiceImpl();

		pollsChoiceImpl.setUuid(getUuid());
		pollsChoiceImpl.setChoiceId(getChoiceId());
		pollsChoiceImpl.setQuestionId(getQuestionId());
		pollsChoiceImpl.setName(getName());
		pollsChoiceImpl.setDescription(getDescription());

		pollsChoiceImpl.resetOriginalValues();

		return pollsChoiceImpl;
	}

	public int compareTo(PollsChoice pollsChoice) {
		int value = 0;

		if (getQuestionId() < pollsChoice.getQuestionId()) {
			value = -1;
		}
		else if (getQuestionId() > pollsChoice.getQuestionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(pollsChoice.getName());

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

		PollsChoice pollsChoice = null;

		try {
			pollsChoice = (PollsChoice)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pollsChoice.getPrimaryKey();

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
		PollsChoiceModelImpl pollsChoiceModelImpl = this;

		pollsChoiceModelImpl._originalQuestionId = pollsChoiceModelImpl._questionId;

		pollsChoiceModelImpl._setOriginalQuestionId = false;

		pollsChoiceModelImpl._originalName = pollsChoiceModelImpl._name;
	}

	@Override
	public CacheModel<PollsChoice> toCacheModel() {
		PollsChoiceCacheModel pollsChoiceCacheModel = new PollsChoiceCacheModel();

		pollsChoiceCacheModel.uuid = getUuid();

		String uuid = pollsChoiceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			pollsChoiceCacheModel.uuid = null;
		}

		pollsChoiceCacheModel.choiceId = getChoiceId();

		pollsChoiceCacheModel.questionId = getQuestionId();

		pollsChoiceCacheModel.name = getName();

		String name = pollsChoiceCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			pollsChoiceCacheModel.name = null;
		}

		pollsChoiceCacheModel.description = getDescription();

		String description = pollsChoiceCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			pollsChoiceCacheModel.description = null;
		}

		return pollsChoiceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", choiceId=");
		sb.append(getChoiceId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.polls.model.PollsChoice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>choiceId</column-name><column-value><![CDATA[");
		sb.append(getChoiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PollsChoice.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			PollsChoice.class
		};
	private String _uuid;
	private long _choiceId;
	private long _questionId;
	private long _originalQuestionId;
	private boolean _setOriginalQuestionId;
	private String _name;
	private String _originalName;
	private String _description;
	private transient ExpandoBridge _expandoBridge;
	private PollsChoice _escapedModelProxy;
}