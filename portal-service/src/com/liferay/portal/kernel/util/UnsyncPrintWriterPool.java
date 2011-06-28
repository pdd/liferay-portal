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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.io.OutputStreamWriter;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.memory.PoolAction;
import com.liferay.portal.kernel.memory.SoftReferencePool;

import java.io.OutputStream;
import java.io.Writer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shuyang Zhou
 */
public class UnsyncPrintWriterPool {

	public static UnsyncPrintWriter borrow(OutputStream outputStream) {
		return borrow(new OutputStreamWriter(outputStream));
	}

	public static UnsyncPrintWriter borrow(Writer writer) {
		if (!isEnabled()) {
			return new UnsyncPrintWriter(writer);
		}

		UnsyncPrintWriter unsyncPrintWriter =
			_unsyncPrintWriterPool.borrowObject(writer);

		_borrowedUnsyncPrintWritersThreadLocal.get().add(unsyncPrintWriter);

		return unsyncPrintWriter;
	}

	public static void cleanUp() {
		List<UnsyncPrintWriter> unsyncPrintWriters =
			_borrowedUnsyncPrintWritersThreadLocal.get();

		for (UnsyncPrintWriter unsyncPrintWriter : unsyncPrintWriters) {
			_unsyncPrintWriterPool.returnObject(unsyncPrintWriter);
		}

		unsyncPrintWriters.clear();
	}

	public static boolean isEnabled() {
		return _enabledThreadLocal.get();
	}

	public static void setEnabled(boolean enabled) {
		_enabledThreadLocal.set(enabled);
	}

	private static final int POOL_SIZE = 8192;

	private static ThreadLocal<List<UnsyncPrintWriter>>
		_borrowedUnsyncPrintWritersThreadLocal =
			new AutoResetThreadLocal<List<UnsyncPrintWriter>>(
				CharBufferPool.class.getName()
					+ "._borrowedUnsyncPrintWritersThreadLocal",
				new ArrayList<UnsyncPrintWriter>());

	private static final ThreadLocal<Boolean> _enabledThreadLocal =
		new AutoResetThreadLocal<Boolean>(
			CharBufferPool.class.getName() + "._enabledThreadLocal", false);

	private static final SoftReferencePool<UnsyncPrintWriter, Writer>
		_unsyncPrintWriterPool =
			new SoftReferencePool<UnsyncPrintWriter, Writer>(
				new PoolAction<UnsyncPrintWriter, Writer>() {

					public UnsyncPrintWriter onBorrow(
						UnsyncPrintWriter output, Writer input) {
						output.reset(input);

						return output;
					}

					public UnsyncPrintWriter onCreate(Writer input) {
						return new UnsyncPrintWriter(input);
					}

					public void onReturn(UnsyncPrintWriter output) {
						output.reset(null);
					}
				}, POOL_SIZE);

}