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

import org.junit.jupiter.api.Test;

import design.pattern.behavioral.command.ChefReceiver;
import design.pattern.behavioral.command.OrderPasta;
import design.pattern.behavioral.command.OrderSalad;
import design.pattern.behavioral.command.OrderSteak;
import design.pattern.behavioral.command.WaiterInvoker;

/**
 * 
 * @author JunMinon
 *
 */
public class CommandDesignPatternTest {

	@Test
	public void orderPasta() {
		
		ChefReceiver chef = new ChefReceiver("Chef Roberto");
		WaiterInvoker waiter = new WaiterInvoker("Leanardo");		
		String meal = waiter.getOrder(new OrderPasta(chef));
		
		assertNotNull(meal);
		assertEquals("Pasta", meal);
		
	}

	@Test
	public void orderSteak() {
		
		ChefReceiver chef = new ChefReceiver("Chef Linguini");
		WaiterInvoker waiter = new WaiterInvoker("Ratatoie");		
		String meal = waiter.getOrder(new OrderSteak(chef));
		
		assertNotNull(meal);
		assertEquals("Steak", meal);
		
	}

	@Test
	public void orderSalad() {
		
		ChefReceiver chef = new ChefReceiver("Chef Rosei");
		WaiterInvoker waiter = new WaiterInvoker("Alena");		
		String meal = waiter.getOrder(new OrderSalad(chef));
		
		assertNotNull(meal);
		assertEquals("Salad", meal);
		
	}
	
}
