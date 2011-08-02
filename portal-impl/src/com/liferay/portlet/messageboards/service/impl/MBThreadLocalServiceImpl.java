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

package com.liferay.portlet.messageboards.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.DuplicateDirectoryException;
import com.liferay.portlet.documentlibrary.NoSuchDirectoryException;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.messageboards.SplitThreadException;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBMessageFlag;
import com.liferay.portlet.messageboards.model.MBMessageFlagConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBThreadConstants;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.base.MBThreadLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class MBThreadLocalServiceImpl extends MBThreadLocalServiceBaseImpl {

	public void deleteThread(long threadId)
		throws PortalException, SystemException {

		MBThread thread = mbThreadPersistence.findByPrimaryKey(threadId);

		deleteThread(thread);
	}

	public void deleteThread(MBThread thread)
		throws PortalException, SystemException {

		MBMessage rootMessage = mbMessagePersistence.findByPrimaryKey(
			thread.getRootMessageId());

		// Indexer

		Indexer indexer = IndexerRegistryUtil.getIndexer(MBMessage.class);

		indexer.delete(thread);

		// Attachments

		long companyId = rootMessage.getCompanyId();
		long repositoryId = CompanyConstants.SYSTEM;
		String dirName = thread.getAttachmentsDir();

		try {
			DLStoreUtil.deleteDirectory(companyId, repositoryId, dirName);
		}
		catch (NoSuchDirectoryException nsde) {
		}

		// Messages

		List<MBMessage> messages = mbMessagePersistence.findByThreadId(
			thread.getThreadId());

		for (MBMessage message : messages) {

			// Social

			socialActivityLocalService.deleteActivities(
				MBMessage.class.getName(), message.getMessageId());

			// Ratings

			ratingsStatsLocalService.deleteStats(
				MBMessage.class.getName(), message.getMessageId());

			// Asset

			assetEntryLocalService.deleteEntry(
				MBMessage.class.getName(), message.getMessageId());

			// Message flags

			mbMessageFlagPersistence.removeByMessageId(message.getMessageId());

			// Resources

			if (!message.isDiscussion()) {
				resourceLocalService.deleteResource(
					message.getCompanyId(), MBMessage.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, message.getMessageId());
			}

			// Message

			mbMessagePersistence.remove(message);

			// Statistics

			if (!message.isDiscussion()) {
				mbStatsUserLocalService.updateStatsUser(
					message.getGroupId(), message.getUserId());
			}

			// Workflow

			workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(
				message.getCompanyId(), message.getGroupId(),
				message.getWorkflowClassName(), message.getMessageId());
		}

		// Category

		if ((rootMessage.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(rootMessage.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			MBCategory category = mbCategoryPersistence.findByPrimaryKey(
				thread.getCategoryId());

			category.setThreadCount(category.getThreadCount() - 1);
			category.setMessageCount(
				category.getMessageCount() - messages.size());

			mbCategoryPersistence.update(category, false);
		}

		// Thread

		mbThreadPersistence.remove(thread);
	}

	public void deleteThreads(long groupId, long categoryId)
		throws PortalException, SystemException {

		List<MBThread> threads = mbThreadPersistence.findByG_C(
			groupId, categoryId);

		for (MBThread thread : threads) {
			deleteThread(thread);
		}
	}

	public int getCategoryThreadsCount(
			long groupId, long categoryId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbThreadPersistence.countByG_C(groupId, categoryId);
		}
		else {
			return mbThreadPersistence.countByG_C_S(
				groupId, categoryId, status);
		}
	}

	public List<MBThread> getGroupThreads(
			long groupId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbThreadPersistence.findByG_NotC(
				groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID, start,
				end);
		}
		else {
			return mbThreadPersistence.findByG_NotC_S(
				groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID, status,
				start, end);
		}
	}

	public List<MBThread> getGroupThreads(
			long groupId, long userId, int status, boolean subscribed,
			boolean includeAnonymous, int start, int end)
		throws PortalException, SystemException {

		if (userId <= 0) {
			if (status == WorkflowConstants.STATUS_ANY) {
				return mbThreadPersistence.findByG_NotC(
					groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID, start,
					end);
			}
			else {
				return mbThreadPersistence.findByG_NotC_S(
					groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID, status,
					start, end);
			}
		}
		else {
			if (subscribed) {
				return mbThreadFinder.findByS_G_U_C_S(
					groupId, userId, null, status, start, end);
			}
			else {
				List<Long> threadIds = null;

				if (includeAnonymous) {
					threadIds = mbMessageFinder.findByG_U_C_S(
						groupId, userId, null, status, start, end);
				}
				else {
					threadIds = mbMessageFinder.findByG_U_C_A_S(
						groupId, userId, null, false, status, start, end);
				}

				List<MBThread> threads = new ArrayList<MBThread>(
					threadIds.size());

				for (long threadId : threadIds) {
					MBThread thread = mbThreadPersistence.findByPrimaryKey(
						threadId);

					threads.add(thread);
				}

				return threads;
			}
		}
	}

	public List<MBThread> getGroupThreads(
			long groupId, long userId, int status, boolean subscribed,
			int start, int end)
		throws PortalException, SystemException {

		return getGroupThreads(
			groupId, userId, status, subscribed, true, start, end);
	}

	public List<MBThread> getGroupThreads(
			long groupId, long userId, int status, int start, int end)
		throws PortalException, SystemException {

		return getGroupThreads(groupId, userId, status, false, start, end);
	}

	public int getGroupThreadsCount(long groupId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbThreadPersistence.countByG_NotC(
				groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID);
		}
		else {
			return mbThreadPersistence.countByG_NotC_S(
				groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID, status);
		}
	}

	public int getGroupThreadsCount(long groupId, long userId, int status)
		throws SystemException {

		return getGroupThreadsCount(groupId, userId, status, false);
	}

	public int getGroupThreadsCount(
			long groupId, long userId, int status, boolean subscribed)
		throws SystemException {

		return getGroupThreadsCount(groupId, userId, status, subscribed, true);
	}

	public int getGroupThreadsCount(
			long groupId, long userId, int status, boolean subscribed,
			boolean includeAnonymous)
		throws SystemException {

		if (userId <= 0) {
			if (status == WorkflowConstants.STATUS_ANY) {
				return mbThreadPersistence.countByG_NotC(
					groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID);
			}
			else {
				return mbThreadPersistence.countByG_NotC_S(
					groupId, MBCategoryConstants.DISCUSSION_CATEGORY_ID,
					status);
			}
		}
		else {
			if (subscribed) {
				return mbThreadFinder.countByS_G_U_C_S(
					groupId, userId, null, status);
			}
			else {
				if (includeAnonymous) {
					return mbMessageFinder.countByG_U_C_S(
						groupId, userId, null, status);
				}
				else {
					return mbMessageFinder.countByG_U_C_A_S(
						groupId, userId, null, false, status);
				}
			}
		}
	}

	public List<MBThread> getPriorityThreads(long categoryId, double priority)
		throws PortalException, SystemException {

		return getPriorityThreads(categoryId, priority, false);
	}

	public List<MBThread> getPriorityThreads(
			long categoryId, double priority, boolean inherit)
		throws PortalException, SystemException {

		if (!inherit) {
			return mbThreadPersistence.findByC_P(categoryId, priority);
		}

		List<MBThread> threads = new ArrayList<MBThread>();

		while ((categoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			   (categoryId != MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			threads.addAll(
				0, mbThreadPersistence.findByC_P(categoryId, priority));

			MBCategory category = mbCategoryPersistence.findByPrimaryKey(
				categoryId);

			categoryId = category.getParentCategoryId();
		}

		return threads;
	}

	public MBThread getThread(long threadId)
		throws PortalException, SystemException {

		return mbThreadPersistence.findByPrimaryKey(threadId);
	}

	public List<MBThread> getThreads(
			long groupId, long categoryId, int status, int start, int end)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbThreadPersistence.findByG_C(
				groupId, categoryId, start, end);
		}
		else {
			return mbThreadPersistence.findByG_C_S(
				groupId, categoryId, status, start, end);
		}
	}

	public int getThreadsCount(long groupId, long categoryId, int status)
		throws SystemException {

		if (status == WorkflowConstants.STATUS_ANY) {
			return mbThreadPersistence.countByG_C(groupId, categoryId);
		}
		else {
			return mbThreadPersistence.countByG_C_S(
				groupId, categoryId, status);
		}
	}

	public MBThread moveThread(long groupId, long categoryId, long threadId)
		throws PortalException, SystemException {

		MBThread thread = mbThreadPersistence.findByPrimaryKey(
			threadId);

		long oldCategoryId = thread.getCategoryId();

		MBCategory oldCategory = null;

		if (oldCategoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
			oldCategory = mbCategoryPersistence.findByPrimaryKey(
				oldCategoryId);
		}

		MBCategory category = null;

		if (categoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
			category = mbCategoryPersistence.findByPrimaryKey(
				categoryId);
		}

		// Messages

		List<MBMessage> messages = mbMessagePersistence.findByG_C_T(
			groupId, oldCategoryId, thread.getThreadId());

		for (MBMessage message : messages) {
			message.setCategoryId(categoryId);

			mbMessagePersistence.update(message, false);

			// Indexer

			if (!message.isDiscussion()) {
				Indexer indexer = IndexerRegistryUtil.getIndexer(
					MBMessage.class);

				indexer.reindex(message);
			}
		}

		// Thread

		thread.setCategoryId(categoryId);

		mbThreadPersistence.update(thread, false);

		// Category

		if ((oldCategory != null) && (categoryId != oldCategoryId)) {
			oldCategory.setThreadCount(oldCategory.getThreadCount() - 1);
			oldCategory.setMessageCount(
				oldCategory.getMessageCount() - messages.size());

			mbCategoryPersistence.update(oldCategory, false);
		}

		if ((category != null) && (categoryId != oldCategoryId)) {
			category.setThreadCount(category.getThreadCount() + 1);
			category.setMessageCount(
				category.getMessageCount() + messages.size());

			mbCategoryPersistence.update(category, false);
		}

		return thread;
	}

	public MBThread splitThread(
			long messageId, String subject, ServiceContext serviceContext)
		throws PortalException, SystemException {

		MBMessage message = mbMessagePersistence.findByPrimaryKey(messageId);

		if (message.isRoot()) {
			throw new SplitThreadException();
		}

		MBCategory category = message.getCategory();
		MBThread oldThread = message.getThread();
		MBMessage rootMessage = mbMessagePersistence.findByPrimaryKey(
			oldThread.getRootMessageId());
		String oldAttachmentsDir = message.getAttachmentsDir();

		// Message flags

		mbMessageFlagLocalService.deleteAnswerFlags(
			oldThread.getThreadId(), message.getMessageId());

		int count = mbMessageFlagPersistence.countByT_F(
			oldThread.getThreadId(), MBMessageFlagConstants.ANSWER_FLAG);

		if (count == 1) {
			MBMessageFlag messageFlag = mbMessageFlagPersistence.fetchByU_M_F(
				rootMessage.getUserId(), rootMessage.getMessageId(),
				MBMessageFlagConstants.ANSWER_FLAG);

			messageFlag.setFlag(MBMessageFlagConstants.QUESTION_FLAG);

			mbMessageFlagPersistence.update(messageFlag, false);
		}

		// Create new thread

		MBThread thread = addThread(message.getCategoryId(), message);

		// Update messages

		if (Validator.isNotNull(subject)) {
			MBMessageDisplay messageDisplay =
				mbMessageService.getMessageDisplay(
					messageId, WorkflowConstants.STATUS_ANY,
					MBThreadConstants.THREAD_VIEW_TREE, false);

			MBTreeWalker treeWalker = messageDisplay.getTreeWalker();

			List<MBMessage> messages = treeWalker.getMessages();

			int[] range = treeWalker.getChildrenRange(message);

			for (int i = range[0]; i < range[1]; i++) {
				MBMessage curMessage = messages.get(i);

				String oldSubject = message.getSubject();
				String curSubject = curMessage.getSubject();

				if (oldSubject.startsWith("RE: ")) {
					curSubject = StringUtil.replace(
						curSubject, rootMessage.getSubject(), subject);
				}
				else {
					curSubject = StringUtil.replace(
						curSubject, oldSubject, subject);
				}

				curMessage.setSubject(curSubject);

				mbMessagePersistence.update(curMessage, false);
			}

			message.setSubject(subject);
		}

		message.setThreadId(thread.getThreadId());
		message.setRootMessageId(thread.getRootMessageId());
		message.setParentMessageId(0);
		message.setAttachmentsDir(null);

		mbMessagePersistence.update(message, false);

		// Attachments

		moveAttachmentsFromOldThread(message, oldAttachmentsDir);

		// Indexer

		if (!message.isDiscussion()) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(MBMessage.class);

			indexer.reindex(message);
		}

		// Update children

		int messagesMoved = 1;

		messagesMoved += moveChildrenMessages(
			message, category, oldThread.getThreadId());

		// Update new thread

		thread.setMessageCount(messagesMoved);

		mbThreadPersistence.update(thread, false);

		// Update old thread

		oldThread.setMessageCount(oldThread.getMessageCount() - messagesMoved);

		mbThreadPersistence.update(oldThread, false);

		// Category

		if ((message.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(message.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			category.setThreadCount(category.getThreadCount() + 1);

			mbCategoryPersistence.update(category, false);
		}

		return thread;
	}

	public MBThread updateThread(long threadId, int viewCount)
		throws PortalException, SystemException {

		MBThread thread = mbThreadPersistence.findByPrimaryKey(threadId);

		thread.setViewCount(viewCount);

		mbThreadPersistence.update(thread, false);

		return thread;
	}

	protected MBThread addThread(long categoryId, MBMessage message)
		throws SystemException {

		long threadId = counterLocalService.increment();

		MBThread thread = mbThreadPersistence.create(threadId);

		thread.setGroupId(message.getGroupId());
		thread.setCompanyId(message.getCompanyId());
		thread.setCategoryId(categoryId);
		thread.setRootMessageId(message.getMessageId());
		thread.setRootMessageUserId(message.getUserId());
		thread.setStatus(message.getStatus());
		thread.setStatusByUserId(message.getStatusByUserId());
		thread.setStatusByUserName(message.getStatusByUserName());
		thread.setStatusDate(message.getStatusDate());

		thread.setMessageCount(thread.getMessageCount() + 1);

		if (message.isAnonymous()) {
			thread.setLastPostByUserId(0);
		}
		else {
			thread.setLastPostByUserId(message.getUserId());
		}

		thread.setLastPostDate(message.getCreateDate());

		if (message.getPriority() != MBThreadConstants.PRIORITY_NOT_GIVEN) {
			thread.setPriority(message.getPriority());
		}

		mbThreadPersistence.update(thread, false);

		return thread;
	}

	protected void moveAttachmentsFromOldThread(
			MBMessage message, String oldAttachmentsDir)
		throws PortalException, SystemException {

		if (!message.getAttachments()) {
			return;
		}

		long companyId = message.getCompanyId();
		long repositoryId = CompanyConstants.SYSTEM;
		String newAttachmentsDir = message.getAttachmentsDir();

		try {
			DLStoreUtil.addDirectory(
				companyId, repositoryId, newAttachmentsDir);
		}
		catch (DuplicateDirectoryException dde) {
		}

		String[] fileNames = DLStoreUtil.getFileNames(
			companyId, repositoryId, oldAttachmentsDir);

		for (String fileName : fileNames) {
			String name = StringUtil.extractLast(fileName, StringPool.SLASH);
			byte[] fileBytes = DLStoreUtil.getFile(
				companyId, repositoryId, fileName);

			DLStoreUtil.addFile(
				companyId, repositoryId, newAttachmentsDir + "/" + name,
				fileBytes);

			DLStoreUtil.deleteFile(companyId, repositoryId, fileName);
		}

		try {
			DLStoreUtil.deleteDirectory(
				companyId, repositoryId, oldAttachmentsDir);
		}
		catch (NoSuchDirectoryException nsde) {
		}
	}

	protected int moveChildrenMessages(
			MBMessage parentMessage, MBCategory category, long oldThreadId)
		throws PortalException, SystemException {

		int messagesMoved = 0;

		List<MBMessage> messages = mbMessagePersistence.findByT_P(
			oldThreadId, parentMessage.getMessageId());

		for (MBMessage message : messages) {
			String oldAttachmentsDir = message.getAttachmentsDir();

			message.setCategoryId(parentMessage.getCategoryId());
			message.setThreadId(parentMessage.getThreadId());
			message.setRootMessageId(parentMessage.getRootMessageId());
			message.setAttachmentsDir(null);

			mbMessagePersistence.update(message, false);

			moveAttachmentsFromOldThread(message, oldAttachmentsDir);

			if (!message.isDiscussion()) {
				Indexer indexer = IndexerRegistryUtil.getIndexer(
					MBMessage.class);

				indexer.reindex(message);
			}

			messagesMoved++;

			messagesMoved += moveChildrenMessages(
				message, category, oldThreadId);
		}

		return messagesMoved;
	}

}