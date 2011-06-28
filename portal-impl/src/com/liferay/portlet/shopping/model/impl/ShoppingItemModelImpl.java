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

package com.liferay.portlet.shopping.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.shopping.model.ShoppingItem;
import com.liferay.portlet.shopping.model.ShoppingItemModel;
import com.liferay.portlet.shopping.model.ShoppingItemSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the ShoppingItem service. Represents a row in the &quot;ShoppingItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.shopping.model.ShoppingItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImpl
 * @see com.liferay.portlet.shopping.model.ShoppingItem
 * @see com.liferay.portlet.shopping.model.ShoppingItemModel
 * @generated
 */
@JSON(strict = true)
public class ShoppingItemModelImpl extends BaseModelImpl<ShoppingItem>
	implements ShoppingItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping item model instance should use the {@link com.liferay.portlet.shopping.model.ShoppingItem} interface instead.
	 */
	public static final String TABLE_NAME = "ShoppingItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "categoryId", Types.BIGINT },
			{ "sku", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "properties", Types.VARCHAR },
			{ "fields_", Types.BOOLEAN },
			{ "fieldsQuantities", Types.VARCHAR },
			{ "minQuantity", Types.INTEGER },
			{ "maxQuantity", Types.INTEGER },
			{ "price", Types.DOUBLE },
			{ "discount", Types.DOUBLE },
			{ "taxable", Types.BOOLEAN },
			{ "shipping", Types.DOUBLE },
			{ "useShippingFormula", Types.BOOLEAN },
			{ "requiresShipping", Types.BOOLEAN },
			{ "stockQuantity", Types.INTEGER },
			{ "featured_", Types.BOOLEAN },
			{ "sale_", Types.BOOLEAN },
			{ "smallImage", Types.BOOLEAN },
			{ "smallImageId", Types.BIGINT },
			{ "smallImageURL", Types.VARCHAR },
			{ "mediumImage", Types.BOOLEAN },
			{ "mediumImageId", Types.BIGINT },
			{ "mediumImageURL", Types.VARCHAR },
			{ "largeImage", Types.BOOLEAN },
			{ "largeImageId", Types.BIGINT },
			{ "largeImageURL", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ShoppingItem (itemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,sku VARCHAR(75) null,name VARCHAR(200) null,description STRING null,properties STRING null,fields_ BOOLEAN,fieldsQuantities STRING null,minQuantity INTEGER,maxQuantity INTEGER,price DOUBLE,discount DOUBLE,taxable BOOLEAN,shipping DOUBLE,useShippingFormula BOOLEAN,requiresShipping BOOLEAN,stockQuantity INTEGER,featured_ BOOLEAN,sale_ BOOLEAN,smallImage BOOLEAN,smallImageId LONG,smallImageURL STRING null,mediumImage BOOLEAN,mediumImageId LONG,mediumImageURL STRING null,largeImage BOOLEAN,largeImageId LONG,largeImageURL STRING null)";
	public static final String TABLE_SQL_DROP = "drop table ShoppingItem";
	public static final String ORDER_BY_JPQL = " ORDER BY shoppingItem.itemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ShoppingItem.itemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.shopping.model.ShoppingItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.shopping.model.ShoppingItem"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ShoppingItem toModel(ShoppingItemSoap soapModel) {
		ShoppingItem model = new ShoppingItemImpl();

		model.setItemId(soapModel.getItemId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCategoryId(soapModel.getCategoryId());
		model.setSku(soapModel.getSku());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setProperties(soapModel.getProperties());
		model.setFields(soapModel.getFields());
		model.setFieldsQuantities(soapModel.getFieldsQuantities());
		model.setMinQuantity(soapModel.getMinQuantity());
		model.setMaxQuantity(soapModel.getMaxQuantity());
		model.setPrice(soapModel.getPrice());
		model.setDiscount(soapModel.getDiscount());
		model.setTaxable(soapModel.getTaxable());
		model.setShipping(soapModel.getShipping());
		model.setUseShippingFormula(soapModel.getUseShippingFormula());
		model.setRequiresShipping(soapModel.getRequiresShipping());
		model.setStockQuantity(soapModel.getStockQuantity());
		model.setFeatured(soapModel.getFeatured());
		model.setSale(soapModel.getSale());
		model.setSmallImage(soapModel.getSmallImage());
		model.setSmallImageId(soapModel.getSmallImageId());
		model.setSmallImageURL(soapModel.getSmallImageURL());
		model.setMediumImage(soapModel.getMediumImage());
		model.setMediumImageId(soapModel.getMediumImageId());
		model.setMediumImageURL(soapModel.getMediumImageURL());
		model.setLargeImage(soapModel.getLargeImage());
		model.setLargeImageId(soapModel.getLargeImageId());
		model.setLargeImageURL(soapModel.getLargeImageURL());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ShoppingItem> toModels(ShoppingItemSoap[] soapModels) {
		List<ShoppingItem> models = new ArrayList<ShoppingItem>(soapModels.length);

		for (ShoppingItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return ShoppingItem.class;
	}

	public String getModelClassName() {
		return ShoppingItem.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.shopping.model.ShoppingItem"));

	public ShoppingItemModelImpl() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@JSON
	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;

		_escapedModelProxy = null;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		_escapedModelProxy = null;
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

		_escapedModelProxy = null;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		_escapedModelProxy = null;
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

		_escapedModelProxy = null;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		_escapedModelProxy = null;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		_escapedModelProxy = null;
	}

	@JSON
	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		_escapedModelProxy = null;
	}

	@JSON
	public String getSku() {
		if (_sku == null) {
			return StringPool.BLANK;
		}
		else {
			return _sku;
		}
	}

	public void setSku(String sku) {
		if (_originalSku == null) {
			_originalSku = _sku;
		}

		_sku = sku;

		_escapedModelProxy = null;
	}

	public String getOriginalSku() {
		return GetterUtil.getString(_originalSku);
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
		_name = name;

		_escapedModelProxy = null;
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

		_escapedModelProxy = null;
	}

	@JSON
	public String getProperties() {
		if (_properties == null) {
			return StringPool.BLANK;
		}
		else {
			return _properties;
		}
	}

	public void setProperties(String properties) {
		_properties = properties;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getFields() {
		return _fields;
	}

	public boolean isFields() {
		return _fields;
	}

	public void setFields(boolean fields) {
		_fields = fields;

		_escapedModelProxy = null;
	}

	@JSON
	public String getFieldsQuantities() {
		if (_fieldsQuantities == null) {
			return StringPool.BLANK;
		}
		else {
			return _fieldsQuantities;
		}
	}

	public void setFieldsQuantities(String fieldsQuantities) {
		_fieldsQuantities = fieldsQuantities;

		_escapedModelProxy = null;
	}

	@JSON
	public int getMinQuantity() {
		return _minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		_minQuantity = minQuantity;

		_escapedModelProxy = null;
	}

	@JSON
	public int getMaxQuantity() {
		return _maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		_maxQuantity = maxQuantity;

		_escapedModelProxy = null;
	}

	@JSON
	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;

		_escapedModelProxy = null;
	}

	@JSON
	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getTaxable() {
		return _taxable;
	}

	public boolean isTaxable() {
		return _taxable;
	}

	public void setTaxable(boolean taxable) {
		_taxable = taxable;

		_escapedModelProxy = null;
	}

	@JSON
	public double getShipping() {
		return _shipping;
	}

	public void setShipping(double shipping) {
		_shipping = shipping;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getUseShippingFormula() {
		return _useShippingFormula;
	}

	public boolean isUseShippingFormula() {
		return _useShippingFormula;
	}

	public void setUseShippingFormula(boolean useShippingFormula) {
		_useShippingFormula = useShippingFormula;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getRequiresShipping() {
		return _requiresShipping;
	}

	public boolean isRequiresShipping() {
		return _requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		_requiresShipping = requiresShipping;

		_escapedModelProxy = null;
	}

	@JSON
	public int getStockQuantity() {
		return _stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		_stockQuantity = stockQuantity;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getFeatured() {
		return _featured;
	}

	public boolean isFeatured() {
		return _featured;
	}

	public void setFeatured(boolean featured) {
		_featured = featured;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getSale() {
		return _sale;
	}

	public boolean isSale() {
		return _sale;
	}

	public void setSale(boolean sale) {
		_sale = sale;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getSmallImage() {
		return _smallImage;
	}

	public boolean isSmallImage() {
		return _smallImage;
	}

	public void setSmallImage(boolean smallImage) {
		_smallImage = smallImage;

		_escapedModelProxy = null;
	}

	@JSON
	public long getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		if (!_setOriginalSmallImageId) {
			_setOriginalSmallImageId = true;

			_originalSmallImageId = _smallImageId;
		}

		_smallImageId = smallImageId;

		_escapedModelProxy = null;
	}

	public long getOriginalSmallImageId() {
		return _originalSmallImageId;
	}

	@JSON
	public String getSmallImageURL() {
		if (_smallImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _smallImageURL;
		}
	}

	public void setSmallImageURL(String smallImageURL) {
		_smallImageURL = smallImageURL;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getMediumImage() {
		return _mediumImage;
	}

	public boolean isMediumImage() {
		return _mediumImage;
	}

	public void setMediumImage(boolean mediumImage) {
		_mediumImage = mediumImage;

		_escapedModelProxy = null;
	}

	@JSON
	public long getMediumImageId() {
		return _mediumImageId;
	}

	public void setMediumImageId(long mediumImageId) {
		if (!_setOriginalMediumImageId) {
			_setOriginalMediumImageId = true;

			_originalMediumImageId = _mediumImageId;
		}

		_mediumImageId = mediumImageId;

		_escapedModelProxy = null;
	}

	public long getOriginalMediumImageId() {
		return _originalMediumImageId;
	}

	@JSON
	public String getMediumImageURL() {
		if (_mediumImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _mediumImageURL;
		}
	}

	public void setMediumImageURL(String mediumImageURL) {
		_mediumImageURL = mediumImageURL;

		_escapedModelProxy = null;
	}

	@JSON
	public boolean getLargeImage() {
		return _largeImage;
	}

	public boolean isLargeImage() {
		return _largeImage;
	}

	public void setLargeImage(boolean largeImage) {
		_largeImage = largeImage;

		_escapedModelProxy = null;
	}

	@JSON
	public long getLargeImageId() {
		return _largeImageId;
	}

	public void setLargeImageId(long largeImageId) {
		if (!_setOriginalLargeImageId) {
			_setOriginalLargeImageId = true;

			_originalLargeImageId = _largeImageId;
		}

		_largeImageId = largeImageId;

		_escapedModelProxy = null;
	}

	public long getOriginalLargeImageId() {
		return _originalLargeImageId;
	}

	@JSON
	public String getLargeImageURL() {
		if (_largeImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _largeImageURL;
		}
	}

	public void setLargeImageURL(String largeImageURL) {
		_largeImageURL = largeImageURL;

		_escapedModelProxy = null;
	}

	@Override
	public ShoppingItem toEscapedModel() {
		if (isEscapedModel()) {
			return (ShoppingItem)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (ShoppingItem)Proxy.newProxyInstance(_classLoader,
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
					ShoppingItem.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		ShoppingItemImpl shoppingItemImpl = new ShoppingItemImpl();

		shoppingItemImpl.setItemId(getItemId());
		shoppingItemImpl.setGroupId(getGroupId());
		shoppingItemImpl.setCompanyId(getCompanyId());
		shoppingItemImpl.setUserId(getUserId());
		shoppingItemImpl.setUserName(getUserName());
		shoppingItemImpl.setCreateDate(getCreateDate());
		shoppingItemImpl.setModifiedDate(getModifiedDate());
		shoppingItemImpl.setCategoryId(getCategoryId());
		shoppingItemImpl.setSku(getSku());
		shoppingItemImpl.setName(getName());
		shoppingItemImpl.setDescription(getDescription());
		shoppingItemImpl.setProperties(getProperties());
		shoppingItemImpl.setFields(getFields());
		shoppingItemImpl.setFieldsQuantities(getFieldsQuantities());
		shoppingItemImpl.setMinQuantity(getMinQuantity());
		shoppingItemImpl.setMaxQuantity(getMaxQuantity());
		shoppingItemImpl.setPrice(getPrice());
		shoppingItemImpl.setDiscount(getDiscount());
		shoppingItemImpl.setTaxable(getTaxable());
		shoppingItemImpl.setShipping(getShipping());
		shoppingItemImpl.setUseShippingFormula(getUseShippingFormula());
		shoppingItemImpl.setRequiresShipping(getRequiresShipping());
		shoppingItemImpl.setStockQuantity(getStockQuantity());
		shoppingItemImpl.setFeatured(getFeatured());
		shoppingItemImpl.setSale(getSale());
		shoppingItemImpl.setSmallImage(getSmallImage());
		shoppingItemImpl.setSmallImageId(getSmallImageId());
		shoppingItemImpl.setSmallImageURL(getSmallImageURL());
		shoppingItemImpl.setMediumImage(getMediumImage());
		shoppingItemImpl.setMediumImageId(getMediumImageId());
		shoppingItemImpl.setMediumImageURL(getMediumImageURL());
		shoppingItemImpl.setLargeImage(getLargeImage());
		shoppingItemImpl.setLargeImageId(getLargeImageId());
		shoppingItemImpl.setLargeImageURL(getLargeImageURL());

		shoppingItemImpl.resetOriginalValues();

		return shoppingItemImpl;
	}

	public int compareTo(ShoppingItem shoppingItem) {
		int value = 0;

		if (getItemId() < shoppingItem.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItem.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		ShoppingItem shoppingItem = null;

		try {
			shoppingItem = (ShoppingItem)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = shoppingItem.getPrimaryKey();

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
		ShoppingItemModelImpl shoppingItemModelImpl = this;

		shoppingItemModelImpl._originalCompanyId = shoppingItemModelImpl._companyId;

		shoppingItemModelImpl._setOriginalCompanyId = false;

		shoppingItemModelImpl._originalSku = shoppingItemModelImpl._sku;

		shoppingItemModelImpl._originalSmallImageId = shoppingItemModelImpl._smallImageId;

		shoppingItemModelImpl._setOriginalSmallImageId = false;

		shoppingItemModelImpl._originalMediumImageId = shoppingItemModelImpl._mediumImageId;

		shoppingItemModelImpl._setOriginalMediumImageId = false;

		shoppingItemModelImpl._originalLargeImageId = shoppingItemModelImpl._largeImageId;

		shoppingItemModelImpl._setOriginalLargeImageId = false;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{itemId=");
		sb.append(getItemId());
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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", sku=");
		sb.append(getSku());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", fields=");
		sb.append(getFields());
		sb.append(", fieldsQuantities=");
		sb.append(getFieldsQuantities());
		sb.append(", minQuantity=");
		sb.append(getMinQuantity());
		sb.append(", maxQuantity=");
		sb.append(getMaxQuantity());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", taxable=");
		sb.append(getTaxable());
		sb.append(", shipping=");
		sb.append(getShipping());
		sb.append(", useShippingFormula=");
		sb.append(getUseShippingFormula());
		sb.append(", requiresShipping=");
		sb.append(getRequiresShipping());
		sb.append(", stockQuantity=");
		sb.append(getStockQuantity());
		sb.append(", featured=");
		sb.append(getFeatured());
		sb.append(", sale=");
		sb.append(getSale());
		sb.append(", smallImage=");
		sb.append(getSmallImage());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", smallImageURL=");
		sb.append(getSmallImageURL());
		sb.append(", mediumImage=");
		sb.append(getMediumImage());
		sb.append(", mediumImageId=");
		sb.append(getMediumImageId());
		sb.append(", mediumImageURL=");
		sb.append(getMediumImageURL());
		sb.append(", largeImage=");
		sb.append(getLargeImage());
		sb.append(", largeImageId=");
		sb.append(getLargeImageId());
		sb.append(", largeImageURL=");
		sb.append(getLargeImageURL());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(106);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.shopping.model.ShoppingItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sku</column-name><column-value><![CDATA[");
		sb.append(getSku());
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
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fields</column-name><column-value><![CDATA[");
		sb.append(getFields());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fieldsQuantities</column-name><column-value><![CDATA[");
		sb.append(getFieldsQuantities());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minQuantity</column-name><column-value><![CDATA[");
		sb.append(getMinQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxQuantity</column-name><column-value><![CDATA[");
		sb.append(getMaxQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxable</column-name><column-value><![CDATA[");
		sb.append(getTaxable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipping</column-name><column-value><![CDATA[");
		sb.append(getShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useShippingFormula</column-name><column-value><![CDATA[");
		sb.append(getUseShippingFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiresShipping</column-name><column-value><![CDATA[");
		sb.append(getRequiresShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stockQuantity</column-name><column-value><![CDATA[");
		sb.append(getStockQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>featured</column-name><column-value><![CDATA[");
		sb.append(getFeatured());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sale</column-name><column-value><![CDATA[");
		sb.append(getSale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImage</column-name><column-value><![CDATA[");
		sb.append(getSmallImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageURL</column-name><column-value><![CDATA[");
		sb.append(getSmallImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediumImage</column-name><column-value><![CDATA[");
		sb.append(getMediumImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediumImageId</column-name><column-value><![CDATA[");
		sb.append(getMediumImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediumImageURL</column-name><column-value><![CDATA[");
		sb.append(getMediumImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImage</column-name><column-value><![CDATA[");
		sb.append(getLargeImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageId</column-name><column-value><![CDATA[");
		sb.append(getLargeImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageURL</column-name><column-value><![CDATA[");
		sb.append(getLargeImageURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ShoppingItem.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ShoppingItem.class
		};
	private long _itemId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private String _sku;
	private String _originalSku;
	private String _name;
	private String _description;
	private String _properties;
	private boolean _fields;
	private String _fieldsQuantities;
	private int _minQuantity;
	private int _maxQuantity;
	private double _price;
	private double _discount;
	private boolean _taxable;
	private double _shipping;
	private boolean _useShippingFormula;
	private boolean _requiresShipping;
	private int _stockQuantity;
	private boolean _featured;
	private boolean _sale;
	private boolean _smallImage;
	private long _smallImageId;
	private long _originalSmallImageId;
	private boolean _setOriginalSmallImageId;
	private String _smallImageURL;
	private boolean _mediumImage;
	private long _mediumImageId;
	private long _originalMediumImageId;
	private boolean _setOriginalMediumImageId;
	private String _mediumImageURL;
	private boolean _largeImage;
	private long _largeImageId;
	private long _originalLargeImageId;
	private boolean _setOriginalLargeImageId;
	private String _largeImageURL;
	private transient ExpandoBridge _expandoBridge;
	private ShoppingItem _escapedModelProxy;
}