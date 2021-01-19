/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package test.unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import design.pattern.creational.singleton.ThreadSafeSingleton;

/**
 * 
 * @author JunMinon
 *
 */
public class ThreadSafeSingletonTest {

//	@Test
//	@Disabled
//	public void testSingleThread() {
//		
//		ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
//		
//		assertNotNull(singleton);
//		
//	}
	
	@Test
	public void testMultiThread() throws InterruptedException {
		
		int nThreads = 1000;
		Set<ThreadSafeSingleton> singletons = new HashSet<>();
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		CountDownLatch latch = new CountDownLatch(nThreads);
		
		IntStream.range(0, nThreads).forEach(thread -> {
			executor.execute(() -> {
				ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();		
				assertNotNull(singleton);
				singletons.add(singleton);
				latch.countDown();
			});
		});

//		latch.await();
		Thread.sleep(3000);
		executor.shutdown();
		executor.awaitTermination(60, TimeUnit.SECONDS);
		
		assertEquals(1, singletons.size());
		
	}
	
}
