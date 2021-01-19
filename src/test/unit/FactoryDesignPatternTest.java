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
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.creational.factory.AccounType;
import design.pattern.creational.factory.Account;
import design.pattern.creational.factory.AccountFactory;

/**
 * 
 * @author JunMinon
 *
 */
public class FactoryDesignPatternTest {

	@Test
	public void createChecking() {
		
		AccountFactory factory = new AccountFactory();
		
		Account account = factory.create(AccounType.CHECKING);
		
		assertNotNull(account);
		assertEquals(AccounType.CHECKING, account.getType());
		
	}

	@Test
	public void createTimeDeposits() {
		
		AccountFactory factory = new AccountFactory();
		
		Account account = factory.create(AccounType.TIME_DEPOSIT);
		
		assertNotNull(account);
		assertEquals(AccounType.TIME_DEPOSIT, account.getType());
		
	}

	@Test
	public void createSavingsAccount() {
		
		AccountFactory factory = new AccountFactory();
		
		Account account = factory.create(AccounType.SAVINGS);
		
		assertNotNull(account);
		assertEquals(AccounType.SAVINGS, account.getType());
		
	}

	@Test
	public void createWithNullType_thenReturnsNull() {
		
		AccountFactory factory = new AccountFactory();
		
		Account account = factory.create(null);
		
		assertNull(account);
		
	}
	
}
