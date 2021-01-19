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

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import design.pattern.structural.decorator.Coffee;
import design.pattern.structural.decorator.CoffeeWithAddOnDecorator;
import design.pattern.structural.decorator.HouseBlendCoffee;
import design.pattern.structural.decorator.MilkAddOn;
import design.pattern.structural.decorator.SugarAddOn;

/**
 * 
 * @author JunMinon
 *
 */
public class DecoratorDesignPatternTest {

	@Test
	public void priceOfHouseBlendWithAddOns() {
		
		Coffee coffee = new HouseBlendCoffee();		
		assertEquals("House Blend", coffee.getName());
		assertTrue(coffee.price().compareTo(BigDecimal.valueOf(150.0)) == 0);
		
		CoffeeWithAddOnDecorator withSugarAddOn = new SugarAddOn(coffee);
		assertEquals("Sugar", withSugarAddOn.getName());
		assertTrue(withSugarAddOn.price().compareTo(BigDecimal.valueOf(150.0)
				.add(BigDecimal.valueOf(25.0))) == 0);
		
		CoffeeWithAddOnDecorator withMilkAddOn = new MilkAddOn(withSugarAddOn);
		assertEquals("Milk", withMilkAddOn.getName());
		assertTrue(withMilkAddOn.price().compareTo(BigDecimal.valueOf(150.0)
				.add(BigDecimal.valueOf(25.0))
				.add(BigDecimal.valueOf(30.0))) == 0);	

		CoffeeWithAddOnDecorator withExtraMilkAddOn = new MilkAddOn(withMilkAddOn);
		assertEquals("Milk", withExtraMilkAddOn.getName());
		assertTrue(withExtraMilkAddOn.price().compareTo(BigDecimal.valueOf(150.0)
				.add(BigDecimal.valueOf(25.0))
				.add(BigDecimal.valueOf(30.0))
				.add(BigDecimal.valueOf(30.0))) == 0);	
		
	}
	
}
