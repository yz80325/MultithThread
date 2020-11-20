package com.chao.design_pattern.chapter8_FUTURE;

import java.util.function.Consumer;

//桥梁
public class FutureService<T> {
	public <T> Future<T> submit(final FutureTask<T> task){
		AsynFuture<T> asynFuture = new AsynFuture<>();
		new Thread(()->{
			// 执行给定的任务
			T result = task.call();
			// 将任务的结果放入asynFuture中
			asynFuture.done(result);
		}).start();
		// 使用另一个线程执行任务，可以立即返回Future
		return asynFuture;
	}

	//实时通信
	public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){
		AsynFuture<T> asynFuture = new AsynFuture<>();
		new Thread(()->{
			// 执行给定的任务
			T result = task.call();
			// 将任务的结果放入asynFuture中
			asynFuture.done(result);
			consumer.accept(result);
		}).start();
		// 使用另一个线程执行任务，可以立即返回Future
		return asynFuture;
	}
}
