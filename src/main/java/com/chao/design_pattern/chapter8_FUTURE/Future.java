package com.chao.design_pattern.chapter8_FUTURE;

//获取结果
public interface Future<T> {
	T get() throws InterruptedException;
}
