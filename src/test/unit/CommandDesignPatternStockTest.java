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

import org.junit.jupiter.api.Test;

import design.pattern.behavioral.command.ex2.Broker;
import design.pattern.behavioral.command.ex2.BuyStock;
import design.pattern.behavioral.command.ex2.SellStock;
import design.pattern.behavioral.command.ex2.Stock;
import design.pattern.behavioral.command.ex2.StockOrder;

/**
 * 
 * @author JunMinon
 *
 */
public class CommandDesignPatternStockTest {

	@Test
	public void buyStock() {
		
		Stock stock = new Stock("Some stock");
		Broker broker = new Broker("Some broker");
		StockOrder stockOrder = new BuyStock(stock);
		
		broker.processOrder(stockOrder);
		
	}

	@Test
	public void sellStock() {
		
		Stock stock = new Stock("Some stock");
		Broker broker = new Broker("Some broker");
		StockOrder stockOrder = new SellStock(stock);
		
		broker.processOrder(stockOrder);
		
	}
	
}
