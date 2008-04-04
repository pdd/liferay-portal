/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.documentlibrary.service;


/**
 * <a href="DLFileRankLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.documentlibrary.service.impl.DLFileRankLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.documentlibrary.service.DLFileRankLocalServiceFactory
 * @see com.liferay.portlet.documentlibrary.service.DLFileRankLocalServiceUtil
 *
 */
public interface DLFileRankLocalService {
	public com.liferay.portlet.documentlibrary.model.DLFileRank addDLFileRank(
		com.liferay.portlet.documentlibrary.model.DLFileRank dlFileRank)
		throws com.liferay.portal.SystemException;

	public void deleteDLFileRank(long fileRankId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteDLFileRank(
		com.liferay.portlet.documentlibrary.model.DLFileRank dlFileRank)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileRank> dynamicQuery(
		com.liferay.portal.kernel.dao.DynamicQueryInitializer queryInitializer)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileRank> dynamicQuery(
		com.liferay.portal.kernel.dao.DynamicQueryInitializer queryInitializer,
		int begin, int end) throws com.liferay.portal.SystemException;

	public com.liferay.portlet.documentlibrary.model.DLFileRank updateDLFileRank(
		com.liferay.portlet.documentlibrary.model.DLFileRank dlFileRank)
		throws com.liferay.portal.SystemException;

	public void deleteFileRanks(long userId)
		throws com.liferay.portal.SystemException;

	public void deleteFileRanks(long folderId, java.lang.String name)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileRank> getFileRanks(
		long groupId, long userId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileRank> getFileRanks(
		long groupId, long userId, int begin, int end)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.documentlibrary.model.DLFileRank updateFileRank(
		long groupId, long companyId, long userId, long folderId,
		java.lang.String name)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;
}