package com.http.xutils.interfaces;

import com.lidroid.xutils.exception.HttpException;

/**
 * Http请求回调
 * 
 * @author eric liu
 *
 */
public interface RequestListener {

	/**
	 * 开始请求
	 * 
	 * @param int
	 *            请求的连接类型id
	 * @author eric liu
	 */
	public void onStart(int urlTypeId, Object obj);

	/**
	 * 请求http结束
	 * 
	 * @param urlTypeId
	 *            请求的连接类型id
	 * @param total
	 *            读取数据总大小（byte）
	 * @param current
	 *            当前读取数据大小（byte）
	 * @param isUploading
	 *            是否上传操作
	 * @param obj
	 * @author eric liu
	 */
	public void onLoading(int urlTypeId, long total, long current, boolean isUploading, Object obj);

	/**
	 * 请求成功返回
	 * 
	 * @param int
	 *            请求的连接类型id
	 * @param response
	 *            服务器返回的json字符串
	 * @author eric liu
	 */
	public void onSuccess(int urlTypeId, String responseString, Object obj);

	/**
	 * 网络连接错误
	 * 
	 * @param int
	 *            请求的连接类型id
	 * @param error
	 *            HttpException
	 * @param msg
	 *            http失败信息
	 * @author eric liu
	 */
	public void onFailure(int urlTypeId, HttpException error, String msg, Object obj);

}
