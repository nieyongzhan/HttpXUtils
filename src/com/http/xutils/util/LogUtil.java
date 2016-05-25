package com.http.xutils.util;

import android.util.Log;

public class LogUtil {

	/** Log输出的控制开关 */
	public static boolean isShowLog = true;

	public static void v(Object objTag, String msg) {
		if (isShowLog) {
			Log.v(formatTag(objTag), msg);
		}
	}

	public static void d(Object objTag, String msg) {
		if (isShowLog) {
			Log.i(formatTag(objTag), msg);
		}
	}

	public static void i(Object objTag, String msg) {
		if (isShowLog) {
			Log.i(formatTag(objTag), msg);
		}
	}

	public static void w(Object objTag, String msg) {
		if (isShowLog) {
			Log.w(formatTag(objTag), msg);
		}
	}

	public static void e(Object objTag, String msg) {
		if (isShowLog) {
			Log.e(formatTag(objTag), msg);
		}
	}

	public static void e(Object objTag, String msg, Throwable tr) {
		if (isShowLog) {
			Log.e(formatTag(objTag), msg, tr);
		}
	}
	
	private static String formatTag(Object objTag) {
		String tag;
		
		// 如果objTag是String，则直接使用
		// 如果objTag不是String，则使用它的类名
		if (objTag instanceof String) {
			tag = (String) objTag;
		} else if (objTag instanceof Class) {
			tag = ((Class) objTag).getSimpleName();
		} else {
			tag = objTag.getClass().getSimpleName();
		}
		return tag;
	}
	
}
