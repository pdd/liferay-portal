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

package com.liferay.portal.model;

/**
 * <p>
 * This class is a wrapper for {@link LayoutBranch}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutBranch
 * @generated
 */
public class LayoutBranchWrapper implements LayoutBranch {
	public LayoutBranchWrapper(LayoutBranch layoutBranch) {
		_layoutBranch = layoutBranch;
	}

	public Class<?> getModelClass() {
		return LayoutBranch.class;
	}

	public String getModelClassName() {
		return LayoutBranch.class.getName();
	}

	/**
	* Returns the primary key of this layout branch.
	*
	* @return the primary key of this layout branch
	*/
	public long getPrimaryKey() {
		return _layoutBranch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this layout branch.
	*
	* @param primaryKey the primary key of this layout branch
	*/
	public void setPrimaryKey(long primaryKey) {
		_layoutBranch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the layout branch ID of this layout branch.
	*
	* @return the layout branch ID of this layout branch
	*/
	public long getLayoutBranchId() {
		return _layoutBranch.getLayoutBranchId();
	}

	/**
	* Sets the layout branch ID of this layout branch.
	*
	* @param LayoutBranchId the layout branch ID of this layout branch
	*/
	public void setLayoutBranchId(long LayoutBranchId) {
		_layoutBranch.setLayoutBranchId(LayoutBranchId);
	}

	/**
	* Returns the group ID of this layout branch.
	*
	* @return the group ID of this layout branch
	*/
	public long getGroupId() {
		return _layoutBranch.getGroupId();
	}

	/**
	* Sets the group ID of this layout branch.
	*
	* @param groupId the group ID of this layout branch
	*/
	public void setGroupId(long groupId) {
		_layoutBranch.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this layout branch.
	*
	* @return the company ID of this layout branch
	*/
	public long getCompanyId() {
		return _layoutBranch.getCompanyId();
	}

	/**
	* Sets the company ID of this layout branch.
	*
	* @param companyId the company ID of this layout branch
	*/
	public void setCompanyId(long companyId) {
		_layoutBranch.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this layout branch.
	*
	* @return the user ID of this layout branch
	*/
	public long getUserId() {
		return _layoutBranch.getUserId();
	}

	/**
	* Sets the user ID of this layout branch.
	*
	* @param userId the user ID of this layout branch
	*/
	public void setUserId(long userId) {
		_layoutBranch.setUserId(userId);
	}

	/**
	* Returns the user uuid of this layout branch.
	*
	* @return the user uuid of this layout branch
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layoutBranch.getUserUuid();
	}

	/**
	* Sets the user uuid of this layout branch.
	*
	* @param userUuid the user uuid of this layout branch
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_layoutBranch.setUserUuid(userUuid);
	}

	/**
	* Returns the layout set branch ID of this layout branch.
	*
	* @return the layout set branch ID of this layout branch
	*/
	public long getLayoutSetBranchId() {
		return _layoutBranch.getLayoutSetBranchId();
	}

	/**
	* Sets the layout set branch ID of this layout branch.
	*
	* @param layoutSetBranchId the layout set branch ID of this layout branch
	*/
	public void setLayoutSetBranchId(long layoutSetBranchId) {
		_layoutBranch.setLayoutSetBranchId(layoutSetBranchId);
	}

	/**
	* Returns the plid of this layout branch.
	*
	* @return the plid of this layout branch
	*/
	public long getPlid() {
		return _layoutBranch.getPlid();
	}

	/**
	* Sets the plid of this layout branch.
	*
	* @param plid the plid of this layout branch
	*/
	public void setPlid(long plid) {
		_layoutBranch.setPlid(plid);
	}

	/**
	* Returns the name of this layout branch.
	*
	* @return the name of this layout branch
	*/
	public java.lang.String getName() {
		return _layoutBranch.getName();
	}

	/**
	* Sets the name of this layout branch.
	*
	* @param name the name of this layout branch
	*/
	public void setName(java.lang.String name) {
		_layoutBranch.setName(name);
	}

	/**
	* Returns the description of this layout branch.
	*
	* @return the description of this layout branch
	*/
	public java.lang.String getDescription() {
		return _layoutBranch.getDescription();
	}

	/**
	* Sets the description of this layout branch.
	*
	* @param description the description of this layout branch
	*/
	public void setDescription(java.lang.String description) {
		_layoutBranch.setDescription(description);
	}

	/**
	* Returns the master of this layout branch.
	*
	* @return the master of this layout branch
	*/
	public boolean getMaster() {
		return _layoutBranch.getMaster();
	}

	/**
	* Returns <code>true</code> if this layout branch is master.
	*
	* @return <code>true</code> if this layout branch is master; <code>false</code> otherwise
	*/
	public boolean isMaster() {
		return _layoutBranch.isMaster();
	}

	/**
	* Sets whether this layout branch is master.
	*
	* @param master the master of this layout branch
	*/
	public void setMaster(boolean master) {
		_layoutBranch.setMaster(master);
	}

	public boolean isNew() {
		return _layoutBranch.isNew();
	}

	public void setNew(boolean n) {
		_layoutBranch.setNew(n);
	}

	public boolean isCachedModel() {
		return _layoutBranch.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_layoutBranch.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _layoutBranch.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_layoutBranch.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _layoutBranch.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_layoutBranch.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _layoutBranch.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_layoutBranch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LayoutBranchWrapper((LayoutBranch)_layoutBranch.clone());
	}

	public int compareTo(LayoutBranch layoutBranch) {
		return _layoutBranch.compareTo(layoutBranch);
	}

	@Override
	public int hashCode() {
		return _layoutBranch.hashCode();
	}

	public com.liferay.portal.model.CacheModel<LayoutBranch> toCacheModel() {
		return _layoutBranch.toCacheModel();
	}

	public LayoutBranch toEscapedModel() {
		return new LayoutBranchWrapper(_layoutBranch.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _layoutBranch.toString();
	}

	public java.lang.String toXmlString() {
		return _layoutBranch.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_layoutBranch.persist();
	}

	public LayoutBranch getWrappedLayoutBranch() {
		return _layoutBranch;
	}

	public void resetOriginalValues() {
		_layoutBranch.resetOriginalValues();
	}

	private LayoutBranch _layoutBranch;
}